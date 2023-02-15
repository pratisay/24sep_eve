package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginorsignup {
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPasswordLink ;
	
	//@FindBy (xpath = "//a[text()='Create new account']")
	//private WebElement createNewAcc;
	
	@FindBy (xpath = "//a[text()='Create a Page']")
	private WebElement createPage;
	
	
	public Loginorsignup (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendUserName (String user)
	{
		username.sendKeys(user);
	}
	
	
	public void sendpassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickonlogin ()
	{
		loginButton.click();
	}
	
	public void clickonforgotpass ()
	{
		forgotPasswordLink.click();
	}
	
	public void clickoncreatenewacc ()
	{
		createNewAcc.click();
	}
	
	public void clickoncreatepage ()
	{
		createPage.click();
	}
	
	
	
	
	
}

















