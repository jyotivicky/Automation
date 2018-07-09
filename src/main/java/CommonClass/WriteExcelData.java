package CommonClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

   public class WriteExcelData 
   {
	public static void Write() throws InvalidFormatException, IOException
	  {
	 FileInputStream fis=new FileInputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sh=wb.getSheet("Sheet2");
	 
	 sh.getRow(2).getCell(2).getStringCellValue();
	 
	 sh.getRow(0).createCell(2).setCellValue("2.41.0");
	 
	 sh.getRow(1).createCell(2).setCellValue("2.5");
	 
	 sh.getRow(2).createCell(2).setCellValue("2.39");
	 
	 FileOutputStream fos = new FileOutputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");	 
	 wb.write(fos);
	 fos.close();
	 System.out.println("END OF WRITING DATA IN EXCEL");
	}
    }
