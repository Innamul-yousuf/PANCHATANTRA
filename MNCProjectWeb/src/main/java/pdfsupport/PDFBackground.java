package pdfsupport;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBackground extends PdfPageEventHelper {

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		Image background;
		String bg;
		try {
			InputStream reader = new FileInputStream("C:\\8047EE\\MNCProjectWeb\\pdf.properties");
	    	
			Properties p = new Properties();
			p.load(reader);
			bg = p.getProperty("bg");
			background = Image.getInstance(bg);

			float width = document.getPageSize().getWidth();
			float height = document.getPageSize().getHeight();

			writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
