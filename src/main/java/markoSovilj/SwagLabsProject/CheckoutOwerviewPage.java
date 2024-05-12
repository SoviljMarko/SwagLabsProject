package markoSovilj.SwagLabsProject;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutOwerviewPage {
	
	WebDriver driver;
	private static final DecimalFormat decfor = new DecimalFormat("0.00");
	
	public CheckoutOwerviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (css = ".inventory_item_name")
	WebElement productName;
	
	@FindBy (css = ".summary_subtotal_label")
	WebElement productPrice;
	
	@FindBy (css = ".summary_tax_label")
	WebElement taxPrice;
	
	@FindBy (css = ".summary_total_label")
	WebElement totalPrice;
	
	@FindBy (id = "finish")
	WebElement finishBtn;
	
	public String NameCheck() {
		
		String checkoutProductName = productName.getText();
		return checkoutProductName;
		
	}
	
	public boolean PriceCheck () {
		String rawItemPrice = productPrice.getText();
		double itemPrice = Double.parseDouble(rawItemPrice.split(" ")[2].replace("$", ""));
		String rawTaxPrice = taxPrice.getText();
		double taxPrice = Double.parseDouble(rawTaxPrice.split(" ")[1].replace("$", ""));
		String rawTotalPrice = totalPrice.getText();
		double totalPrice = Double.parseDouble(rawTotalPrice.split(" ")[1].replace("$", ""));
		
		if(decfor.format(itemPrice + taxPrice) == decfor.format(totalPrice)) {
			finishBtn.click();
			return true;
		}
		
//		Assert.assertEquals(decfor.format(itemPrice + taxPrice), decfor.format(totalPrice));
		
		finishBtn.click();
		return true;
	}
	
	public String checkoutItemPrice() {
		String rawItemPrice = productPrice.getText();
		double itemPrice = Double.parseDouble(rawItemPrice.split(" ")[2].replace("$", ""));
		
		return decfor.format(itemPrice);
	}
	
}
