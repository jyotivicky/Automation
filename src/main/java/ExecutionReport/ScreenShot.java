package ExecutionReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

   public class ScreenShot 
  {
	static WebDriver driver;
	static int i=1;
	
	public ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String CaptureScreenshot(WebDriver driver,String screenshotName,String s) throws IOException
	       {
	  			TakesScreenshot screenshot =(TakesScreenshot)driver;
	  			
	  			File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
	  				  			
	  			String destFile="C:\\Users\\VICKY\\Desktop\\TEST_SHOT\\"+System.currentTimeMillis()+s+".png";
	  			
	  			i++;
	  			
	  			File destination=new File(destFile);
	  			
	  			FileUtils.copyFile(scrFile, destination);
	  				  			
	  			System.out.println("Screenshot Taken");
	  			
	  			return destFile;	
	  		}
            }
