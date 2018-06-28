package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonClass.HomeFunction;

  public class Contact_Test 
 {
    WebDriver driver;
    
	HomeFunction qf;
	ExtentTest test;
    
    @FindBy(xpath="//a[text()='Contacts']") WebElement contacts_List;
    
    @FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;
    
    @FindBy(xpath="//div[@class='contacts-help-text-anonymous tc']//a[@class='btn btn-primary anchor-btn']") WebElement Learn_More;
    
    @FindBy(xpath="//div[@class='popover fade bottom in']//div[2]") WebElement Pop_Over_Text;
    
    @FindBy(xpath="//div[@class='popover-content']//a[text()='Log Out']") WebElement Logout_Button;
    
    @FindBy(xpath="//div[@class='fl tl-rm ml-fl w-fl']//a[@class='contacts-popover company-actions-popover in-bl vm']") WebElement Contact_Button; 
        
    @FindBy(xpath="//h3[@class='popover-title']") WebElement Popup_Text2;
    
    @FindBy(xpath="//div[@class='hd-rft']//button[@id='user-menu-popover']") WebElement ToolButton;
    
    @FindBy(xpath="//div[@class='user-menu pull-right']//button[@id='user-menu-popover']") WebElement ToolButton2;
    
    @FindBy(xpath="//p[@class='company-page-icons']//a//small//span[1]") WebElement Contact_Overview;
    
	@FindBy(xpath="//div[@class='input-group']/input[@id='edit-search-autocomplete']") WebElement Quick_Search_Box;
	
	@FindBy(xpath="//a[@href='/company/lenz-family-farms-llc']") WebElement Company22;
	
	@FindBy(xpath="//div[@class='navbar-header cm-usr-lg cm-hd-wrp pg-wdth']") WebElement TOOL;
	
	@FindBy(xpath="//a[@class='pop-ov-btn']") WebElement View_Contact;
	
	@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;

	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//div[@class='user-login pull-right']//a[text()='Login']") WebElement LoginButton;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//div[@class='popover fade bottom in']//div[2]//small//a") WebElement View_Contact_Button;

    public Contact_Test(WebDriver driver)
    {
    	this.driver=driver;
    	qf=new HomeFunction(driver);
    	this.test=test;
    	PageFactory.initElements(driver, this);
    }
    
    public void ContactTest() throws InterruptedException
    {
    	HomeFunction.Quick();
		ENTER_COMPANY.sendKeys("Lenz Family Farms LLC");
		Thread.sleep(2000);
		Company22.click();
    	Thread.sleep(3000);
    	
        Contact_Overview.click();
        Thread.sleep(2000);

        String Actual=Pop_Over_Text.getText();  
        System.out.println("Text :" + Actual);
        String Expected="View Contacts";     
        String Expected2="You must be logged in to view a company's contacts";
        
        if(Actual.equals(Expected2))
        {   	
        	System.out.println("User need to Log in to View the Contacts");
        	LoginButton.click();
    		Thread.sleep(3000);
    		NAME.sendKeys("redbookpcladmin2016@gmail.com");
    		Thread.sleep(2000);
    		PWD.sendKeys("redbookpcladmin2016");
    		SUBMIT.click();
    		Thread.sleep(3000);
    		Contact_Overview.click();
    	    Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@class='popover fade bottom in']//div[2]//small//a")).click();
		
    		WebElement element=contacts_List;
    		Actions actions = new Actions(driver);
    		actions.moveToElement(element).click().perform();
        }
        
        else if(Actual.equals(Expected))
        {
        	System.out.println("User is Logged in and the Contacts Functionality is working fine");
        	Contact_Overview.click();
            Thread.sleep(2000);
            View_Contact_Button.click();
        }
        
        else
        {
        	System.out.println("Contacts Functionality Broken"); 
        }

//        String s11="Learn More About Membership";
//        String s22=Learn_More.getText();
//
//        if(s11.equals(s22))
//        {	
//        	System.out.println("User is Logged in and  Contact View is working fine");
//        }
//        
//        else
//        {
//        	System.out.println("Contact View is not Working fine"); 
//        }		  
    }
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
