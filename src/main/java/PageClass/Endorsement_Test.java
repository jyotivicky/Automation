package PageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import CommonClass.HomeFunction;

   public class Endorsement_Test 
  {
	WebDriver driver;
	HomeFunction Qf;
	ExtentTest test;
	
	@FindBy(xpath="//a[@href='#endorsement-block-popup']") WebElement Endorse_Button;
	
	@FindBy(xpath="//div[@id='endorsement-block']//ul//li[7]//div//span[@class='action-icon']") WebElement Button;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//a[@href='/company/191539/triple-j-produce-inc']") WebElement Click_Company;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//button[text()='Endorse']") WebElement Endorse;
	
	@FindBy(xpath="//div[@class='modal-content']//div/div//p//a[text()='Sounds good!']") WebElement Sounds_Good;

	public Endorsement_Test(WebDriver driver)
	{
		this.driver=driver;
		Qf=new HomeFunction(driver);
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	public void EndroseTest() throws InterruptedException
	{
	Qf.Quick();
	ENTER_COMPANY.sendKeys("Triple J Produce Inc");
	Thread.sleep(2000);
	Click_Company.click();
    Thread.sleep(3000);
    
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)", "");
    Thread.sleep(3000);
    
    Endorse_Button.click();
    Thread.sleep(3000);
    Button.click();
    Thread.sleep(2000);
    NAME.sendKeys("vdas0692@gmail.com");
    Thread.sleep(2000);
    PWD.sendKeys("t");
    Thread.sleep(3000);
    SUBMIT.click(); 
    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
    jse1.executeScript("window.scrollBy(0,450)", "");  
    Thread.sleep(3000);
    
    int xCord=Endorse_Button.getLocation().x;
	int yCord=Endorse_Button.getLocation().y;
	Actions act=new Actions(driver);
	Thread.sleep(3000);
	
	act.moveToElement(Endorse_Button, xCord, yCord).perform();
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    jse2.executeScript("window.scrollBy(0,250)", "");
	Endorse_Button.click();

    Thread.sleep(3000);
    Button.click();
    Endorse.click(); 

	Thread.sleep(3000); 
    
	String Text="Sounds good!";
    String pop =Sounds_Good.getText();
    System.out.println("The Text: "+ pop);
    
    Assert.assertEquals(pop, "Sounds good!");    
    if(Text.equals(pop))
    {
    System.out.println("Endorement Pop UP is Working fine");  
    }
    else
    {
    	System.out.println("Endorsement Pop up is Not working Fine");
    }
	}
	}


   
   
   
   
   
   
   
   
