    package PageClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import CommonClass.ExcelData;
import CommonClass.HomeFunction;
	 
	  public class ClaimPOP_UP_Test 
	  {
		WebDriver driver;
		ExtentTest test;
		ExcelData read;

		@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

		@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
		
		@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
		
		@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
		
		@FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
		
		@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;
		
		@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
		
		@FindBy(xpath="//div[@id='claim_stat_msg']//p") WebElement ErrorMessage;
		
		public ClaimPOP_UP_Test(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

		public void ClaimTest() throws IOException, Exception
		{
			HomeFunction.Quick();
			Thread.sleep(3000);
			ENTER_COMPANY.sendKeys("Vidalia Sweet Produce LLC");
			Thread.sleep(2000);
			Click_Company.click();
			Thread.sleep(3000);
			
			if(Click_Claim_Button!= null)
		      {
			System.out.println("Claim Button is Absent");
			ExcelData.ReadData();			
			  }
		    else
		      {
			   System.out.println("Claim Button is Present");
			   System.out.println("testing done12345566");
			   Click_Claim_Button.click();
			   
			   System.out.println("Claim Company is Working fine");
		       }
		       }
	           }



	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
