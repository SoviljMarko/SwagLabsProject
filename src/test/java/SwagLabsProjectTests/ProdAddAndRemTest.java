package SwagLabsProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.TestComponents;
import markoSovilj.SwagLabsProject.CartPage;
import markoSovilj.SwagLabsProject.LoginPage;
import markoSovilj.SwagLabsProject.ProductsPage;

public class ProdAddAndRemTest extends TestComponents {
	
	WebDriver driver;
	
	String productOne = "Backpack";
	String productTwo = "Bike Light";
	String productThree = "Bolt T-Shirt";
	String productFour = "Fleece Jacket";
	String productFive = "Onesie";
	String productSix = "T-Shirt (Red)";
	
	@Test
	public void caseOne() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.addProduct(productOne);
		pp.addProduct(productFive);
		pp.addProduct(productThree);
		
		CartPage cp = new CartPage(driver);
		cp.removeProd(productFive);
		
		pp.addProduct(productFive);
		pp.addProduct(productTwo);
		
		cp.removeProd(productOne);
		cp.removeProd(productFive);
		cp.removeProd(productThree);
	}
	
	@Test
	public void caseTwo() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.addProduct(productSix);
		pp.addProduct(productTwo);
		pp.addProduct(productThree);
		
		CartPage cp = new CartPage(driver);
		cp.removeProd(productTwo);
		
		pp.addProduct(productFive);
		pp.addProduct(productOne);
		
		cp.removeProd(productOne);
		
	}
	
	@Test
	public void caseThree() {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.addProduct(productOne);
		
		
		CartPage cp = new CartPage(driver);
		cp.removeProd(productOne);
		
		pp.addProduct(productSix);
		pp.addProduct(productFour);
		pp.addProduct(productFive);
		
		
		cp.removeProd(productFive);
		cp.removeProd(productSix);
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
