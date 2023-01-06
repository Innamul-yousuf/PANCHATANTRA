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

@Path("/studentCourse")
public class SC_ServiceImpl implements SC_Service {

	@Override
	@Path("/findById/{sid}/{cid}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Student_CourseDTO getSC(@PathParam("sid") long sid,@PathParam("cid")int cid) {
		Connection con = ConnectionUtility.getConnection();
		Student_CourseDAO master = Student_CourseDAOImpl.createCourseDAOInstance();
		Student_CourseCK ck=new Student_CourseCK(sid, cid);
		Student_CourseDTO cmdto = master.findByID(ck, con);
		ConnectionUtility.closeConnection(null, null);
		return cmdto;
	}

	@Path("/findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Collection<Student_CourseDTO> getSCDTOAll() {
		Connection con = ConnectionUtility.getConnection();
		Student_CourseDAO master =Student_CourseDAOImpl.createCourseDAOInstance();
		
		Collection<Student_CourseDTO> ccmt = master.findAll(con);
		ConnectionUtility.closeConnection(null, null);
		return ccmt;
	}

	@Override
	@Path("/insertValue")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int insertValue(Student_CourseDTO cm) {
		Connection con = ConnectionUtility.getConnection();
		Student_CourseDAO master =Student_CourseDAOImpl.createCourseDAOInstance();
		
		int i = master.insertStudent_Course(cm, con);
		ConnectionUtility.closeConnection(null, null);
		return i;
	}

	@Path("/InsertMany")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void insertMany(Collection<Student_CourseDTO> csm) {
		Connection con = ConnectionUtility.getConnection();
		Student_CourseDAO master =Student_CourseDAOImpl.createCourseDAOInstance();
		Iterator<Student_CourseDTO> iter1 = csm.iterator();
		while (iter1.hasNext()) {
			Student_CourseDTO smd = iter1.next();
			master.insertStudent_Course(smd, con);
		}
		ConnectionUtility.closeConnection(null, null);
	}

}
