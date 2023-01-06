package excell;
import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;

import dao.Student_MasterDTO;

public class ExcellDataToList {

	public static void main(String[] args) {
		
		File file = new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx");
		Student_MasterDTO sd=new Student_MasterDTO();
		
		List<Student_MasterDTO> invoices = Poiji.fromExcel(file, Student_MasterDTO.class);
		System.out.println("Printing List Data: " +invoices);

	}

}