package com.HMRCTest.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings({ "unused", "unused", "unused" })
public class TestBase {

	public static WebDriver driver;
	WebDriverWait wait;
	String Url = "https://www.etsy.com";
	String browser = "chrome";

	public void init() {

		selectBrowser(browser);
		getUrl(Url);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

			driver = new FirefoxDriver();

		}
	}

	public void getUrl(String Url) {

		driver.get(Url);

		driver.manage().window().maximize();

	}

	public WebElement waitForClickability(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void sendKeys(WebElement element, String str) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(str);
	}

	public void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	public boolean isTextPresent(String text) {
		try {
			boolean b = driver.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
		return false;
	}
	}
	public void teardown() {
		driver.quit();
	}

}
