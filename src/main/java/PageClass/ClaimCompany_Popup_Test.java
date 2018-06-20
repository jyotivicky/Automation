package PageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import CommonClass.HomeFunction;
import WaitClass.Wait;
 
  public class ClaimCompany_Popup_Test 
  {
	WebDriver driver;
	
	HomeFunction qf;
	ExtentTest test;
	
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

	@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//a[@href='/company/108163/hronis-inc']") WebElement Click_Company;
	
	@FindBy(xpath="//div[@id='claim-for-17325']") WebElement Click_Claim_Button;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;
	
	@FindBy(xpath="//a[@href='/company/2000032/switchfast-logistics']") WebElement Company2;
	
	@FindBy(xpath="//a[@href='/company/140256/awe-sum-organics-inc']") WebElement Company3;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_Up_Size;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_UP_Size;
	
	
	public ClaimCompany_Popup_Test(WebDriver driver) 
	{
		this.driver=driver;
		qf=new HomeFunction(driver);
		this.test=test;
		PageFactory.initElements(driver,this);
	}

	public void ClaimTest() throws InterruptedException
	{
		qf.Quick();
		
		ENTER_COMPANY.sendKeys("Hronis Inc");
		Thread.sleep(2000);
		Click_Company.click();
		Thread.sleep(3000);
		boolean b=driver.getPageSource().contains("Claim Company");
		System.out.println(b);

		if(b==true)
		{
			Thread.sleep(2000);
			Click_Claim_Button.click();
		}
		else if(b==true)
		{
			Quick_Search_Box.sendKeys("SwitchFast Logistics");
		    driver.manage().timeouts().implicitlyWait(Wait.Implicitly_Wait,TimeUnit.SECONDS);
		    Company2.click();
			Thread.sleep(1000);
		    Thread.sleep(2000);
		    Click_Claim_Button.click();
		}
		
		else if(b==true)
		{
			Quick_Search_Box.sendKeys("Awe Sum Organics Inc");
			Thread.sleep(1000);
			Company3.click();
			Thread.sleep(1000);
			Click_Claim_Button.click();	
		}
		
		else
		{
			System.out.println("Claim Company buttoon is missing");
		}	
		   WebDriverWait wait1=new WebDriverWait(driver, 10);
		   wait1.until(ExpectedConditions.visibilityOf(Pop_Up_Size));
		   
     	   WebElement loginPopup=Pop_UP_Size; 
		   int height=loginPopup.getSize().getHeight();
		   int width=loginPopup.getSize().getWidth();

		   if(height==428 && width==450)
		   {
			   System.out.println("Claim Company Pop Up Is Working Fine");
		   }
		   else
		   {
			   System.out.println(" Claim Company Pop Up Broken");
		   }

	}
    }

























