package TestComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestComponents {
	
	

	public WebDriver Initialization() {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		this.driver = driver;
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return driver;
	}
	

	public SoftAssert softAssertions() {
		SoftAssert soft = new SoftAssert();
		return soft;
	}
	
	public static ExtentReports ExtentReporter() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Marko Sovilj");
		
		return extent;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}


}
