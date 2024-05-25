package SwagLabsProjectTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import markoSovilj.SwagLabsProject.LoginPage;
import resources.TestConstants;

public class LoginTest extends BaseTest {


	@Test(dataProvider="getData")
	public void pullingDataForLogin(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(username, password);

		Assert.assertTrue(loginPage.waitForProductTitle() != null);

	}


	@Test
	public void incorrectUsername() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(TestConstants.INVALID_USER, TestConstants.VALID_PASS);
		Assert.assertEquals(loginPage.loginErrorMessageCheck(), TestConstants.ERROR_MESSAGE);
	}

	@Test
	public void incorrectPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(TestConstants.VALID_USER,TestConstants.INVALID_PASS);
		Assert.assertEquals(loginPage.loginErrorMessageCheck(), TestConstants.ERROR_MESSAGE);
	}

	@Test
	public void incorrectUserAndPass() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(TestConstants.INVALID_USER, TestConstants.INVALID_PASS);
		Assert.assertEquals(loginPage.loginErrorMessageCheck(), TestConstants.ERROR_MESSAGE);
	}

	@Test
	public void lockedUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(TestConstants.BLOCKED_USER, TestConstants.VALID_PASS);
		Assert.assertEquals(loginPage.loginErrorMessageCheck(), TestConstants.LOCKED_USER_MESSAGE);
	}

	@Test
	public void emptyUserField() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn(TestConstants.EMPTY_USER, TestConstants.VALID_PASS);
		Assert.assertEquals(loginPage.loginErrorMessageCheck(), TestConstants.EMPTY_USER_MESSAGE);
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


//	@BeforeMethod
//	public void begin() {
//		driver = Initialization();
//	}
//
//	@AfterMethod
//	public void finish() {
//		driver.close();
//	}

}
