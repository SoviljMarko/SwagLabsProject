package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.LoginPage;

public class LoginTest extends TestComponents {
	
	WebDriver driver;
	
    String invalidUser = "unknown_user";
	String invalidPass = "abcd1234";
	String validUser = "standard_user";
	String validPass = "secret_sauce";
	String blockedUser = "locked_out_user";
	String emptyUser = "";
	
	String errorMessage = "Epic sadface: Username and password do not match any user in this service";
	String lockedUserMessage = "Epic sadface: Sorry, this user has been locked out.";
	String emptyUserMessage = "Epic sadface: Username is required";
	
	WebElement titleElement;
	
	@Test(dataProvider="getData")
	public void pullingDataForLogin(String username, String password) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(username, password);
		
		Assert.assertTrue(lp.waitForProductTitle() != null);
		
	}
	
	
	@Test
	public void incorrectUsername() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(invalidUser, validPass);
		Assert.assertEquals(lp.loginErrorMessageCheck(), errorMessage);
	}
	
	@Test
	public void incorrectPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(validUser, invalidPass);
		Assert.assertEquals(lp.loginErrorMessageCheck(), errorMessage);
	}

	@Test
	public void incorrectUserAndPass() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(invalidUser, invalidPass);
		Assert.assertEquals(lp.loginErrorMessageCheck(), errorMessage);
	}
	
	@Test
	public void lockedUser() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(blockedUser, validPass);
		Assert.assertEquals(lp.loginErrorMessageCheck(), lockedUserMessage);
	}
	
	@Test
	public void emptyUserField() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(emptyUser, validPass);
		Assert.assertEquals(lp.loginErrorMessageCheck(), emptyUserMessage);
	}
	
	
	
	
	@DataProvider
	public Object getData() {
		
		Object[][] data = new Object[5][2];
		
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		
		data[1][0] = "problem_user";
		data[1][1] = "secret_sauce";
		
		data[2][0] = "performance_glitch_user";
		data[2][1] = "secret_sauce";
		
		data[3][0] = "error_user";
		data[3][1] = "secret_sauce";
		
		data[4][0] = "visual_user";
		data[4][1] = "secret_sauce";
		
		
		return data;
		
	}
	
	
	@BeforeMethod
	public void begin() {
		driver = Initialization();
	}
	
	@AfterMethod
	public void finish() {
		driver.close();
	}
	
}
