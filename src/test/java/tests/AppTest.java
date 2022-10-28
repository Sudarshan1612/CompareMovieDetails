package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.IMDBPage;
import PageObjects.WikiPage;
import resources.BaseTest;

public class AppTest extends BaseTest {

	String movieName = "Pushpa: The Rise - Part 1";
	List<String> wikiDetails;
	List<String> imdbDetails;

	public void verifyMovieNameAndDate(String movieName) throws IOException {
		IMDBPage im = new IMDBPage(driver);
		im.goToSiteAndSearchMovieName(movieName);
		imdbDetails = im.verifyDateAndCountry();
		WikiPage wi = new WikiPage(driver);
		wi.goToSiteAndSearchMovieNameinWiki(movieName);
	    wikiDetails = wi.verifyDateAndCountry();

	}
	
	@Test
	public void validateMovieName() throws IOException
	{
		verifyMovieNameAndDate(movieName);
		Assert.assertEquals(wikiDetails, imdbDetails);
}
	
}
