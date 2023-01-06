package services;

import java.util.Collection;

import dao.Course_MasterDTO;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public interface P_Service{
	public PanchatanthraDTO getPDTO(long sid,int cid);
	public int insertValue(PanchatanthraDTO sc);
	public Collection<PanchatanthraDTO> getSCDTOAll();
	public void insertMany(Collection<PanchatanthraDTO> col);
	public void deleteAll();
}
