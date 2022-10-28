package PageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WikiPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='search']")
	WebElement wikiSearch;

	@FindBy(xpath = "//div[normalize-space()='Release date']/parent::th[@scope='row']/following-sibling::td[@class='infobox-data']")
	WebElement releaseDate;
	
	@FindBy(xpath = "//th[text()='Country']/following-sibling::td[@class='infobox-data']")
	WebElement countryOfOrigin;
	
	
	public WikiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void goToSiteAndSearchMovieNameinWiki(String movieName) {
		
         driver.get("https://en.wikipedia.org/");
         wikiSearch.sendKeys(movieName);
         Iterable<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='suggestions-result']//span[@class='highlight']")); 
 		for(WebElement option : dropdownOptions) {
 			if(option.getText().equals(movieName)) {
 				option.click();
 				break;
 			}else {
 				System.out.println(option.getText()+ " is not the required value");
 			}
 		}
		
	}
public List<String> verifyDateAndCountry() {
		
		List<String> wikiList = new ArrayList<String>();
		String date = releaseDate.getText();
		String country = countryOfOrigin.getText();
		wikiList.add(date);
		wikiList.add(country);
		return wikiList;
		
	
	}

}
