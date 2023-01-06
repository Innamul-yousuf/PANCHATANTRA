package pdfsupport;

//import java.net.MalformedURLException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.core.util.Constants;

import com.itextpdf.text.pdf.ColumnText;
	import com.itextpdf.text.pdf.PdfPageEventHelper;
	import com.itextpdf.text.pdf.PdfWriter;

	public class HeaderFooterPageEvent extends PdfPageEventHelper {


		
	
		
	    
	    public void onStartPage(PdfWriter writer, Document document) {
	    	try{
	    		Rectangle rect= new Rectangle(577,825,18,15); // you can resize rectangle 
	    	
            rect.enableBorderSide(1);
            rect.enableBorderSide(2);
            rect.enableBorderSide(4);
            rect.enableBorderSide(8);
            rect.setBorderColor(BaseColor.BLACK);
            rect.setBorderWidth(1);
            document.add(rect);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    }
	    	
	    	String logo="";
	    	try {

	    		InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\pdf.properties");
	    		
	    

	    	Properties p = new Properties();
	    	p.load(reader);
	    	logo=p.getProperty("logo");
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	int i=document.getPageNumber();
	    	if(i==0) {
	    		
	    	
	    	try {
            Image image = Image.getInstance(logo);
            
           
           
            image.setWidthPercentage(5);
            image.setXYRatio(3);
            
            image.setAbsolutePosition(235, 720);
            image.scalePercent(20, 30);
            image.setAlignment(Element.ALIGN_MIDDLE);
            image.setAlignment(Element.ALIGN_TOP);
            
            writer.getDirectContent().addImage(image, true);
              

	        } catch (IOException | DocumentException e) {
	            e.printStackTrace();
	        }
	    	writer.setPageEvent(new PDFBackground());
	    	}

	    }
	    public void onEndPage(PdfWriter writer, Document document) {
	    	
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("http://haarisinfotech.com"), 110, 25, 0);
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + document.getPageNumber()), 550, 25, 0);
	    }
	


    }

