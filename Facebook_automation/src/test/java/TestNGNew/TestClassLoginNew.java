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

import Base.Browser;
import pomModules.Loginorsignup;
import utils.Utility;

public class TestClassLoginNew extends Browser {
public WebDriver driver ;
private Loginorsignup loginorsignup ;
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
    	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOmobjects ()
	{
		loginorsignup = new Loginorsignup (driver);
	}
	
	@BeforeMethod
	public void enterNameAndPassClickOnLogin () throws EncryptedDocumentException, IOException {
		
		driver.get("https://www.facebook.com/");
		//Loginorsignup loginorsignup = new Loginorsignup (driver);
		
     	loginorsignup.sendUserName("8805238195");
		loginorsignup.sendUserName(Utility.fetchDataFromExcel("TestData", 1, 0));
		
		loginorsignup.sendpassword("130120");
     	loginorsignup.sendpassword(Utility.fetchDataFromExcel("TestData", 2, 0));
		
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
		
		    Assert.assertEquals(actualurl, expectedurl, "fb login title");
		    Assert.assertEquals(actualtitle, expectedtitle, "fb login title");
		    
//		    if (actualtitle.equals(expectedtitle) && actualurl.equals(expectedurl))
//		    {
//		    	System.out.println("test case pass");
//		    }
//		    else
//		    {
//		    	System.out.println("test case fail");
//		    }
	}
	
	@AfterMethod
	public void afterMethod () {
		System.out.println("After Method");
		System.out.println("logout");
	}
	
	@AfterClass
	public void test123 () {
		loginorsignup = null ;
		
	}
	
	@AfterTest
	public void afterTest ()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
}

