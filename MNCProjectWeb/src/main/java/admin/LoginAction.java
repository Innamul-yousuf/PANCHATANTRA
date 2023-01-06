package admin;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;

@Path("/admin")
public class LoginAction {

	@Path("/login/{id}/{pass}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public boolean doLoginAction(@PathParam("id") long id,@PathParam("pass")  String pass ) {
		Connection con=ConnectionUtility.getConnection();
	AdminDAOImpl dao=AdminDAOImpl.createAdminInstance();
	boolean user=dao.checkAdmin(id, pass);
	if(user) {
		boolean flag=dao.checkFlag(id,pass , con);
		if(flag) {
			 
			ConnectionUtility.closeConnection(null, null);
			return true;
			
		}
		else {
			ConnectionUtility.closeConnection(null, null);
			return false;
		}
	}else {
		ConnectionUtility.closeConnection(null, null);
		return true;
	}
	
	
}
	@Path("/log/{id}/{pass}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AdminDTO doLoginTry(@PathParam("id") long id,@PathParam("pass")  String pass ) {
		Connection con=ConnectionUtility.getConnection();
	AdminDAOImpl dao=AdminDAOImpl.createAdminInstance();
	AdminDTO adto=new AdminDTO();
	adto=dao.try2(id, pass, con);
	ConnectionUtility.closeConnection(null, null);
	return adto;
}
	
	@Path("/logout")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public boolean doLogoutAction() {
		Connection con=ConnectionUtility.getConnection();
		AdminDAOImpl dao=AdminDAOImpl.createAdminInstance();
	
		boolean flag=dao.reSetFlag();
		if(flag) {
			ConnectionUtility.closeConnection(null, null);
			return true;
		}
		else {
			ConnectionUtility.closeConnection(null, null);
			return false;
		}
	
}
}
