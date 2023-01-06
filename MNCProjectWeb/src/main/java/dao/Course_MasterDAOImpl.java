package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Course_MasterDAOImpl implements Course_MasterDAO, Cloneable{
	private Course_MasterDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static Course_MasterDAOImpl  coursedao;
	public static Course_MasterDAOImpl createCourseDAOInstance() {
		if(coursedao==null){
			coursedao=new Course_MasterDAOImpl();
			return coursedao;
		}else {
			return coursedao.createClone();
		}
	}
		public Course_MasterDAOImpl createClone() {
			try {
				return (Course_MasterDAOImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public static Course_MasterDTO createOneDTO(ResultSet rs) throws Exception {
			Course_MasterDTO master=new Course_MasterDTO();
			if(rs.next()) {
				
				master.setCourse_id(rs.getInt(1));
				master.setCourse_name(rs.getString(2));
				master.setDuration_in_hrs(rs.getInt(3));
				master.setCourse_level(rs.getInt(4));
				master.setCourse_fees(rs.getInt(5));
			return master;
			}else {
				return null;
		}
		}
		
		public static Collection<Course_MasterDTO>  createManyDTOs(ResultSet rs) throws Exception {
			List<Course_MasterDTO> mydtos=new ArrayList<>();
			while(rs.next()) {
				Course_MasterDTO master=new Course_MasterDTO();
				master.setCourse_id(rs.getInt(1));
				master.setCourse_name(rs.getString(2));
				master.setDuration_in_hrs(rs.getInt(3));
				master.setCourse_level(rs.getInt(4));
				master.setCourse_fees(rs.getInt(5));
				mydtos.add(master);
			}
			return mydtos;
		}
		
		@Override
		public Course_MasterDTO findByID(int cid, Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=con.prepareStatement("select * from course where course_id=?");
				ps.setInt(1, cid);
				rs=ps.executeQuery();
				Course_MasterDTO master= Course_MasterDAOImpl.createOneDTO(rs);
					return master;
				
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				try {
					if(ps!=null && rs!=null) {
						ps.close();
						rs.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		@Override
		public Collection<Course_MasterDTO> findAll(Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=con.prepareStatement("select * from course");
				
				rs=ps.executeQuery();
				if(rs!=null) {
					Collection<Course_MasterDTO> masters=Course_MasterDAOImpl.createManyDTOs(rs);
					return masters;
				}else{
					return null;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(ps!=null && rs!=null) {
						ps.close();
						rs.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		@Override
		public Course_MasterDTO findByName(String cname, Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=con.prepareStatement("select * from course where course_name=?");
				ps.setString(1, cname);
				rs=ps.executeQuery();
				if(rs!=null) {
					Course_MasterDTO master= Course_MasterDAOImpl.createOneDTO(rs);
					return master;
				}else{
					return null;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(ps!=null && rs!=null) {
						ps.close();
						rs.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		@Override
		public int insertCourse_Master(Course_MasterDTO cmd, Connection con) {
			PreparedStatement ps=null;
			try {
				ps=con.prepareStatement("insert into course values(?,?,?,?,?)");
				Course_MasterDTO master=new Course_MasterDTO();
				
				ps.setInt(1, cmd.getCourse_id());
				ps.setString(2, cmd.getCourse_name());
				ps.setInt(3, cmd.getDuration_in_hrs());
				ps.setInt(4, cmd.getCourse_level());
				ps.setInt(5, cmd.getCourse_fees());
			
				int i=ps.executeUpdate();
				return i;
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				try {
					if(ps!=null ) {
						ps.close();
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		}
		
	

		@Override
		public int updateCourse_Master(Course_MasterDTO cmd, Connection con) {
			PreparedStatement ps=null;
			
			try {
				ps=con.prepareStatement("update course set course_id=?,course_name=?,duration_in_hrs=?,course_level=?,course_fees=? where course_id=?");
				
				
				Course_MasterDTO master=new Course_MasterDTO();
				
				
				ps.setInt(1, cmd.getCourse_id());
				ps.setString(2, cmd.getCourse_name());
				ps.setInt(3, cmd.getDuration_in_hrs());
				ps.setInt(4, cmd.getCourse_level());
				ps.setInt(5, cmd.getCourse_fees());
				ps.setInt(6, cmd.getCourse_id());
				
				
//				master.setCourse_id(cmd.getCourse_id());
//				master.setCourse_name(cmd.getCourse_name());
//				master.setDuration_in_hrs(cmd.getDuration_in_hrs());
//				master.setCourse_level(cmd.getCourse_level());
//				master.setCourse_fees(cmd.getCourse_fees());
				int i=ps.executeUpdate();
				return i;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(ps!=null ) {
					ps.close();
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
	}
		@Override
		public int deleteCourse_MasterByID(int cid, Connection con) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("delete from course where course_id=?");
			ps.setInt(1, cid);
			int i=ps.executeUpdate();
			return i;}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				try {
					if(ps!=null ) {
						ps.close();
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		}
		@Override
		public int deleteCourse_MasterByName(String cname, Connection con) {
			PreparedStatement ps=null;
			try {
				ps=con.prepareStatement("delete from course where course_name=?");
				ps.setString(1, cname);
				int i=ps.executeUpdate();
				return i;}catch(Exception e) {
					e.printStackTrace();
					return 0;
				}finally {
					try {
						if(ps!=null ) {
							ps.close();
							
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				
				}
			}
		@Override
		public Collection<Course_MasterDTO> findCoursesByLevel(int level, Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=con.prepareStatement("select * from course where course_level=?");
				ps.setInt(1, level);
				rs=ps.executeQuery();
				if(rs!=null) {
					Collection<Course_MasterDTO> masters=Course_MasterDAOImpl.createManyDTOs(rs);
					return masters;
				}else{
					return null;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(ps!=null && rs!=null) {
						ps.close();
						rs.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
}