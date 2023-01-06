package pdfsupport;

//import java.net.MalformedURLException;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
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

public class HeaderFooterCertificates extends PdfPageEventHelper {



	public void onStartPage(PdfWriter writer, Document document) {

		String logo;
		try {
			InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\certificate.properties");
			
			Properties p = new Properties();
			p.load(reader);
			logo = p.getProperty("logo");
			Image image = Image.getInstance(logo);

			image.setWidthPercentage(5);
			image.setXYRatio(3);

			image.setAbsolutePosition(347, 440);
			image.scalePercent(20, 30);
			image.setAlignment(Element.ALIGN_MIDDLE);
			image.setAlignment(Element.ALIGN_TOP);

			writer.getDirectContent().addImage(image, true);

			Font f = new Font(FontFamily.TIMES_ROMAN, 30.0f, Font.ITALIC, BaseColor.BLUE);

			
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
					new Phrase("CERTIFICATE OF APPRECIATION", f), 400, 400, 0);


		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}

	public void onEndPage(PdfWriter writer, Document document) {
		
		String correct;
		String wrong;
		try {
			String ass;
			String pro;

			InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\certificate.properties");
			
			Properties p = new Properties();
			p.load(reader);
			correct = p.getProperty("correct");
			wrong = p.getProperty("wrong");
			ass=p.getProperty("ass");
			pro=p.getProperty("pro");
			String tick;
		if(ass.equals("yes")) {
			tick=correct;	
		}else {
			tick=wrong;	
		}
		if(pro.equals("yes")) {
			tick=correct;		
		}else {
			tick=wrong;	
		}
		String sign =p.getProperty("sign");
			try {
				Image image = Image.getInstance(correct);

				image.setWidthPercentage(5);
				image.setXYRatio(3);

				image.setAbsolutePosition(310, 130);
				image.scalePercent(10, 10);
				image.setAlignment(Element.ALIGN_MIDDLE);
				image.setAlignment(Element.ALIGN_TOP);

				writer.getDirectContent().addImage(image, true);

				Font f = new Font(FontFamily.TIMES_ROMAN, 30.0f, Font.ITALIC, BaseColor.BLUE);

				Font f2 = new Font(FontFamily.TIMES_ROMAN, 15.0f, Font.ITALIC, BaseColor.BLUE);

				
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
						new Phrase("Assignment Done:", f), 200, 140, 0);

				Image image2 = Image.getInstance(wrong);

				image2.setWidthPercentage(5);
				image2.setXYRatio(3);

				image2.setAbsolutePosition(665, 125);
				image2.scalePercent(10, 10);
				image2.setAlignment(Element.ALIGN_MIDDLE);
				image2.setAlignment(Element.ALIGN_TOP);

				writer.getDirectContent().addImage(image2, true);
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
						new Phrase("Project Done:", f), 590, 140, 0);

				Image image3 = Image.getInstance(sign);

				image3.setWidthPercentage(5);
				image3.setXYRatio(3);

				image3.setAbsolutePosition(390, 60);
				image3.scalePercent(20, 20);
				image3.setAlignment(Element.ALIGN_MIDDLE);
				image3.setAlignment(Element.ALIGN_TOP);
				writer.getDirectContent().addImage(image3, true);
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
						new Phrase("Mr. M. H. Shoiab", f2), 450, 40, 0);
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
						new Phrase("Haris InfoTech", f2), 450, 25, 0);
			} catch (IOException | DocumentException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
