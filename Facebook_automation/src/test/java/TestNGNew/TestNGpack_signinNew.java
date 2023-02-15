package TestNGNew;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Browser;
import pomModules.Loginorsignup;
import pomModules.Signup;
import utils.Utility;

public class TestNGpack_signinNew extends Browser {
	public WebDriver driver ;
	private  Loginorsignup loginorsignup ;
	private  Signup signup ;
	
	@Parameters ("browser123")
	@BeforeTest
	public void launchBrowser (String browser) {
		
		if (browser.equals("chrome"))
    	{
		    driver = openChromeBrowser();
    	}
    	
    	if (browser.equals("edge"))
    	{
    		driver = openEdgeBrowser();
    	}
    	
    	if (browser.equals("firefox"))
    	{
    		driver = openFirefoxBrowser ();
    		
    	}
	}
	@BeforeClass 
	public void createPOMobject ()
	{
		 loginorsignup = new Loginorsignup (driver);
		 signup = new Signup (driver);
	}
	@BeforeMethod
	public void clickOnCrateNewAccount () throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
	//	 Loginorsignup loginorsignup = new Loginorsignup (driver);
		 loginorsignup.clickoncreatenewacc ();
		 
	//	 Signup signup = new Signup (driver);
		 
		    signup.sendkeysOnFirstName(Utility.fetchDataFromExcel("TestData", 6, 0));
		    signup.sendkeysOnLastname(Utility.fetchDataFromExcel("TestData", 7, 0));
		    
		    
		    signup.sendkeysOnEmailorMob(Utility.fetchDataFromExcel("TestData", 6, 1));
		    signup.sendkeysOnnewPassword(Utility.fetchDataFromExcel("TestData", 7, 1));
		    
		    signup.sendkeysOnDayOfBirth();
		    signup.sendkeysOnMonthofBirth();
		    signup.sendkeysOnYearOfBirth();
		    signup.clickOnmaleRadioButton();
		    
		  //  signup.clickOncustomRadioButton();
		    signup.clickOnsubmitButton();
		    
	}
	
	@Test
	public void test () {
		System.out.println("Test");
	
		String actualUrl = driver.getCurrentUrl();
		   String actualtitle = driver.getTitle();	
		    
		   System.out.println(actualUrl);
		   System.out.println(actualtitle);
		    
		   String expectedUrl = "https://www.facebook.com/";
		   String expectedTitle = "Facebook – log in or sign up";
		   
		   if (actualUrl.equals(expectedUrl) && actualtitle.equals(expectedTitle))
		   {
			   System.out.println("test case pass");
		   }
		   else
		   {
			   System.out.println("test case fail");
		   }
		    
	}
	
	@AfterMethod
	public void afterMethod () {
		
		System.out.println("logout");
	}
	
	@AfterClass
	public void afterClass () {
		loginorsignup = null;
		 signup = null;
	}
	
	@AfterTest
	public void afterTest ()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
}
