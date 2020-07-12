package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.GoogleResultPage;
import pages.GoogleSearchPage;

public class CompleteTextTest {
	
	private static WebDriver driver;	
	static GoogleSearchPage searchPage;
	static GoogleResultPage resultsPage;
	
	@BeforeClass
	public static void setUp() throws Exception {
		searchPage = new GoogleSearchPage(driver);
		driver = searchPage.chromeDriverConnection();
		searchPage.visit("https://www.google.com/?gl=us&hl=en&pws=0&gws_rd=cr");
		resultsPage = new GoogleResultPage(driver);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void makeCompleteTextSearch() {
		searchPage.searhText("The name of the wind");
		assertTrue(resultsPage.getFirstResultText().contains("The Name of the Wind"));
	}
	
	@Test
	public void checkFirstResult() {
		resultsPage.clickFirstResult();
		assertFalse(resultsPage.getURL().contains("https://www.patrickrothfuss.com/content/books.asp"));
	}

}
