package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

 public class AdvancedSearch_Popup_Test 
 {	
 WebDriver driver;
 ExtentTest test;
 
 @FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;
 
 @FindBy(xpath="//div[@class='advanced-search-link']/a[text()='Advanced Search']") WebElement Advanced_Search_Button; 
 
 @FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']") WebElement Advanced_Search_Popup;
 
 @FindBy(xpath="//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='close']") WebElement Popup_Close;
 
 @FindBy(xpath="//button[@class='button js-form-submit form-submit btn-default btn']") WebElement Button;
 
 @FindBy(xpath="//div[@class='advanced-search-link quick-search']/a[text()='Advanced Search']") WebElement Advanced_Button2;
 
 @FindBy(id="edit-submit--4") WebElement ButtonHome;
 
 @FindBy(xpath="//div[@class='advanced-search-change-search br-box ml-fl pr']") WebElement Update_Search;
 
 public AdvancedSearch_Popup_Test(WebDriver driver,ExtentTest test)
 {
	 this.driver=driver;
	 this.test=test;
	 PageFactory.initElements(driver, this);
 }
 

public void AdvancedPopupTest() throws InterruptedException
 {
	   Thread.sleep(3000);
	   Home_Popup.click();
 	   Thread.sleep(3000);
	   Advanced_Search_Button.click();
	   WebDriverWait wait1=new WebDriverWait(driver, 10);
	   wait1.until(ExpectedConditions.visibilityOf(Advanced_Search_Popup));
	   WebElement loginPopup=driver.findElement(By.xpath("//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']")); 
	   int height=loginPopup.getSize().getHeight();
	   int width=loginPopup.getSize().getWidth();
	   
	   System.out.println("Advanced Search Pop Up Height is "+height);
	   System.out.println("Advanced Search Pop Up Width is "+width);
	   
	   System.out.println("***************************");
	   
	   Popup_Close.click();
	   Thread.sleep(2000);
	   Button.click();
	   Thread.sleep(2000);
	   Advanced_Button2.click();
	   Thread.sleep(3000);
	   
	   WebDriverWait wait11=new WebDriverWait(driver, 10);
	   wait11.until(ExpectedConditions.visibilityOf(Advanced_Button2));
	   WebElement loginPopup1=driver.findElement(By.xpath("//div[@id='drupal-modal']//div[@class='modal-dialog']//div[@class='modal-content']")); 
	   int height1=loginPopup1.getSize().getHeight();
	   int width1=loginPopup1.getSize().getWidth();
	   
	   System.out.println("Another Advanced Search Pop Up Height is "+height1);
	   System.out.println("Another Advanced Search Pop Up Width is "+width1);

	   if(height==895 && width==1029)
	   {
		   System.out.println("*****************************");
		   System.out.println("Advanced Search Pop Up's are Same");
		   System.out.println("*****************************");

	   }
	   else
	   {
		   System.out.println("*****************************");
		   System.out.println("Advanced Search Pop Up's are not Same");
	   }
	   //Popup_Close.click();	
     }
     }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 