package totalDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dao.PanchatanthraDTO;
import dao.Student_CourseCK;

public class PanchataAllImpl implements PanchaAllDAO, Cloneable{
	private PanchataAllImpl() {
		// TODO Auto-generated constructor stub
	}
	private static PanchataAllImpl  pandao;
	public static PanchataAllImpl createPanchaDAOInstance() {
		if(pandao==null){
			pandao=new PanchataAllImpl();
			return pandao;
		}else {
			return pandao.createClone();
		}
	}
		public PanchataAllImpl createClone() {
			try {
				return (PanchataAllImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public static PanchaAllDTO createOneDTO(ResultSet rs) throws Exception {
			PanchaAllDTO master=new PanchaAllDTO();
			if(rs.next()) {
				master.setStudent_id(rs.getLong(1));
				master.setCourse_id(rs.getInt(2));
				master.setCod_count(rs.getInt(3));
				master.setQod_count(rs.getInt(4));
				master.setTod_count(rs.getInt(5));
				master.setLow_count(rs.getInt(6));
				master.setVow_count(rs.getInt(7));
				return master;
			}else {
				return null;
		}
		}

		public static Collection<PanchaAllDTO>  createManyDTOs(ResultSet rs) throws Exception {
			List<PanchaAllDTO> mydtos=new ArrayList<>();
			while(rs.next()) {
				PanchaAllDTO master=new PanchaAllDTO();
				master.setStudent_id(rs.getLong(1));
				master.setCourse_id(rs.getInt(2));
				master.setCod_count(rs.getInt(3));
				master.setQod_count(rs.getInt(4));
				master.setTod_count(rs.getInt(5));
				master.setLow_count(rs.getInt(6));
				master.setVow_count(rs.getInt(7));
				mydtos.add(master);
			}
			return mydtos;
		}

		
		@Override
		public PanchaAllDTO findByID(Student_CourseCK scck, Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				
				ps=con.prepareStatement("select * from panchatanthraAll where student_id=? AND course_id=?");
				ps.setLong(1, scck.getSid());
				ps.setInt(2, scck.getCid());
				rs=ps.executeQuery();
				PanchaAllDTO master=PanchataAllImpl.createOneDTO(rs);
				
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
		public Collection<PanchaAllDTO> findAll(Connection con) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=con.prepareStatement("select * from panchatanthraAll");
				
				rs=ps.executeQuery();
				//List<Student_MasterDTO> masters=new ArrayList<Student_MasterDTO>();
				if(rs!=null) {
					Collection<PanchaAllDTO> masters=PanchataAllImpl.createManyDTOs(rs);
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
		public int insertPanchataAllDTO(PanchatanthraDTO cmd, Connection con) {
			PreparedStatement ps=null;
			try {
				 ps=con.prepareStatement("insert into panchatanthraAll values(?,?,?,?,?,?,?)");
				 PanchatanthraDTO master=new PanchatanthraDTO();
				 	ps.setLong(1, cmd.getStudent_id());
				 	ps.setInt(2, cmd.getCourse_id());
				 	ps.setInt(3, cmd.getCod_count());
				 	ps.setInt(4, cmd.getQod_count());
				 	ps.setInt(5, cmd.getTod_count());
				 	ps.setInt(6,cmd.getLow_count());
				 	ps.setInt(7, cmd.getVow_count());
				 	
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
		public int updatePanchaAllDTO(PanchatanthraDTO cmd, Connection con) {
			PreparedStatement ps=null;
			try {
				 ps=con.prepareStatement("update panchatanthraAll set student_id=?,course_id=?,cod_count=?,qod_count=?,tod_count=?,low_count=?,vow_count=? where student_id=? AND course_id=?");
				 PanchatanthraDTO master=new PanchatanthraDTO();
				 	ps.setLong(1, cmd.getStudent_id());
				 	ps.setInt(2, cmd.getCourse_id());
				 	ps.setInt(3, cmd.getCod_count());
				 	ps.setInt(4, cmd.getQod_count());
				 	ps.setInt(5, cmd.getTod_count());
				 	ps.setInt(6,cmd.getLow_count());
				 	ps.setInt(7, cmd.getVow_count());
				 	ps.setLong(8, cmd.getStudent_id());
				 	ps.setLong(9, cmd.getCourse_id());
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
		public int deletePanchaAllDTOByID(Student_CourseCK cid, Connection con) {
			PreparedStatement ps=null;
			try {
			ps=con.prepareStatement("delete from panchatanthraAll where student_id=? AND course_id=?");
			
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
