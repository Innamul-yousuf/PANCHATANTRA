package dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

public class TestDAO_PanchaThantra {
public static void main(String[] args) {
	Connection con=ConnectionUtility.getConnection();
	PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
	PanchatanthraDTO sdt=new PanchatanthraDTO();
	Student_CourseCK ck=new Student_CourseCK(12333, 23333);
	sdt.setStudent_id(12333);
	sdt.setCourse_id(23333);
	sdt.setCod_count(9);
	sdt.setLow_count(4);
	sdt.setQod_count(99);
	
	int i=master.updatePanchatanthraDTO(sdt, con);
	System.out.println(i);
	System.out.println("____");
	
//	Collection<PanchatanthraDTO> allusers=master.findAll(con);
//	//System.out.println(allusers);
//	Iterator<PanchatanthraDTO> iter=allusers.iterator();
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
