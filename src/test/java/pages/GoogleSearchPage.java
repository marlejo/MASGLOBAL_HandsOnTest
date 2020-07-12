package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class GoogleSearchPage extends Base{
	
	By searchField = By.cssSelector("[title^='Search']");
	By searchOnGoogleBtn = By.name("btnK");
	By firstSuggestion = By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[2]/div[2]/ul/li[1]");
		
	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	public void searhText(String text) {
		waitToBeVisible(searchField);
		type(text, searchField);
		waitToBeClickable(firstSuggestion);
		clic(firstSuggestion);
	}

}
