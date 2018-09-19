package PageClass;
import java.util.List;
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
import WaitClass.Wait;

   public class Endorsement_Test 
  {
	WebDriver driver;
	boolean isEnabled;
	ExtentTest test;
	List<WebElement> links;
	
	@FindBy(xpath="//a[@href='#endorsement-block-popup']") WebElement Endorse_Button;
	
	@FindBy(xpath="//div[@id='endorsement-block']//ul//li[7]//div//span[@class='action-icon']") WebElement Button;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//button[text()='Endorse']") WebElement Endorse;
	
	@FindBy(xpath="//div[@id='endorsement-block']//ul//li//div//span[2]")  WebElement AllTopics;
	
	@FindBy(xpath="//div[@id='endorsement-block']//ul//li//div//span[2]//label//i[1]") WebElement Only_Button;
	
	@FindBy(xpath="//div[@class='modal-content']//div/div//p//a[text()='Sounds good!']") WebElement Sounds_Good;

	public Endorsement_Test(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	public void EndroseTest() throws InterruptedException
	{
	HomeFunction.Quick();
	ENTER_COMPANY.sendKeys("Hiland Farms");
	Thread.sleep(2000);
	Click_Company.click();
    Wait.Thread_20();
    
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,350)", "");
    Wait.Thread_30();
    
    Endorse_Button.click();
    Wait.Thread_20();
    Button.click();
    Wait.Thread_20();
    NAME.sendKeys("vdas0692@gmail.com");
    Wait.Thread_20();
    PWD.sendKeys("t");
    Thread.sleep(1000);
    SUBMIT.click(); 
    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
    jse1.executeScript("window.scrollBy(0,450)", "");  
    Wait.Thread_20();;
    
    int xCord=Endorse_Button.getLocation().x;
	int yCord=Endorse_Button.getLocation().y;
	Actions act=new Actions(driver);
	 Wait.Thread_20();
	
	act.moveToElement(Endorse_Button, xCord, yCord).perform();
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    jse2.executeScript("window.scrollBy(0,250)", "");
	Endorse_Button.click();

      Wait.Thread_20();    	
        links=driver.findElements(By.xpath("//div[@id='endorsement-block']//ul//li//div//span[2]//label//i[1]"));
        System.out.println("Total Number of Links : " + links.size());
    	
        boolean TopicsButton=driver.findElement(By.xpath("//div[@id='endorsement-block']//ul//li//div//span[2]//label//i[1]")).isEnabled();
        System.out.println("Button Status : " + TopicsButton);

         try 
          {
           List<WebElement> links = driver.findElements(By.xpath("//div[@id='endorsement-block']//ul//li//div//span[2]//i[1]"));
           int linkcount = links.size(); 
            System.out.println(links.size()); 
             for (WebElement myElement : links)
             {   	 
            String link = myElement.getText(); 
            System.out.println(link);
            System.out.println(myElement);  
            
            while(true)
            {        
           if (link !=null)
              {
        	    System.out.println("Button is Enabled");
                myElement.click();
                break;
               }
           else
           {
        	System.out.println("Button is Disabled");   
           }
           } 
           }
          }
       catch (Exception e)
       {
        System.out.println("error "+e);
       }

    Endorse.click(); 
	Wait.Thread_30();
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
	


   
   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
