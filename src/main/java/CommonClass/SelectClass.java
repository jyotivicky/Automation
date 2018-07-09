package CommonClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

  public class SelectClass 
   { 
	public static void selectingByvalue(WebElement element,String value) 
	{	
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	public static void selectingByText(WebElement element,String text) 
	{	
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	public static void seleictingByIndex(WebElement element,int index) 
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
    }
