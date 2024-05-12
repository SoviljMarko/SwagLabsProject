package markoSovilj.SwagLabsProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".inventory_item_name")
	List<WebElement> productList;
	
	@FindBy (css = "title")
	public
	WebElement pageTitle;
	
	
	public String selectProduct(String requestedProduct) {
		WebElement choice = productList.stream().filter(s->s.getText().contains(requestedProduct)).findFirst().orElse(null);
		String productName = choice.getText();
		choice.click(); 
		return productName;
	}
	
	
	public void addProduct(String requestedProduct) {
		
		for (int i = 0; i < productList.size(); i++) {
			if(productList.get(i).getText().contains(requestedProduct)) {
				driver.findElement(By.xpath("(//button)[" + (i + 3) + "]")).click();
			}
			
		}
		
	}
	
	
		
}
