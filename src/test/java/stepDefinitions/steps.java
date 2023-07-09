package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class steps {
	 WebDriver driver;
	 LoginPage lp;
	 HomePage hp;
	 
	// List<HashMap<String, String>> datamap;//for datadriven
	 Logger logger;
	 ResourceBundle rb;
	 String br;
	 
	 @Before
	 public void setUp()//Junit hook - executes once before starting
	 {
		 logger=LogManager.getLogger(this.getClass());
		 rb=ResourceBundle.getBundle("config");
		 br=rb.getString("browser");
	 }
	 
	 @After
	 public void tearDown(Scenario scenario)
	 {
		 if(scenario.isFailed())
		 {
			 TakesScreenshot ts =(TakesScreenshot)driver;
			 byte[] sceernshot=ts.getScreenshotAs(OutputType.BYTES);
			 scenario.attach(sceernshot, "image/png", scenario.getName());
		 }
		 driver.quit();
	 }
	 
     //Given-preconditions
	@Given("User Launch browser")
	public void user_launch_browser()
	{
	   /*if(br.equals("chrome")) {
		   driver=new ChromeDriver();
	   }
	   else if(br.equals("edge"))
	   {
		   driver=new EdgeDriver();
	   }
	   else if(br.equals("firefox"))
	   {
		   driver=new FirefoxDriver();
	   }
	   */
		   driver=new ChromeDriver();
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}
	

	@Given("opens URL {string}")
	public void opens_url(String url) //url parameter
	{
	    driver.get(url);
	    driver.manage().window().maximize();
	}
    //when-actions
	@When("User navigate to Login page")
	public void user_navigate_to_login_page()
	{
		System.out.println("Title of the page is: "+ driver.getTitle());
		logger.info("Title of the page..");
	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password)
	{
		lp=new LoginPage(driver);
		
	    lp.Setusername(username);
	    logger.info("provided username..");
	    lp.Setpassword(password);
	    logger.info("provided password..");
	}

	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException
	{
	    lp.Clicklogin();
	    logger.info("Clicked on Login button");
	    Thread.sleep(2000);
	    
	}
     
	//Then-validations
	@Then("User navigate to Home page")
	public void user_navigate_to_home_page() 
	{ 
		hp=new HomePage(driver);
		boolean hpage=hp.isMyHomePageExist();
		
		if(hpage)
		{
			logger.info("Login passed");
			Assert.assertTrue(true);
		}
		else
		{ 
			logger.info("Login failed");
			Assert.assertTrue(false);
		}
		
	}}