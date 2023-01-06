package pdf;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

import dao.ConnectionUtility;
import dao.PanchatanthraDAO;
import dao.PanchatanthraDAOImpl;
import dao.PanchatanthraDTO;

public class SortingDemo {
	public static void main(String[] args) {
		SortingDemo.sortByRanking();
	}

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
			smd.setTotal(total);
		}
		Collections.sort((List<PanchatanthraDTO>) allusers, (o1, o2) -> {
			return o1.getTotal().compareTo(o2.getTotal());
		});
		return allusers;
	}
}