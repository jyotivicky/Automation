package CommonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  public class HomeFunction 
  {
	static WebDriver driver;
	
    @FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']")
	static WebElement Home_Popup;
    
	@FindBy(xpath="//a[text()='Quick Search']")
	static  WebElement QUICKSEARCH;
	
	public HomeFunction(WebDriver driver)
	{	
		this.driver=driver;
    	PageFactory.initElements(driver, this);
	}
	
	public static void Quick() throws InterruptedException 
	{
		Thread.sleep(2000);
    	Home_Popup.click();
		Thread.sleep(2000);
    	int xCord=QUICKSEARCH.getLocation().x;
		int yCord=QUICKSEARCH.getLocation().y;
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(QUICKSEARCH, xCord, yCord).perform();
		
		QUICKSEARCH.click();
	}
    }
