package PageClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import CommonClass.ExcelData;
import CommonClass.HomeFunction;
import WaitClass.Wait;

	  public class Claim_POP_UP_Test 
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
		
		@FindBy(xpath="//div[@id='drupal-modal']//div//div//div[2]//div//div[1]//p") WebElement LoginErrorMsg;
		
		public Claim_POP_UP_Test(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

		public void ClaimTest() throws IOException, Exception
		{
			HomeFunction.Quick();
			Wait.Thread_20();
			ENTER_COMPANY.sendKeys("Vidalia Sweet Produce LLC");
			Wait.Thread_20();
			Click_Company.click();
			
			if(Click_Claim_Button!= null)
		      {
			System.out.println("Claim Button is Absent");
			ExcelData.ReadData();			
			  }
		    else
		      {
			   System.out.println("Claim Button is Present");
			   Click_Claim_Button.click();
			   System.out.println("Claim Company is Working fine");
		       }
		       }
	           }



	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
