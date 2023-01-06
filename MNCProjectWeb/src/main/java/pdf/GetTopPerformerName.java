package pdf;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import dao.ConnectionUtility;
import dao.Course_MasterDAO;
import dao.Course_MasterDAOImpl;
import dao.Course_MasterDTO;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;

public class GetTopPerformerName {
	private String Stu_name;

	public String getStu_name() {
		return Stu_name;
	}

	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}

	public Long TopPerformer() {

		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();

		SortingDemo sd = new SortingDemo();
		Collection<PanchatanthraDTO> sc = sd.sortByRanking();
		Iterator<PanchatanthraDTO> iter1 = sc.iterator();
		while (iter1.hasNext()) {
			PanchatanthraDTO smd = iter1.next();
			long stu_id;
			stu_id = smd.getStudent_id();
			// System.out.println(stu_id);

			return stu_id;

			// break;

		}
		return 0l;

	}

	public String getStuName(Long sid) {
//	Connection con=ConnectionUtility.getConnection();
//    Course_MasterDAO cm=Course_MasterDAOImpl.createCourseDAOInstance();
//    
//   Course_MasterDTO cmt=cm.findByID(0, con);
//   String stu_name=cmt.getCourse_name();
//   
		Connection con = ConnectionUtility.getConnection();
		Student_MasterDAO sm = Student_MasterDAOImpl.createStudentDAOInstance();

		Student_MasterDTO cmt = sm.findByID(sid, con);
		String stu_name = cmt.getStudent_name();

		return stu_name;
	}

	public String getCourseName(Long sid, int cid) {
		Connection con = ConnectionUtility.getConnection();
		Course_MasterDAO cm = Course_MasterDAOImpl.createCourseDAOInstance();

		Course_MasterDTO cmt = cm.findByID(cid, con);
		String cour_name = cmt.getCourse_name();

		PanchatanthraDAO pda = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Student_CourseCK sck = new Student_CourseCK(sid, cid);
		sck.setSid(sid);
		sck.setCid(cid);
		PanchatanthraDTO pdt = pda.findByID(sck, con);

		return cour_name;
	}
}
