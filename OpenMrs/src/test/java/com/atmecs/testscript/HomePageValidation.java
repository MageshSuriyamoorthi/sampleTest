package com.atmecs.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.classpaths.Classpaths;
import com.atmecs.helper.ReadExcelFile;
import com.atmecs.helper.ReadPropertiesFile;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.Utils;

public class HomePageValidation extends TestBase {
	Utils util = new Utils();
	
	ReadPropertiesFile property = new ReadPropertiesFile();
	
	ReadExcelFile excelRead=new ReadExcelFile(Classpaths.HOMEPAGETESTDATA);
	
	String actual, expected =excelRead.getData("Sheet1", "TestData", "TC001") ;

	@BeforeMethod
	public void login() {
		
		util.maximize(driver);

		util.getUrl(driver, property.getLocatorValue("config.url"));

		util.enterText(driver, property.getLocatorValue("loc.username.text"), "admin");

		util.enterText(driver, property.getLocatorValue("loc.password.password"), "Admin123");

		util.clickButton(driver, property.getLocatorValue("loc.registration.select"));

		util.clickButton(driver, property.getLocatorValue("loc.login.button"));

	}

	@Test
	public void enteringDetails() {

		actual = util.getText(driver, property.getLocatorValue("loc.gettext.message"));

		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void logout() {

		util.clickButton(driver, property.getLocatorValue("loc.logout.button"));
		
		
	}

}
