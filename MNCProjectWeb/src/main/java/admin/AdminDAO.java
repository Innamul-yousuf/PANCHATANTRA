package admin;

import java.sql.Connection;

import dao.Course_MasterDTO;

public interface AdminDAO {
	public boolean  checkAdmin(long id, String pass);
	public boolean checkFlag(long id,String pass,Connection con);
	public boolean reSetFlag();
	public AdminDTO findAll(Connection con);
	public AdminDTO getAdmin(long id, String pass);
	AdminDTO try2(long id, String pass,Connection con);
}
