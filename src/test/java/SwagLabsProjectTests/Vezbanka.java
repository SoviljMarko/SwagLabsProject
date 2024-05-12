package SwagLabsProjectTests;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.CheckoutInformationPage;
import markoSovilj.SwagLabsProject.CheckoutOwerviewPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.ProductsPage;

public class Vezbanka extends TestComponents {
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");
	
	static WebDriver driver;
	
	static String productOne = "Backpack";
	static String productTwo = "Bike Light";
	static String productThree = "Bolt T-Shirt";
	static String productFour = "Fleece Jacket";
	static String productFive = "Onesie";
	static String productSix = "T-Shirt (Red)";
	
	static String firstName = "John";
	static String lastName = "Wick";
	static String postalCode = "123456";
	
	public static void main(String[] args) {
		
		TestComponents tc= new TestComponents();
		driver = tc.Initialization();
		
		LoginPage lp = new LoginPage(driver);
		lp.LogIn();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.addProduct(productOne);
		pp.addProduct(productTwo);
		
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		
		CartPage cp = new CartPage(driver);
		
		List <WebElement> productInCart = driver.findElements(By.cssSelector(".inventory_item_name"));
		for (int i = 0; i < productInCart.size(); i++) {
			
			if( productInCart.get(i).getText().contains(productTwo)) {
				productInCart.get(i).click();
			}
		}
		
		driver.findElement(By.id("remove")).click();
		driver.findElement(By.id("back-to-products")).click();
		
		pp.addProduct(productThree);
		pp.addProduct(productFive);
		pp.addProduct(productSix);
		
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		
		String sum = cp.getAllCartPrices();
		System.out.println(sum);
		
		CheckoutInformationPage cip = new CheckoutInformationPage(driver);
		cip.EnterInformations(firstName, lastName, postalCode);
		
		CheckoutOwerviewPage copage = new CheckoutOwerviewPage(driver);
		String finalSum = copage.checkoutItemPrice();
		
		System.out.println(finalSum);
		
		Assert.assertEquals(sum, finalSum);
	}

}
