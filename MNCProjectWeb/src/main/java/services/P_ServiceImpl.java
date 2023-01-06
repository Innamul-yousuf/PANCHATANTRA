package services;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;
import dao.Course_MasterDAO;
import dao.Course_MasterDAOImpl;
import dao.Course_MasterDTO;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDAO;
import dao.Student_CourseDAOImpl;
import dao.Student_CourseDTO;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;

@Path("/pancha")
public class P_ServiceImpl implements P_Service {

	@Override
	@Path("/findById/{sid}/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PanchatanthraDTO getPDTO(@PathParam("sid")long sid,@PathParam("cid")int cid) {
		Connection con=ConnectionUtility.getConnection();
		PanchatanthraDAO pdao=PanchatanthraDAOImpl.createPanchaDAOInstance();
		Student_CourseCK ck=new Student_CourseCK(sid,cid);
		PanchatanthraDTO pdto=pdao.findByID(ck, con);
		ConnectionUtility.closeConnection(null, null);
		return pdto;
	}

	@Path("/findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Collection<PanchatanthraDTO> getSCDTOAll() {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		
		Collection<PanchatanthraDTO> ccmt = master.findAll(con);
		ConnectionUtility.closeConnection(null, null);
		return ccmt;
	}

	@Override
	@Path("/insertValue")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int insertValue(PanchatanthraDTO cm) {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		
		int i = master.insertPanchatanthraDTO(cm, con);
		ConnectionUtility.closeConnection(null, null);
		return i;
	}

	@Path("/InsertMany")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void insertMany(Collection<PanchatanthraDTO> csm) {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		Iterator<PanchatanthraDTO> iter1 = csm.iterator();
		while (iter1.hasNext()) {
			PanchatanthraDTO smd = iter1.next();
			master.insertPanchatanthraDTO(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}

	@Override
	@Path("/deleteAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAll() {
		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master=PanchatanthraDAOImpl.createPanchaDAOInstance();
		master.deleteAllPanchatanthraDTO(con);
		ConnectionUtility.closeConnection(null, null);
	}
}
