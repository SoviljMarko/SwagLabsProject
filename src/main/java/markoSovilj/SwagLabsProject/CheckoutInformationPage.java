package markoSovilj.SwagLabsProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
	
	WebDriver driver;
	
	public CheckoutInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "input[placeholder='First Name']")
	WebElement firstName;
	
	@FindBy (css = "input[placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy (id = "postal-code")
	WebElement postalCode;
	
	@FindBy (id = "continue")
	WebElement continueBtn;
	
	
	public void EnterInformations(String fname, String lname, String enterPostalCode) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(enterPostalCode);
		continueBtn.click();
	}
	
	
//	driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("John");
//	driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Wick");
//	driver.findElement(By.id("postal-code")).sendKeys("123456");
//	driver.findElement(By.id("continue")).click();
	
}
