package pomModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
    
	private WebDriver driverG;
	private Actions act ;
	private WebDriverWait wait ;
	
	@FindBy (xpath = "(//input[@type='text']) [2]") 
	private WebElement firstName ;
	
	@FindBy (xpath = "//input[@name='lastname']")
	private WebElement lastName ;
	
	@FindBy (xpath = "//input[@name='reg_email__']") 
	private WebElement emailIdOrMob ;
	
	@FindBy (xpath = "//input[@id='password_step_input']")
	private WebElement newPassword ;
	
	@FindBy (xpath = "//select[@aria-label='Day']") 
	private WebElement dayOfBirth ;
	
	@FindBy (xpath = "//select[@aria-label='Month']")
	private WebElement monthOfBirth ;
	
	@FindBy (xpath = "//select[@aria-label='Year']") 
	private WebElement yearOfBirth ;
	
	@FindBy (xpath = "(//input[@type='radio']) [1]")
	private WebElement femaleRadioButton ;
	
	@FindBy (xpath = "(//input[@type='radio']) [2]")
	private WebElement maleRadioButton ;
	
	@FindBy (xpath = "(//input[@type='radio']) [3]")
	private WebElement customRadioButton ;
	
	@FindBy (xpath = "(//a[text()='Terms']) [2]")
	private WebElement termsLink ;
	
	@FindBy (xpath = "(//a[text()='Privacy Policy']) [2]")
	private WebElement privacyPolicy ;
	
	@FindBy (xpath = "//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy ;
	
	
	
	@FindBy (xpath = "(//button[text()='Sign Up']) [1]")
	private WebElement signupSubmitButton ;
	
	
	public Signup (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    this.driverG = driver ;
		act = new Actions (driver);
		wait = new WebDriverWait (driverG, 5);
	}
	
	
	public void sendkeysOnFirstName (String user)
	{   wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(user);
	}
	
	public void sendkeysOnLastname (String lname)
	{                                                                       // explicit wait used
		WebDriverWait wait = new WebDriverWait (driverG, 5);
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lname);                                      
	}
	
	public void sendkeysOnEmailorMob (String mob)
	{   WebDriverWait wait = new WebDriverWait (driverG, 10);
	    wait.until(ExpectedConditions.visibilityOf(emailIdOrMob));
		emailIdOrMob.sendKeys(mob);
	
	}
	
	public void sendkeysOnnewPassword (String pass)
	{
		newPassword.sendKeys(pass);
	
	}
	
	public void sendkeysOnDayOfBirth()
	{
	  //	dayOfBirth.sendKeys(pass);
		Select s = new Select (dayOfBirth);
		s.selectByVisibleText("18");
	}
	
	public void sendkeysOnMonthofBirth ()
	{      //monthOfBirth.sendkeys("Dec");
		Select s = new Select (monthOfBirth);
		s.selectByVisibleText("Dec");
    }
	
	public void sendkeysOnYearOfBirth ()
	{       //yearOfBirth.sendkeys ("1996");
		Select s = new Select (yearOfBirth);
		s.selectByVisibleText("1996");
	}
	
	public void clickOnFemaleRadioButton ()
	{      femaleRadioButton.click();
	    JavascriptExecutor js = (JavascriptExecutor) driverG;
	    js.executeScript("arguments[0].scrollIntoView(true);", femaleRadioButton);
		
	}
	
	public void clickOnmaleRadioButton ()
	{      maleRadioButton.click();
		
	}
	
	public void clickOncustomRadioButton ()
	{      //customRadioButton.click();
		//Actions act = new Actions (driverG);
		act.moveToElement(customRadioButton).click().build().perform();
	}
	
	
	public void clickOnTermsLink ()
	{      termsLink.click();
		
	}
	
	public void clickOnPrivacypolicyLink ()
	{      privacyPolicy.click();
		
	}
	
	
	public void clickOnCookiesPolicyLink ()
	{      cookiesPolicy.click();
		
	}
	
	
	
	
	
	public void clickOnsubmitButton ()
	{      //signupSubmitButton.click();
		//Actions act = new Actions (driverG);
		act.moveToElement(signupSubmitButton).click().build().perform();
	}
	
	
	
}
