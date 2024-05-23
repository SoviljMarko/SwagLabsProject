package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.CheckoutInformationPage;
import markoSovilj.SwagLabsProject.CheckoutOwerviewPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.ProductsPage;

public class ProductPriceConsistencyTest extends BaseTest {

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
	public void fitstTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productOne);
		productsPage.addProduct(productTwo);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);

		CheckoutOwerviewPage checkoutOwerviewPage = new CheckoutOwerviewPage(driver);
		String finalSum = checkoutOwerviewPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

	}


	@Test
	public void secondTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productOne);
		productsPage.addProduct(productTwo);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);

		CheckoutOwerviewPage coPage = new CheckoutOwerviewPage(driver);
		String finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(productOne);
		productsPage.addProduct(productFive);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);
	}


	@Test
	public void thirdTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productOne);
		productsPage.addProduct(productTwo);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);

		CheckoutOwerviewPage coPage = new CheckoutOwerviewPage(driver);
		String finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(productOne);
		productsPage.addProduct(productFive);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);
		
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(productFive);
		cartPage.removeProd(productTwo);
		productsPage.addProduct(productThree);
		productsPage.addProduct(productFour);
		productsPage.addProduct(productSix);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(firstName, lastName, postalCode);
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

	}


}
