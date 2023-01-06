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

import dao.Course_MasterDTO;
import dao.Student_CourseCK;
import dao.Student_CourseDTO;
import dao.Student_MasterDTO;

public class SCourse_MasterExcel_DAOImpl implements SCourse_MasterExcel_DAO {

	@Override
	public Collection<Student_CourseDTO> readAll() {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(2);
			ArrayList<Student_CourseDTO> smarray = new ArrayList<>();
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				Student_CourseDTO sm = new Student_CourseDTO();
				Row ro = sheet.getRow(i);
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {
						sm.setStudent_id((long) ce.getNumericCellValue());
					}
					if (j == 1) {
						sm.setCourse_id((int) ce.getNumericCellValue());

					}
					if (j == 2) {
						sm.setFees_paid((int) ce.getNumericCellValue());
					}
					if (j == 3) {
						sm.setStudent_CJD(df.format(ce.getDateCellValue()));
						// sm.setStudent_CJD(ce.getStringCellValue());
						// sm.setStudent_CJD(String.valueOf((int)ce.getNumericCellValue()) );
					}
					if (j == 4) {
						sm.setStudent_CED(df.format(ce.getDateCellValue()));
						// sm.setStudent_CED(ce.getStringCellValue());
						// sm.setStudent_CED(String.valueOf((int)ce.getNumericCellValue()) );
						// STRING value from a NUMERIC cell
					}
					if (j == 5) {
						sm.setStudent_CAttendance((int) ce.getNumericCellValue());
					}
					if (j == 6) {
						sm.setStudent_CGrade((int) ce.getNumericCellValue());
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
	public Student_CourseDTO readyByID(Student_CourseCK ck) {
		try {

			String excelFile = "D:\\1 MNC Project\\Excell/StudentTry.xlsx";
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(2);
			long sid = ck.getSid();
			int cid = ck.getCid();
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			Student_CourseDTO sm = new Student_CourseDTO();
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			for (int r = 1; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int j = 0; j < cols; j++) {
					XSSFCell ce = row.getCell(j);

					if (sid == (long) row.getCell(0).getNumericCellValue()
							&& cid == (long) row.getCell(1).getNumericCellValue()) {

						if (j == 0) {
							sm.setStudent_id((long) ce.getNumericCellValue());
						}
						if (j == 1) {
							sm.setCourse_id((int) ce.getNumericCellValue());

						}
						if (j == 2) {
							sm.setFees_paid((int) ce.getNumericCellValue());
						}
						if (j == 3) {
							sm.setStudent_CJD(df.format(ce.getDateCellValue()));

						}
						if (j == 4) {
							sm.setStudent_CED(df.format(ce.getDateCellValue()));
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
	public Collection<Student_CourseDTO> readByRange(int start_row, int end_row) {
		try {
			FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(2);
			ArrayList<Student_CourseDTO> smarray = new ArrayList<>();
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			
			if (start_row <= sheet.getLastRowNum() && end_row <= sheet.getLastRowNum()) {
				for (int i = start_row; i <= end_row; i++) {
					Student_CourseDTO sm = new Student_CourseDTO();
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
							sm.setFees_paid((int) ce.getNumericCellValue());
						}
						if (j == 3) {
							sm.setStudent_CJD(df.format(ce.getDateCellValue()));

						}
						if (j == 4) {
							sm.setStudent_CED(df.format(ce.getDateCellValue()));
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