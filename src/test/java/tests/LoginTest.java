package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	 Logger log;
	WebDriver driver;

	@Test(dataProvider="getLoginData")
	public void login(String email,String pass,String expectedStatus) throws IOException
	{
	
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("clicked on My account dropdown");
		landingPage.loginOption().click();
		log.debug("clicked on login option");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(email);
		log.debug("email address got entered");
		loginpage.passwordField().sendKeys(pass);
		log.debug("password got entered");
		loginpage.LoginButton().click();
		log.debug("clicked on login button");
		
		AccountPage accountpage = new AccountPage(driver);
		
		
		
		try{
		accountpage.editAccountInformationOption().isDisplayed();
		log.debug("user got logged in");
		System.out.println(expectedStatus);
		
		}catch(Exception e)
		{
			log.debug("user didn't login");
			System.out.println(expectedStatus);
		}
		log.info("login has passed");
	}
	@BeforeMethod
	public void openApplication() throws IOException
	{
		 log =	LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
	}
	
    @AfterMethod
	public void closure()
	{
		driver.close();
		log.debug("browser has closed");
	}
    @DataProvider
    public Object[][] getLoginData()
    {
    	Object[][] data = {{"mohd@gmail.com","shajeb7860","failure"},{"shajebfaruqui@gmail.com","Shajeb7860","successful"}};
    	
    	return data;
    }
}




