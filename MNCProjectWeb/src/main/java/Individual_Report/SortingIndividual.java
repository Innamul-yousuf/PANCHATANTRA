package Individual_Report;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

import dao.ConnectionUtility;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;

@Path("/course_count")
public class SortingIndividual {
	

	public static Collection<PanchatanthraDTO> sortByRanking() {

		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Collection<PanchatanthraDTO> allusers = master.findAll(con);

		Iterator<PanchatanthraDTO> iter = allusers.iterator();
		while (iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			long stu_id = smd.getStudent_id();

			int cour_id = smd.getCourse_id();
			int cod_count = smd.getCod_count() * 5;

			int qod_count = smd.getQod_count() * 5;

			int tod_count = smd.getTod_count();

			int low_count = smd.getLow_count();

			int Vow_count = smd.getVow_count() * 5;

			Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;

			smd.setTotal(total);
		}
		Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
			return o2.getTotal().compareTo(o1.getTotal());
		});
//		Iterator<PanchatanthraDTO> iter1 = allusers.iterator();
//		while (iter1.hasNext()) {
//			System.out.println(iter1.next());
//		}
		ConnectionUtility.closeConnection(null, null);
		return allusers;
	}
	
	public static Collection<PanchatanthraDTO> sortByLowToHigh() {

		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Collection<PanchatanthraDTO> allusers = master.findAll(con);

		Iterator<PanchatanthraDTO> iter = allusers.iterator();
		while (iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			long stu_id = smd.getStudent_id();

			int cour_id = smd.getCourse_id();
			int cod_count = smd.getCod_count() * 5;

			int qod_count = smd.getQod_count() * 5;

			int tod_count = smd.getTod_count();

			int low_count = smd.getLow_count();

			int Vow_count = smd.getVow_count() * 5;

			Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
			
		}
		Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
			return o1.getTotal().compareTo(o2.getTotal());
		});
//		Iterator<PanchatanthraDTO> iter1 = allusers.iterator();
//		while (iter1.hasNext()) {
//			System.out.println(iter1.next());
//		}
		ConnectionUtility.closeConnection(null, null);
		return allusers;
	}
	
	@Path("/cod")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<PanchatanthraDTO> sortByCod() {

		Connection con = ConnectionUtility.getConnection();
		PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
		Collection<PanchatanthraDTO> allusers = master.findAll(con);

		Iterator<PanchatanthraDTO> iter = allusers.iterator();
		while (iter.hasNext()) {
			PanchatanthraDTO smd = iter.next();
			long stu_id = smd.getStudent_id();

			int cour_id = smd.getCourse_id();
			int cod_count = smd.getCod_count() * 5;

			int qod_count = smd.getQod_count() * 5;

			int tod_count = smd.getTod_count();

			int low_count = smd.getLow_count();

			int Vow_count = smd.getVow_count() * 5;
			
			Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
			
			smd.setTotal(total);
			
			//Integer cod=Integer.valueOf(cod_count);

			smd.setTotal(total);
			smd.setCod(cod_count);
			smd.setQod(qod_count);
			smd.setTod(tod_count);
			smd.setLow(low_count);
			smd.setVow(Vow_count);
		}
		Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
			return o2.getCod().compareTo(o1.getCod());
		});
//		Iterator<PanchatanthraDTO> iter1 = allusers.iterator();
//		while (iter1.hasNext()) {
//			System.out.println(iter1.next());
//		}
		//ConnectionUtility.closeConnection(null, null);
		return allusers;
	}
	
	@Path("/qod")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<PanchatanthraDTO> sortByQod() {

	Connection con = ConnectionUtility.getConnection();
	PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
	Collection<PanchatanthraDTO> allusers = master.findAll(con);

	Iterator<PanchatanthraDTO> iter = allusers.iterator();
	while (iter.hasNext()) {
		PanchatanthraDTO smd = iter.next();
		long stu_id = smd.getStudent_id();

		int cour_id = smd.getCourse_id();
		int cod_count = smd.getCod_count() * 5;

		int qod_count = smd.getQod_count() * 5;

		int tod_count = smd.getTod_count();

		int low_count = smd.getLow_count();

		int Vow_count = smd.getVow_count() * 5;
		
		Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
		
		smd.setTotal(total);
		

		smd.setTotal(total);
		smd.setCod(cod_count);
		smd.setQod(qod_count);
		smd.setTod(tod_count);
		smd.setLow(low_count);
		smd.setVow(Vow_count);
	}
	Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
		return o2.getQod().compareTo(o1.getQod());
	});

	return allusers;
}

	@Path("/tod")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public static Collection<PanchatanthraDTO> sortBytod() {

	Connection con = ConnectionUtility.getConnection();
	PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
	Collection<PanchatanthraDTO> allusers = master.findAll(con);

	Iterator<PanchatanthraDTO> iter = allusers.iterator();
	while (iter.hasNext()) {
		PanchatanthraDTO smd = iter.next();
		long stu_id = smd.getStudent_id();

		int cour_id = smd.getCourse_id();
		int cod_count = smd.getCod_count() * 5;

		int qod_count = smd.getQod_count() * 5;

		int tod_count = smd.getTod_count();

		int low_count = smd.getLow_count();

		int Vow_count = smd.getVow_count() * 5;
		
		Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
		
		smd.setTotal(total);
		

		smd.setTotal(total);
		smd.setCod(cod_count);
		smd.setQod(qod_count);
		smd.setTod(tod_count);
		smd.setLow(low_count);
		smd.setVow(Vow_count);
	}
	Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
		return o2.getTod().compareTo(o1.getTod());
	});

	return allusers;
}
	@Path("/low")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public static Collection<PanchatanthraDTO> sortByLow() {

	Connection con = ConnectionUtility.getConnection();
	PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
	Collection<PanchatanthraDTO> allusers = master.findAll(con);

	Iterator<PanchatanthraDTO> iter = allusers.iterator();
	while (iter.hasNext()) {
		PanchatanthraDTO smd = iter.next();
		long stu_id = smd.getStudent_id();

		int cour_id = smd.getCourse_id();
		int cod_count = smd.getCod_count() * 5;

		int qod_count = smd.getQod_count() * 5;

		int tod_count = smd.getTod_count();

		int low_count = smd.getLow_count();

		int Vow_count = smd.getVow_count() * 5;
		
		Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
		
		smd.setTotal(total);
		

		smd.setTotal(total);
		smd.setCod(cod_count);
		smd.setQod(qod_count);
		smd.setTod(tod_count);
		smd.setLow(low_count);
		smd.setVow(Vow_count);
	}
	Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
		return o2.getLow().compareTo(o1.getLow());
	});

	return allusers;
}

	@Path("/vow")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public static Collection<PanchatanthraDTO> sortByVow() {

	Connection con = ConnectionUtility.getConnection();
	PanchatanthraDAO master = PanchatanthraDAOImpl.createPanchaDAOInstance();
	Collection<PanchatanthraDTO> allusers = master.findAll(con);

	Iterator<PanchatanthraDTO> iter = allusers.iterator();
	while (iter.hasNext()) {
		PanchatanthraDTO smd = iter.next();
		long stu_id = smd.getStudent_id();

		int cour_id = smd.getCourse_id();
		int cod_count = smd.getCod_count() * 5;

		int qod_count = smd.getQod_count() * 5;

		int tod_count = smd.getTod_count();

		int low_count = smd.getLow_count();

		int Vow_count = smd.getVow_count() * 5;
		
		Integer total = cod_count + qod_count + tod_count + low_count + Vow_count;
		
		smd.setTotal(total);
		

		smd.setTotal(total);
		smd.setCod(cod_count);
		smd.setQod(qod_count);
		smd.setTod(tod_count);
		smd.setLow(low_count);
		smd.setVow(Vow_count);
	}
	Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
		return o2.getVow().compareTo(o1.getVow());
	});

	return allusers;
}
}
