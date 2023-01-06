package dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

public class TestDAOCourse {
public static void main(String[] args) {
	Connection con=ConnectionUtility.getConnection();
	
	Course_MasterDAOImpl master=Course_MasterDAOImpl.createCourseDAOInstance();
	Course_MasterDTO cdt=new Course_MasterDTO();
	cdt.setCourse_id(555);
	cdt.setCourse_fees(444);
	cdt.setCourse_level(2);
	cdt.setCourse_name("python");
//	int i=master.updateCourse_Master(cdt, con);
//	System.out.println(i);
//	
	
	
	int i=master.insertCourse_Master(cdt, con);
	System.out.println(i);
	System.out.println("____");
	
//	Collection<Course_MasterDTO> allusers=master.
//	//System.out.println(allusers);
//	Iterator<Course_MasterDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	//_____________________
	System.out.println("____");
	//______________________
//	Collection<Student_MasterDTO> allusers=master.findAll(con);
//	//System.out.println(allusers);
//	Iterator<Student_MasterDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	//_____________________
	System.out.println("____");
	
	//____________
//	Collection<Student_MasterDTO> allusers=master.findByCellNumber(9841087434l, con);
//	//System.out.println(allusers);
//	Iterator<Student_MasterDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	//-------------------
	
//	sdt.setStudent_id(77784);
//	sdt.setStudent_address1("bbb");
//	sdt.setStudent_city("gggg");
//	sdt.setStudent_college("tggtgtg");
//	sdt.setStudent_email1("hhhh");
//	sdt.setStudent_name("panIndia");
//	sdt.setStudent_whatsappno2(9999999999l);
	int is=master.updateCourse_Master(cdt, con);
//	System.out.println(i);
	
	
	
	ConnectionUtility.closeConnection(null, null);
	
	
	
}
}
