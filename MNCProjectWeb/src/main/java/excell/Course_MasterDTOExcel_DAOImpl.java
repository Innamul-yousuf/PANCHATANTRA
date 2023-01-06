package excell;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Course_MasterDTO;
import dao.Student_MasterDTO;

public class Course_MasterDTOExcel_DAOImpl implements Course_MasterDTOExcel_DAO {

	@Override
	public Collection<Course_MasterDTO> readAll() {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			ArrayList<Course_MasterDTO> smarray = new ArrayList<>();
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				Course_MasterDTO sm = new Course_MasterDTO();
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {
						sm.setCourse_id((int) ce.getNumericCellValue());
					}
					if (j == 1) {
						sm.setCourse_name(ce.getStringCellValue());
					}
					if (j == 2) {
						sm.setDuration_in_hrs((int) ce.getNumericCellValue());
					}
					if (j == 3) {
						sm.setCourse_level((int) ce.getNumericCellValue());
					}
					if (j == 4) {
						sm.setCourse_fees((int) ce.getNumericCellValue());
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
	public Course_MasterDTO readyByID(int id) {
		try {

			String excelFile = "D:\\1 MNC Project\\Excell/StudentTry.xlsx";
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			Course_MasterDTO sm = new Course_MasterDTO();
			for (int r = 1; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int j = 0; j < cols; j++) {
					XSSFCell ce = row.getCell(j);
					int cid = (int) row.getCell(0).getNumericCellValue();
					if (cid == id) {
						if (j == 0) {
							sm.setCourse_id((int) ce.getNumericCellValue());
						}
						if (j == 1) {
							sm.setCourse_name(ce.getStringCellValue());
						}
						if (j == 2) {
							sm.setDuration_in_hrs((int) ce.getNumericCellValue());
						}
						if (j == 3) {
							sm.setCourse_level((int) ce.getNumericCellValue());
						}
						if (j == 4) {
							sm.setCourse_fees((int) ce.getNumericCellValue());
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
	public Collection<Course_MasterDTO> readByRange(int start_row, int end_row) {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			ArrayList<Course_MasterDTO> smarray = new ArrayList<>();
			if (start_row <= sheet.getLastRowNum() && end_row <= sheet.getLastRowNum()) {
				for (int i = start_row; i <= end_row; i++) {
					Course_MasterDTO sm = new Course_MasterDTO();
					Row ro = sheet.getRow(i);
					for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
						Cell ce = ro.getCell(j);
						if (j == 0) {
							sm.setCourse_id((int) ce.getNumericCellValue());
						}
						if (j == 1) {
							sm.setCourse_name(ce.getStringCellValue());
						}
						if (j == 2) {
							sm.setDuration_in_hrs((int) ce.getNumericCellValue());
						}
						if (j == 3) {
							sm.setCourse_level((int) ce.getNumericCellValue());
						}
						if (j == 4) {
							sm.setCourse_fees((int) ce.getNumericCellValue());
						}
					}
					smarray.add(sm);
					// return employeeList;
				}
				file.close();
				return smarray;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}