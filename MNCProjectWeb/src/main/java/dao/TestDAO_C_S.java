package dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

public class TestDAO_C_S {
public static void main(String[] args) {
	Connection con=ConnectionUtility.getConnection();
	Student_CourseDAO master=Student_CourseDAOImpl.createCourseDAOInstance();
	Student_CourseDTO sdt=new Student_CourseDTO();
	Student_CourseCK ck=new Student_CourseCK(123123, 5555);
	sdt=master.findByID(ck, con);
	System.out.println(sdt);
//	sdt.setStudent_id(9999999999l);
//	sdt.setCourse_id(9999999);
//	sdt.setFees_paid(787878);
//	sdt.setStudent_CAttendance(89);
//	sdt.setStudent_CGrade(899);
//	sdt.setStudent_CJD("2004-07-23");
//	int i=master.deleteStudent_CourseByID(ck, con);
//	System.out.println(i);
//	System.out.println("____");
//	
//	Collection<Student_CourseDTO> allusers=master.findAll(con);
//	//System.out.println(allusers);
//	Iterator<Student_CourseDTO> iter=allusers.iterator();
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
//	int i=master.deleteStudent(6684, con);
//	System.out.println(i);
	
	
	
	ConnectionUtility.closeConnection(null, null);
}
}
