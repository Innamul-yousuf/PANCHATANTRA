package pdf;

import java.io.*;
import java.io.ObjectInputFilter.Config;
import java.util.*;
//

import javax.activation.DataSource;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.apache.poi.sl.usermodel.ObjectMetaData.Application;

import java.sql.*;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
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
import pdfsupport.HeaderFooterIndividualReport;
import pdfsupport.HeaderFooterPageEvent;

@Path("/pdf")
public class Individual_Report {
	
public static void main(String[] args)throws Exception {
	//Individual_Report.individualreport(123123, 23444);
	Individual_Report in=new Individual_Report();
	in.individualreport(12333, 23333);
		
}
@Path("/ipdf/{sid}/{cid}")
@GET
	public  void individualreport(@PathParam("sid")long stu_id,@PathParam("cid")int cour_id) throws Exception {
		
	
//	String resourceName = "individualpdf.properties"; // could also be a constant
//	ClassLoader loader = Thread.currentThread().getContextClassLoader();
//	Properties p = new Properties();
//	try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
//	    p.load(resourceStream);
	
		Document document = new Document();
		String pdfloc;
		//props.load(new FileInputStream("src/main/resources/myconf.properties"));
		//FileReader reader = new FileReader("/MNCProjectWeb/individualpdf.properties");
		//new Individual_Report().getClass().getClassLoader().getResourceAsStream("/individualpdf.properties");
		
		//InputStream reader = new FileInputStream(("individualpdf.properties"));
		Properties p = new Properties();
	
		//p.load(DataSource.class.getClassLoader().getResourceAsStream("individualpdf.properties"));
		//p.load(reader);
		//javax.ws.rs.core.Application app=new javax.ws.rs.core.Application();
		
		//String contextPath = servletContext.getRealPath("C:\\8047EE\\MNCProjectWeb\\individualpdf.properties");
		InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\individualpdf.properties");
		//p.load(getClass().getResourceAsStream("C:\\8047EE\\MNCProjectWeb\\individualpdf.properties"));
		p.load(reader);

		pdfloc = p.getProperty("pdflocation");
		
		PdfWriter writer = PdfWriter.getInstance(document,
		new FileOutputStream(pdfloc));
	
		document.open();

		document.addTitle("Individual Panchatanthra Reports");
		
		int i = document.getPageNumber();
		if (i == 0) {
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
		
		}

		HeaderFooterIndividualReport event = new HeaderFooterIndividualReport();
		event.onStartPage(writer, document);
		writer.setPageEvent(event);
		Font f = new Font(FontFamily.TIMES_ROMAN, 45.0f, Font.BOLD, BaseColor.BLACK);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Overall report",f), 285,
				675, 0);

		document.add(new Chunk(""));
		Connection con = ConnectionUtility.getConnection();

		String name = Generate_Certificate.assignnameCerttficate(stu_id, cour_id);
		String c_name = Generate_Certificate.assignCour_NameCerttficate(stu_id, cour_id);
		float per = Generate_Certificate.assignPercentage(stu_id, cour_id);

		ConnectionUtility.closeConnection(null, null);
		
		Font f1 = new Font(FontFamily.TIMES_ROMAN, 35.0f, Font.BOLDITALIC, BaseColor.BLACK);

		Font f3 = new Font(FontFamily.HELVETICA, 25.0f, Font.BOLD, BaseColor.BLACK);

		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		
		PanchatanthraDTO pdto= PercentageGetter.getAllDetails(stu_id, cour_id);
		document.add(new Paragraph(new Phrase("       Name of the student : "+ name, f1)));
		document.add(new Paragraph(new Phrase("       Course : "+ c_name, f1)));
		document.add(new Paragraph(new Phrase("       Code of the day: "+ pdto.getCod_count(), f1)));
		document.add(new Paragraph(new Phrase("       Question of the day: "+ pdto.getQod_count(), f1)));
		document.add(new Paragraph(new Phrase("       Test of the day: "+ +pdto.getTod_count(), f1)));
		document.add(new Paragraph(new Phrase("       Lab of the week: "+ pdto.getLow_count(), f1)));
		document.add(new Paragraph(new Phrase("       Video of the week: "+pdto.getVow_count(), f1)));
		document.close();

		ConnectionUtility.closeConnection(null, null);
//	}catch(Exception e) {
//		e.printStackTrace();
//	}
	}
	}
	

