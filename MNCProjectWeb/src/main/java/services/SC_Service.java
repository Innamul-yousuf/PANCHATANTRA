package services;

import java.util.Collection;

import dao.Course_MasterDTO;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public interface SC_Service{
	public Student_CourseDTO getSC(long sid,int cid);
	public int insertValue(Student_CourseDTO sc);
	public Collection<Student_CourseDTO> getSCDTOAll();
	public void insertMany(Collection<Student_CourseDTO> col);
	
}
