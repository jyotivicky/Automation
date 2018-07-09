package CommonClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

    public class PageScroll 
    {
	public static void ScroolDown(WebDriver driver)
	{
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,350)", "");
	}
	public static void ScroolUp(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,-350)", "");	
	}
    }
