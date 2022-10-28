package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='suggestion-search']")
	WebElement imdbSearch;
	
	@FindBy(xpath = "//li[@data-testid='title-details-releasedate']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")
	WebElement releaseDate;
	
	@FindBy(css = "a[href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']")
	WebElement countryOfOrigin;

	public IMDBPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void goToSiteAndSearchMovieName(String movieName) {
		driver.get("https://www.imdb.com/");
		imdbSearch.sendKeys(movieName);
		Iterable<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='sc-d2740ffb-2 STkQo searchResult__constTitle']"));
		for (WebElement option : dropdownOptions) {
			if (option.getText().equals(movieName)) {
				option.click();
				break;
			}else {
				System.out.println(option.getText()+" movie not found");
				
			}
		}
	}

	public List<String> verifyDateAndCountry() {
		
		List<String> imdbList = new ArrayList<String>();
		String date = releaseDate.getText();
		String country = countryOfOrigin.getText();
		imdbList.add(date);
		imdbList.add(country);
		return imdbList;
		
	
	}

}
