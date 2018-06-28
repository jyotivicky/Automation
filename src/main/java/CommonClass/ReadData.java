package CommonClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

       public class ReadData 
       {
    	   WebDriver driver;
    	   
	    @DataProvider(name="userData")
	    public Object[][] loginData() throws EncryptedDocumentException, InvalidFormatException, InterruptedException 
	    {
			Object[][] arrayObject = getExcelData("C:\\Users\\VICKY\\Desktop\\DATA.xlsx","Sheet1");
			return arrayObject;
		}

		public String[][] getExcelData(String fileName, String sheetName) throws EncryptedDocumentException, InvalidFormatException, InterruptedException 
		   {
			String[][] arrayExcelData = null;
			try 
			{
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = WorkbookFactory.create(fs);
				Sheet sh = wb.getSheet("Sheet1");

				int count = sh.getLastRowNum();

				for (int i= 1 ; i <= count; i++) 
				{
					Row row=sh.getRow(i);
					
		    		String COMPANY= row.getCell(0).getStringCellValue();
		    		
		    		driver.findElement(By.xpath("//div[@id='popup-dialog-window']//span[@id='close-dialog']")).click();
		    		int xCord=driver.findElement(By.xpath("//a[text()='Quick Search']")).getLocation().x;
		    		int yCord=driver.findElement(By.xpath("//a[text()='Quick Search']")).getLocation().y;
		    		Actions act=new Actions(driver);
		    		Thread.sleep(2000);
		    		act.moveToElement(driver.findElement(By.xpath("//a[text()='Quick Search']")), xCord, yCord).perform();
		    		
		    		driver.findElement(By.xpath("//a[text()='Quick Search']")).click();
		    		driver.findElement(By.xpath("//input[@id='edit-search-autocomplete']")).sendKeys(COMPANY);
		    		
	    			System.out.println("Company Name : " + COMPANY);
				}
			  } 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return arrayExcelData;
		}
	    }

















