package markoSovilj.SwagLabsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver driver;
	
	public ProductDetailsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy (id = "back-to-products")
	WebElement backBtn;
	
	public void addToCart() {
		addToCartBtn.click();
		backBtn.click();
	}
	
	
}
