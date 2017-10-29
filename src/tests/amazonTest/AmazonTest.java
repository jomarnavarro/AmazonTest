package tests.amazonTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

/**
 * Tests Amazon related functionality.  It uses JUnitParams features to allow for file parameters.
 * @author omar.navarro
 *
 */

@RunWith(JUnitParamsRunner.class)
public class AmazonTest extends BaseTest{
	
	@Test
	@FileParameters("./data/params.csv")
	public void testAmazonSearch(String browser, String url, String article,
			String filter1, String bottom_price, String top_price) {
		
		setUp(browser, url);
		//uses chaining to indicate page transitions.
		//here a transition from the home page to the results page is indicated 
		
		resultsPage = homePage.search(article);
		filterPage = resultsPage.validateSearchResults(article);
		filterPage.setMaterialFilter(filter1);
		resultsPage = filterPage.setPriceFilter(bottom_price, top_price);
		resultsPage.outputTop5Results();
		resultsPage.validateSearchResultsPriceBetween(bottom_price, top_price);
		resultsPage.sortTop5ByPrice();
		resultsPage.sortTop5ByRating();
		resultsPage.validateTop5SortedByPrice();
		resultsPage.getItemRecommendation();
		
	}

}
