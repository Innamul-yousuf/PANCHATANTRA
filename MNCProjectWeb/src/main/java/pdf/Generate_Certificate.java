package pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
import email.SendEmailCertificate;
import pdfsupport.BG_For_Certificate;
import pdfsupport.HeaderFooterCertificates;

@Path("/cer")
public class Generate_Certificate {
	public static void main(String[] args) throws Exception {
		Generate_Certificate.createCertificate(984, 5555);
		//SendEmailCertificate.getDetails(984, 5555);
	}
	@Path("/cpdf/{sid}/{cid}")
	@GET
	public static void createCertificate(@PathParam("sid")long sid,@PathParam("cid") int cid) throws Exception {
		InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\certificate.properties");
		
		Properties p = new Properties();
		p.load(reader);
		String cer_loc = p.getProperty("certificate_loc");
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(cer_loc));
		document.open();

		HeaderFooterCertificates evec = new HeaderFooterCertificates();
		writer.setPageEvent(evec);

		document.addTitle("Certificate");

		HeaderFooterCertificates event1 = new HeaderFooterCertificates();
		event1.onStartPage(writer, document);
		writer.setPageEvent(event1);

		Connection con = ConnectionUtility.getConnection();

		String name = Generate_Certificate.assignnameCerttficate(sid, cid);
		String c_name = Generate_Certificate.assignCour_NameCerttficate(sid, cid);
		float per = Generate_Certificate.assignPercentage(sid, cid);

		ConnectionUtility.closeConnection(null, null);

		Font f = new Font(FontFamily.TIMES_ROMAN, 45.0f, Font.BOLD, BaseColor.BLUE);
		Font f1 = new Font(FontFamily.HELVETICA, 25.0f, Font.BOLD, BaseColor.BLACK);

		Font f2 = new Font(FontFamily.HELVETICA, 25.0f, Font.BOLD, BaseColor.BLACK);

		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
				new Phrase("This certificate is presented to", f1), 400, 350, 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(name, f), 400, 300, 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
				new Phrase("for successfully completing the course " + c_name, f1), 400, 270, 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
				new Phrase(" with a percentage of " + per + " %", f2), 400, 230, 0);
		writer.setPageEvent(new BG_For_Certificate());
		document.close();

	}

	public static String assignCour_NameCerttficate(long sid, int cid) throws Exception {

		Connection con = ConnectionUtility.getConnection();
		GetTopPerformerName gn = new GetTopPerformerName();

		GetTopPerformerName gtn = new GetTopPerformerName();

		String c_name = gtn.getCourseName(sid, cid);
		Course_MasterDAO cm = Course_MasterDAOImpl.createCourseDAOInstance();
		Course_MasterDTO cmt = new Course_MasterDTO();
		con = ConnectionUtility.getConnection();

		return c_name;
	}

	public static String assignnameCerttficate(long sid, int cid) throws Exception {

		Connection con = ConnectionUtility.getConnection();
		GetTopPerformerName gn = new GetTopPerformerName();

		Student_MasterDAO sa = Student_MasterDAOImpl.createStudentDAOInstance();
		GetTopPerformerName gtn = new GetTopPerformerName();
		String name = gtn.getStuName(sid);
		con = ConnectionUtility.getConnection();

		ConnectionUtility.closeConnection(null, null);
		return name;

	}

	public static float assignPercentage(long sid, int cid) throws Exception {

		GetTopPerformerName gtn = new GetTopPerformerName();
		Connection con = ConnectionUtility.getConnection();
		con = ConnectionUtility.getConnection();

		PercentageGetter pg = new PercentageGetter();
		float per = pg.getpercentage(sid, cid);

		return per;
	}
}
