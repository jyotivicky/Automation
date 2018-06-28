package ExecutionReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

   public class ScreenShot 
  {
	static WebDriver driver;
	
	public ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String CaptureScreenshot(WebDriver driver,String screenshotName) throws IOException
	       {
	  			TakesScreenshot screenshot =(TakesScreenshot)driver;
	  			
	  			File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
	  			
	  			String  destFile="C:\\Users\\VICKY\\Desktop\\TEST_SHOT\\"+screenshotName+".png";
	  			
	  			File destination=new File(destFile);
	  			
	  			FileUtils.copyFile(scrFile, destination);
	  				  			
	  			System.out.println("Screenshot Taken");
	  			
	  			return destFile;	
	  		}
            }
