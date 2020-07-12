package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.GoogleResultPage;
import pages.GoogleSearchPage;

public class AutomationTests {
	
	private WebDriver driver;
	
	GoogleSearchPage searchPage;
	GoogleResultPage resultsPage;
	
	@Before
	public void setUp() throws Exception {
		searchPage = new GoogleSearchPage(driver);
		driver = searchPage.chromeDriverConnection();
		searchPage.visit("https://www.google.com/?gl=us&hl=en&pws=0&gws_rd=cr");
		resultsPage = new GoogleResultPage(driver);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void makeCompleteTextSearch() {
		searchPage.searhText("The name of the wind");
		assertTrue(resultsPage.getFirstResultText().contains("The Name of the Wind"));
		assertTrue(resultsPage.getFirstResultText().contains("Patrick Rothfuss"));
		resultsPage.clickFirstResult();
		assertFalse(resultsPage.getURL().contains("https://www.patrickrothfuss.com/content/books.asp"));
	}
	
	@Test
	public void makePartialTextSearch() {
		searchPage.searhText("The name of the w");
		assertTrue(resultsPage.getFirstResultText().contains("The Name of the Wind"));
		assertTrue(resultsPage.getFirstResultText().contains("Patrick Rothfuss"));
	}

}
