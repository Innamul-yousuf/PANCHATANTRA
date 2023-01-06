package Individual_Report;

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
//

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
public class trypage {  	
        public static void main(String[] args) throws Exception{
                
           
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\1 MNC Project\\PDF\\try.pdf"));
                document.open();   
                
                Rectangle rect= new Rectangle(577,825,18,15); // you can resize rectangle 
                rect.enableBorderSide(1);
                rect.enableBorderSide(2);
                rect.enableBorderSide(4);
                rect.enableBorderSide(8);
                rect.setBorderColor(BaseColor.BLACK);
                rect.setBorderWidth(1);
                document.add(rect);
                //document.setMargins(100, 50, 50, 100);
                
                document.addTitle("VOW Reports");//
                
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                


                
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                event.onStartPage(writer, document);
                writer.setPageEvent(event);
           
                
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));  
                document.add(new Paragraph(" ")); 
                document.add(new Paragraph(" "));
                
                
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Performance wise VOW report"), 285, 705, 0);
    	        	
                document.add(new Chunk(""));
                             
                PdfContentByte cb = writer.getDirectContent();
                BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                
                
                
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                //create a cell object
                table.setWidths(new float[]{1.7f, 1.7f, 1,1,1});
                PdfPCell table_cell;
                table_cell=new PdfPCell(new Phrase("Student ID"));
                table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Student Name"));
                table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Course  ID"));
                table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Course  Name"));
                table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("VOW"));
                table.addCell(table_cell);
//                table_cell=new PdfPCell(new Phrase("QOD"));
//                table.addCell(table_cell);
//                table_cell=new PdfPCell(new Phrase("TOD"));
//                table.addCell(table_cell);
//                table_cell=new PdfPCell(new Phrase("LOW"));
//                table.addCell(table_cell);
//                table_cell=new PdfPCell(new Phrase("VOW"));
//                table.addCell(table_cell);
//                table_cell=new PdfPCell(new Phrase("Total"));
//                table.addCell(table_cell);
                Connection con=ConnectionUtility.getConnection();
                PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
                
                SortingIndividual sd=new SortingIndividual();
                Collection<PanchatanthraDTO> sc=sd.sortByQod();
                Iterator<PanchatanthraDTO> iter1 = sc.iterator();
        		while (iter1.hasNext()) {
        			
        			PanchatanthraDTO smd=iter1.next();	
            		
            		long stu_id=smd.getStudent_id();
            		
            		
            		table_cell=new PdfPCell(new Phrase(String.valueOf(stu_id)));
            		table.addCell(table_cell);
            		
            		Student_MasterDAO sm=Student_MasterDAOImpl.createStudentDAOInstance();
            		Student_MasterDTO smt=sm.findByID(stu_id, con);
                	String student_name=smt.getStudent_name();
            		
            		table_cell=new PdfPCell(new Phrase(student_name));
            		table.addCell(table_cell);
            		
            		int cour_id=smd.getCourse_id();
            		table_cell=new PdfPCell(new Phrase(String.valueOf(cour_id)));
            		table.addCell(table_cell);
            		
            		//Iterator<PanchatanthraDTO> iter=allusers.iterator();
                	Course_MasterDAO cm=Course_MasterDAOImpl.createCourseDAOInstance();
                	Course_MasterDTO ccm=cm.findByID(cour_id, con);
                	
                	String course_name=ccm.getCourse_name();
                	table_cell=new PdfPCell(new Phrase(course_name));
                	table.addCell(table_cell);
        			
                	int vow_count=smd.getVow_count();
            	
            		table_cell=new PdfPCell(new Phrase(String.valueOf(vow_count)));
            		table.addCell(table_cell);
            		
            		
//            		long stu_id=smd.getStudent_id();
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(stu_id)));
//            		int cour_id=smd.getCourse_id();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(cour_id)));
//            		int cod_count=smd.getCod_count();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(cod_count)));
//            		int qod_count=smd.getQod_count();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(qod_count)));
//            		int tod_count=smd.getTod_count();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(tod_count)));
//            		int low_count=smd.getLow_count();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(low_count)));
//            		int Vow_count=smd.getVow_count();
//            		table.addCell(table_cell);
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(Vow_count)));
//            		table.addCell(table_cell);
//            		float Total=((cod_count*5)+(qod_count*5)+tod_count+(low_count*25)+(Vow_count*25));
//            		float Total_P=(Total/125)*100;
//            		
//            		table_cell=new PdfPCell(new Phrase(String.valueOf(Total_P)+"%"));
//            		table.addCell(table_cell);
            		for(int i=0;i<=250;i++) {
            			table_cell=new PdfPCell(new Phrase(String.valueOf(i)));
                		table.addCell(table_cell);
            		}
        		}
                
//            
        		   
            	document.add(table);  
            	PDFBackground pg=new PDFBackground();
            	writer.setPageEvent(pg);
            	
            	document.close();
        }


}