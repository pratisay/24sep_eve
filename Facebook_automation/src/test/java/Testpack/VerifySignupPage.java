package Testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomModules.Loginorsignup;
import pomModules.Signup;

public class VerifySignupPage {
	public static void main(String[] args) {
		// step 1 - open the browser and enter the url
				    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				    WebDriver driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.manage().window().maximize();
				    driver.get("https://www.facebook.com/");
				    
		//step 2 - click on create new account 
				    
				    Loginorsignup loginorsignup = new Loginorsignup (driver);
				    loginorsignup.clickoncreatenewacc ();
				    
		//step 3 -  sendkeys on first and last name
				    
				    Signup signup = new Signup (driver);
				    signup.sendkeysOnFirstName("Soham");
				    
				    signup.sendkeysOnLastname("Kadam");
		
		//step 4 -   Enter the mobile number and password
				    
				    signup.sendkeysOnEmailorMob("9876987510");
				    
				    signup.sendkeysOnnewPassword("Pass4567");
				    
		// step 5 - select the date of birth
				    
				    signup.sendkeysOnDayOfBirth();
				    signup.sendkeysOnMonthofBirth();
				    signup.sendkeysOnYearOfBirth();
				    
	   // step 6 - click on mail radio button 	    
				    
				    signup.clickOnmaleRadioButton();
				    
				  //  signup.clickOncustomRadioButton();
				    
		//step 7 - submit the signup page
				    
				    signup.clickOnsubmitButton();
				    
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
}