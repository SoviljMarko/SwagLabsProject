package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import resources.ConfigLoader;

public class BaseTest {
	
	public static WebDriver driver;
	
	public WebDriver Initialization() {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return driver;
	}
	
	public SoftAssert softAssertions() {
		SoftAssert soft = new SoftAssert();
		return soft;
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void begin() {
		driver = Initialization();
	}

	@AfterMethod(alwaysRun = true)
	public void finish() {
		driver.close();
	}
	
//	@BeforeClass
//    public static ConfigLoader setUp() {
//        return new ConfigLoader();
//    }
	
}
