package commonHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	ThreadLocal<String> webBrowser = new ThreadLocal<String>();
	ThreadLocal<String> country = new ThreadLocal<String>();
	ThreadLocal<String> language = new ThreadLocal<String>();
	ThreadLocal<String> ordernumber = new ThreadLocal<String>();
	ThreadLocal<String> returnnumber = new ThreadLocal<String>();
	ThreadLocal<String> loggedinUserEmail = new ThreadLocal<String>();
	ThreadLocal<String> environment = new ThreadLocal<String>();

	private Logger log = Logger.getLogger(BrowserFactory.class.getName());

	/** Singleton constructor declared **/
	private BrowserFactory() {

	}

	/** Creating instance of class **/
	public static BrowserFactory getInstance() {
		new BrowserFactory().log.info("Creating Browser Factory Instance");
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	/** Setting value of driver instance **/
	public final void setDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			log.info("Creating Firefox Driver Instance");
			WebDriverManager.firefoxdriver().setup();
			webDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("chrome")) {
			log.info("Creating Chrome Driver Instance");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");			
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("--window-size=1300,1000");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			webDriver.set(new ChromeDriver(capabilities));
		}
	}

	/** returning value of driver instance **/
	public WebDriver getDriver() {
		log.info("Returning Driver Instance");
		return webDriver.get();
	}

	/** Setting value of browser instance **/
	public final void setBrowser(String browser) {
		log.info("Creating Browser Instance " + browser);
		webBrowser.set(browser);
	}

	/** returning value of browser instance **/
	public String getBrowser() {
		log.info("Returning Browser Instance");
		return webBrowser.get();
	}

	/** Setting value of country instance **/
	public final void setCountry(String countrycode) {
		log.info("Setting Execution Country " + countrycode);
		country.set(countrycode);
	}

	/** Setting value of language instance **/
	public final void setLanguage(String languagecode) {
		log.info("Setting Execution language " + languagecode);
		language.set(languagecode);
	}

	/** returning value of country instance **/
	public String getCountry() {
		log.info("Getting Execution Country");
		return country.get();
	}

	/** returning value of language instance **/
	public String getLanguage() {
		log.info("Getting Execution language");
		return language.get();
	}

	/** returning value of order instance **/
	public String getOrderNumber() {
		log.info("Returning order Instance");
		return ordernumber.get();
	}

	/** Setting value of order instance **/
	public final void setOrder(String order) {
		log.info("Setting Return Order instance" + order);
		ordernumber.set(order);
	}

	/** returning value of return instance **/
	public String getReturnNumber() {
		log.info("Returning returnOrder Instance");
		return returnnumber.get();
	}

	/** Setting value of return instance **/
	public final void setReturnNumber(String returnID) {
		log.info("Setting Return Order instance " + returnID);
		returnnumber.set(returnID);
	}

	/** returning value of login User Email instance **/
	public String getLoggedInUserEmail() {
		log.info("Returning login Email Instance");
		return loggedinUserEmail.get();
	}

	/** Setting value of login User Email instance **/
	public final void setLoggedInUserEmail(String loginEmail) {
		log.info("Setting Return login Email instance" + loginEmail);
		loggedinUserEmail.set(loginEmail);
	}

	/** Setting value of environment instance **/
	public final void setEnvironment(String env) {
		log.info("Creating environment Instance " + env);
		environment.set(env);
	}

	/** returning value of environment instance **/
	public String getEnvironment() {
		log.info("Returning environment Instance");
		return environment.get();
	}
}
