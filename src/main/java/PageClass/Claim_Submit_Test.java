package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonClass.HomeFunction;

public class Claim_Submit_Test 
{
	WebDriver driver;
	HomeFunction qf;
	ExtentTest test;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//a[@id='login-claim']") WebElement Claim_Button;
	
	@FindBy(xpath="//h1[@class='title']//small//div") WebElement Claim_Button_Logged_In;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement AutoComplete;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//a//a[@href='/company/191539/triple-j-produce-inc']") WebElement Company;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//button[text()='Submit request']") WebElement Submit_Request;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//div//button[@value='Submit request']") WebElement Submit_Request_Logged_In;
	
	@FindBy(xpath="//input[@id='mobile-number']") WebElement Phone_Field;
	
	public Claim_Submit_Test(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		qf=new HomeFunction(driver);
	}
	
	public void SubmitTest() throws InterruptedException
	{
		HomeFunction.Quick();
		ENTER_COMPANY.sendKeys("Triple J Produce Inc");
		Thread.sleep(2000);
		Company.click();
		Thread.sleep(2000);
		Claim_Button.click();
		Thread.sleep(2000);
		NAME.sendKeys("vdas0692@gmail.com");
		PWD.sendKeys("t");
		SUBMIT.click();
		Thread.sleep(2000);	
		
		Claim_Button_Logged_In.click();	
		Thread.sleep(2000);

		boolean Verify=Submit_Request_Logged_In.isEnabled();
		System.out.println("Status : " + Verify);
		if(Verify==true)
		{
			System.out.println("Button is Enabled");
			//Submit_Request_Logged_In.click();	
		}	
		else
		{
			System.out.println("Button is Disabled");
			//Submit_Request_Logged_In.click();
		}  
	    }
        }

























