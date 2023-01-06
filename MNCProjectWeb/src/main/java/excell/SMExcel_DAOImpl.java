package excell;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Student_MasterDTO;

public class SMExcel_DAOImpl implements SMExcel_DAO {

	@Override
	public Collection<Student_MasterDTO> readAll() {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			ArrayList<Student_MasterDTO> smarray = new ArrayList<>();
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				Student_MasterDTO sm = new Student_MasterDTO();
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {
						sm.setStudent_id((long) ce.getNumericCellValue());
					}
					if (j == 1) {
						sm.setStudent_name(ce.getStringCellValue());
					}
					if (j == 2) {
						sm.setStudent_pass(ce.getStringCellValue());
					}
					if (j == 3) {
						sm.setStudent_whatsappno1((long) ce.getNumericCellValue());
					}
					if (j == 4) {
						sm.setStudent_whatsappno2((long) ce.getNumericCellValue());
					}
					if (j == 5) {
						sm.setStudent_whatsappno3((long) ce.getNumericCellValue());
					}
					if (j == 6) {
						sm.setStudent_email1(ce.getStringCellValue());
					}
					if (j == 7) {
						sm.setStudent_email2(ce.getStringCellValue());
					}
					if (j == 8) {
						sm.setStudent_email3(ce.getStringCellValue());
					}
					if (j == 9) {
						sm.setStudent_address1(ce.getStringCellValue());
					}
					if (j == 10) {
						sm.setStudent_address2(ce.getStringCellValue());
					}
					if (j == 11) {
						sm.setStudent_city(ce.getStringCellValue());
					}
					if (j == 12) {
						sm.setStudent_country(ce.getStringCellValue());
					}
					if (j == 13) {
						sm.setStudent_college(ce.getStringCellValue());
					}
					if (j == 14) {
						sm.setStudent_college_year(ce.getStringCellValue());
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
	public Student_MasterDTO readyByID(long id) {
		try {

			String excelFile = "D:\\1 MNC Project\\Excell/StudentTry.xlsx";
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			Student_MasterDTO sm = new Student_MasterDTO();
			for (int r = 1; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					XSSFCell ce = row.getCell(c);
					int cid = (int) row.getCell(0).getNumericCellValue();
					if (cid == id) {
						if (c == 0) {
							sm.setStudent_id((long) ce.getNumericCellValue());
						}
						if (c == 1) {
							sm.setStudent_name(ce.getStringCellValue());
						}
						if (c == 2) {
							sm.setStudent_pass(ce.getStringCellValue());
						}
						if (c == 3) {
							sm.setStudent_whatsappno1((long) ce.getNumericCellValue());
						}
						if (c == 4) {
							sm.setStudent_whatsappno2((long) ce.getNumericCellValue());
						}
						if (c == 5) {
							sm.setStudent_whatsappno3((long) ce.getNumericCellValue());
						}
						if (c == 6) {
							sm.setStudent_email1(ce.getStringCellValue());
						}
						if (c == 7) {
							sm.setStudent_email2(ce.getStringCellValue());
						}
						if (c == 8) {
							sm.setStudent_email3(ce.getStringCellValue());
						}
						if (c == 9) {
							sm.setStudent_address1(ce.getStringCellValue());
						}
						if (c == 10) {
							sm.setStudent_address2(ce.getStringCellValue());
						}
						if (c == 11) {
							sm.setStudent_city(ce.getStringCellValue());
						}
						if (c == 12) {
							sm.setStudent_country(ce.getStringCellValue());
						}
						if (c == 13) {
							sm.setStudent_college(ce.getStringCellValue());
						}
						if (c == 14) {
							sm.setStudent_college_year(ce.getStringCellValue());
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
	public Collection<Student_MasterDTO> readByRange(int start_row, int end_row) {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			ArrayList<Student_MasterDTO> smarray = new ArrayList<>();
			if (start_row <= sheet.getLastRowNum() && end_row <= sheet.getLastRowNum()) {
				for (int i = start_row; i <= end_row; i++) {
					Student_MasterDTO sm = new Student_MasterDTO();
					Row ro = sheet.getRow(i);
					for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
						Cell ce = ro.getCell(j);
						if (j == 0) {
							sm.setStudent_id((long) ce.getNumericCellValue());
						}
						if (j == 1) {
							sm.setStudent_name(ce.getStringCellValue());
						}
						if (j == 2) {
							sm.setStudent_pass(ce.getStringCellValue());
						}
						if (j == 3) {
							sm.setStudent_whatsappno1((long) ce.getNumericCellValue());
						}
						if (j == 4) {
							sm.setStudent_whatsappno2((long) ce.getNumericCellValue());
						}
						if (j == 5) {
							sm.setStudent_whatsappno3((long) ce.getNumericCellValue());
						}
						if (j == 6) {
							sm.setStudent_email1(ce.getStringCellValue());
						}
						if (j == 7) {
							sm.setStudent_email2(ce.getStringCellValue());
						}
						if (j == 8) {
							sm.setStudent_email3(ce.getStringCellValue());
						}
						if (j == 9) {
							sm.setStudent_address1(ce.getStringCellValue());
						}
						if (j == 10) {
							sm.setStudent_address2(ce.getStringCellValue());
						}
						if (j == 11) {
							sm.setStudent_city(ce.getStringCellValue());
						}
						if (j == 12) {
							sm.setStudent_country(ce.getStringCellValue());
						}
						if (j == 13) {
							sm.setStudent_college(ce.getStringCellValue());
						}
						if (j == 14) {
							sm.setStudent_college_year(ce.getStringCellValue());
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
