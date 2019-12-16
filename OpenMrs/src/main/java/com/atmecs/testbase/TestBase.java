package com.atmecs.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.classpaths.Classpaths;
import com.atmecs.helper.ReadPropertiesFile;
import com.atmecs.reports.Log4j;

public class TestBase {
	Log4j log = new Log4j();
	ReadPropertiesFile propertyReader = new ReadPropertiesFile();

	public WebDriver driver;
	String driverName;

	@BeforeClass
	public void getDriver() {

		driverName = propertyReader.getLocatorValue("config.browser");

		switch (driverName) {

		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Classpaths.CHROMEFILE);
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", Classpaths.FIREFOXFILE);
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", Classpaths.IEFILE);
			driver = new ChromeDriver();
			break;
		default:
			log.info("Driver name need to given correctly ");
		}
		if (driver != null) {
			log.info(driverName + " DriverInitiated");
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.close();
	}
}
