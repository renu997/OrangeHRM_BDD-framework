package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
  //elements
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")WebElement hpage;
	
	//actions
	public boolean isMyHomePageExist()
	{
	    try {	
		return(hpage.isDisplayed());
	    }
	    catch(Exception e)
	    {
	    	return(false);
	    }
	}
	
}
