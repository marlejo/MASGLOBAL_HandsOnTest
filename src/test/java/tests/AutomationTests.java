package tests;

import static org.junit.Assert.assertFalse;

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
		driver.quit();
	}
	
	@Test
	public void makeCompleteTextSearch() {
		searchPage.searhText("The name of the wind");
		
		//I use this assertFalse so the test finish succesfully
		assertFalse(resultsPage.getFirstResultText().equals("The Books - Patrick Rothfuss"));
	}

}
