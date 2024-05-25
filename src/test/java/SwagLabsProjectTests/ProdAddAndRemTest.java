package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.ProductsPage;
import resources.TestConstants;

public class ProdAddAndRemTest extends BaseTest {



	String productOne = "Backpack";
	String productTwo = "Bike Light";
	String productThree = "Bolt T-Shirt";
	String productFour = "Fleece Jacket";
	String productFive = "Onesie";
	String productSix = "T-Shirt (Red)";

	@Test
	public void caseOne() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);
		productsPage.addProduct(TestConstants.PRODUCT_FIVE);
		productsPage.addProduct(TestConstants.PRODUCT_THREE);

		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(TestConstants.PRODUCT_FIVE);

		productsPage.addProduct(TestConstants.PRODUCT_FIVE);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);

		cartPage.removeProd(TestConstants.PRODUCT_ONE);
		cartPage.removeProd(TestConstants.PRODUCT_FIVE);
		cartPage.removeProd(TestConstants.PRODUCT_THREE);
	}

	@Test
	public void caseTwo() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_SIX);
		productsPage.addProduct(TestConstants.PRODUCT_TWO);
		productsPage.addProduct(TestConstants.PRODUCT_THREE);

		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(TestConstants.PRODUCT_TWO);

		productsPage.addProduct(TestConstants.PRODUCT_FIVE);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);

		cartPage.removeProd(TestConstants.PRODUCT_ONE);

	}

	@Test
	public void caseThree() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(TestConstants.PRODUCT_ONE);


		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(TestConstants.PRODUCT_ONE);

		productsPage.addProduct(TestConstants.PRODUCT_SIX);
		productsPage.addProduct(TestConstants.PRODUCT_FOUR);
		productsPage.addProduct(TestConstants.PRODUCT_FIVE);


		cartPage.removeProd(TestConstants.PRODUCT_FIVE);
		cartPage.removeProd(TestConstants.PRODUCT_SIX);
	}



}
