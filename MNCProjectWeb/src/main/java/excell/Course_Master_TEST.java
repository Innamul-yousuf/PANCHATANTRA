package excell;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import dao.ConnectionUtility;
import dao.Course_MasterDTO;
import dao.Student_MasterDTO;

public class Course_Master_TEST {
public static void main(String[] args) {
	
	Course_MasterDTOExcel_DAO dao=new Course_MasterDTOExcel_DAOImpl();
	//dao.realAll();
	Collection<Course_MasterDTO> allusers=dao.readAll();
	//System.out.println(allusers);
	Iterator<Course_MasterDTO> iter=allusers.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
	//---------------------------------------------
	
	System.out.println("//---------------------------------------------");
	
//	//dao.realAll();
//	Collection<Course_MasterDTO> all1=dao.readByRange(1, 3);
//	//System.out.println(allusers);
//	Iterator<Course_MasterDTO> iter1=all1.iterator();
//	while(iter1.hasNext()) {
//		System.out.println(iter1.next());
//	}	
	
//	Course_MasterDTO st=dao.readyByID(333);
//	System.out.println(st);
	

	
	
}
}
