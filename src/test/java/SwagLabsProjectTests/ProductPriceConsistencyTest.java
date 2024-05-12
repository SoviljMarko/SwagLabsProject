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
import markoSovilj.SwagLabsProject.ProductsPage;

public class ProductPriceConsistencyTest extends TestComponents {
	
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
	public void fitstTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LogIn();
		
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addProduct(productOne);
		productsPage.addProduct(productTwo);
		
	 	CartPage cP = new CartPage(driver);
	 	
	 	String sum = cP.getAllCartPrices();
		System.out.println(sum);
		
		CheckoutInformationPage cip = new CheckoutInformationPage(driver);
		cip.EnterInformations(firstName, lastName, postalCode);
		
		CheckoutOwerviewPage coPage = new CheckoutOwerviewPage(driver);
		String finalSum = coPage.checkoutItemPrice();
		
		System.out.println(finalSum);
		
		Assert.assertEquals(sum, finalSum);
		
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
