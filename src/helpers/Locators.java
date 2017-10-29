package helpers;

/**
 * Keeps track of all the locators
 * @author omar.navarro
 *
 */
public class Locators {
	
	/* Home Page Locators */
	public static final String SEARCH_BOX_ID = "twotabsearchtextbox";
	public static final String SEARCH_BUTTON_ID = "nav-search-submit-text";
	public static final String SEARCH_BUTTON_XPATH = "//*[@id='navbar']//input[@value='Go' ]";
	
	/* Filter Page Locators */
	public static final String PLASTIC_MATERIAL_LABEL_XPATH = "//*[text()='Case Material']/following-sibling::ul//*[text()='Plastic']";
	public static final String AMAZON_LOGO_ID = "nav-logo";
	public static final String MIN_PRICE_TXT_ID = "low-price";
	public static final String MAX_PRICE_TXT_ID = "high-price";
	public static final String LEFT_NAV_GO_BUTTON_XPATH = "//*[@id='leftNav']//input[@value='Go' ]";
	
	/* Results Page Locators */
	public static final String RESULTS_DIV_ID = "atfResults";
	public static final String RESULTS_XPATH = "//*[@id='atfResults']//li[contains(@id, 'result')]";
	public static final String ARTICLE_NAME_RELATIVE_XPATH = ".//*[contains(@class, 's-access-detail-page')]";
	public static final String ARTICLE_PRICE_RELATIVE_XPATH = ".//*[starts-with(text(), '$')]";
	public static final String ARTICLE_RATING_RELATIVE_XPATH = ".//*[contains(text(), 'stars')]";

}
