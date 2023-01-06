package excell;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Student_MasterDTO;

public class ExcelToObject {

    public static Collection<Student_MasterDTO> main(String[] args) {
         try
          {
              FileInputStream file = new FileInputStream(new File("D:\\1 MNC Project\\Excell/StudentTry.xlsx"));

              //Create Workbook instance holding reference to .xlsx file
              XSSFWorkbook workbook = new XSSFWorkbook(file);

              //Get first/desired sheet from the workbook
              XSSFSheet sheet = workbook.getSheetAt(0);

              ArrayList<Student_MasterDTO> employeeList = new ArrayList<>();
    //I've Header and I'm ignoring header for that I've +1 in loop
              for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
            	  Student_MasterDTO e= new Student_MasterDTO();
                  Row ro=sheet.getRow(i);
                  
                  for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
                      Cell ce = ro.getCell(j);
                    if(j==0){  
                        //If you have Header in text It'll throw exception because it won't get NumericValue
                        e.setStudent_id((long) ce.getNumericCellValue());
                        

                    }
                    if(j==1){
                        e.setStudent_name(ce.getStringCellValue());
                    }
                    if(j==2){
                        e.setStudent_pass(ce.getStringCellValue());
                    }    
                  }
                  employeeList.add(e);
                  return employeeList;
              }
              file.close();
              return employeeList;
//              for(Student_MasterDTO emp: employeeList){
//                  System.out.println("ID:"+emp.getStudent_id()+" firstName:"+emp.getStudent_name());
//              }
              
              
          } 
          catch (Exception e) 
          {
              e.printStackTrace();
              return null;
          }
		
		
      }
}