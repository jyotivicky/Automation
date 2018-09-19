package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import WaitClass.Wait;

   public class Login_Test 
  {
   WebDriver driver;
   ExtentTest test;
   ExtentReports report;

	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialogggggg']") WebElement Home_Popup;

	@FindBy(xpath="//div[@class='user-login user-login-front pull-right']/a[text()='Login']") WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//img[@src='/themes/redbook/logo.svg']") WebElement Home;	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement WrongPass;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//div[1]//div[1]//a[2]") WebElement ErrorMessage;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[1]//div[1]//div[1]//button[@class='close']") WebElement CloseButton; 

	public Login_Test(WebDriver driver, ExtentTest test,ExtentReports report)
	{
		this.driver=driver;
		this.report=report;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public String ValidateTitle()
	{
		return driver.getTitle();
	}

	public void UserLogin(String un,String pwd,String un1,String pwd1) throws InterruptedException
	   {
		Home_Popup.click();
		Wait.Thread_20();
		
		LoginButton.click();
		
		Wait.Thread_20();
		NAME.sendKeys(un1);
		Thread.sleep(1000);
		PWD.sendKeys(pwd1);
		Wait.Thread_20();
		SUBMIT.click();
		  
		Wait.Thread_30();
		Assert.assertEquals("Forgot your password?", ErrorMessage.getText());			
		System.out.println("User Entered Wrong Password");

		PWD.sendKeys(pwd);
		Wait.Thread_20();
		SUBMIT.click();
		System.out.println("User Entered a Valid Password");
	    }
        }










   
   
   
   
   
   
   
   
   