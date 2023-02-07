package datapro;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import generic.Capture;

public class Data_provider {
	
	
	public WebDriver driver;
	@BeforeMethod
	public void openApp() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com");
	}
	@AfterMethod
	public void closeApp(ITestResult res) {
		if(ITestResult.FAILURE==res.getStatus()) {
			Capture.takeScreenshot(driver);
		}
		driver.quit();
		
	}

}
