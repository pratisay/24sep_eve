package TestNGNew;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Browser;
import pomModules.Forgotpassword;
import pomModules.Loginorsignup;
import utils.Utility;

public class TestNGPack_forgotNew extends Browser {
	public WebDriver driver ;
	private Loginorsignup loginorsignup ;
	private Forgotpassword forgotpassword ;
	
	
	@Parameters ("browser123")
	
	@BeforeTest
	public void launchTheBrowser (String browser) {
		
		if (browser.equals("chrome"))
    	{
		   driver =  openChromeBrowser();
    	}
    	
    	if (browser.equals("edge"))
    	{
    		driver = openEdgeBrowser();
    	}
    	
    	if (browser.equals("firefox"))
    	{
    		driver = openFirefoxBrowser ();
    		
    	}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	@BeforeClass
	public void beforeClass ()
	{
		loginorsignup = new Loginorsignup (driver);
		forgotpassword = new Forgotpassword (driver);
	}
	@BeforeMethod
	public void clickOnForgotPassword () throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver.get("https://www.facebook.com/");
	//	Loginorsignup loginorsignup = new Loginorsignup (driver);
		loginorsignup.clickonforgotpass();
		
	//	Forgotpassword forgotpassword = new Forgotpassword (driver);
		Thread.sleep(2000);
		String gettext = forgotpassword.getTextMesage();
		System.out.println(gettext);
		
		SoftAssert soft = new SoftAssert ();
		soft.assertEquals(gettext, "Please enter your email address or mobile number to search for your account.");
		
//		if (gettext.equals("Please enter your email address or mobile number to search for your account."))
//		{
//			System.out.println("text message validate");
//		}
//		else 
//		{
//			System.out.println("text message not validate");
//		}
		
        forgotpassword.enterEmailOrPhoneNumber(Utility.fetchDataFromExcel("TestData", 4, 0));
		
		
		forgotpassword.clickOnSearch();
	}
	
	@Test
	public void test () {
		System.out.println("Test");
	 
		String actualtitle = driver.getTitle();
		String actualurl = driver.getCurrentUrl();
		
		System.out.println(actualtitle);
		System.out.println(actualurl);
		
		String expectedtitle = "Forgotten Password | Can't Log In | Facebook";
		String expectedurl = "https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0";
		
		Assert.assertEquals(actualurl, expectedurl, "forgot password link working");
		Assert.assertEquals(actualtitle, expectedtitle, "forgot title working");
		
//		if (actualtitle.equals(expectedtitle) && actualurl.equals(expectedurl))
//		{
//			System.out.println("test case pass");
//		}
//		else
//		{
//			System.out.println("test case fail");
//		}
	
	
	}
		@AfterMethod
		public void afterMethod () {
			
			System.out.println("logout");
		}
		
		@AfterClass
		public void afterClass () {
			loginorsignup = null ;
			forgotpassword = null ;
			
		}
		@AfterTest
		public void afterTest ()
		{
			driver.close();
			driver = null ;
			System.gc();
		}
}
