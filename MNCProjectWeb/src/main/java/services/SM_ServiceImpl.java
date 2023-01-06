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
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_MasterDAO;
import dao.Student_MasterDAOImpl;
import dao.Student_MasterDTO;


@Path("/student")
public class SM_ServiceImpl implements SM_Service{


@Path("/findAll")
@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Override
public Collection<Student_MasterDTO> getPDTOAll() {
	Connection con=ConnectionUtility.getConnection();
	Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
	Collection<Student_MasterDTO> csmt=master.findAll(con);
	ConnectionUtility.closeConnection(null, null);
	return csmt;
}

@Override
@Path("/insertValue")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public int insertValue(Student_MasterDTO sm){
	Connection con=ConnectionUtility.getConnection();
	Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
	int i=master.insertStudent(sm, con);
	ConnectionUtility.closeConnection(null, null);
	return i;
}





@Path("/InsertMany")
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Override
public void insertMany(Collection<Student_MasterDTO> csm) {
	Connection con=ConnectionUtility.getConnection();
	Student_MasterDAO master=Student_MasterDAOImpl.createStudentDAOInstance();
	Iterator<Student_MasterDTO> iter1 = csm.iterator();
	while (iter1.hasNext()) {
		Student_MasterDTO smd = iter1.next();
		master.insertStudent(smd, con);
}
	ConnectionUtility.closeConnection(null, null);
}

@Override
@Path("/FindById/{sid}")
@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Student_MasterDTO getSDTO(@PathParam("sid")long sid) {
	Connection con=ConnectionUtility.getConnection();
	Student_MasterDAO smdao=Student_MasterDAOImpl.createStudentDAOInstance();
	Student_MasterDTO smdto=smdao.findByID(sid, con);
	ConnectionUtility.closeConnection(null, null);
	return smdto;
}

}
