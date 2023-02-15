package TestNGNew;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
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

public class TestNGlinksCombine_New extends Browser {

	public WebDriver driver ;
	private Loginorsignup loginorsignup ;
	private  Signup signup ;
	
	
	@Parameters ("browser123")
	@BeforeTest
	public void openBrowserLaunchApplication (String browser ) {
		
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
		 signup = new Signup (driver);
		
	}
	
	@BeforeMethod
	public void clickOnLoginButton () {
		
		driver.get("https://www.facebook.com/");
	//	Loginorsignup loginorsignup = new Loginorsignup (driver);
		loginorsignup.clickoncreatenewacc();
		
		
	}
	
	
	@Test
	public void clickOnTermsLink () {
		
		
	//	 Signup signup = new Signup (driver);
		 signup.clickOnTermsLink();
		 
		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
     	driver.switchTo().window(addr.get(1));
     	
		 
		 String expectedUrl = "https://www.facebook.com/legal/terms/update";
		 String actualUrl = driver.getCurrentUrl();
		 
		 Assert.assertEquals(actualUrl, expectedUrl, "termsLinks not working");
		 
//		 if (expectedUrl.equals(actualUrl))
//		 {
//			 System.out.println("test pass");
//		 }
//		 else
//		 {
//			 System.out.println("test fail");
//		 }
	}	 
		 
		 
	@Test (priority = 1)
	public void clickOnPrivacypolicy () {
		
	//	 Signup signup = new Signup (driver);
		 signup.clickOnPrivacypolicyLink();
		 
		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
     	driver.switchTo().window(addr.get(1));
     	
		 
		 String expectedUrl = "https://www.facebook.com/legal/terms/update";
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
	
	
     
	

	         
	         @Test (priority = 2)
	     	public void clickOnCookiesPolicyLink () {
	     		
	     //		 Signup signup = new Signup (driver);
	     		 signup.clickOnPrivacypolicyLink();
	     		 
	     		 ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
	          	driver.switchTo().window(addr.get(1));
	          	
	     		 
	     		 String expectedUrl = "https://www.facebook.com/legal/terms/update";
	     		 String actualUrl = driver.getCurrentUrl();
	     		 
	    		Assert.assertEquals(actualUrl, expectedUrl, "privacypolicy not working");
	     		 
//	     		 if (expectedUrl.equals(actualUrl))
//	     		 {
//	     			 System.out.println("test pass");
//	     		 }
//	     		 else
//	     		 {
//	     			 System.out.println("test fail");
//	     		 }
	     	}	 
	         

	     	@Test (priority = 3)
	     	public void signupComplete () throws EncryptedDocumentException, IOException {
	     	
	     		
	    // 		    Signup signup = new Signup (driver);
//	     		    signup.sendkeysOnFirstName("Soham");
//	     		    signup.sendkeysOnLastname("Kadam");
//	     		    signup.sendkeysOnEmailorMob("9876987510");
//	     		    signup.sendkeysOnnewPassword("Pass4567");
	     		
	     		 signup.sendkeysOnFirstName(Utility.fetchDataFromExcel("TestData", 6, 0));
	 		     signup.sendkeysOnLastname(Utility.fetchDataFromExcel("TestData", 7, 0));
	 		     signup.sendkeysOnEmailorMob(Utility.fetchDataFromExcel("TestData", 6, 1));
	 		     signup.sendkeysOnnewPassword(Utility.fetchDataFromExcel("TestData", 7, 1));
	     		    signup.sendkeysOnDayOfBirth();
	     		    signup.sendkeysOnMonthofBirth();
	     		    signup.sendkeysOnYearOfBirth();
	     		    signup.clickOnmaleRadioButton();
	     		    
	     		    signup.clickOncustomRadioButton();
	     		    signup.clickOnsubmitButton();
	     		    
	     		    String actualUrl = driver.getCurrentUrl();
	     			   String actualtitle = driver.getTitle();	
	     			    
	     			   System.out.println(actualUrl);
	     			   System.out.println(actualtitle);
	     			    
	     			  
	     			   String expectedUrl = "https://www.facebook.com/";
	     			   String expectedTitle = "Facebook – log in or sign up";
	     			   
	     			  Assert.assertEquals(actualtitle, expectedTitle, "facebook title");
	     			  Assert.assertEquals(actualUrl, expectedUrl, "facebook url");
	     			  
//	     			   if (actualUrl.equals(expectedUrl) && actualtitle.equals(expectedTitle))
//	     			   {
//	     				   System.out.println("test case pass");
//	     			   }
//	     			   else
//	     			   {
//	     				   System.out.println("test case fail");
//	     			   }
	     			    
	     		}
	     		 
	     	       
	         
	         @AfterMethod
	         public void backtoHomepage2 ()
	         {
	            ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
	            driver.switchTo().window(addr.get(0));
	            
	            	
	         }
	     	
	         
	         @AfterClass
	         public void afterClass ()
	         {
	        	 loginorsignup = null ;
	    		 signup = null ;
	    	    
	         }
		 
	         @AfterTest
	         public void afterTest ()
	         {
	        	 driver.quit();
	        	 driver = null ;
	        	 System.gc();
	         }
	         
		 
	
	
		
	
        
        
		 
	

}
