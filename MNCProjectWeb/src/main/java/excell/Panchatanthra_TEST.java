package excell;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import dao.ConnectionUtility;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public class Panchatanthra_TEST {
public static void main(String[] args) {
	
	PanchatanthraExcel_DAO dao=new PanchatanthraExcel_DAOImpl();
	//dao.realAll();
//	Collection<PanchatanthraDTO> allusers=dao.readAll();
//	//System.out.println(allusers);
//	Iterator<PanchatanthraDTO> iter=allusers.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next());
//	}
	//---------------------------------------------
	
	System.out.println("//---------------------------------------------");
	
//	//dao.realAll();
	Collection<PanchatanthraDTO> all1=dao.readByRange(5,6);
	//System.out.println(allusers);
	Iterator<PanchatanthraDTO> iter1=all1.iterator();
	while(iter1.hasNext()) {
		System.out.println(iter1.next());
	}	
//	Student_CourseCK ck=new Student_CourseCK(123123, 23444);
//	PanchatanthraDTO st=dao.readyByID(ck);
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
