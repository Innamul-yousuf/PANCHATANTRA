package totalDB;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ConnectionUtility;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;

@Path("/panchaAll")
public class PanchaResetDB {
	@Path("/addAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void read_P_db() {
	Connection con=ConnectionUtility.getConnection();
	PanchatanthraDAO pdao=PanchatanthraDAOImpl.createPanchaDAOInstance();
	PanchatanthraDTO pdt=new PanchatanthraDTO();
	Collection<PanchatanthraDTO> allP=pdao.findAll(con);
	Iterator<PanchatanthraDTO> iter=allP.iterator();
	while(iter.hasNext()) {
		PanchatanthraDTO smd = iter.next();
		PanchaAllDAO pa=PanchataAllImpl.createPanchaDAOInstance();
		pa.insertPanchataAllDTO(smd, con);
		}
	pdao.deleteAllPanchatanthraDTO(con);
	ConnectionUtility.closeConnection(null, null);
	}
}
