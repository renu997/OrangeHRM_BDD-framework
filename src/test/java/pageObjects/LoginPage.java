package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//elements
	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pass;
	@FindBy(xpath="//button[@type='submit']")WebElement loginbtn;
	@FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']")WebElement errormsg;
	
     
	//actions
	public void Setusername(String username)
	{
	uname.sendKeys(username);
	 
	}
	public void Setpassword(String password)
	{
	 pass.sendKeys(password);	
	}
	public void Clicklogin()
	{
		loginbtn.click();
		
	}
	
	
}
