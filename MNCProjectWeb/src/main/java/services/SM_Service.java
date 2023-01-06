package services;

import java.util.Collection;

import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_MasterDTO;

public interface SM_Service{
	public Student_MasterDTO getSDTO(long sid);
	public Collection<Student_MasterDTO> getPDTOAll();
	public int insertValue(Student_MasterDTO sm);
	public void insertMany(Collection<Student_MasterDTO> col);
	
}
