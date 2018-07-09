package WaitClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class Wait 
    {
	  WebDriver driver;
	
	   public static void Implicitly(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   }
	   
	   public static void Thread_20() throws InterruptedException
	   {
		   Thread.sleep(2000);
	   }
	   
	   public static void Thread_30() throws InterruptedException
	   {
		   Thread.sleep(3000);
	   }
	   public static void Explicitly(WebDriver driver,String element)
	   {
		   WebDriverWait wait=new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));  
	   }
       }
