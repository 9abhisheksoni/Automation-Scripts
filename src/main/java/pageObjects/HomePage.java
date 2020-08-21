package pageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class HomePage extends CucumberRunner {
	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	private Logger log = Logger.getLogger(HomePage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public HomePage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//input[@id='search']")
	private WebElement txtSearchProduct;

	@FindBy(xpath = "//img[@id='mainBannerImage']")
	private WebElement bannerHomePage;

	@FindBy(xpath = "//div[@class='logo']//img")
	private WebElement imgHomePage;

	@FindBy(xpath = "//form[contains(@class,'active')]//span[@class='search_icon']")
	private WebElement icnSearch;

	@FindBy(xpath = "//span[@id='customer_name_top_menu']")
	private WebElement menuUserNameTop;

	@FindBy(xpath = "//a[@class='top-link-order-history-link' and .='Order History']")
	private WebElement optionOrderHistory;

	/**
	 * WebElement declaration ends here
	 **/

	public void searchProduct(String product) {
		commonMethods.clearAndSendKeys(txtSearchProduct, product, Keys.ENTER);
		log.info("submitting search term");
	}

	public void verifyHomePageDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(bannerHomePage));
		log.info("home page is loaded");
	}

	public void waitForBannerLoading() {
		try {
			waitHelper.staticWait(5000);
			waitHelper.waitForElementInVisiblity(new CartPage().lblCartCount);
		} catch (Exception e) {
			log.info("minicart disappeared");
		}
		log.info("home page is banner loaded");
	}

	public void clickMyAccountMenu() {
		commonMethods.click(menuUserNameTop);
		log.info("My account menu link is clicked");
	}

	public void selectOrderHistory() {
		commonMethods.click(optionOrderHistory);
		log.info("Order history is selected");
	}
}
