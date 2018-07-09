package PageClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import CommonClass.HomeFunction;

   public class RateCompany_Popup_Test 
  {
	WebDriver driver;
	boolean isPresent;
	ExtentTest test;

	@FindBy(xpath="//a[text()='Rate This Company']") WebElement Rate_Company_Button;
	
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Pop_Up_Size;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
	
	@FindBy(xpath="//a[text()='Quick Search']")  WebElement QUICKSEARCH;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
    @FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//input[@id='edit-names-fieldset-0-row-company-name--QsxmXYbJ4Mk']") WebElement Company_Field;
	
	@FindBy(xpath="//button[@id='add-new-company-0']") WebElement Requst_Company;
	
	@FindBy(xpath="//div[@id='edit_payment_experience__eXorDz2Hc5U_chosen']//a[@class='chosen-single']") WebElement Select_Pay_Experience;
	
	@FindBy(xpath="//input[@placeholder='Company']") WebElement Input_Company; 
	
	@FindBy(xpath="//input[@placeholder='Job title']") WebElement Job_Title;
	
	@FindBy(xpath="//div[@class='where-i-work-update-cancel-wrapper form-actions form-group js-form-wrapper form-wrapper']//button[@value='Update']") WebElement Update;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-content']//div[@class='modal-header']/h4") WebElement Pop_up_Header;
	
	@FindBy(xpath="//div[@id='showCompanySubmitMessage']//div//div//button[text()='Close']") WebElement Close_Button;	
	
	@FindBy(xpath="//div[@class='experience-form']//div//div//div//div//ul//li[4]") WebElement Net_Twenty_One;
	
	@FindBy(xpath="//div[@class='experience-form']//div[2]//div//div//div//ul//li[4]") WebElement Years;
	
	@FindBy(xpath="//div[@class='experience-form']//div[3]/div//div//div//div//ul//li[2]") WebElement Company_NAME; 
	
	@FindBy(xpath="//div[@class='experience-form']//div[4]//div//div//div//ul//li[text()='Retailer']") WebElement Company_Type; 
	
	@FindBy(xpath="//div[@class='add-company']//div//div[7]/button[text()='Submit']") WebElement Sumbit_Button;
	
	@FindBy(xpath="//div[@class='clr-grn tc']") WebElement Sounds_Good; 
	
	@FindBy(xpath="//div[label[text()='What was your pay experience?']]//div//div//a") WebElement Pay1;
	
	@FindBy(xpath="//div[@class='experience-form']//div[2]//div//div[1]//a[1]") WebElement Pay2;
	
	@FindBy(xpath="//div[@class='experience-form']//div[3]//div//div[1]//a[1]")  WebElement Pay3;
	
	@FindBy(xpath="//div[@class='experience-form']//div[4]//div//div[1]//a[1]") WebElement Pay4;
	
	@FindBy(xpath="//div[@class='clr-grn tc']")  WebElement Text_Pop_UP;
	
	public RateCompany_Popup_Test(WebDriver driver,ExtentTest test,ExtentReports report)
	{
		this.driver=driver;	
		this.test=test;
        PageFactory.initElements(driver, this);
	}
	
	public void RateTest() throws InterruptedException
	      {		
		    HomeFunction.Quick();
			ENTER_COMPANY.sendKeys("Awe Sum Organics Inc");
            Thread.sleep(2000);
			Click_Company.click();
			Thread.sleep(3000);
			boolean b=driver.getPageSource().contains("Rate This Company");
			System.out.println(b);
			Thread.sleep(2000);
		   Rate_Company_Button.click();
		   Thread.sleep(2000);
		   WebDriverWait wait2=new WebDriverWait(driver, 10);
		   wait2.until(ExpectedConditions.visibilityOf(Pop_Up_Size));
 		   WebElement loginPopup=Pop_Up_Size;

		   int height=loginPopup.getSize().getHeight();
		   int width=loginPopup.getSize().getWidth();

		   if(height==428 && width==450)
		   {
			   System.out.println("Rate Company Pop Up Is Fine");
		   }
		   else
		   {
			   System.out.println("Rate Company Pop Up Broken");
		   }
		   Thread.sleep(2000);
		   NAME.sendKeys("vdas4829@gmail.com");
		   Thread.sleep(1000);
		   PWD.sendKeys("t");
		   SUBMIT.click();
		   
             Thread.sleep(2000);
             
		    int xCord=driver.findElement(By.partialLinkText("Rate this Company")).getLocation().x;
		    int yCord=driver.findElement(By.partialLinkText("Rate this Company")).getLocation().y;
		    Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.partialLinkText("Rate this Company")), xCord, yCord).perform();
			driver.findElement(By.partialLinkText("Rate this Company")).click();
			Thread.sleep(2000);

			String Header=Pop_up_Header.getText();
			System.out.println("The Text: "+ Header);
			
			if(Header.contains("Where I Work"))
			{
				System.out.println("To Rate any Company there should be a Company User need to Add in Where I work");
				Input_Company.sendKeys("test");
				WebElement table = driver.findElement(By.id("ui-id-2")); 
				Thread.sleep(3000);
	            List<WebElement> rows = table.findElements(By.tagName("li")); 
	            System.out.println("Total no. of rows: "+ rows.size());
	            
	            for (WebElement a : rows)
	            {
	                System.out.println("Values are = " + a.getText());

	            rows.get(3).click();
	            Thread.sleep(3000);
	            Job_Title.sendKeys("Test");
	            Thread.sleep(3000);
	            Update.click();
	            Close_Button.click();
	            Thread.sleep(2000);
				driver.findElement(By.partialLinkText("Rate this Company")).click();
			}
			}
			else if(Header.contains("What was your payment experience?"))
			{
				System.out.println("Direct Rate the Company");
				
				Pay1.click();
				Thread.sleep(2000);
				Net_Twenty_One.click();
				
				Pay2.click();
				Thread.sleep(2000);
				Years.click();
				
				Pay3.click();
				Thread.sleep(2000);
				Company_NAME.click();
				Thread.sleep(3000);

				 Pay4.click();
				 Thread.sleep(2000);
				 Company_Type.click();
                 Thread.sleep(2000);
                 SUBMIT.click();      
                 Thread.sleep(3000);

                int xCord1=Sounds_Good.getLocation().x;
             	int yCord1=Sounds_Good.getLocation().y;
             	Actions act1=new Actions(driver);
             	Thread.sleep(3000);
             	 act1.moveToElement(Sounds_Good, xCord1, yCord1).perform();
             	 String s1="Sounds good!";
                 String s2=Text_Pop_UP.getText();
                 System.out.println("The Text: "+ s2);
                 if(s1.equals(s2))
                 {
                	 System.out.println("Rate Company Pop up is Working Fine");
                 }
                
                 else
                 {
                	 System.out.println("Rate Company Pop up is Broken");
                 }
                }
			else if(Header.contains("Rating Approval Pending"))
			{
				System.out.println("Previous Rating is not Approved Yet");
			}
			else
			{
				System.out.println("Rate this Company Functionality is Broken");
			}
			}
            }

		   
	      
	
	      
  
	

   
   
   
   
   
   
   