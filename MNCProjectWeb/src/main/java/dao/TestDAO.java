package dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;




public class TestDAO {
public static void main(String[] args) {
	
	
	Connection con=ConnectionUtility.getConnection();
//	Student_MasterDAO userdao=Student_MasterDAOImpl.createStudentDAOInstance();
//	Student_MasterDTO smd=new Student_MasterDTO();
//	smd.setStudent_id(23423);
//	smd.setStudent_address1("etrert");
//	
//	int u=userdao.updateStudentMaster(smd, con);
	
	PanchatanthraDAO userdaof=PanchatanthraDAOImpl.createPanchaDAOInstance();
	
	
	
	PanchatanthraDTO pdt=new PanchatanthraDTO();
	pdt.setStudent_id(123123);
	pdt.setCourse_id(23444);
	Student_CourseCK scck=new Student_CourseCK(123123, 23444);
	PanchatanthraDTO dto=userdaof.findByID(scck, con);
	System.out.println(dto);
	
	
	
	//Student_MasterDTO user=userdao.findByName("rtydfdf", con);
	
//	Student_CourseDAO userdaof=Student_CourseDAOImpl.createCourseDAOInstance();
//	Student_CourseDTO sc=new Student_CourseDTO();
//	sc.setStudent_id(5555);
//	sc.setCourse_id(2224);	
//	sc.setFees_paid(2666);
//	sc.setStudent_CJD("2002-02-02");
//	sc.setStudent_CED("2003-03-04");
//	sc.setStudent_CAttendance(12);
//	sc.setStudent_CGrade(6);
//	
//	Student_CourseCK scck=new Student_CourseCK(23423, 23444);
//	
//	int i=userdaof.deleteStudent_CourseByID(scck, con);
//	System.out.println(i);
//	Student_CourseDTO scdt=userdaof.findByID(scck, con);
//	System.out.println(scdt);
	
	//int i=userdaof.updateStudent_Course(sc, con);
	//System.out.println(i);
	
//	Collection<Student_MasterDTO> allusers=userdaof.findAll(con);
//	System.out.println(allusers);
//	Student_MasterDTO st=new Student_MasterDTO();
	//st.setStudent_college_year("5");
//	st.setStudent_id(444123);
//
//	st.setStudent_email2("ffff@gmail.com");
//	int i=userdaof.updateStudentMaster(st, con);
//	System.out.println(i);
	//int i=userdaof.deleteStudent(123123, con);
	//System.out.println(i);
//	Collection<Student_CourseDTO> allusers=userdaof.findAll(con);
//	System.out.println(allusers);
//	Iterator<Student_CourseDTO> iter=allusers.iterator();
//	
//	while(iter.hasNext()) {
//		
//
//		System.out.println(iter.next());
//	}
	//System.out.println("ddd");
//	
	//System.out.println(user);
//	System.out.println(user.getUid());
//	System.out.println(user.getAmt());
//	LoginService ls=new LoginService();
//	System.out.println(ls.checkUser(user.getUid(), user.getUpass()));
//	
//	Student_CourseDAO coursed=Student_CourseDAOImpl.createCourseDAOInstance();
//	Student_CourseCK scck=new Student_CourseCK(23423, 23444);
//	
//	Student_CourseDTO cdt=coursed.findByID(scck, con);
//	System.out.println(cdt);
	
//	Course_MasterDAO co=Course_MasterDAOImpl.createCourseDAOInstance();
//	Course_MasterDTO cm= co.findByName("eeeer", con);
//	System.out.println(cm);
	
	ConnectionUtility.closeConnection(null, null);
}
}
