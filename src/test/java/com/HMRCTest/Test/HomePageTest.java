package com.HMRCTest.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.HMRCTest.Pages.HomePage;
import com.HMRCTest.qa.base.TestBase;



public class HomePageTest extends TestBase {
	HomePage homePage;

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test
	public void verifyHomePageContainsLatestNewsHeader() {
		homePage = new HomePage(driver);

		assertTrue(homePage.isTextPresent("--------"));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
