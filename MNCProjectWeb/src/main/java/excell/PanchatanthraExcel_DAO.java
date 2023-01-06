package excell;

import java.util.Collection;

import dao.PanchatanthraDTO;
import dao.Student_CourseCK;

public interface PanchatanthraExcel_DAO extends Cloneable{
	public Collection<PanchatanthraDTO> readAll();
	public PanchatanthraDTO readyByID(Student_CourseCK ck);
	public Collection<PanchatanthraDTO> readByRange(int start_row,int end_row);
}