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

   public class ProduceIndex 
   {
	WebDriver driver;
	boolean isPresent;
	List<WebElement> links;
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Pop_Up;
	@FindBy(xpath="//button[@class='menu-toggle']") WebElement Menu_Button;
	@FindBy(xpath="//a[text()='Produce Index']") WebElement Produce_Index;
	@FindBy(xpath="//div[div[div[div[span[a[text()='All']]]]]]/div[2]//a") WebElement All_Links;
	@FindBy(xpath="//a[text()='Find companies']") WebElement Find_Companies;
	int count=0;
	int errorLinkCount;
	ArrayList<String> errorLink=new ArrayList<String>();
	ExtentTest test;
	
	public ProduceIndex(WebDriver driver)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
  public void ProduceIndex_Test() throws InterruptedException 
               {
			    Thread.sleep(3000); 
			    Home_Pop_Up.click();
			    Thread.sleep(3000);
			    Menu_Button.click();
			    Thread.sleep(3000);
			    driver.findElement(By.partialLinkText("Find Produce")).click();
			    Thread.sleep(3000);
			    Produce_Index.click();
			    links=driver.findElements(By.xpath("//div[div[div[div[span[a[text()='All']]]]]]/div[2]//a"));
			    //links=All_Links;
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

   public void movetToCordinate(WebElement eleemnt) 
   {
	Actions act=new Actions(driver);
	int xCord=eleemnt.getLocation().x;
	int yCord=eleemnt.getLocation().y;
	act.moveByOffset(xCord, yCord).perform();
   }
   
   public void Companies()
   {
	   
   } 
   }





 



