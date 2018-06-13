package com.HMRCTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMRCTest.qa.base.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='search-query']")
	WebElement SearchText;

	@FindBy(xpath = ".//*[@id='gnav-search']/div/div[2]/button")
	WebElement SearchButton;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage clickOnSearch() {
		SearchText.sendKeys("Sports shoes Men");
		SearchButton.click();
		return new SearchPage(driver);
	}

	public boolean isTextPresent(String text) {
		try {
			boolean b = driver.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
		return false;
	}

}
}
