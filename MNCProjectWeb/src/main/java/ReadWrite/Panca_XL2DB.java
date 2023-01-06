package ReadWrite;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import excell.PanchatanthraExcel_DAO;
import excell.PanchatanthraExcel_DAOImpl;

@Path("/excell")
public class Panca_XL2DB {

	
	@Path("/readAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void P_XL_toP_DB() {
		PanchatanthraExcel_DAO dao=new PanchatanthraExcel_DAOImpl();
		Collection<PanchatanthraDTO> allusers=dao.readAll();
		Iterator<PanchatanthraDTO> iter=allusers.iterator();
		Connection con=ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		
		while(iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			master.insertPanchatanthraDTO(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}
	@Path("/readRange/{start_row}/{end_row}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void P_XL_toP_DBRange(@PathParam("start_row")int start_row,@PathParam("end_row") int end_row) {
		PanchatanthraExcel_DAO dao=new PanchatanthraExcel_DAOImpl();
		Collection<PanchatanthraDTO> allusers=dao.readByRange(start_row, end_row);
		Iterator<PanchatanthraDTO> iter=allusers.iterator();
		Connection con=ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		
		while(iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			master.insertPanchatanthraDTO(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}
	
	@Path("/readId/{sid}/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void P_XL_toP_DBID(@PathParam("sid")long sid,@PathParam("cid")int cid) {
		PanchatanthraExcel_DAO dao=new PanchatanthraExcel_DAOImpl();
		Connection con=ConnectionUtility.getConnection();
		Student_CourseCK ck=new Student_CourseCK(sid, cid);
		PanchatanthraDTO pdto=dao.readyByID(ck);
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		master.insertPanchatanthraDTO(pdto, con);
		ConnectionUtility.closeConnection(null, null);
		
	}
}
