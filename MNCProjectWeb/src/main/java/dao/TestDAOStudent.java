package dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

public class TestDAOStudent {
public static void main(String[] args) {
	Connection con=ConnectionUtility.getConnection();
	Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
	Student_MasterDTO sdt=new Student_MasterDTO();
	sdt=master.findByID(9841087434l, con);
	System.out.println(sdt);
	System.out.println("____");
	
	Collection<Student_MasterDTO> allusers=master.findAll(con);
//	//System.out.println(allusers);
//	Iterator<Student_MasterDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	Iterator<Student_MasterDTO> iter=allusers.iterator();
	while(iter.hasNext()) {
		Student_MasterDTO smd=iter.next();
		long i=smd.getStudent_id();
		System.out.println(i);
	}
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
	
	sdt.setStudent_id(77784);
	sdt.setStudent_address1("bbb");
	sdt.setStudent_city("gggg");
	sdt.setStudent_college("tggtgtg");
	sdt.setStudent_email1("hhhh");
	sdt.setStudent_name("panIndia");
	sdt.setStudent_whatsappno2(9999999999l);
	int i=master.deleteStudent(6684, con);
	System.out.println(i);
	
	
	
	ConnectionUtility.closeConnection(null, null);
}
}
