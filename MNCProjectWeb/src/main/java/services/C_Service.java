package services;

import java.util.Collection;

import dao.Course_MasterDTO;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_MasterDTO;

public interface C_Service{
	public Course_MasterDTO getCourse(int cid);
	public int insertValue(Course_MasterDTO cm);
	public Collection<Course_MasterDTO> getPDTOAll();
	public void insertMany(Collection<Course_MasterDTO> col);
	
}
