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
import markoSovilj.SwagLabsProject.ProductsPage;
import resources.ConfigLoader;
import resources.TestConstants;

public class ProductPriceConsistencyTest extends BaseTest {


	@Test
	public void fitstTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);

		CheckoutOwerviewPage checkoutOwerviewPage = new CheckoutOwerviewPage(driver);
		String finalSum = checkoutOwerviewPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

	}


	@Test
	public void secondTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);

		CheckoutOwerviewPage coPage = new CheckoutOwerviewPage(driver);
		String finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_FIVE);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);
	}


	@Test
	public void thirdTest() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);

	 	CartPage cartPage = new CartPage(driver);

	 	String sum = cartPage.getAllCartPrices();

		CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(driver);
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);

		CheckoutOwerviewPage coPage = new CheckoutOwerviewPage(driver);
		String finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_FIVE);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);
		
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

		// product modification

		productsPage.backToProductPage();

		cartPage.removeProd(TestConstants.PRODUCT_FIVE);
		cartPage.removeProd(TestConstants.PRODUCT_TWO);
		productsPage.addProduct(TestConstants.PRODUCT_THREE);
		productsPage.addProduct(TestConstants.PRODUCT_FOUR);
		productsPage.addProduct(TestConstants.PRODUCT_SIX);

		sum = cartPage.getAllCartPrices();
		checkoutInfoPage.EnterInformations(TestConstants.FIRST_NAME, TestConstants.LAST_NAME, TestConstants.POSTAL_CODE);
		finalSum = coPage.checkoutItemPrice();

		Assert.assertEquals(sum, finalSum);

	}


}
