package totalDB;

import java.sql.Connection;
import java.util.Collection;

import dao.PanchatanthraDTO;
import dao.Student_CourseCK;

public interface PanchaAllDAO extends Cloneable{
	public PanchaAllDTO findByID(Student_CourseCK scck,Connection con);
	public Collection<PanchaAllDTO> findAll(Connection con);
	public int insertPanchataAllDTO(PanchatanthraDTO cmd,Connection con);
	public int updatePanchaAllDTO(PanchatanthraDTO cmd,Connection con);
	public int deletePanchaAllDTOByID(Student_CourseCK cid,Connection con);
}
