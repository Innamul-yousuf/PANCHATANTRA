package admin;

import java.sql.Connection;

import dao.ConnectionUtility;

public class AdminTest {
public static void main(String[] args) {
	Connection con=ConnectionUtility.getConnection();
	AdminDAOImpl dao=AdminDAOImpl.createAdminInstance();
	AdminDTO adto=new AdminDTO();
	//adto=dao.getAdmin(7010395318l, "Innamulsec");
	//System.out.println(dao.checkAdmin(7010395318l, "Innamulsec"));
	System.out.println(dao.try2(7010395318l, "Innamulsec", con));
}
}
