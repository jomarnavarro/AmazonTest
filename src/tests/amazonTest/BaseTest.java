package tests.amazonTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import helpers.Properties;
import pages.amazonTest.FilterPage;
import pages.amazonTest.HomePage;
import pages.amazonTest.ResultsPage;

/**
 * Implements set up and tear down methods, as well as hides Selenium implementation
 * details.
 * @author omar.navarro
 *
 */
public class BaseTest {

	protected WebDriver driver;
	protected HomePage homePage;
	protected ResultsPage resultsPage;
	protected FilterPage filterPage;

	/**
	 * Sets up the environment to start the test by starting the browser, 
	 * configuring it, navigating to the appropriate page and setting up the 
	 * initial page object. 
	 * @param browser, chrome or firefox
	 * @param url, initial url to test
	 */
	protected void setUp(String browser, String url) {
		switch(browser) {
		case Properties.CHROME_BROWSER:
			System.setProperty(Properties.CHROME_DRIVER_PROPERTY, Properties.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case Properties.FIREFOX_BROWSER:	
			System.setProperty(Properties.FIREFOX_DRIVER_PROPERTY, Properties.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case Properties.IE_BROWSER:	
			System.setProperty(Properties.IE_DRIVER_PROPERTY, Properties.IE_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty(Properties.FIREFOX_DRIVER_PROPERTY, Properties.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		}
		//driver.manage().timeouts().implicitlyWait(Properties.MEDIUM_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		homePage = new HomePage(driver);
	}
	
	/**
	 * Destroys initial configuration
	 */
	@After
	public void tearDown() {
		driver.quit();
	}
}