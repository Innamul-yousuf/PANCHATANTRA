package dao;

import java.sql.Connection;
import java.util.Collection;

public interface Student_CourseDAO {
	public Student_CourseDTO findByID(Student_CourseCK scck,Connection con);
	public Collection<Student_CourseDTO> findAll(Connection con);
	public int insertStudent_Course(Student_CourseDTO cmd,Connection con);
	public int updateStudent_Course(Student_CourseDTO cmd,Connection con);
	public int deleteStudent_CourseByID(Student_CourseCK cid,Connection con);
}
