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
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;

@Path("/course")
public class C_ServiceImpl implements C_Service {

	@Override
	@Path("/FindById/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course_MasterDTO getCourse(@PathParam("cid") int cid) {
		Connection con = ConnectionUtility.getConnection();
		Course_MasterDAO master = Course_MasterDAOImpl.createCourseDAOInstance();
		Course_MasterDTO cmdto = master.findByID(cid, con);
		ConnectionUtility.closeConnection(null, null);
		return cmdto;
	}

	@Path("/findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Collection<Course_MasterDTO> getPDTOAll() {
		Connection con = ConnectionUtility.getConnection();
		Course_MasterDAO master = Course_MasterDAOImpl.createCourseDAOInstance();
		Collection<Course_MasterDTO> ccmt = master.findAll(con);
		ConnectionUtility.closeConnection(null, null);
		return ccmt;
	}

	@Override
	@Path("/insertValue")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int insertValue(Course_MasterDTO cm) {
		Connection con = ConnectionUtility.getConnection();
		Course_MasterDAO master = Course_MasterDAOImpl.createCourseDAOInstance();
		int i = master.insertCourse_Master(cm, con);
		ConnectionUtility.closeConnection(null, null);
		return i;
	}

	@Path("/InsertMany")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void insertMany(Collection<Course_MasterDTO> csm) {
		Connection con = ConnectionUtility.getConnection();
		Course_MasterDAO master = Course_MasterDAOImpl.createCourseDAOInstance();
		Iterator<Course_MasterDTO> iter1 = csm.iterator();
		while (iter1.hasNext()) {
			Course_MasterDTO smd = iter1.next();
			master.insertCourse_Master(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}

}
