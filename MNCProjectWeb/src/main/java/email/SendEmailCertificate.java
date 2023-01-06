package email;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;
import pdf.Generate_Certificate;

@Path("/email")
public class SendEmailCertificate {
	public static void main(String[] args)throws Exception {
		SendEmailCertificate.getDetails(123123, 23444, "try");
	}
	
	@Path("/sendById/{stu_id}/{cour_id}/{pdfname}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public static void getDetails(@PathParam("stu_id") long stu_id,@PathParam("cour_id")int cour_id,@PathParam("pdfname")String pdfname)throws Exception {
		
		String name = Generate_Certificate.assignnameCerttficate(stu_id, cour_id);
//		String email1=SendEmailCertificate.getEmailOfStudent1(stu_id);
//		String email2=SendEmailCertificate.getEmailOfStudent2(stu_id);
//		String email3=SendEmailCertificate.getEmailOfStudent3(stu_id);
		String to=null;
		
		int count=0;
		Collection<String> emails=SendEmailCertificate.getAllEmail(stu_id);
		Iterator<String> iter=emails.iterator();
		while(iter.hasNext()) {
			to=iter.next();
		int c=0;
		
		String from = "innamulprojects@gmail.com";
		
		
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("innamulprojects@gmail.com", "bvahvbfewirmcfcs");

            }

        });

        try {
            
            MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Reg: Golden Touch, Panchatanthra");

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {
            	String filesend=pdfname;
            	//D:\\1 MNC Project\\PDF\\Certificate.pdf
            	String link="D:\\1 MNC Project\\PDF\\"+filesend+".pdf";
                File f =new File(link);

                attachmentPart.attachFile(f);
                
                textPart.setText("Hello "+name+", \n"+"Greetings from HaarisInfotech \n"
                		+ "This is your weekly certificate, Kindly see the attachement.");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }
        

            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        c++;
		}
		
	}
	public static  Collection<String> getAllEmail(long stu_id) {
		Connection con = ConnectionUtility.getConnection();
		Student_MasterDAO sm = Student_MasterDAOImpl.createStudentDAOInstance();

		Student_MasterDTO cmt = sm.findByID(stu_id, con);
		String email = cmt.getStudent_email1();
		String email2 = cmt.getStudent_email2();
		String email3 = cmt.getStudent_email3();
		
		List<String> emails= new ArrayList<String>(); 
		emails.add(email);
		emails.add(email2);
		emails.add(email3);
		

		return emails;
	}
}
