package com.HMRCTest.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMRCTest.qa.base.TestBase;

public class SearchPage extends TestBase {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='gnav-search']/div/div[2]/button")
	WebElement SortBy;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void SortByRelavance(String SortType) {

		WebElement SortList = driver.findElement(By.xpath(".//*[@id='gnav-search']/div/div[2]/button"));
		List<WebElement> Sort = SortList.findElements(By.tagName("li"));
		for (WebElement li : Sort) {
			if (li.getText().equals(SortType)) {
				li.click();
			}
		}
	}

	public boolean ListofPrice() {

		// scrape price elements
		List<WebElement> price = driver.findElements(By.xpath("(.//*[@id='content']//span[@class ='currency-value'])"));

		// extract the prices from the price elements and store in a List
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price) {
			prices.add(e.getText());
		}

		// make a copy of the list
		List<String> sortedPrices = new ArrayList<String>(prices);

		// sort the list
		Collections.sort(sortedPrices);
		return false;

		// true if the prices are sorted
		// System.out.println(sortedPrices.equals(prices));

		//assertEquals("Sorting low to high prices aint working.",prices,sortedPrices);
	}

	public void searchPageByUrl(String product) {

		driver.getCurrentUrl().contains(product);

	}
}
