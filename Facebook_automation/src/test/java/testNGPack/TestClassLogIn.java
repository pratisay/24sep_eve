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

public class TestClassLogIn {
public WebDriver driver ;

    
	@BeforeClass
	public void launchBrowser () {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void enterNameAndPassClickOnLogin () {
		
		driver.get("https://www.facebook.com/");
		Loginorsignup loginorsignup = new Loginorsignup (driver);
     	loginorsignup.sendUserName("8805238195");
		loginorsignup.sendpassword("120");
		loginorsignup.clickonlogin();
	}
	
	@Test
	public void test () {
		
		 String actualtitle = driver.getTitle();
		    String actualurl = driver.getCurrentUrl();
		    
		    System.out.println(actualtitle);
		    System.out.println(actualurl);
		
		    String expectedtitle = "Facebook – log in or sign up";
		    String expectedurl = "https://www.facebook.com/";
		
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
		System.out.println("After Method");
		System.out.println("logout");
	}
	
	@AfterClass
	public void afterClass () {
		System.out.println("After Class");
		driver.close();
	}
}
