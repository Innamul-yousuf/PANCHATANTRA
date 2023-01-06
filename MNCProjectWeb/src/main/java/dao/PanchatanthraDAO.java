package dao;

import java.sql.Connection;
import java.util.Collection;

public interface PanchatanthraDAO extends Cloneable{
	public PanchatanthraDTO findByID(Student_CourseCK scck,Connection con);
	public Collection<PanchatanthraDTO> findAll(Connection con);
	public int insertPanchatanthraDTO(PanchatanthraDTO cmd,Connection con);
	public int updatePanchatanthraDTO(PanchatanthraDTO cmd,Connection con);
	public int deletePanchatanthraDTOByID(Student_CourseCK cid,Connection con);
	public int deleteAllPanchatanthraDTO(Connection con);
}
