package PageClass;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import CommonClass.ExcelData;
import WaitClass.Wait;

   public class LastUpdatedTest
   {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	ExcelData read;
	
        @FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	    @FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
	
	    @FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
	
	    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	 	
		@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
		
		@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
		
		@FindBy(xpath="//button[@value='Submit request']") WebElement Submit_Request;
		
		@FindBy(xpath="//button[@class='btn btn-primary btn-block']") WebElement GotIt;
		
		@FindBy(xpath="//div[@class='hd-rft']//div//a[2]") WebElement LoginButton;
		
		@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

	    @FindBy(xpath="//p[@class='company-page-icons']//a//small//span[1]") WebElement Contact_Overview;
	    
	    @FindBy(xpath="//div[@class='hd-rft']//div//div//button") WebElement ToolButton;
	    
	    @FindBy(xpath="//div[@class='popover-content']//ul//li[5]//a") WebElement LogOut;
		
		@FindBy(xpath="//div[@class='popover-content']//ul//li[5]//a") WebElement Admin_Dash;
		
		@FindBy(xpath="//a[@href='/cvrs-pending-claims']") WebElement PendingClaim; 
		
		@FindBy(xpath="//div[@class='view-content']//div[1]//table//tbody//tr//td[3]//a[1]") WebElement Pending;
		
		@FindBy(xpath="//div[@class='popover-content']//div//textarea") WebElement TextArea;
		
		@FindBy(xpath="//div[@class='popover-content']//div//a[2]") WebElement Approve;
		
		@FindBy(xpath="//div[@id='claimApproved']//div//div//div[2]//button[1]") WebElement OK_Buton;
		
		@FindBy(xpath="//div[@id='claim-approved-status-msg']//div//div//div[2]//button") WebElement Close;
		
		@FindBy(xpath="//div[@class='popover-content']//ul//li[6]//a") WebElement LogOutAdmin;
		
		@FindBy(xpath="//div[@class='popover-content']//ul//li[2]//a") WebElement CompanyProfile;
		
		@FindBy(xpath="//a[@class='logo navbar-btn pull-left']") WebElement LOGO;
		
		@FindBy(xpath="//div[@id='company_listing']//div//ul//li[1]//a//div[2]//p") WebElement CompanyName1;
		
		@FindBy(xpath="//div[@id='fd-cts']//div//a[text()='Contacts']") WebElement Contacts;

	public LastUpdatedTest(WebDriver driver,ExtentTest test,ExtentReports report)
	{
		this.driver=driver;
		this.report=report;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void LastDate() throws IOException, Exception
	{
		Home_Popup.click();
		Wait.Thread_20();
		LoginButton.click();
		Wait.Thread_20();
		NAME.sendKeys("vdas0692@gmail.com");
		Wait.Thread_20();
		PWD.sendKeys("t");
		Wait.Thread_20();
		SUBMIT.click();
		Wait.Thread_20();
		ToolButton.click();
		Wait.Thread_20();
		CompanyProfile.click();
		Wait.Thread_30();
		CompanyName1.click();
		Wait.Thread_30();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", Contacts);
		Wait.Thread_20();
		Contacts.click();

		

		
		//test=report.startTest("test1234");
//		HomeFunction.Quick();
//		Wait.Thread_20();
//		ENTER_COMPANY.sendKeys("Yes Fresh LLC");
//		Wait.Thread_20();
//		Click_Company.click();
//		test.log(LogStatus.INFO, "Click Company Status");
//		Wait.Implicitly(driver);
//		
//		boolean b=driver.getPageSource().contains("Claim Company");
//		
//		if(b==true)
//	      {
//		System.out.println("Claim Button is Present");
//		Click_Claim_Button.click();
//		  }
//	    else
//	      {
//		   System.out.println("Claim Button is Absent");
//		   ExcelData.ReadData();
//	       }
		
//		Wait.Thread_30();
//		NAME.sendKeys("vdas0692@gmail.com");
//		PWD.sendKeys("t");
//		SUBMIT.click();
//		Wait.Thread_20();
//		Click_Claim_Button.click();
//		Wait.Thread_30();
//		Submit_Request.click();
//		String Expected="Got it! Continue";
//		String text=GotIt.getText();
//		Wait.Thread_20();
//		if(Expected.equals(text))
//		{
//			System.out.println("Claim Functionality Is Working Fine");
//		}
//		else
//		{
//			System.out.println("Claim Functionality Is Not Working Fine");
//		}
//		Wait.Thread_20();
//		GotIt.click();
//		Wait.Thread_30();
//		ToolButton.click();
//		Wait.Thread_20();
//		LogOut.click();
//		Wait.Implicitly(driver);
//		LoginButton.click();
//		Wait.Thread_20();
//		NAME.sendKeys("vdas4829@gmail.com");
//		Wait.Thread_20();
//		PWD.sendKeys("t");
//		Wait.Thread_20();
//		SUBMIT.click();
//		Wait.Thread_20();
//		ToolButton.click();
//		Wait.Thread_20();
//		Admin_Dash.click();
//		Wait.Implicitly(driver);
//		PendingClaim.click();
//		Wait.Implicitly(driver);
//		Pending.click();
//		TextArea.sendKeys("Test");
//		Approve.click();
//		Wait.Thread_20();
//		OK_Buton.click();
//		Wait.Thread_20();
//		Close.click();
//		Wait.Thread_30();
//		ToolButton.click();
//		Wait.Thread_20();
//		LogOutAdmin.click();
//		Wait.Implicitly(driver);
//		LoginButton.click();
//		Wait.Thread_20();
//		NAME.sendKeys("vdas0692@gmail.com");
//		Wait.Thread_20();
//		PWD.sendKeys("t");
//		Wait.Thread_20();
//		SUBMIT.click();
//		Wait.Thread_20();
//		LOGO.click();
//		Wait.Thread_20();
//		ToolButton.click();
//		Wait.Thread_20();
//		CompanyProfile.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        //Approving as a Site Owner
		
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver=new ChromeDriver(capabilities);
//		driver.get("https://dev-redbook-pcl.pantheonsite.io");
//		driver.manage().window().maximize();

		 
		
	}
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
