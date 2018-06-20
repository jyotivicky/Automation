package CommonClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

   public class ActionClass
   {
	public static void ActionCordinate(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.chord(Keys.DOWN)).perform();
	}
	
	public static void ActionMoveElement(WebDriver driver,WebElement element)
	{
		Actions act1=new Actions(driver);
		act1.moveToElement(element).click().perform();		
	}
	
	
	
   }
