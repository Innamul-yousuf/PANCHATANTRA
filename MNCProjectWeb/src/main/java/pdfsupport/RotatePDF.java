//package pdfsupport;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.pdf.PdfName;
//import com.itextpdf.text.pdf.PdfNumber;
//import com.itextpdf.text.pdf.PdfPage;
//import com.itextpdf.text.pdf.PdfPageEventHelper;
//import com.itextpdf.text.pdf.PdfWriter;
//
//	public class RotatePDF extends PdfPageEventHelper {
//	    
//	    protected PdfNumber orientation = PdfPage.PORTRAIT;
//	    
//	    public void setOrientation(PdfNumber orientation) {
//	        this.orientation = orientation;
//	    }
//	    
//	    @Override
//	    public void onStartPage(PdfWriter writer, Document document) {
//	        writer.addPageDictEntry(PdfName.ROTATE, orientation);
//	    }
//	}