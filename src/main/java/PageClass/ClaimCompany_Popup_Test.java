package PageClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import CommonClass.HomeFunction;
import WaitClass.Wait;
 
  public class ClaimCompany_Popup_Test 
  {
	WebDriver driver;
	
	HomeFunction qf;
	ExtentTest test;
	ExtentReports report;
	
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

	@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
	
	@FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;
	
	@FindBy(xpath="//a[@href='/company/2000032/switchfast-logistics']") WebElement Company2;
	
	@FindBy(xpath="//a[@href='/company/140256/awe-sum-organics-inc']") WebElement Company3;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_Up_Size;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_UP_Size;
	
	@FindBy(xpath="//div[@id='claim_stat_msg']//p") WebElement ErrorMessage;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button") WebElement Submit_Request;
	
	
	public ClaimCompany_Popup_Test(WebDriver driver,ExtentTest test,ExtentReports report) 
	{
		this.driver=driver;
		qf=new HomeFunction(driver);
		this.test=test;
		this.report=report;
		PageFactory.initElements(driver,this);
	}

	public void ClaimTest() throws InterruptedException, IOException
	{
		qf.Quick();	
		ENTER_COMPANY.sendKeys("Hronis Inc");
		Thread.sleep(2000);
		Click_Company.click();
		Thread.sleep(3000);
		boolean b=driver.getPageSource().contains("Claim Company");
		System.out.println(b);

		if(b==true)
		{
			Thread.sleep(2000);
			Click_Claim_Button.click();
			test=report.startTest("Pop Up Test");
			test.log(LogStatus.INFO, "Pop Up Exist");
		}
		else if(b==false)
		{
			Quick_Search_Box.sendKeys("SwitchFast Logistics");
		    driver.manage().timeouts().implicitlyWait(Wait.Implicitly_Wait,TimeUnit.SECONDS);
		    Company2.click();
			Thread.sleep(1000);
		    Thread.sleep(2000);
		    Click_Claim_Button.click();
		}
		
		else
		{
			Quick_Search_Box.sendKeys("Awe Sum Organics Inc");
			Thread.sleep(1000);
			Company3.click();
			Thread.sleep(1000);
			Click_Claim_Button.click();	
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
		   
		   String ErrorText=ErrorMessage.getText();
		   //System.out.println("Error Message is : " + ErrorText);
		   Assert.assertEquals(ErrorText, "Oops... we need you to log in first to claim your company.");
		   System.out.println("User is Not Logged In -- Need to Log in Tpo Claim Company");
		   Thread.sleep(1000);
		   NAME.sendKeys("vdas0692@gmail.com");
		   Thread.sleep(1000);
		   PWD.sendKeys("t");
		   Thread.sleep(2000);
		   SUBMIT.click();
		   Thread.sleep(4000);
		   Click_Claim_Button.click();
		   Thread.sleep(1000);
		   Submit_Request.click();

	}
    }



  
  
  
  
  
  
  
  
  
  






















