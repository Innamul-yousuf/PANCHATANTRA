package excell;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.PanchatanthraDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public class PanchatanthraExcel_DAOImpl implements PanchatanthraExcel_DAO {

	@Override
	public Collection<PanchatanthraDTO> readAll() {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(3);
			ArrayList<PanchatanthraDTO> smarray = new ArrayList<>();
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				PanchatanthraDTO sm = new PanchatanthraDTO();
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {
						sm.setStudent_id((long) ce.getNumericCellValue());
					}
					if (j == 1) {
						sm.setCourse_id((int) ce.getNumericCellValue());
						}
					if (j == 2) {
						sm.setCod_count((int) ce.getNumericCellValue());
					}
					if (j == 3) {
						sm.setQod_count((int) ce.getNumericCellValue());
					}
					if (j == 4) {
						sm.setTod_count((int) ce.getNumericCellValue());
					}
					if (j == 5) {
						sm.setLow_count((int) ce.getNumericCellValue());
					}
					if (j == 6) {
						sm.setVow_count((int) ce.getNumericCellValue());
					}
				}
				smarray.add(sm);
				// return employeeList;
			}
			file.close();
			return smarray;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PanchatanthraDTO readyByID(Student_CourseCK ck) {
		try {

			String excelFile = "D:\\1 MNC Project\\Excell/StudentTry.xlsx";
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(3);
			long sid=ck.getSid();
			int cid=ck.getCid();
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			PanchatanthraDTO sm = new PanchatanthraDTO();
			DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
			for (int r = 1; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int j = 0; j < cols; j++) {
					XSSFCell ce = row.getCell(j);
					 
					if (sid == (long) row.getCell(0).getNumericCellValue()&&cid==(long) row.getCell(1).getNumericCellValue()) {
						
						if (j == 0) {
							sm.setStudent_id((long) ce.getNumericCellValue());
						}
						if (j == 1) {
							sm.setCourse_id((int) ce.getNumericCellValue());
							}
						if (j == 2) {
							sm.setCod_count((int) ce.getNumericCellValue());
						}
						if (j == 3) {
							sm.setQod_count((int) ce.getNumericCellValue());
						}
						if (j == 4) {
							sm.setTod_count((int) ce.getNumericCellValue());
						}
						if (j == 5) {
							sm.setLow_count((int) ce.getNumericCellValue());
						}
						if (j == 6) {
							sm.setVow_count((int) ce.getNumericCellValue());
						}
						}
					}
				}
			
			fis.close();
			return sm;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		
	}
	}

	@Override
	public Collection<PanchatanthraDTO> readByRange(int start_row, int end_row) {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(3);
			ArrayList<PanchatanthraDTO> smarray = new ArrayList<>();
			DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
			if (start_row <= sheet.getLastRowNum() && end_row <= sheet.getLastRowNum()) {
			for (int i = start_row; i <= end_row; i++) {
				PanchatanthraDTO sm = new PanchatanthraDTO();
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {
						sm.setStudent_id((long) ce.getNumericCellValue());
					}
					if (j == 1) {
						sm.setCourse_id((int) ce.getNumericCellValue());
						}
					if (j == 2) {
						sm.setCod_count((int) ce.getNumericCellValue());
					}
					if (j == 3) {
						sm.setQod_count((int) ce.getNumericCellValue());
					}
					if (j == 4) {
						sm.setTod_count((int) ce.getNumericCellValue());
					}
					if (j == 5) {
						sm.setLow_count((int) ce.getNumericCellValue());
					}
					if (j == 6) {
						sm.setVow_count((int) ce.getNumericCellValue());
					}
				}
				smarray.add(sm);
				// return employeeList;
			}
			file.close();
			return smarray;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
