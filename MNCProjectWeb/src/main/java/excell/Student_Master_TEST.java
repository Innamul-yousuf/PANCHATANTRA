package excell;

import java.io.File;
import java.lang.System.Logger;
import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.LogManager;

import org.apache.logging.log4j.spi.LoggerContext;

import dao.ConnectionUtility;
import dao.Student_MasterDTO;

public class Student_Master_TEST {
public static void main(String[] args) {



//	
	SMExcel_DAO dao=new SMExcel_DAOImpl();
//	//dao.realAll();
	Collection<Student_MasterDTO> allusers=dao.readAll();
	//System.out.println(allusers);
	Iterator<Student_MasterDTO> iter=allusers.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
	//---------------------------------------------
	
	System.out.println("//---------------------------------------------");
	
//	//dao.realAll();
//	Collection<Student_MasterDTO> all1=dao.readByRange(1, 3);
//	//System.out.println(allusers);
//	Iterator<Student_MasterDTO> iter1=all1.iterator();
//	while(iter1.hasNext()) {
//		System.out.println(iter1.next());
//	}	
	
	Student_MasterDTO st=dao.readyByID(123123);
	System.out.println(st);
	
//	Course_MasterDAOImpl master=Course_MasterDAOImpl.createCourseDAOInstance();
//	Course_MasterDTO cdt=new Course_MasterDTO();
//	cdt.setCourse_id(555);
//	cdt.setCourse_fees(444);
//	cdt.setCourse_level(2);
//	cdt.setCourse_name("python");
//	int i=master.updateCourse_Master(cdt, con);
//	System.out.println(i);
//	
	
	
	//int i=master.insertCourse_Master(cdt, con);
//	System.out.println(i);
	System.out.println("____");
	
//	Collection<Course_MasterDTO> allusers=master.
//	//System.out.println(allusers);
//	Iterator<Course_MasterDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	
	
}
}
