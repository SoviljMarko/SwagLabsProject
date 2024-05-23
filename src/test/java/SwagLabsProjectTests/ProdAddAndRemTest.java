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
		productsPage.addProduct(productOne);
		productsPage.addProduct(productFive);
		productsPage.addProduct(productThree);

		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(productFive);

		productsPage.addProduct(productFive);
		productsPage.addProduct(productTwo);

		cartPage.removeProd(productOne);
		cartPage.removeProd(productFive);
		cartPage.removeProd(productThree);
	}

	@Test
	public void caseTwo() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productSix);
		productsPage.addProduct(productTwo);
		productsPage.addProduct(productThree);

		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(productTwo);

		productsPage.addProduct(productFive);
		productsPage.addProduct(productOne);

		cartPage.removeProd(productOne);

	}

	@Test
	public void caseThree() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productOne);


		CartPage cartPage = new CartPage(driver);
		cartPage.removeProd(productOne);

		productsPage.addProduct(productSix);
		productsPage.addProduct(productFour);
		productsPage.addProduct(productFive);


		cartPage.removeProd(productFive);
		cartPage.removeProd(productSix);
	}



}
