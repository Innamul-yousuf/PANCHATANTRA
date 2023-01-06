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
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;
import excell.PanchatanthraExcel_DAO;
import excell.PanchatanthraExcel_DAOImpl;
import excell.SMExcel_DAO;
import excell.SMExcel_DAOImpl;

@Path("/smexcell")
public class Student_Mater_XL2DB {

	
	@Path("/readAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void readAll() {
		//PanchatanthraExcel_DAO dao=new PanchatanthraExcel_DAOImpl();
		SMExcel_DAO dao=new SMExcel_DAOImpl();
		Collection<Student_MasterDTO> csm=dao.readAll();
		Iterator<Student_MasterDTO> iter=csm.iterator();
		Connection con=ConnectionUtility.getConnection();
		Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
		while(iter.hasNext()) {
			Student_MasterDTO smd = iter.next();
			master.insertStudent(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}
	@Path("/readRange/{start_row}/{end_row}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void readByRange(@PathParam("start_row")int start_row,@PathParam("end_row") int end_row) {
		SMExcel_DAO dao=new SMExcel_DAOImpl();
		Collection<Student_MasterDTO> csm=dao.readAll();
		Iterator<Student_MasterDTO> iter=csm.iterator();
		Connection con=ConnectionUtility.getConnection();
		Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
		while(iter.hasNext()) {
			Student_MasterDTO smd = iter.next();
			master.insertStudent(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}
	
	@Path("/readId/{sid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static  void readById(@PathParam("sid")long sid) {
		SMExcel_DAO dao=new SMExcel_DAOImpl();
		Connection con=ConnectionUtility.getConnection();
	
		Student_MasterDTO pdto=dao.readyByID(sid);
		Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
		master.insertStudent(pdto, con);
		ConnectionUtility.closeConnection(null, null);
		
	}
}
