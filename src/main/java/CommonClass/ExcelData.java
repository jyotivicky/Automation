package CommonClass;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class ExcelData 
       {
    	static WebDriver driver;
    	
		static @FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
		
		static @FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
		
		static @FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;
	
		static @FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_UP_Size;
		
        static @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
		
        static @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
		
        static @FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
        
        static @FindBy(xpath="//div[@id='drupal-modal--body']//button") WebElement Submit_Request;
        
    	public ExcelData(WebDriver driver)
    	{
    		this.driver=driver;
    		PageFactory.initElements(driver, this);
    	}

	  public static void ReadData() throws Exception, Exception, IOException 
	      {
	    	FileInputStream fis=new FileInputStream("C:\\Users\\VICKY\\Desktop\\DATA.xlsx");
	    	Workbook wb=WorkbookFactory.create(fis);
	    	Sheet sh=wb.getSheet("Sheet1");
	    	
	    	int count=sh.getLastRowNum();
	    	System.out.println("Total number of rows:"+count);

	    	for(int i=1;i<= count;i++)
	    	 {
	    		Row row=sh.getRow(i);
	    		String COMPANY= row.getCell(0).getStringCellValue();
    			System.out.println("Company Name : " + COMPANY);
                Quick_Search_Box.sendKeys(COMPANY);
    			Thread.sleep(3000);
                Click_Company.click();
    			Thread.sleep(3000);
                
    			boolean b=driver.getPageSource().contains("Claim Company");
    				
    			if(b==true)
    			    {
    				System.out.println("Claim Button is Present");
    				Click_Claim_Button.click();
    				
    				   WebDriverWait wait1=new WebDriverWait(driver, 10);
    				   wait1.until(ExpectedConditions.visibilityOf(Pop_UP_Size));   
    		     	   WebElement loginPopup=Pop_UP_Size; 
    				   int height=loginPopup.getSize().getHeight();
    				   int width=loginPopup.getSize().getWidth();
    				   System.out.println("Pop Up Height Is : " + height);
    				   System.out.println("Pop Up Width Is : " + width);
    				   
    				   if(height==428 && width==450)
    				   {
    					   System.out.println("Claim Company Pop Up Is Working Fine");
    				   }
    				   else
    				   {
    					   System.out.println(" Claim Company Pop Up Broken");
    				   }
    				   Thread.sleep(3000);
    				   NAME.sendKeys("vdas0692@gmail.com");
    				   Thread.sleep(1000);
    				   PWD.sendKeys("t");
    				   Thread.sleep(1000);
    				   SUBMIT.click();
    				   Thread.sleep(2000);
    				   System.out.println("Test Passed");   
    				break;
    				}
    			else
    			    {
    				System.out.println("Claim Button is Absent");
    				continue;
    			    }
    			    }
	                }
                    }
          

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    