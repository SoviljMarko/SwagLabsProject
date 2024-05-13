package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TestComponents {

	public WebDriver Initialization() {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return driver;
	}

	public SoftAssert softAssertions() {
		SoftAssert soft = new SoftAssert();
		return soft;
	}


}
