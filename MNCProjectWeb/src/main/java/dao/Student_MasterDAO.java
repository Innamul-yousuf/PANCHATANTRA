package dao;

import java.sql.Connection;
import java.util.Collection;

public interface Student_MasterDAO {
	public Student_MasterDTO findByID(long id,Connection con);
	public Collection<Student_MasterDTO> findByName(String name,Connection con);
	public Collection<Student_MasterDTO> findByCity(String city,Connection con);
	public Collection<Student_MasterDTO> findByCollege(String college,Connection con);
	public Collection<Student_MasterDTO> findAll(Connection con);
	public Collection<Student_MasterDTO> findByCountry(String country,Connection con);
	public Collection<Student_MasterDTO> findByYear(String year, Connection con);
	public Collection<Student_MasterDTO> findByCollegeAndYear(String college,String year,Connection con);
	public Collection<Student_MasterDTO> findByCellNumber(long cellno,Connection con);
	public int updateStudentMaster(Student_MasterDTO sm,Connection con);
	public int deleteStudent(int id,Connection con);
	public int insertStudent(Student_MasterDTO sm,Connection con);
}
