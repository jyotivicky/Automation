package MyTestCase;

import java.io.IOException;
import java.util.EmptyStackException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import BaseClass.Red_InvokeBrowser;
import CommonClass.ExcelData;
import ExecutionReport.Extent_Report;
import ExecutionReport.ScreenShot;
import PageClass.AdvancedSearch_Popup_Test;
import PageClass.Claim_POP_UP_Test;
import PageClass.Claim_Submit_Test;
import PageClass.Contact_Test;
import PageClass.Endorsement_Test;
import PageClass.Financial_Snapshot_Popup_Test;
import PageClass.LastUpdatedTest;
import PageClass.Login_Test;
import PageClass.Non_LoggedIn_User_Test;
import PageClass.ProduceIndex;
import PageClass.RateCompany_Popup_Test;
import PropertyClass.Property;

  public class NewTest 
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
	LastUpdatedTest dateTest;
	
	
	
	
	
	
	
	
	
	@BeforeClass
	public void setUpClass() throws IOException ,InterruptedException 
	{	 	  
		 report=new ExtentReports("C:\\Test-OXYGEN\\RedBook\\report\\redbook.html",true);  
		 test=report.startTest("RedBookTest");
		 
		 report.addSystemInfo("Project", "Redbook Automation");
		 report.addSystemInfo("Environment", "DEV");
		 report.addSystemInfo("Test Engineer", "Jyotiprakash");

		 browser=Property.getData("DATA", "browserName");
		 url=Property.getData("DATA", "url"); 
	}

	@BeforeMethod()
	public void Setup() throws InterruptedException, IOException
	   {	   
		 driver=Red_InvokeBrowser.openBrowser(browser); 
		 driver.get(url); 

		 login=new Login_Test(driver, test,report); 
		 rest=new RateCompany_Popup_Test(driver,test,report);
		 advanced=new AdvancedSearch_Popup_Test(driver,test);
		 PIN=new ProduceIndex(driver, test);
		 Endorse=new Endorsement_Test(driver, test);
		 pop=new Non_LoggedIn_User_Test(driver, test);
		 financialSnap=new Financial_Snapshot_Popup_Test(driver, test, report);
		 ER=new Extent_Report();
		 Submit=new Claim_Submit_Test(driver,test);
		 sc=new ScreenShot(driver);
	 	 contact=new Contact_Test(driver);
	 	 read=new ExcelData();
	 	 dateTest=new LastUpdatedTest(driver,test, report);
	  }
	
  @Test(enabled=false)
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
  
  @Test(priority=1)
  public void CheckDate() throws IOException, Exception
  {
	dateTest.LastDate();
	test=report.startTest("Last Updated Test");
	test.log(LogStatus.INFO, "Status Of Login Test");
  }
  
  @Test(enabled=false)
  public void CheckPopUp() throws InterruptedException
  {
	  pop.PopUps();
	  test=report.startTest("Pop Up Test");
	  test.log(LogStatus.INFO, "Status of Pop Up UI Test");
  }

  @Test(enabled=false)
  public void CheckClaim() throws IOException, Exception
  {
	  poppy=new Claim_POP_UP_Test(driver);
	  poppy.ClaimTest();
	  test=report.startTest("Claim Company Test");
	  test.log(LogStatus.INFO, "Status of Company Claim Functionality Test");
  }
  
  @Test(enabled=false)
  public void CheckRating() throws InterruptedException
  {
	  rest.RateTest();
	  test=report.startTest("Rate This Company Test");
	  test.log(LogStatus.INFO, "Status of Rate This Company Functionality Test");
  }
  
  @Test(enabled=false)
  public void CheckFinancialSnapshot() throws InterruptedException
  {
	  financialSnap.FinancialTest();
	  test=report.startTest("Financial Snapshot Test");
	  test.log(LogStatus.INFO, "Status of Financial Snapshot Functionality Test");
  }
  
  @Test(enabled=false)
  public void CheckAdvancedPopup() throws InterruptedException
  {
	  advanced.AdvancedPopupTest();
	  test=report.startTest("Aadvanced Search Pop Up Test");
	  test.log(LogStatus.INFO, "Status of Advanced Search Pop up Test");
  }
  
  @Test(enabled=false)
   public void CheckContact() throws InterruptedException
   {
	  contact.ContactTest();
	  test=report.startTest("Contact Listing Test");
	  test.log(LogStatus.INFO, "Status of Contacts Logged in and Looged out User Test");
   }
  
  @Test(enabled=false)
  public void CheckProduce() throws InterruptedException
  {
	 PIN.ProduceIndex_Test();
	 test=report.startTest("Produce Index Test");
	 test.log(LogStatus.INFO, "Status of Produce Index Test"); 
  }
  
  @Test(enabled=false)
  public void CheckSubmit() throws InterruptedException
  {
	  Submit.SubmitTest();
	  test=report.startTest("Submit Test");
	  test.log(LogStatus.INFO, "Status of Claim Submit Test");
  }

  @Test(enabled=false)
  public void CheckEndorse() throws InterruptedException
  {
	  Endorse.EndroseTest();
	  test=report.startTest("Endorsement Test");
	  test.log(LogStatus.INFO, "Status of Endorsement Test");
  }
  
  @AfterMethod
  public void TestSucessfullReport(ITestResult result) throws IOException, EmptyStackException
    {	
	 if(result.getStatus()==result.SUCCESS) 
	 {
		 test.log(LogStatus.PASS, "Test Case Got Pass");
	 }
	 else if (result.getStatus()==result.SKIP) 
	 {
		test.log(LogStatus.SKIP, "Test Case Got Skipped");
		test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	 else if (result.getStatus()==result.FAILURE) 
	 {
		 test.log(LogStatus.FAIL, "Test Case Got Failed");
		 String Path=ScreenShot.CaptureScreenshot(driver, "screenshotName","s");
		 test.log(LogStatus.FAIL, result.getThrowable());
         test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(Path));
	}
	 //driver.quit();
    } 
 
  @AfterClass
  public void tearDown() 
  {			  
	report.endTest(test);
	report.flush();
   }
  }
   
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
