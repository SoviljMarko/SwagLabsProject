package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.CheckoutInformationPage;
import markoSovilj.SwagLabsProject.CheckoutOwerviewPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.OrderCompletePage;
import markoSovilj.SwagLabsProject.ProductDetailsPage;
import markoSovilj.SwagLabsProject.ProductsPage;
import resources.ConfigLoader;
import resources.TestConstants;



public class StandAloneTest extends BaseTest {


	@Test
	public void firsTest() throws InterruptedException {


		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		String productName = productsPage.selectProduct(TestConstants.PRODUCT_ONE);

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addToCart();

		CartPage cartPage = new CartPage(driver);
		String cartProductName = cartPage.checkNameAndCheckout();

		Assert.assertEquals(productName, cartProductName);

		CheckoutInformationPage checkoutInfo = new CheckoutInformationPage(driver);
		checkoutInfo.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);

		CheckoutOwerviewPage checkOwerview = new CheckoutOwerviewPage(driver);
		String checkoutProductName =  checkOwerview.NameCheck();

		Assert.assertEquals(productName, checkoutProductName);
		Assert.assertTrue(checkOwerview.PriceCheck());

		OrderCompletePage orderComplete = new OrderCompletePage(driver);

		Assert.assertEquals(orderComplete.CheckoutComplete(), "Thank you for your order!");

	}

	@Test
	public void secondTest() throws InterruptedException {



		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);

	 	CartPage cartPage = new CartPage(driver);

		Assert.assertTrue(cartPage.checkAllNamesAndCheckout(TestConstants.PRODUCT_ONE, TestConstants.PRODUCT_TWO));

		CheckoutInformationPage checkoutInfo = new CheckoutInformationPage(driver);
		checkoutInfo.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);

		CheckoutOwerviewPage checkOwerview = new CheckoutOwerviewPage(driver);
		Assert.assertTrue(checkOwerview.PriceCheck());

		OrderCompletePage orderComplete = new OrderCompletePage(driver);
		Assert.assertEquals(orderComplete.CheckoutComplete(), "Thank you for your order!");

	}


}
