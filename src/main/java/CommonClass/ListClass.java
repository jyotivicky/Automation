package CommonClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

      public class ListClass 
     {
    	  WebDriver driver;
    	  @FindBy(xpath="//ul[@class='chosen-results']//li") WebElement Test;
    	  
    	  public ListClass(WebDriver driver)
    	  {
    		 this.driver=driver;
    		 PageFactory.initElements(driver,this); 
    	  }
	   public static void List(WebDriver driver)
	   {
		   List<WebElement> list=driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
		   for(int i=0;i<list.size();i++)
		   {
			   WebElement element1=list.get(i);
			   String innerItem=element1.getAttribute("innerHTML");
			   if(innerItem.contains("Net 21"))
			   {
				   element1.click();
				   break;
			   }
			   System.out.println("Values From Drop-Down is == "+ innerItem);
		   }   
	      }
         }
