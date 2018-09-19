package PageClass;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import WaitClass.Wait;

   public class ProduceIndex 
   {
	WebDriver driver;
	boolean isPresent;
	List<WebElement> links;
	
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Pop_Up;
	
	@FindBy(xpath="//button[@class='menu-toggle']") WebElement Menu_Button;
	
	@FindBy(xpath="//a[text()='Produce Index']") WebElement Produce_Index;
	
	@FindBy(xpath="//div[div[div[div[span[a[text()='All']]]]]]/div[2]//a") WebElement All_Links;
	
	@FindBy(xpath="//div[@class='sliding-menu']//div[2]//nav//ul//li[2]//a[@class='dropdown-toggle']") WebElement FindProduce; 
	
	@FindBy(xpath="//a[text()='Find companies']") WebElement Find_Companies;
	
	int count=0;
	int errorLinkCount;
	ArrayList<String> errorLink=new ArrayList<String>();
	ExtentTest test;
	
	public ProduceIndex(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
    public void ProduceIndex_Test() throws InterruptedException 
               {
			    Wait.Thread_30(); 
			    Home_Pop_Up.click();
			    Wait.Thread_30(); 
			    Menu_Button.click();
			    Wait.Thread_30(); 
			    FindProduce.click();
			    Wait.Thread_30(); 
			    Produce_Index.click();
			    
			    links=driver.findElements(By.xpath("//div[div[div[div[span[a[text()='All']]]]]]/div[2]//a"));
		    	while(count<links.size()) 
		    	   { 		
		    		List<WebElement> alllLinks=driver.findElements(By.xpath("//div[div[div[div[span[a[text()='All']]]]]]/div[2]//a"));    			
		    				 scrollToExactElement(alllLinks.get(count));
		    				 movetToCordinate(alllLinks.get(count));
		    				 alllLinks.get(count).click();
		    				 if(isElementPresent("Find_Companies")==true) 
		    				   {
								   System.out.println("button is present");
								   driver.navigate().back();
								   Thread.sleep(1000);
								   count++;		   
							   }
		    				 else 
		    				   {
		    					   System.out.println("button is not present");
								   String url=driver.getCurrentUrl();
								   System.out.println(url); 
								   System.out.println(errorLink);
								   Thread.sleep(1000);
								   count++;
								   errorLinkCount++;
								   driver.navigate().back();
							   }
		    			       }
		    	System.out.println(errorLink);
		    	System.out.println("The total no of link doesn't have compnay buttton is "+errorLinkCount);
		    		}
     public boolean isElementPresent(String xpath)  
        {
		  List<WebElement> element=driver.findElements(By.xpath(xpath));
		  if(element.size()!=0) 
		  {
			  isPresent=true;
		  }
		  else 
		  {
			  isPresent=false;
		  }
	return isPresent;	  
          }

   public void scrollToExactElement(WebElement element) throws InterruptedException 
   {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(500); 
   }

   public void movetToCordinate(WebElement element) 
   {
	Actions act=new Actions(driver);
	int xCord=element.getLocation().x;
	int yCord=element.getLocation().y;
	act.moveByOffset(xCord, yCord).perform();
   }
   
   public void Companies()
   {
	   
   } 
   }





 




   
   
   
   
   
   
   