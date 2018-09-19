package PageClass;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class DataProviderTest 
{
// int count1;	
// 
//	public void ReadExcel() 
//	{
//		FileInputStream fs = new FileInputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");
//		Workbook wb = WorkbookFactory.create(fs);
//
//		Sheet sh = wb.getSheet("Sheet2");
//		
//		int count=sh.getLastRowNum();
//		
//		System.out.println("Total Row : " + count);
//		
//		Row row=sh.getRow(count);
//		
//		int count1=row.getLastCellNum();
//		
//		
//		System.out.println("Total Column : " + count1);
//
//		for (int i = 0; i<=count; i++) 
//		{
//			Row row1=sh.getRow(i);
//			
//			for (int j = 0; j<= count1; j++) 
//			{
//				//System.out.print(sh.getCell(count1, row1).getContents() + "\t");
//			}
//			System.out.println();
		//}
	    }
        //}
  