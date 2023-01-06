package excell;

import java.util.Collection;

import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public interface SCourse_MasterExcel_DAO {
	public Collection<Student_CourseDTO> readAll();
	public Student_CourseDTO readyByID(Student_CourseCK ck);
	public Collection<Student_CourseDTO> readByRange(int start_row,int end_row);
}