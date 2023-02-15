package testNGPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomModules.Loginorsignup;
import pomModules.Signup;

public class TestNGlinksCombine {

	public WebDriver driver ;
	@BeforeClass
	public void openBrowserLaunchApplication () {
		System.out.println("Before Class");
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void clickOnLoginButton () {
		
		driver.get("https://www.facebook.com/");
		Loginorsignup loginorsignup = new Loginorsignup (driver);
		loginorsignup.clickoncreatenewacc();
	}
	
	@Test
	public void clickOnTermsLink () {
		
		
		 Signup signup = new Signup (driver);
		 signup.clickOnTermsLink();
		 
		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
     	driver.switchTo().window(addr.get(1));
     	
		 
		 String expectedUrl = "https://www.facebook.com/legal/terms/update";
		 String actualUrl = driver.getCurrentUrl();
		 
		 
		 Assert.assertEquals(actualUrl, expectedUrl);
		 
//		 if (expectedUrl.equals(actualUrl))
//		 {
//			 System.out.println("test pass");
//		 }
//		 else
//		 {
//			 System.out.println("test fail");
//		 }
	}	 
		 
		 
	@Test
	public void clickOnPrivacypolicy () {
		
		 Signup signup = new Signup (driver);
		 signup.clickOnPrivacypolicyLink();
		 
		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
     	driver.switchTo().window(addr.get(1));
     	
		 
		 String expectedUrl = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
		 String actualUrl = driver.getCurrentUrl();
		 
		 Assert.assertEquals(actualUrl, expectedUrl, "privacy policy is not working");
		 
//		 if (expectedUrl.equals(actualUrl))
//		 {
//			 System.out.println("test pass");
//		 }
//		 else
//		 {
//			 System.out.println("test fail");
//		 }
	}	  
	
	

	@Test
	public void signupComplete () {
	
		
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
		    
		    String actualUrl = driver.getCurrentUrl();
			   String actualtitle = driver.getTitle();	
			    
			   System.out.println(actualUrl);
			   System.out.println(actualtitle);
			    
			   String expectedUrl = "https://www.facebook.com/";
			   String expectedTitle = "Facebook – log in or sign up";
			   
			   Assert.assertEquals(actualUrl, expectedUrl, "facebook url");
			   
			   SoftAssert soft = new SoftAssert ();
			   soft.assertEquals(actualtitle, expectedTitle, "facebook title");
			   
//			   if (actualUrl.equals(expectedUrl) && actualtitle.equals(expectedTitle))
//			   {
//				   System.out.println("test case pass");
//			   }
//			   else
//			   {
//				   System.out.println("test case fail");
//			   }
			    
		}
		 
	         @AfterMethod
	         public void backtoHomepage () {
	            ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
	            driver.switchTo().window(addr.get(0));
	            
	            	
	}
		 
		 
	
	
		
	@Test
	public void clickOnCookiesPolicyLink () {
		
		 Signup signup = new Signup (driver);
		 signup.clickOnPrivacypolicyLink();
		 
		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
     	driver.switchTo().window(addr.get(1));
     	
		 
		 String expectedUrl = "https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
		 String actualUrl = driver.getCurrentUrl();
		 
		 if (expectedUrl.equals(actualUrl))
		 {
			 System.out.println("test pass");
		 }
		 else
		 {
			 System.out.println("test fail");
		 }
	}	  
	
	 @AfterMethod
     public void backtoHomepage1 () {
        ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
        driver.switchTo().window(addr.get(0));
        
     
        
        
		 
	

		
	}
	
	
}	
	
	
	
	
	
	

