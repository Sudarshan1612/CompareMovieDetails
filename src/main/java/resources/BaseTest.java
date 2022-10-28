package resources;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		// prop.getProperty("browser");

		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void launchBrowser() throws IOException {

		driver = initializeDriver();

	}

	@AfterMethod(alwaysRun = true)

	public void closeBrowser() {
		driver.close();
	}
}
