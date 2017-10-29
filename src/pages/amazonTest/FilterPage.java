package pages.amazonTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import helpers.Locators;
import helpers.Properties;

/**
 * Contains all the elements needed to automate the interaction with the amazon filter page
 * (Actually the navigation bar).
 * @author omar.navarro
 */
public class FilterPage {
	
public WebDriver driver;
public JavascriptExecutor jse;
public WebDriverWait wait;
	
/**
 * Constructs a new FilterPage object, using the driver created in <class>tests.BaseTest</class>
 * It also initializes its web elements by using the PageFactory method, pointing to all elements
 * defined in this very class.
 * @param driver WebDriver used to run the tests.
 */
	public FilterPage(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Properties.MEDIUM_WAIT);
		PageFactory.initElements(driver, this);
		
	}
	
	/* WebElement Section*/
	@FindBy(how = How.XPATH, using = Locators.PLASTIC_MATERIAL_LABEL_XPATH)
	WebElement plasticMaterialLbl;
	
	@FindBy(how = How.ID, using = Locators.MIN_PRICE_TXT_ID)
	WebElement minPriceTxt;
	
	@FindBy(how = How.ID, using = Locators.MAX_PRICE_TXT_ID)
	WebElement maxPriceTxt;
	
	@FindBy(how = How.XPATH, using = Locators.LEFT_NAV_GO_BUTTON_XPATH)
	WebElement goBtn;
	
	/* Automation method section */
	/**
	 * Sets the material filter.
	 * @param filter1, filter type
	 */
	public void setMaterialFilter(String filter1) {
		//this element requires being visible.
		jse.executeScript("arguments[0].scrollIntoView(true);", plasticMaterialLbl);
		wait.until(ExpectedConditions.visibilityOf(plasticMaterialLbl));
		this.plasticMaterialLbl.click();
	}

	/**
	 * Sets price filter based in a price range.  It then waits for the results to be loaded
	 * and initializes the <class>pages.amazonTest.ResultsPage</class>
	 * @param bottom_price, minimum price for the article
	 * @param top_price, maximum price for the article
	 * @return <class>pages.amazonTest.ResultsPage</class>
	 */
	public ResultsPage setPriceFilter(String bottom_price, String top_price) {
		jse.executeScript("arguments[0].scrollIntoView(true);", this.minPriceTxt);
		wait.until(ExpectedConditions.visibilityOf(minPriceTxt));
		wait.until(ExpectedConditions.visibilityOf(maxPriceTxt));
		wait.until(ExpectedConditions.visibilityOf(goBtn));
		this.minPriceTxt.sendKeys(bottom_price);
		this.maxPriceTxt.sendKeys(top_price);
		this.goBtn.click();
		return new ResultsPage(driver);
	}
}
