package MyTestCase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import BaseClass.Red_InvokeBrowser;
import CommonClass.ExcelData;
import CommonClass.WriteData;
import ExecutionReport.Extent_Report;
import ExecutionReport.ScreenShot;
import PageClass.AdvancedSearch_Popup_Test;
import PageClass.Claim_POP_UP_Test;
import PageClass.Claim_Submit_Test;
import PageClass.Contact_Test;
import PageClass.Endorsement_Test;
import PageClass.Financial_Snapshot_Popup_Test;
import PageClass.Login_Test;
import PageClass.Non_LoggedIn_User_Test;
import PageClass.ProduceIndex;
import PageClass.RateCompany_Popup_Test;
import PropertyClass.Property;

public class DemoTest 
{
	WebDriver driver;
	String browser;
	String url;
	Login_Test login;
	Claim_POP_UP_Test claim;
	RateCompany_Popup_Test rest;
	ScreenShot sc;
	Financial_Snapshot_Popup_Test financialSnap;
	AdvancedSearch_Popup_Test advanced;
	Contact_Test contact; 
    ProduceIndex PIN;
    Extent_Report ER;
	Claim_Submit_Test Submit;
	Endorsement_Test Endorse;
	ExtentTest test;
	ExtentReports report;
	Claim_POP_UP_Test poppy;
	ExcelData read;
	Non_LoggedIn_User_Test pop;
	WriteData sss;
	
	@Parameters("browser")
	
	@BeforeMethod()
	public void Setup(String browser) throws InterruptedException, IOException
	   {	   
		if(browser.equals("FF")) 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\VICKY\\Desktop\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\VICKY\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();			
		}	
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\VICKY\\Desktop\\IEDriverServer-64.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}	
		 driver.get("https://dev-redbook-pcl.pantheonsite.io/");

		 login=new Login_Test(driver, test,report); 
		 rest=new RateCompany_Popup_Test(driver,test, report);
		 advanced=new AdvancedSearch_Popup_Test(driver,test);
		 PIN=new ProduceIndex(driver);
		 Endorse=new Endorsement_Test(driver, test);
		 pop=new Non_LoggedIn_User_Test(driver, test);
		 financialSnap=new Financial_Snapshot_Popup_Test(driver, test, report);
		 ER=new Extent_Report();
		 Submit=new Claim_Submit_Test(driver,test);
		 sc=new ScreenShot(driver);
	 	 contact=new Contact_Test(driver);
	 	 read=new ExcelData(driver);
	  }
	
	@Test(priority=1)
	  public void checkLogin() throws IOException, InterruptedException 
	  { 
		  String un=Property.getData("DATA", "username");
		  String pwd=Property.getData("DATA", "password");
		  
		  String un1=Property.getData("DATA", "username1");
		  String pwd1=Property.getData("DATA","password1");
		  
		  login.UserLogin(un, pwd,un1,pwd1);	
		  
		  String title=login.ValidateTitle();
		  Assert.assertEquals("Home | Produce Market Guide",title);
		  test=report.startTest("Login Test");
		  test.log(LogStatus.INFO, "Status of Login Test");
	  }
	  
	  @Test(priority=2)
	  public void CheckPopUp() throws InterruptedException
	  {
		  pop.PopUps();
		  test=report.startTest("Pop Up Test");
		  test.log(LogStatus.INFO, "Status of Pop Up UI Test");
	  }

	  @Test(priority=3)
	  public void CheckClaim() throws IOException, Exception
	  {
		  poppy=new Claim_POP_UP_Test(driver);
		  poppy.ClaimTest();
		  test=report.startTest("Claim Company Test");
		  test.log(LogStatus.INFO, "Status of Company Claim Functionality Test");
	  }
	  
	  @Test(priority=4)
	  public void CheckRating() throws InterruptedException
	  {
		  rest.RateTest();
		  test=report.startTest("Rate This Company Test");
		  test.log(LogStatus.INFO, "Status of Rate This Company Functionality Test");
	  }
	  
	  @Test(priority=5)
	  public void CheckFinancialSnapshot() throws InterruptedException
	  {
		  financialSnap.FinancialTest();
		  test=report.startTest("Financial Snapshot Test");
		  test.log(LogStatus.INFO, "Status of Financial Snapshot Functionality Test");
	  }
	  
	  @Test(priority=6)
	  public void CheckAdvancedPopup() throws InterruptedException
	  {
		  advanced.AdvancedPopupTest();
		  test=report.startTest("Aadvanced Search Pop Up Test");
		  test.log(LogStatus.INFO, "Status of Advanced Search Pop up Test");
	  }
	  
	  @Test(priority=7)
	   public void CheckContact() throws InterruptedException
	   {
		  contact.ContactTest();
		  test=report.startTest("Contact Listing Test");
		  test.log(LogStatus.INFO, "Status of Contacts Logged in and Looged out User Test");
	   }
	  
	  @Test(priority=10)
	  public void CheckProduce() throws InterruptedException
	  {
		 PIN.ProduceIndex_Test();
		 test=report.startTest("Produce Index Test");
		 test.log(LogStatus.INFO, "Status of Produce Index Test"); 
	  }
	  
	  @Test(priority=8)
	  public void CheckSubmit() throws InterruptedException
	  {
		  Submit.SubmitTest();
		  test=report.startTest("Submit Test");
		  test.log(LogStatus.INFO, "Status of Claim Submit Test");
	  }

	  @Test(priority=9)
	  public void CheckEndorse() throws InterruptedException
	  {
		  Endorse.EndroseTest();
		  test=report.startTest("Endorsement Test");
		  test.log(LogStatus.INFO, "Status of Endorsement Test");
	  }
	  
	  @AfterMethod
	  public void TestSucessfullReport() 
	    {	
         driver.quit();
		}

	    } 
       
	  
 




















