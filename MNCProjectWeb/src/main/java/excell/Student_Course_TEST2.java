package excell;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import dao.ConnectionUtility;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public class Student_Course_TEST2 {
public static void main(String[] args) {
	
	SCourse_MasterExcel_DAO dao=new SCourse_MasterExcel_DAOImpl();
//	//dao.realAll();
	Collection<Student_CourseDTO> allusers=dao.readAll();
	//System.out.println(allusers);
	Iterator<Student_CourseDTO> iter=allusers.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
//	//---------------------------------------------
	
	System.out.println("//---------------------------------------------");
	
//	//dao.realAll();
	Collection<Student_CourseDTO> all1=dao.readByRange(2, 3);
	//System.out.println(allusers);
//	Iterator<Student_CourseDTO> iter1=all1.iterator();
//	while(iter1.hasNext()) {
//		System.out.println(iter1.next());
//	}	
//	Student_CourseCK ck=new Student_CourseCK(9999999999l, 9999999);
//	Student_CourseDTO st=dao.readyByID(ck);
//	System.out.println(st);
	
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
