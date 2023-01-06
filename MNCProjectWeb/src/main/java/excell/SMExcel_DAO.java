package excell;

import java.util.Collection;

import dao.Student_MasterDTO;


public interface SMExcel_DAO {
	public Collection<Student_MasterDTO > readAll();
	public Student_MasterDTO readyByID(long id);
	public Collection<Student_MasterDTO> readByRange(int start_row,int end_row);
}
