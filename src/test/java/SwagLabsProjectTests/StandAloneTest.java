package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.CheckoutInformationPage;
import markoSovilj.SwagLabsProject.CheckoutOwerviewPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.OrderCompletePage;
import markoSovilj.SwagLabsProject.ProductDetailsPage;
import markoSovilj.SwagLabsProject.ProductsPage;



public class StandAloneTest extends TestComponents {

	WebDriver driver;

	String productOne = "Backpack";
	String productTwo = "Bike Light";
	String productThree = "Bolt T-Shirt";
	String productFour = "Fleece Jacket";
	String productFive = "Onesie";
	String productSix = "T-Shirt (Red)";

	String firstName = "John";
	String lastName = "Wick";
	String postalCode = "123456";


	@Test
	public void firsTest() throws InterruptedException {


		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		String productName = productsPage.selectProduct(productOne);

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addToCart();

		CartPage cartPage = new CartPage(driver);
		String cartProductName = cartPage.checkNameAndCheckout();

		Assert.assertEquals(productName, cartProductName);

		CheckoutInformationPage checkoutInfo = new CheckoutInformationPage(driver);
		checkoutInfo.EnterInformations(firstName, lastName, postalCode);

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
		productsPage.addProduct(productOne);
		productsPage.addProduct(productTwo);

	 	CartPage cartPage = new CartPage(driver);

		Assert.assertTrue(cartPage.checkAllNamesAndCheckout(productOne, productTwo));

		CheckoutInformationPage checkoutInfo = new CheckoutInformationPage(driver);
		checkoutInfo.EnterInformations(firstName, lastName, postalCode);

		CheckoutOwerviewPage checkOwerview = new CheckoutOwerviewPage(driver);
		Assert.assertTrue(checkOwerview.PriceCheck());

		OrderCompletePage orderComplete = new OrderCompletePage(driver);
		Assert.assertEquals(orderComplete.CheckoutComplete(), "Thank you for your order!");

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
