package PageClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import CommonClass.HomeFunction;

public class Financial_Snapshot_Popup_Test 

  {
	WebDriver driver;
	HomeFunction qf;
	ExtentTest test;
	
	@FindBy(xpath="//a[text()='View Snapshot']") WebElement Financial;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_Up_Size;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
    
    @FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

	@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//a[@href='/company/108163/hronis-inc']") WebElement Click_Company;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_UP_SIZE;

	
	public Financial_Snapshot_Popup_Test(WebDriver driver)
	{
		this.driver=driver;
		qf=new HomeFunction(driver);
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void FinancialTest() throws InterruptedException
	{
		  Thread.sleep(3000);
		  qf.Quick();
		
			ENTER_COMPANY.sendKeys("Hronis Inc");
			Thread.sleep(3000);
			Click_Company.click();
			boolean b=driver.getPageSource().contains("View Snapshot");
			System.out.println(b);
			
		Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
        Financial.click();
        
           WebDriverWait wait2=new WebDriverWait(driver, 10);
		   wait2.until(ExpectedConditions.visibilityOf(Pop_Up_Size));
		   WebElement loginPopup=Pop_UP_SIZE;

		   int height=loginPopup.getSize().getHeight();
		   int width=loginPopup.getSize().getWidth();

		   if(height==428 && width==450)
		   {
			   System.out.println("*****************************");
			   System.out.println("Financial Snapshot Pop Up Is Fine");
			   System.out.println("*****************************");
		   }
		   else
		   {
			   System.out.println("Financial Snapshot Pop Up Broken");
		   }
		   NAME.sendKeys("vdas4829@gmail.com");
		   Thread.sleep(1000);
		   PWD.sendKeys("t");
		   SUBMIT.click();
		   
		    Thread.sleep(2000);
		    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	        jse1.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(3000);
	        Financial.click();
	       }
           }


































