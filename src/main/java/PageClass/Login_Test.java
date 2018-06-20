package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

   public class Login_Test 
  {
   WebDriver driver;
   ExtentTest test;

	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;

	@FindBy(xpath="//div[@class='user-login user-login-front pull-right']/a[text()='Login']") WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//img[@src='/themes/redbook/logo.svg']") WebElement Home;	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement WrongPass;

	public Login_Test(WebDriver driver)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public String ValidateTitle()
	{
		return driver.getTitle();
	}

	public void UserLogin(String un,String pwd) throws InterruptedException
	{
		Home_Popup.click();
		Thread.sleep(2000);
		LoginButton.click();
		Thread.sleep(2000);
		NAME.sendKeys(un);
		Thread.sleep(1000);
		PWD.sendKeys(pwd);
		SUBMIT.click();
		Thread.sleep(3000); 
	    }
        }









