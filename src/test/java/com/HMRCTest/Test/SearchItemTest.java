package com.HMRCTest.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.HMRCTest.Pages.HomePage;
import com.HMRCTest.Pages.SearchPage;
import com.HMRCTest.qa.base.TestBase;


public class SearchItemTest extends TestBase{
	
	HomePage homePage;
	SearchPage searchpage;

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test
	public void verifyServicePageContainsServiceHeader() {
		homePage = new HomePage(driver);
		searchpage = new SearchPage(driver);
		homePage.clickOnSearch();
		assertTrue(searchpage.isTextPresent("Shoes"));
		searchpage.SortByRelavance("High-low");
		Assert.assertTrue(searchpage.ListofPrice());
	
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
	

}
