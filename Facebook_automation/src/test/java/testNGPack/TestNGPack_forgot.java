package testNGPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomModules.Forgotpassword;
import pomModules.Loginorsignup;

public class TestNGPack_forgot {
	public WebDriver driver ;
	@BeforeClass
	public void launchTheBrowser () {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void clickOnForgotPassword () throws InterruptedException {
		
		driver.get("https://www.facebook.com/");
		Loginorsignup loginorsignup = new Loginorsignup (driver);
		loginorsignup.clickonforgotpass();
		
		Forgotpassword forgotpassword = new Forgotpassword (driver);
		Thread.sleep(2000);
		String gettext = forgotpassword.getTextMesage();
		System.out.println(gettext);
		
		if (gettext.equals("Please enter your email address or mobile number to search for your account."))
		{
			System.out.println("text message validate");
		}
		else 
		{
			System.out.println("text message not validate");
		}
        forgotpassword.enterEmailOrPhoneNumber("abc@gmail.com");
		
		
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
		
		if (actualtitle.equals(expectedtitle) && actualurl.equals(expectedurl))
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
			
			driver.close();
		}
	
	
	
}
