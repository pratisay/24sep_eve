package testNGPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomModules.Loginorsignup;
import pomModules.Signup;

public class testNGPack_signin {
	public WebDriver driver ;
	@BeforeClass
	public void launchBrowser () {
		System.out.println("Before Class");
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void clickOnCrateNewAccount () throws InterruptedException {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		 Loginorsignup loginorsignup = new Loginorsignup (driver);
		 loginorsignup.clickoncreatenewacc ();
		 
		 Signup signup = new Signup (driver);
		    signup.sendkeysOnFirstName("Soham");
		    signup.sendkeysOnLastname("Kadam");
		    signup.sendkeysOnEmailorMob("9876987510");
		    signup.sendkeysOnnewPassword("Pass4567");
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
		System.out.println("after class 1");
		driver.close();
	}
	
}
