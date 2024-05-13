package markoSovilj.SwagLabsProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletePage {

	WebDriver driver;

	public OrderCompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (tagName = "h2")
	WebElement message;

	@FindBy (css = ".btn.btn_primary.btn_small")
	WebElement homeBtn;


	public String CheckoutComplete() {
		String messagePrinted = message.getText();
		homeBtn.click();
		return messagePrinted;
	}


}
