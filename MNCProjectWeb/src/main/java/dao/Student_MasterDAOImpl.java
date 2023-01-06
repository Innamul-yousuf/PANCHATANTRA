package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class Student_MasterDAOImpl implements Student_MasterDAO, Cloneable{
	
	public Student_MasterDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static Student_MasterDAOImpl masterdao;
	public static Student_MasterDAOImpl createStudentDAOInstance() {
		if(masterdao==null){
			masterdao=new Student_MasterDAOImpl();
			return masterdao;
		}else {
			return masterdao.createClone();
		}
	
	}
	
	public Student_MasterDAOImpl createClone() {
		try {
			return (Student_MasterDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
public static Student_MasterDTO createOneDTO(ResultSet rs) throws Exception {
	Student_MasterDTO master=new Student_MasterDTO();
	if(rs.next()) {
		master.setStudent_id(rs.getLong(1));
		master.setStudent_name(rs.getString(2));
		master.setStudent_pass(rs.getString(3));
		master.setStudent_whatsappno1(rs.getLong(4));
		master.setStudent_whatsappno2(rs.getLong(5));
		master.setStudent_whatsappno3(rs.getLong(6));
		master.setStudent_email1(rs.getString(7));
		master.setStudent_email2(rs.getString(8));
		master.setStudent_email3(rs.getString(9));
		master.setStudent_address1(rs.getString(10));
		master.setStudent_address2(rs.getString(11));
		master.setStudent_city(rs.getString(12));
		master.setStudent_country(rs.getString(13));
		master.setStudent_college(rs.getString(14));
		master.setStudent_college_year(rs.getString(15));
		return master;
	}else {
		return null;
}
}

public static Collection<Student_MasterDTO>  createManyDTOs(ResultSet rs) throws Exception {
	List<Student_MasterDTO> mydtos=new ArrayList<>();
	while(rs.next()) {
		Student_MasterDTO master=new Student_MasterDTO();
		master.setStudent_id(rs.getLong(1));
		master.setStudent_name(rs.getString(2));
		master.setStudent_pass(rs.getString(3));
		master.setStudent_whatsappno1(rs.getLong(4));
		master.setStudent_whatsappno2(rs.getLong(5));
		master.setStudent_whatsappno3(rs.getLong(6));
		master.setStudent_email1(rs.getString(7));
		master.setStudent_email2(rs.getString(8));
		master.setStudent_email3(rs.getString(9));
		master.setStudent_address1(rs.getString(10));
		master.setStudent_address2(rs.getString(11));
		master.setStudent_city(rs.getString(12));
		master.setStudent_country(rs.getString(13));
		master.setStudent_college(rs.getString(14));
		master.setStudent_college_year(rs.getString(15));
		 mydtos.add(master);
	}
	return mydtos;
}
	
	@Override
	public Student_MasterDTO findByID(long id, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_id=?");
			ps.setLong(1, id);
			rs=ps.executeQuery();
				Student_MasterDTO master= Student_MasterDAOImpl.createOneDTO(rs);
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
	public Collection<Student_MasterDTO> findByName(String name, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 ps=con.prepareStatement("select * from student_master where student_name=?");
			ps.setString(1, name);
			 rs=ps.executeQuery();
			if(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
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
	public Collection<Student_MasterDTO> findByCity(String city, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_city=?");
			ps.setString(1, city);
			rs=ps.executeQuery();
			if(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
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
	public Collection<Student_MasterDTO> findByCollege(String college, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_college=?");
			ps.setString(1, college);
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			if(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
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
	public Collection<Student_MasterDTO> findAll(Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master");
			
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			if(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
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
	public Collection<Student_MasterDTO> findByCountry(String country, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_country=?");
			ps.setString(1, country);
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			while(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
				return masters;
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
		return null;
		
	}

	@Override
	public Collection<Student_MasterDTO> findByYear(String year, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_college_year=?");
			ps.setString(1, year);
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			while(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
				return masters;
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
		return null;
		
	}
	
	@Override
	public Collection<Student_MasterDTO> findByCollegeAndYear(String college, String year, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_college=? AND student_college_year=?");
			ps.setString(1, college);
			ps.setString(2, year);
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			while(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
				return masters;
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
		return null;
		
	}

	@Override
	public Collection<Student_MasterDTO> findByCellNumber(long cellno, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from student_master where student_whatsappno1=? OR student_whatsappno2=? OR student_whatsappno3=?");
			ps.setLong(1, cellno);
			ps.setLong(2, cellno);
			ps.setLong(3, cellno);
			rs=ps.executeQuery();
			//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
			if(rs!=null) {
				Collection<Student_MasterDTO> masters=Student_MasterDAOImpl.createManyDTOs(rs);
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
	public int updateStudentMaster(Student_MasterDTO sm, Connection con) {
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("update student_master set student_id=?,student_name=?,student_pass=?,student_whatsappno1 =?,student_whatsappno2=?,student_whatsappno3=?,student_email1=?,student_email2=?,student_email3=?,student_address1=?,student_address2=?,student_city=?,student_country=?,student_college=?,student_college_year=? where student_id=?");
			
			
			ps.setLong(1,sm.getStudent_id());
			ps.setString(2, sm.getStudent_name());
			ps.setString(3, sm.getStudent_pass());
			ps.setLong(4, sm.getStudent_whatsappno1());
			ps.setLong(5, sm.getStudent_whatsappno2());
			ps.setLong(6, sm.getStudent_whatsappno3());
			ps.setString(7, sm.getStudent_email1());
			ps.setString(8, sm.getStudent_email2());
			ps.setString(9, sm.getStudent_email3());
			ps.setString(10, sm.getStudent_address1());
			ps.setString(11, sm.getStudent_address2());
			ps.setString(12, sm.getStudent_city());
			ps.setString(13, sm.getStudent_country());
			ps.setString(14, sm.getStudent_college());
			ps.setLong(16,sm.getStudent_id());
			ps.setString(15, sm.getStudent_college_year());
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
	public int deleteStudent(int id, Connection con) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("delete from student_master where student_id=?");
			
			ps.setLong(1,id);
		
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
	public int insertStudent(Student_MasterDTO sm, Connection con) {
		PreparedStatement ps=null;
		try {
			 ps=con.prepareStatement("insert into student_master values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setLong(1,sm.getStudent_id());
			ps.setString(2, sm.getStudent_name());
			ps.setString(3, sm.getStudent_pass());
			ps.setLong(4, sm.getStudent_whatsappno1());
			ps.setLong(5, sm.getStudent_whatsappno2());
			ps.setLong(6, sm.getStudent_whatsappno3());
			ps.setString(7, sm.getStudent_email1());
			ps.setString(8, sm.getStudent_email2());
			ps.setString(9, sm.getStudent_email3());
			ps.setString(10, sm.getStudent_address1());
			ps.setString(11, sm.getStudent_address2());
			ps.setString(12, sm.getStudent_city());
			ps.setString(13, sm.getStudent_country());
			ps.setString(14, sm.getStudent_college());
			ps.setString(15, sm.getStudent_college_year());
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
