package ExecutionReport;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

  public class Extent_Report 
 {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	
	
	public  void Report(ITestResult result)
	  {	
		 report=new ExtentReports("C:\\Test-OXYGEN\\RedBook\\report\\redbook.html",true);  
		 test=report.startTest("RedBookTest");
		 
		 if(result.getStatus()==result.SUCCESS) 
		 {
			 test.log(LogStatus.PASS, "Test case got pass");
		 }
		 else if (result.getStatus()==result.SKIP) 
		 {
			test.log(LogStatus.SKIP, "Test Case got skipped");
		 }
		 else if (result.getStatus()==result.FAILURE) 
		 {
			 test.log(LogStatus.FAIL, "Test Case got failed");
		}
			report.endTest(test);
			report.flush();
			report.close();	
	    } 
        }	
     

		
  
  
  
  
  
  
  
  
	