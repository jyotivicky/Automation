    package PageClass;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.relevantcodes.extentreports.ExtentTest;

	import CommonClass.HomeFunction;
	import WaitClass.Wait;
	 
	  public class ClaimPOP_UP_Test 
	  {
		WebDriver driver;
		HomeFunction qf;
		ExtentTest test;

		@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

		@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
		
		@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
		
		@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
		
		@FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
		
		@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;

		@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_Up_Size;
		
		@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
		
		@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_UP_Size;
		
		@FindBy(xpath="//div[@id='claim_stat_msg']//p") WebElement ErrorMessage;
		
	    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
		
		@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
		
		@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
		
		@FindBy(xpath="//div[@id='drupal-modal--body']//button") WebElement Submit_Request;

		
		public ClaimPOP_UP_Test(WebDriver driver) 
		{
			this.driver=driver;
			qf=new HomeFunction(driver);
			//this.test=test;
			PageFactory.initElements(driver,this);
		}

		public void ClaimTest() throws InterruptedException
		{
			qf.Quick();
			
			ENTER_COMPANY.sendKeys("SwitchFast Logistics");
			Thread.sleep(2000);
			Click_Company.click();
			Thread.sleep(3000);
			boolean b=driver.getPageSource().contains("Claim Company");
			System.out.println(b);

			if(b==true)
			{
				Thread.sleep(2000);
				Click_Claim_Button.click();
			}
			else if(b==false)
			{
				Quick_Search_Box.sendKeys("SwitchFast Logistics");
			    driver.manage().timeouts().implicitlyWait(Wait.Implicitly_Wait,TimeUnit.SECONDS);
			    Click_Company.click();
				Thread.sleep(1000);
			    Thread.sleep(2000);
			    Click_Claim_Button.click();
			}
			
			else if(b==true)
			{
				Quick_Search_Box.sendKeys("Awe Sum Organics Inc");
				Thread.sleep(1000);
				Click_Company.click();
				Thread.sleep(1000);
				Click_Claim_Button.click();	
			}
			
			else
			{
				System.out.println("Claim Company buttoon is missing");
			}	
			   WebDriverWait wait1=new WebDriverWait(driver, 10);
			   wait1.until(ExpectedConditions.visibilityOf(Pop_Up_Size));
			   
	     	   WebElement loginPopup=Pop_UP_Size; 
			   int height=loginPopup.getSize().getHeight();
			   int width=loginPopup.getSize().getWidth();

			   if(height==428 && width==450)
			   {
				   System.out.println("Claim Company Pop Up Is Working Fine");
			   }
			   else
			   {
				   System.out.println(" Claim Company Pop Up Broken");
			   }

		}
	    }



