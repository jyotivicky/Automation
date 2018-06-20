package BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

   public class Red_InvokeBrowser 
   {
	static WebDriver driver;

	public static WebDriver openBrowser(String browserName) throws InterruptedException
	{
		if(browserName.equals("FF")) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\VICKY\\Desktop\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\VICKY\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();			
		}
		
		return driver;		
	}
    }
