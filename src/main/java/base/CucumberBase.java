package base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commonHelper.BrowserFactory;
import commonHelper.ReportHelper;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import testRunner.CucumberRunner;
import utilities.DateTimeHelper;

public class CucumberBase extends AbstractTestNGCucumberTests {
	public Properties config = null;
	public static BrowserFactory browserFactory;
	CucumberRunner cucumberRunner;
	Config configReader = new Config();
	public String currCountry = "";
	public static String environment;

	private Logger log = Logger.getLogger(CucumberBase.class.getName());

	/** This method loads config file object **/
	public void LoadConfigProperty() {
		log.info("loading property file");
		config = configReader.createConfigObject();
	}

	/** This method configures browser binary file path **/
	public void configureDriverPath() throws IOException {
		if (System.getProperty("os.name").startsWith("Linux")) {
			log.info("OS = Linux");
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if (System.getProperty("os.name").startsWith("Mac")) {
			log.info("OS = Mac");
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if (System.getProperty("os.name").startsWith("Windows")) {
			log.info("OS = Windows");
			String firefoxDriverPath = System.getProperty("user.dir")
					+ "//src//test//resources//drivers//windows//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir")
					+ "//src//test//resources//drivers//windows//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}

	/** this methods opens browser instance **/
	public void openBrowser() {
		log.info("identifying browser to launch");
		// loads the config options
		try {
			LoadConfigProperty();
			configureDriverPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// configures the driver path
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver(browserFactory.getBrowser());
		maximizeWindow();
		implicitWait(configReader.getImplicitTimeoutInSec());
		deleteAllCookies();
		setEnv(browserFactory.getCountry(), browserFactory.getLanguage(), CucumberBase.environment);
	}

	/** this methods maximizes browser window **/
	public void maximizeWindow() {
		log.info("maximizing browser window");
		browserFactory.getDriver().manage().window().maximize();
	}

	/** this methods sets implicit wait **/
	public void implicitWait(int time) {
		log.info("Setting up implicit wait in secs " + time);
		browserFactory.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/** this methods sets page load timeout **/
	public void pageLoadTimeout(int time) {
		log.info("Setting up page load time out in secs " + time);
		browserFactory.getDriver().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	/** this methods clears all browser cookies **/
	public void deleteAllCookies() {
		log.info("Clearing browser cookies");
		browserFactory.getDriver().manage().deleteAllCookies();
	}

	/** this methods sets url **/
	public void setEnv(String country, String language, String environment) {
		log.info("Setting up browser url for country " + country + ", language " + language + " and environment as "
				+ environment);
		LoadConfigProperty();
		String siteUrl = configReader.getSiteURL(country, language, environment);
		browserFactory.getDriver().get(siteUrl);
	}

	/** This is before suite method **/
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		DOMConfigurator.configure("src/test/resources/configuration/log4j.xml");
		log.info("Executing Before Suite");
		try {
			FileUtils.cleanDirectory(new File("./screenshots"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** This is before test method **/
	@BeforeTest(alwaysRun = true)
	@Parameters({ "browser", "country", "language", "environment" })
	public void beforeTest(String browser, String country, String language, String environment) {
		log.info("Executing Before Test");
		CucumberBase.environment = environment;
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setBrowser(browser);
		browserFactory.setCountry(country);
		browserFactory.setLanguage(language);
		browserFactory.setEnvironment(environment);
	}

	/** This method captures and saves screen shot **/
	public void takeScreenShot(Scenario scenario) {
		log.info("Capturing screenshot");
		File srcImageFile = ((TakesScreenshot) browserFactory.getDriver()).getScreenshotAs(OutputType.FILE);

		String imageFileName = scenario.getName().replace(" ", "") + "_" + browserFactory.getBrowser() + "_"
				+ new DateTimeHelper().getCurrentDateTime("dd_MM_yyyy_hh_mm_ss") + ".png";
		File destnImageFile = new File(System.getProperty("user.dir") + "/screenshots/" + imageFileName);
		try {
			FileHandler.copy(srcImageFile, destnImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** This is method attaches screen shot to cucumber html report **/
	public void attachScreen(Scenario scenario) {
		log.info("Attaching screenshot to cucumber html report");
		final byte[] screenshot = ((TakesScreenshot) browserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}

	/** This is generates cucumber and extent html report **/
	@Parameters({ "browser" })
	@AfterSuite(alwaysRun = true)
	public void generateHTMLReports(String browser) {
		log.info("Generating reports after suite execution");
		new ReportHelper().generateCucumberReport(browser);
		new ReportHelper().configureExtentReport(browser);
		try {
			if (browserFactory.getDriver().getWindowHandles().size() > 0) {
				quit();
			}
		} catch (Exception e) {
			log.info("no window to close");
		}
	}

	/** This is closes all browser instances **/
	public void quit() {
		log.info("Closing all browser instances");
		browserFactory.getDriver().quit();
	}

}
