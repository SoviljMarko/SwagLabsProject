package markoSovilj.SwagLabsProject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".shopping_cart_link")
	WebElement shopingCart;
	
	@FindBy (css = ".inventory_item_name")
	WebElement productName;
	
	@FindBy (id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy (css = ".inventory_item_name")
	List<WebElement> cartProductsNames;
	
	@FindBy (id = "remove")
	WebElement removeBtn;
	
	@FindBy (id = "back-to-products")
	WebElement backToProdBtn;
	
	@FindBy (css = ".inventory_item_price")
	List<WebElement> itemsPrices;
	
	public String checkNameAndCheckout() {
		shopingCart.click();
		String cartProductName = productName.getText();
		checkoutBtn.click();
		return cartProductName;
	}
	
	public boolean checkAllNamesAndCheckout(String productOne, String productTwo) {
		shopingCart.click(); 
			if(cartProductsNames.get(0).getText().contains(productOne) || cartProductsNames.get(1).getText().contains(productTwo)) {
//				System.out.println(cartProductsNames.get(0).getText());
//				System.out.println(cartProductsNames.get(1).getText());
				checkoutBtn.click();
				return true;
			}
		return false;
	}
	
	public void removeProd (String prodToRemove) {
		shopingCart.click();
		
		for (int i = 0; i < cartProductsNames.size(); i++) {
			
			if( cartProductsNames.get(i).getText().contains(prodToRemove)) {
				cartProductsNames.get(i).click();
			}
		}
		
		removeBtn.click();
		backToProdBtn.click();
	}
	
	
	public String getAllCartPrices() {
		shopingCart.click();
		
		ArrayList<Double> allprices = new ArrayList<Double>();
		for(int i = 0; i < itemsPrices.size(); i++) {
			 String privremen = itemsPrices.get(i).getText();
			 allprices.add( Double.parseDouble(privremen.split(" ")[0].replace("$", "")));		 
		 }
		double summ = 0;
		 
		for (int i =0; i < allprices.size(); i++) {
			 summ += allprices.get(i);
		}
		checkoutBtn.click();
		
		return decfor.format(summ);
	}
	
	
//	List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
//	
//	ArrayList<Double> allprices = new ArrayList<Double>();
//	
//	 for(int i = 0; i < itemPrices.size(); i++) {
//		 String privremen = itemPrices.get(i).getText();
//		 allprices.add( Double.parseDouble(privremen.split(" ")[0].replace("$", "")));
////		 
//	 }
//	 
//	 double summ = 0;
//	 
//	 for (int i =0; i < allprices.size(); i++) {
//		 summ += allprices.get(i);
//	 }
//	 
//	 System.out.println(allprices);
//	 System.out.println(decfor.format(summ));     // uspeo sam da izvucem sve cene ovde i da ih saberem, sto ce mi sluziti da proverim kasnije
	 
	
	
}
