package Individual_Report;

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
//

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.sql.*;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import dao.ConnectionUtility;
import dao.Course_MasterDAO;
import dao.Course_MasterDAOImpl;
import dao.Course_MasterDTO;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;
import pdf.SortingDemo;
import pdfsupport.HeaderFooterPageEvent;
import pdfsupport.PDFBackground;

@Path("/qodp")
public class Qod_Descending {
	@GET
	public static void qod() throws Exception {

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("D:\\1 MNC Project\\PDF\\Qod_Performance.pdf"));
		document.open();

		document.addTitle("Qod Reports");//

		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
		event.onStartPage(writer, document);
		writer.setPageEvent(event);

		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));

		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
				new Phrase("Performance wise QOD report"), 285, 705, 0);

		document.add(new Chunk(""));

		PdfContentByte cb = writer.getDirectContent();

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(3);
		table.setSpacingAfter(5);
		table.setWidths(new float[] { 1.7f, 1.7f, 1, 1, 1 });
		PdfPCell table_cell;
		table_cell = new PdfPCell(new Phrase("Student ID"));
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Student Name"));
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Course  ID"));
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Course  Name"));
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("QOD"));
		table.addCell(table_cell);

		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();

		SortingIndividual sd = new SortingIndividual();
		Collection<PanchatanthraDTO> sc = sd.sortByQod();
		Iterator<PanchatanthraDTO> iter1 = sc.iterator();
		while (iter1.hasNext()) {

			PanchatanthraDTO smd = iter1.next();

			long stu_id = smd.getStudent_id();

			table_cell = new PdfPCell(new Phrase(String.valueOf(stu_id)));
			table.addCell(table_cell);

			Student_MasterDAO sm = Student_MasterDAOImpl.createStudentDAOInstance();
			Student_MasterDTO smt = sm.findByID(stu_id, con);
			String student_name = smt.getStudent_name();

			table_cell = new PdfPCell(new Phrase(student_name));
			table.addCell(table_cell);

			int cour_id = smd.getCourse_id();
			table_cell = new PdfPCell(new Phrase(String.valueOf(cour_id)));
			table.addCell(table_cell);

			// Iterator<PanchatanthraDTO> iter=allusers.iterator();
			Course_MasterDAO cm = Course_MasterDAOImpl.createCourseDAOInstance();
			Course_MasterDTO ccm = cm.findByID(cour_id, con);

			String course_name = ccm.getCourse_name();
			table_cell = new PdfPCell(new Phrase(course_name));
			table.addCell(table_cell);

			int qod_count = smd.getQod_count();

			table_cell = new PdfPCell(new Phrase(String.valueOf(qod_count)));
			table.addCell(table_cell);


		}

          

		document.add(table);

		document.close();
	}

}