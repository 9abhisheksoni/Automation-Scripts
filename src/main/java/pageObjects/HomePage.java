package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Scanner;

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
	SearhPage searchPage = new SearhPage();
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

	@FindBy(xpath = "//a[@class='top-link-return-item-link']")
	private WebElement optionReturnHistory;

	@FindBy(xpath = "//div[@id='toggleSignup']")
	private WebElement btnSignUp;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement txtEmailID;

	@FindBy(xpath = "//input[@id='popup_password']")
	private WebElement txtPwd;

	@FindBy(xpath = "//button[@ID='yopeso_register']")
	private WebElement btnCreateAccount;

	@FindBy(xpath = "//li[@class='header-wishlist']/a")
	private WebElement lnkWishlist;

	@FindBy(xpath = "(//div[@class='aa-dataset-products']//div[@class='aa-suggestion'])[1]")
	private WebElement FirstSearchEle;

	@FindBy(xpath = "(//div[@class='aa-dataset-products']//div[@class='aa-suggestion'])[1]//span[@class='after_special']")
	private WebElement txtPriceInSearch;

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
			waitHelper.waitForElementVisible(imgHomePage);
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

	public void clickReturnAnOrder() {
		commonMethods.click(optionReturnHistory);
		log.info("Return history is selected");
	}

	public void createAccount(String firstName, String lastName, String email, String pwd) {
		waitHelper.waitForElementVisible(btnSignUp);
		commonMethods.click(btnSignUp);
		commonMethods.clearAndSendKeys(txtFirstName, firstName);
		commonMethods.clearAndSendKeys(txtLastName, lastName);
		commonMethods.clearAndSendKeys(txtEmailID, email);
		commonMethods.clearAndSendKeys(txtPwd, pwd);
		waitHelper.waitForElementVisible(btnCreateAccount);
		commonMethods.click(btnCreateAccount);

	}

	public void typeInSearchField(String product) {
		commonMethods.clearAndSendKeys(txtSearchProduct, product);
		log.info("Entering text in Search field");
	}

	public void clickHomeLogo() {
		commonMethods.click(imgHomePage);
		log.info("Clicked on Home Logo");
	}

	public void clickOnWishlistInHeader() {
		commonMethods.click(lnkWishlist);
		log.info("clicked Wishlist in Header");
	}

	public void clickOnFirstItemSearchResult() {
		commonMethods.moveToElementAndClick(FirstSearchEle);
		log.info("First Search element clicked");
	}

	/*
	 * This method fetches price displaying for an SKU at the Search bar
	 */
	public String getPriceValueAtSearch(String country) {
		String actualPrice = null;
		log.info("Fetching the price at the search");
		waitHelper.waitForElementVisible(txtPriceInSearch);
		String priceWithCurrenyCode = commonMethods.getText(txtPriceInSearch);
		log.info("The price available in the search bar: " + priceWithCurrenyCode);
		actualPrice = priceWithCurrenyCode.replaceAll(",", ""); // Works correctly for KSA and UAE
		if (country.equalsIgnoreCase("UAE") || country.equalsIgnoreCase("KSA") || country.equalsIgnoreCase("QA")) {
			actualPrice = priceWithCurrenyCode.replaceAll("[^0-9]", "");
		} else if (country.equalsIgnoreCase("BH") || country.equalsIgnoreCase("OM") || country.equalsIgnoreCase("KW")) {
			actualPrice = priceWithCurrenyCode.replaceAll("[^\\.0-9]", "");
			if (actualPrice.equals("^\\d*(?:\\.\\d{1,3})$")) {
				System.out.println("3 digits available after the decimal point");
			}
		} else {
			log.info("The country code is not valid");
		}
		log.info("The actual price is " + actualPrice);
		return actualPrice;
	}

	/*
	 * This method compares the price displaying in the search bar with the price
	 * given by the user
	 */
	public void evaluateSpecialPriceAtSearch(String sellingPrice, String country) {
		log.info("comparing the price displaying at the search");
		log.info("The price at search is " + getPriceValueAtSearch(country));
		assertEquals(getPriceValueAtSearch(country), sellingPrice, "Prices are matching at the search");
	}

	/*
	 * This method compares the price displaying in the search bar with the price
	 * given by the user
	 */
	public void evaluateSpecialPriceAtSearch(String country) {
		log.info("comparing the price displaying at the search");
		log.info("The global special price is " + searchPage.globalSpecialPrice);
		assertEquals(getPriceValueAtSearch(country), searchPage.globalSpecialPrice, "Prices are matching at the search");
	}

}
