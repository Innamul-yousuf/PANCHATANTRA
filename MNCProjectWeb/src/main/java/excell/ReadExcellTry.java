package excell;
import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
//public class ReadExcellTry {
//    public static  void main(String args[]) throws IOException {
//         
//        String path = "D:\\1 MNC Project\\Excell/StudentTry.xlsx";
//         
//        //Create an object of FileInputStream class to read excel file
//        FileInputStream fis = new FileInputStream(path);
//         
//        //Create object of XSSFWorkbook class
//        Workbook workbook = new XSSFWorkbook(fis);
//         
//        //Read excel sheet by sheet name 
//        Sheet sheet = workbook.getSheet("Reviews");
//         
//         
//        //Find number of rows in excel file
//        //int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();      
//       // System.out.println("row count:"+rowCount);
         
         //iterate over all the row to print the data present in each cell.
      //  for(int i=0;i<=rowCount;i++){
             
            //get cell count in a row
//            int cellcount=sheet.getRow(i).getLastCellNum();         
//        
//            //iterate over each cell to print its value       
//            for(int j=0;j<cellcount;j++){
//            	 switch (cell.getCellType()) 
//                 {
//                     case NUMERIC:
//                         //System.out.print(cell.getNumericCellValue() + "t");
//                         long student_id=(long) cell.getNumericCellValue();
//                         System.out.println(student_id);
//                         break;
//                     case STRING:
//                         //System.out.print(cell.getStringCellValue() + "t");
//                         break;
//                 }
//             }
//            	
//                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue().toString() +"||");
//            }
//            System.out.println();
//        }
//    }
//}