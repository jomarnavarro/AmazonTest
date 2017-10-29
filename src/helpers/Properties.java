package helpers;

/**
 * Keeps track of all properties
 * @author omar.navarro
 *
 */
public class Properties {
	
	/* Chrome browser properties.  You want to edit these when importing the project to your os.*/
	public static final String CHROME_BROWSER = "chrome";
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "./DriverEXE/chromedriver";
	
	/* Firefox browser properties.  You want to edit these when importing the project to your os.*/
	public static final String FIREFOX_BROWSER = "firefox";
	public static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH = "./DriverEXE/geckodriver";
	
	/* IE browser properties.  You want to edit these when importing the project to your os.*/
	public static final String IE_BROWSER = "ie";
	public static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	public static final String IE_DRIVER_PATH = "./DriverEXE/IEDriverServer.exe";
	
	/* Wait time properties.  You want to edit these when importing the project to your os according
	 * to your internet speed..*/
	public static final long SHORT_WAIT = 5;
	public static final long MEDIUM_WAIT = 10;
	public static final long LONG_WAIT = 15;
	
	
	

}
