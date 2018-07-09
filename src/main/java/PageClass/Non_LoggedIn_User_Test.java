package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import CommonClass.PageScroll;
import WaitClass.Wait;

   public class Non_LoggedIn_User_Test 
   {
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//div[@id='popup-dialog-window']//span[@id='close-dialog']") WebElement Home_Popup;
	
	@FindBy(xpath="//a[text()='Quick Search']") WebElement QUICKSEARCH;
	
	@FindBy(xpath="//input[@id='edit-search-autocomplete']") WebElement ENTER_COMPANY;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li[3]//a[1]//a") WebElement Click_Company;
	
	@FindBy(xpath="//div[@class='user-login user-login-front pull-right']/a[text()='Login']") WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='mn-wrp']//div//section//div//article//h1/small//div") WebElement Click_Claim_Button;
	
	@FindBy(xpath="//div[@id='claim_stat_msg']//p") WebElement ClaimErrorMsg;

	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='name']") WebElement NAME;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//input[@name='pass']") WebElement PWD;
	
	@FindBy(xpath="//div[@id='drupal-modal--body']//button[@type='submit']") WebElement SUBMIT;
	
	@FindBy(xpath="//div[@class='modal-body']//div//div//h3") WebElement CreateAccount;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div//div//div//button[@class='close']") WebElement CloseCreate;
	
	@FindBy(xpath="//div[@id='drupal-modal']//div//div//div[1]//button[@class='close']") WebElement ClosePopUp; 
	
	@FindBy(xpath="//div[@class='popover fade bottom in']//div[2]") WebElement Pop_Over_Text;
	
    @FindBy(xpath="//p[@class='company-page-icons']//a//small//span[1]") WebElement Contact_Overview;
    
    @FindBy(xpath="//p[@class='company-page-icons']//span[@id='endorsement-count']") WebElement EndorsePopButton;
    
    @FindBy(xpath="//p[@class='company-page-icons']//span[@class='count hpr']//a") WebElement RateButton; 
    
	@FindBy(xpath="//a[text()='Rate This Company']") WebElement Rate_Company_Button;
	
	@FindBy(xpath="//div[@id='endorse_stat_msg']//p") WebElement RateErrorMSG;
	
	@FindBy(xpath="//div[@id='reset-password-modals']//h4") WebElement ResetPopUp;
	
	@FindBy(xpath="//a[@href='#endorsement-block-popup']") WebElement Endorse_Button;
	
	@FindBy(xpath="//div[@id='endorsement-block-popup']//div//div//div//h4") WebElement EndorsePopUpMsg;
	
	@FindBy(xpath="//div[@id='endorsement-block-popup']//div//div//div[1]//button") WebElement EndorseClose;
	
	@FindBy(xpath="//div[@id='endorse_stat_msg']//p") WebElement EndorsePopUpHeader; 
	
	@FindBy(xpath="//a[text()='View Snapshot']") WebElement Financial;

	@FindBy(xpath="//div[@id='endorse_stat_msg']/p") WebElement FinancialErrorMsg;
	
	@FindBy(xpath="//div[@class='hd-rft']//div//div//button") WebElement ToolButton;
	
	@FindBy(xpath="//div[@class='popover-content']//ul//li[5]//a") WebElement Admin_Dash;
	
	@FindBy(xpath="//a[@href='/cvrs-pending-claims']") WebElement PendingClaim; 
	
	@FindBy(xpath="//tr[@class='item-233704']//td[3]//a") WebElement Pending;
	
	@FindBy(xpath="//div[@id='popover-content-233704']//a[1]") WebElement REJECT;
	
	@FindBy(xpath="//div[@id='claimRejected']//div//div//div[2]//h4") WebElement ClaimRejectedText;
	
	@FindBy(xpath="//div[@id='claimApproved']//div//div//div[2]//h4") WebElement ClaimApproveText;
	
	@FindBy(xpath="//div[@id='claimRejected']//div//div//div[2]//button[2]") WebElement CancelButton;
	
	@FindBy(xpath="//div[@id='claimApproved']//div//div//div[2]//button[2]") WebElement CancelButton1;
	
	@FindBy(xpath="//div[@id='popover-content-233704']//textarea") WebElement TextArea;
	
	@FindBy(xpath="//div[@id='popover-content-233704']//a[2]") WebElement Approve;
	
	public Non_LoggedIn_User_Test(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void PopUps() throws InterruptedException
	{
		Home_Popup.click();
		Wait.Thread_30();
		LoginButton.click();
		Thread.sleep(3000);
		String srt="Log in";
		String srt1=SUBMIT.getText();
		if(srt.equals(srt1))
		{
			System.out.println("Login Pop Up is Coming==No Issue");
		}
		else
		{
			System.out.println("no Pop Up==Issue");
		}
		Wait.Thread_20();
		driver.findElement(By.partialLinkText("Create Account")).click();
		
		String srt2="Create Account";
		Wait.Thread_20();
		String srt22=CreateAccount.getText();
		if(srt2.equals(srt22))
		{
			System.out.println("Create Account Pop up Is Coming==No Issue");
		}
		else
		{
			System.out.println("No Create Account Pop up==Issue");
		}
		
		CloseCreate.click();
		Wait.Thread_20();
		QUICKSEARCH.click();
		Wait.Thread_20();
		ENTER_COMPANY.sendKeys("Yes Fresh LLC");
		Wait.Thread_20();
		Click_Company.click();
		Wait.Implicitly(driver);
		Click_Claim_Button.click();
		Wait.Thread_20();
		String ErrorMsg1="Oops... we need you to log in first to claim your company.";
		String Expected=ClaimErrorMsg.getText();
		if(ErrorMsg1.equals(Expected))
		{
			System.out.println("Claim Login Pop Is Coming==No Issue");
		}
		else
		{
			System.out.println("Pop up is missing==Issue"); 
		}
		//Wait.Thread_20();
		ClosePopUp.click();	
		Wait.Thread_20();
		Contact_Overview.click();
		String s3="You must be logged in to view a company's contacts";
		String S33=Pop_Over_Text.getText();
		if(s3.equals(S33))
		{
			System.out.println("OverView Pop Over is Coming==No Issue");
		}	
		else
		{
			System.out.println("OverView Pop Over is not Coming==Issue");
		}
		Wait.Thread_20();
		EndorsePopButton.click();
		Wait.Thread_20();
		String s4=Pop_Over_Text.getText();
		String Expected1="You must be logged in to view who endorsed this company.";
		if(Expected1.equals(s4))	
		{
			System.out.println("Endorse Pop Over is Coming==No Issue");
		}
		else
		{
			System.out.println("Endorse Pop over is Not Coming==Issue");
		}
		Wait.Thread_30();
		RateButton.click();
		Wait.Thread_20();
		String s5=Pop_Over_Text.getText();
		String Expected3="You must be logged in to rate the company.";
		if(Expected3.equals(s5))
		{
			System.out.println("Rate Company Pop Over is Coming==No Issue");
		}
		else
		{
			System.out.println("Rate Company Pop Over is Not Coming==Issue");
		}
		Wait.Thread_30();
		Rate_Company_Button.click();
		Wait.Thread_20();
		String s6=RateErrorMSG.getText();
		String Expected6="Oops... we need you to log in first to rate this company.";
		if(Expected6.equals(s6))
		{
			System.out.println("Rate Login Pop Up is Coming==No Issue");
		}
		else
		{
			System.out.println("Rate Pop up is not Coming==Issue");
		}
		Wait.Thread_30();
		
		driver.findElement(By.partialLinkText("Send reset email")).click();
		Wait.Thread_30(); 
		String s7=ResetPopUp.getText();
		String Expected7="Enter your registered email here";
		if(Expected7.equals(s7))
		{
			System.out.println("Reset Pop Up is Coming==No Issue");
		}
		else
		{
			System.out.println("Reset Pop Up is Not Coming==Issue");
		}
		Wait.Thread_20();
		ClosePopUp.click();
		Wait.Thread_20();
		PageScroll.ScroolDown(driver);
		Endorse_Button.click();
		Wait.Thread_20();
		String s8=EndorsePopUpMsg.getText();
		if(s8.contains("Endorse"))
		{
			System.out.println("Endorse Pop Up Is Coming==No Issue");
		}
		else
		{
			System.out.println("Endorse Pop Up Is Not Coming==Issue");	
		}
		Wait.Thread_30();
		EndorseClose.click();
		Wait.Thread_20();
		Financial.click();
		Wait.Thread_20();
		String S9=FinancialErrorMsg.getText();
		String Expected9="You must be logged in to view this company's snapshot.";
		if(S9.equals(Expected9))
		{
			System.out.println("Snapshot Pop Up Is Coming==No Issue");
		}
		else
		{
			System.out.println("Snapshot Pop Up Is Coming==Issue");	
		}
		NAME.sendKeys("vdas4829@gmail.com");
		PWD.sendKeys("t");
		SUBMIT.click();
     	Wait.Thread_20();
		ToolButton.click();
		Wait.Thread_20();
		Admin_Dash.click();
		Wait.Thread_20();
		PendingClaim.click();
		Wait.Thread_20();
		Pending.click();
		Wait.Thread_20();
		TextArea.sendKeys("Test");
		Wait.Thread_20();
		REJECT.click();
		Wait.Thread_20();
		String s10=ClaimRejectedText.getText();
		String Expected10="Are you sure to reject this claim";
		if(s10.equals(Expected10))
		{
			System.out.println("Claim Reject Pop Up is Coming==No Issue");
		}
		else
		{
			System.out.println("Claim Reject Pop Up is Not Coming==Issue");
		}
		CancelButton.click();
		Wait.Thread_20();
		Pending.click();
		Approve.click();
		Wait.Thread_20();
		String s11=ClaimApproveText.getText();
		String Expected11="Are you sure to approve this claim";
		if(s11.equals(Expected11))
		{
			System.out.println("Pop Up Fine==No Issue");
		}
		else
		{
			System.out.println("Pop Up Is Not Fine==Issue");
		}
		Wait.Thread_20();
		CancelButton1.click();
		driver.navigate().back();
	  }
      }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
      