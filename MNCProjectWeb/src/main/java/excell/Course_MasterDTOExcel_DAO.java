package excell;

import java.util.Collection;

import dao.Course_MasterDTO;

public interface Course_MasterDTOExcel_DAO {
	public Collection<Course_MasterDTO> readAll();
	public Course_MasterDTO readyByID(int id);
	public Collection<Course_MasterDTO> readByRange(int start_row,int end_row);
}