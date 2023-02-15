package Testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomModules.Loginorsignup;

public class VerifyLoginFunctionality {

	
	public static void main(String[] args) {
// step 1 - open the browser and enter the url
		    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://www.facebook.com/");
			
// step 2 - enter username and password		
			Loginorsignup loginorsignup = new Loginorsignup (driver);
	     	loginorsignup.sendUserName("8805238195");
			loginorsignup.sendpassword("120");
			
// step 3 - click on login button		
			loginorsignup.clickonlogin();
			
// step 4 - verify the url and title	
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
}
