package pages.amazonTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import helpers.Article;
import helpers.Locators;
import helpers.Properties;
import helpers.SortHelper;

import static org.junit.Assert.*;

/**
 * Contains all the elements needed to automate the interaction with the amazon search results page.
 * @author omar.navarro
 *
 */
public class ResultsPage {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public WebDriverWait wait;
	//aids in sorting Articles by quality, price, etc.
	private ArrayList<Article> firstArticles;

	/**
	 * Constructs a new ResultsPage object, using the driver created in <class>tests.BaseTest</class>
	 * It also initializes its web elements by using the PageFactory method, pointing to all elements
	 * defined in this very class.
	 * @param driver WebDriver used to run the tests.
	 */
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Properties.MEDIUM_WAIT);
		PageFactory.initElements(driver, this);

	}

	/* WebElement Section*/
	@FindBy(how = How.ID, using = Locators.RESULTS_DIV_ID)
	WebElement resultsDivId;

	/* Automation method section */

	/**
	 * Validates search results correspond with the article. It then makes sure the 
	 * Filter page is initialized.
	 * @param article, 
	 * @return <class>pages.amazonTest.FilterTest</class>
	 */
	public FilterPage validateSearchResults(String article) {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(Locators.RESULTS_XPATH), 0));
		return new FilterPage(driver);
	}

	/**
	 * Outputs the top 5 results of the original search
	 */
	public void outputTop5Results() {

		firstArticles = getTopResults(5);
		
		System.out.println("Top 5 results");
		for(Article art: firstArticles) {
			System.out.println(art.toString());
		}
	}
	
	/**
	 * Creates an arraylist with the first results
	 * @param numResults  number of article results to fetch from Amazon 
	 * @return
	 */
	private ArrayList<Article> getTopResults(int numResults) {
		ArrayList<Article> search_results = new ArrayList<Article>();
		ArrayList<WebElement> results = (ArrayList<WebElement>) driver.findElements(By.xpath(Locators.RESULTS_XPATH));
		int counter = 1;
		for(WebElement elem: results) {
			WebElement nameElem = elem.findElement(By.xpath(Locators.ARTICLE_NAME_RELATIVE_XPATH));
			String articleName = nameElem.getAttribute("textContent");
			WebElement priceElem = elem.findElement(By.xpath(Locators.ARTICLE_PRICE_RELATIVE_XPATH));
			double articlePrice = Double.parseDouble(priceElem.getAttribute("textContent").substring(1));
			//TODO: take into account product may not be rated yet.
			WebElement ratingElem = elem.findElement(By.xpath(Locators.ARTICLE_RATING_RELATIVE_XPATH));
			StringTokenizer st = new StringTokenizer(ratingElem.getAttribute("textContent"), " ");
			double articleRating = Double.parseDouble(st.nextToken());
			search_results.add(new Article(articleName, articlePrice, articleRating));
			counter++;
			if(counter > numResults)
				break;
		}
		return search_results;
	}

	/**
	 * Asserts that price for search result items is in a given price range
	 * @param bottom_price, from price
	 * @param top_price, to price
	 */
	public void validateSearchResultsPriceBetween(String bottom_price, String top_price) {
		for(Article art: firstArticles) {
			assertTrue(art.getPrice() + " is not between " + bottom_price + " and " + top_price,
					art.getPrice() >= Double.parseDouble(bottom_price)
					&& art.getPrice() <= Double.parseDouble(top_price));
		}
	}

	/**
	 * Outputs item recommendation based on item rating and lower price.
	 */
	public void getItemRecommendation() {
		SortHelper.sortByValue(firstArticles);//sort by value
		
		//outputs the last article after it's been sorted.
		System.out.println("Item recommendation");
		System.out.println(firstArticles.get(firstArticles.size() - 1));
	}

	/**
	 * Sorts the top 5 articles by price and outputs the result.
	 */
	public void sortTop5ByPrice() {
		
		SortHelper.sortByPrice(firstArticles);
		System.out.println("Top 5 results sorted by price");
		for(Article art: firstArticles) {
			System.out.println(art.toString());
		}
	}

	/**
	 * Sorts the top 5 articles by rating and outputs the result.
	 */
	public void sortTop5ByRating() {
		SortHelper.sortByRating(firstArticles);
		System.out.println("Top 5 results sorted by rating.");
		for(Article art: firstArticles) {
			System.out.println(art.toString());
		}
	}

	/**
	 * Asserts top 5 articles are sorted by price.
	 */
	public void validateTop5SortedByPrice() {
		SortHelper.sortByPrice(firstArticles);
		//assert all articles are sorted.
		for(int i = 0; i < firstArticles.size() - 1; i++) {
			assertTrue(" is not sorted.", 
					firstArticles.get(i).getPrice() < firstArticles.get(i + 1).getPrice());
		}
	}
}
