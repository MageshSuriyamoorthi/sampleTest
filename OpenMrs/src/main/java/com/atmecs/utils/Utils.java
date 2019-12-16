package com.atmecs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.reports.Log4j;

public class Utils {
	Log4j log = new Log4j();

	String[] getOriginalLocator;

	public By locator(String locator) {
		By by = null;
		getOriginalLocator = locator.split(":");
		
		switch (getOriginalLocator[0]) {
		case "NAME":
			by = By.name(getOriginalLocator[1]);
			break;
		case "CLASSNAME":
			by = By.className(getOriginalLocator[1]);
			break;
		case "ID":
			by = By.id(getOriginalLocator[1]);
			break;
		case "TAGNAME":
			by = By.tagName(getOriginalLocator[1]);
			break;
		case "LINKTEXT":
			by = By.linkText(getOriginalLocator[1]);
			break;
		case "PARTIALLINK":
			by = By.partialLinkText(getOriginalLocator[1]);
			break;
		case "CSS":
			by = By.cssSelector(getOriginalLocator[1]);
			break;
		case "XPATH":
			by = By.xpath(getOriginalLocator[1]);
			break;
		default:
			log.info("Enter correct locator");
		}
		return by;
	}

	public void getUrl(WebDriver driver, String locator) {
		driver.get(locator);
	}
	
	public void maximize(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

	public void clickButton(WebDriver driver, String locator) {

		driver.findElement(locator(locator)).click();
	}

	public void enterText(WebDriver driver, String locator, String text) {

		driver.findElement(locator(locator)).sendKeys(text);
	}

	public String getText(WebDriver driver, String locator) {

		return driver.findElement(locator(locator)).getText();

	}

}
