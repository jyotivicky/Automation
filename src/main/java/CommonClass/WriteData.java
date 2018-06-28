package CommonClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

    public class WriteData 
   {
	public static void Write() throws EncryptedDocumentException, InvalidFormatException, IOException
	  {
		 FileInputStream fis=new FileInputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");
    	 Workbook wb=WorkbookFactory.create(fis);
    	 Sheet sh=wb.getSheet("Sheet2");

    	 sh.getRow(1).createCell(1).setCellValue("Test");
         
    	 FileOutputStream fos = new FileOutputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");
    	 
    	 wb.write(fos);
    	 fos.close();
    	 System.out.println("END OF WRITING DATA IN EXCEL");
    	
	}

    
    }
   
