package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Student_CourseDAOImpl implements Student_CourseDAO, Cloneable {

	private Student_CourseDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static Student_CourseDAOImpl coursedao;
	public static Student_CourseDAOImpl createCourseDAOInstance() {
		if(coursedao==null){
			coursedao=new Student_CourseDAOImpl();
			return coursedao;
		}else {
			return coursedao.createClone();
		}
	}


public Student_CourseDAOImpl createClone() {
	try {
		return (Student_CourseDAOImpl)super.clone();
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}
	
public static Student_CourseDTO createOneDTO(ResultSet rs) throws Exception {
	Student_CourseDTO master=new Student_CourseDTO();
	if(rs.next()) {
		master.setStudent_id(rs.getLong(1));
		master.setCourse_id(rs.getInt(2));
		master.setFees_paid(rs.getInt(3));
		master.setStudent_CJD(rs.getString(4));
		master.setStudent_CED(rs.getString(5));
		master.setStudent_CAttendance(rs.getInt(6));
		master.setStudent_CGrade(rs.getInt(7));
		return master;
	}else {
		return null;
}
}

public static Collection<Student_CourseDTO>  createManyDTOs(ResultSet rs) throws Exception {
	List<Student_CourseDTO> mydtos=new ArrayList<>();
	while(rs.next()) {
		Student_CourseDTO master=new Student_CourseDTO();
		master.setStudent_id(rs.getLong(1));
		master.setCourse_id(rs.getInt(2));
		master.setFees_paid(rs.getInt(3));
		master.setStudent_CJD(rs.getString(4));
		master.setStudent_CED(rs.getString(5));
		master.setStudent_CAttendance(rs.getInt(6));
		master.setStudent_CGrade(rs.getInt(7));
		mydtos.add(master);
	}
	return mydtos;
}

	@Override
	public Student_CourseDTO findByID(Student_CourseCK scck, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_course where student_id=? AND course_id=?");
			ps.setLong(1, scck.getSid());
			ps.setInt(2, scck.getCid());
			rs=ps.executeQuery();
			Student_CourseDTO master=Student_CourseDAOImpl.createOneDTO(rs);
			
			
			return master;
			
			
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
	public Collection<Student_CourseDTO> findAll(Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_course");
			
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			if(rs!=null) {
				Collection<Student_CourseDTO> masters=Student_CourseDAOImpl.createManyDTOs(rs);
				return masters;
				
			}else {
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
	public int insertStudent_Course(Student_CourseDTO cmd, Connection con) {
		PreparedStatement ps=null;
		try {
			 ps=con.prepareStatement("insert into student_course values(?,?,?,?,?,?,?)");
			 Student_CourseDTO master=new Student_CourseDTO();
			 	ps.setLong(1, cmd.getStudent_id());
			 	ps.setInt(2, cmd.getCourse_id());
			 	ps.setInt(3, cmd.getFees_paid());
			 	ps.setString(4, cmd.getStudent_CJD());
			 	ps.setString(5, cmd.getStudent_CED());
			 	ps.setInt(6, cmd.getStudent_CAttendance());
			 	ps.setInt(7, cmd.getStudent_CGrade());
			 	
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
	public int updateStudent_Course(Student_CourseDTO cmd, Connection con) {
		PreparedStatement ps=null;
		try {
			 ps=con.prepareStatement("update student_course set student_id=?,course_id=?,fees_paid=?,student_CJD=?,student_CED=?,student_CAttendance=?,student_CGrade=? where student_id=? AND course_id=?");
			 Student_CourseDTO master=new Student_CourseDTO();
			 	ps.setLong(1, cmd.getStudent_id());
			 	ps.setInt(2, cmd.getCourse_id());
			 	ps.setInt(3, cmd.getFees_paid());
			 	ps.setString(4, cmd.getStudent_CJD());
			 	ps.setString(5, cmd.getStudent_CED());
			 	ps.setInt(6, cmd.getStudent_CAttendance());
			 	ps.setInt(7, cmd.getStudent_CGrade());
			 	ps.setLong(8, cmd.getStudent_id());
			 	ps.setInt(9, cmd.getCourse_id());
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
	public int deleteStudent_CourseByID(Student_CourseCK cid, Connection con) {
		PreparedStatement ps=null;
		try {
		ps=con.prepareStatement("delete from student_course where student_id=? AND course_id=?");
		
		ps.setLong(1,cid.getSid());
		ps.setInt(2, cid.getCid());
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

}
