 package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotpassword {

	@FindBy (xpath = "//table//tr[1]//td[2]//div")
	private WebElement forgotmessage;
	
	@FindBy (xpath = "(//input[@name='email']) [2]")
	private WebElement emailorphonenumber;
	
	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement Searchbutton ;
	
	
	public Forgotpassword (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTextMesage ()
	{
		String text = forgotmessage.getText();
		System.out.println(text);
		return text;
	}
	
	public void enterEmailOrPhoneNumber (String email)
	{
		emailorphonenumber.sendKeys(email);
	}
	
	
	public void clickOnCancel ()
	{
		cancelButton.click();
	}
	
	public void clickOnSearch ()
	{
		Searchbutton.click();
	}
}
