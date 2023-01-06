package dao;

import java.sql.Connection;
import java.util.Collection;

public interface Course_MasterDAO extends Cloneable {
	public Course_MasterDTO findByID(int cid,Connection con);
	public Collection<Course_MasterDTO> findAll(Connection con);
	public Course_MasterDTO findByName(String cname,Connection con);
	public int insertCourse_Master(Course_MasterDTO cmd,Connection con);
	public int updateCourse_Master(Course_MasterDTO cmd,Connection con);
	public int deleteCourse_MasterByID(int cid,Connection con);
	public int deleteCourse_MasterByName(String cname,Connection con);
	public Collection<Course_MasterDTO> findCoursesByLevel(int level,Connection con);
}
