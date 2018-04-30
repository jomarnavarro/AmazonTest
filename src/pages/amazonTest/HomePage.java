package pages.amazonTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import helpers.Locators;

/**
 * Contains all the elements needed to automate the interaction with the amazon home page.
 * @author omar.navarro
 */
public class HomePage {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	public WebDriverWait wait;
	
	/**
	 * Constructs a new HomePage object, using the driver created in <class>tests.BaseTest</class>
	 * It also initializes its web elements by using the PageFactory method, pointing to all elements
	 * defined in this very class.
	 * @param driver WebDriver used to run the tests.
	 */	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		
	}
	/* WebElement Section*/
	
	@FindBy(how = How.ID, using = Locators.AMAZON_LOGO_ID)
	WebElement amazonLogoImg;
	
	@FindBy(how = How.ID, using = Locators.SEARCH_BOX_ID)
	WebElement searchBoxTxt;
	
	@FindBy(how = How.XPATH, using = Locators.SEARCH_BUTTON_XPATH)
	WebElement searchBtn;
	
	/* Automation method section */
	/**
	 * Searches for an article by inputting the article into the top search box and clicking the
	 * magnifying glass icon.  It also waits for the <class>pages.amazonTest.ResultsPage</class>
	 * to load and initializes it.
	 * @param article
	 * @return 
	 */
	public ResultsPage search(String article) {
		searchBoxTxt.sendKeys(article);
		searchBtn.click();
		return new ResultsPage(driver);
	}

}
