package email;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import dao.ConnectionUtility;
import dao.Course_MasterDAOImpl;
import dao.Course_MasterDTO;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;

public class AssignEmails {
	public static String  AssignEmails() throws Exception{
		String email=null;
		
		FileReader reader = new FileReader("emails.properties");
		int rows=AssignEmails.setRowCountSM();
		Properties p = new Properties();
		p.load(reader);
		
		for(int i=0;i<=rows;i++) {
			if(i>=1&&i<=2) {
				email = p.getProperty("e1");
				//pass = p.getProperty("p1");
			}
			else if(i>=3&&i<=4) {
				email = p.getProperty("e2");
				//pass = p.getProperty("p1");
			}
			else if(i>=5&&i<=6) {
				email = p.getProperty("e3");
			}
			else {
				email = p.getProperty("e4");
			}
		}
		return email;
		
	}
	public static String  AssignPass() throws Exception{
		
		String pass=null;
		FileReader reader = new FileReader("emails.properties");
		int rows=AssignEmails.setRowCountSM();
		Properties p = new Properties();
		p.load(reader);
		
		for(int i=0;i<=rows;i++) {
			if(i>=1&&i<=2) {
				pass = p.getProperty("p1");
				//pass = p.getProperty("p1");
			}
			else if(i>=3&&i<=4) {
				pass = p.getProperty("p2");
				//pass = p.getProperty("p1");
			}
			else if(i>=5&&i<=6) {
				pass = p.getProperty("p3");
			}
			else {
				pass = p.getProperty("p4");
			}
		}
		return pass;
		
	}
	public static  int setRowCountSM() {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("SELECT COUNT (*) from student_master");
			
			rs=ps.executeQuery();
			int rows=rs.getInt(1);
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
}