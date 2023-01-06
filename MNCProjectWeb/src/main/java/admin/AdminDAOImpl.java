package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
 
public class AdminDAOImpl implements AdminDAO, Cloneable{
	
	private AdminDAOImpl() {
		
	}
	private static AdminDAOImpl adao;
	public static AdminDAOImpl createAdminInstance() {
		if(adao==null) {
			adao=new AdminDAOImpl();
			return adao;
		}else {
			return adao.createClone();
		}
	}
	public AdminDAOImpl createClone() {
		try {
			return (AdminDAOImpl)super.clone();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkAdmin(long id, String pass) {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from admin where id=? and pass=?");
			ps.setLong(1, id);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			AdminDTO adto=new AdminDTO();
			adto.setName(rs.getString(1));
			adto.setAname(rs.getString(2));
			adto.setId(rs.getLong(3));
			adto.setPass(rs.getString(4));
			adto.setEmail(rs.getString(5));
			adto.setWhatsapp(rs.getLong(6));
			adto.setFlag(rs.getInt(7));
			if(rs.next()) {
				ConnectionUtility.closeConnection(null, null);
				return true;
			}
			else {
				ConnectionUtility.closeConnection(null, null);
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionUtility.closeConnection(null, null);
		return false;
	}
	
	
	@Override
	public AdminDTO getAdmin(@PathParam("id") long id,@PathParam("pass")  String pass) {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from admin where id=? and pass=?");
			ps.setLong(1, id);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			AdminDTO adto=new AdminDTO();
			adto.setName(rs.getString(1));
			adto.setAname(rs.getString(2));
			adto.setId(rs.getLong(3));
			adto.setPass(rs.getString(4));
			adto.setEmail(rs.getString(5));
			adto.setWhatsapp(rs.getLong(6));
			adto.setFlag(rs.getInt(7));
			ConnectionUtility.closeConnection(null, null);
			return adto;
			
			
			
		}catch (Exception e) {
			e.printStackTrace();

			ConnectionUtility.closeConnection(null, null);
			return null;
		}
	
	}

	@Override
	public boolean checkFlag(long id, String pass, Connection con) {
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps=con.prepareStatement("select flag from admin where id=? and pass=?");
			ps.setLong(1, id);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			int result1=0;
			if(rs.next()) {
				result1=rs.getInt(1);
				System.out.println(result1);
			}
			if (result1==0) {
			 	ps=con.prepareStatement("update admin set flag=1 where id=? and pass=?");
			 	ps.setLong(1, id);
				ps.setString(2, pass);
				ps.executeUpdate();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean reSetFlag() {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("update admin set flag=0");
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public AdminDTO findAll(Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from admin");
			
			rs=ps.executeQuery();
			AdminDTO admin=new AdminDTO();
					if(rs.next()) {
					admin.setName(rs.getString(1));
					admin.setAname(rs.getString(2));
					admin.setId(rs.getLong(3));
					admin.setPass(rs.getString(4));
					admin.setEmail(rs.getString(5));
					admin.setWhatsapp(rs.getLong(6));
					admin.setFlag(rs.getInt(7));
						return admin;
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
	public AdminDTO try2(long id, String pass, Connection con) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from admin where id=? and pass=?");
			ps.setLong(1, id);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			AdminDTO admin=new AdminDTO();
					if(rs.next()) {
					admin.setName(rs.getString(1));
					admin.setAname(rs.getString(2));
					admin.setId(rs.getLong(3));
					admin.setPass(rs.getString(4));
					admin.setEmail(rs.getString(5));
					admin.setWhatsapp(rs.getLong(6));
					admin.setFlag(rs.getInt(7));
						return admin;
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

}
