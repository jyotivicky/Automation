package CommonClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import BaseClass.Red_InvokeBrowser;
import PropertyClass.Property;

public class Home_Page 
{
	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void Open() throws IOException, InterruptedException
	{
		browser=Property.getData("DATA", "browserName"); 	  
		driver=Red_InvokeBrowser.openBrowser(browser); 
		url=Property.getData("DATA", "url");
		driver.get(url);
		Thread.sleep(3000);
	}
    }
