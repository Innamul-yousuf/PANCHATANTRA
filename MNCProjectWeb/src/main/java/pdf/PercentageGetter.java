package pdf;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

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

public class PercentageGetter {
	public float getpercentage(long stud_id, int cid) {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Collection<PanchatanthraDTO> allusers = master.findAll(con);
		Iterator<PanchatanthraDTO> iter = allusers.iterator();
		float Total_P = 0.0f;
		while (iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			long stu_id = smd.getStudent_id();
			if (stu_id == stud_id) {
				Student_MasterDAO sm = Student_MasterDAOImpl.createStudentDAOInstance();
				Student_MasterDTO smt = sm.findByID(stu_id, con);
				String student_name = smt.getStudent_name();
				int cour_id = smd.getCourse_id();
				Course_MasterDAO cm = Course_MasterDAOImpl.createCourseDAOInstance();
				Course_MasterDTO ccm = cm.findByID(cour_id, con);
				String course_name = ccm.getCourse_name();
				int cod_count = smd.getCod_count();
				int qod_count = smd.getQod_count();
				int tod_count = smd.getTod_count();
				int low_count = smd.getLow_count();
				int Vow_count = smd.getVow_count();
				float Total = ((cod_count * 5) + (qod_count * 5) + tod_count + (low_count * 25) + (Vow_count * 25));
				Total_P = (Total / 125) * 100;
				return Total_P;
			}
		}
		return Total_P;
	}

	public static PanchatanthraDTO getAllDetails(long stud_id, int cid) {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Student_CourseCK ck=new Student_CourseCK(stud_id, cid);
		PanchatanthraDTO smd = master.findByID(ck, con);
		
		float Total_P = 0.0f;
		
			long stu_id = smd.getStudent_id();
			if (stu_id == stud_id) {
				Student_MasterDAO sm = Student_MasterDAOImpl.createStudentDAOInstance();
				Student_MasterDTO smt = sm.findByID(stu_id, con);
				String student_name = smt.getStudent_name();
				int cour_id = smd.getCourse_id();
				Course_MasterDAO cm = Course_MasterDAOImpl.createCourseDAOInstance();
				Course_MasterDTO ccm = cm.findByID(cour_id, con);
				String course_name = ccm.getCourse_name();
				int cod_count = smd.getCod_count();
				int qod_count = smd.getQod_count();
				int tod_count = smd.getTod_count();
				int low_count = smd.getLow_count();
				int Vow_count = smd.getVow_count();
				float Total = ((cod_count * 5) + (qod_count * 5) + tod_count + (low_count * 25) + (Vow_count * 25));
				Total_P = (Total / 125) * 100;
				
			}
		
			return smd;
	}
}
