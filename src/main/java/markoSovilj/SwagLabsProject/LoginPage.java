package markoSovilj.SwagLabsProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id = "user-name")
	WebElement username;

	@FindBy (id = "password")
	WebElement password;

	@FindBy (id = "login-button")
	WebElement loginBtn;

	@FindBy (tagName = "h3")
	WebElement errorMessage;


	By pageTitle = By.cssSelector(".title");

	public void LogIn() {
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginBtn.click();
	}

	public void LogIn(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}

	public String loginErrorMessageCheck() {
		return errorMessage.getText();
	}

	public WebElement waitForProductTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
	}

}
