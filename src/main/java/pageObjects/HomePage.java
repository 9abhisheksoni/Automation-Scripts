package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
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
import utilities.StringUtility;

public class HomePage extends CucumberRunner {
	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	private Logger log = Logger.getLogger(HomePage.class.getName());
	StringUtility strUtil=new StringUtility();

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
	
	@FindBy(xpath="//li[@class='header-wishlist']/a")
	private WebElement lnkWishlist;
	
	@FindBy(xpath="//a[@class='algoliasearch-autocomplete-hit']")
	private WebElement FirstSearchEle;
	
	/*Footer Links*/
	@FindBy(xpath="//a[contains(text(),'About 6TH STREET')]")
	private WebElement lnkAbout6thStreet;
	
	@FindBy(xpath="//a[contains(text(),'Consumer Rights')]")
	private WebElement lnkConsumerRights;
	
	@FindBy(xpath="//a[contains(text(),'Disclaimer')]")
	private WebElement lnkDisclaimer;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	private WebElement lnkPrivacyPolicy;
	
	@FindBy(xpath="//a[contains(text(),'Shipping Information')]")
	private WebElement lnkShippingInfo;
	
	@FindBy(xpath="//a[contains(text(),'Returns Information')]")
	private WebElement lnkReturnInfo;
	
	@FindBy(xpath="//a[contains(text(),'Order Tracking')]")
	private WebElement lnkOrderTrack;
	
	@FindBy(xpath="//a[contains(text(),\"FAQ's\")]")
	private WebElement lnkFAQs;
	
	@FindBy(xpath="//a[contains(text(),'Feedback')]")
	private WebElement lnkFeedback;
	
	@FindBy(xpath="//body/div[4]/footer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[3]/span[2]")
	private WebElement lnkCustomerCare;
	
	@FindBy(xpath="//body/div[4]/footer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[2]/span[2]")
	private WebElement lnkSupportPhoneNo;
	
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
	
	public void createAccount() {
		waitHelper.waitForElementVisible(btnSignUp);
		commonMethods.click(btnSignUp);
		commonMethods.clearAndSendKeys(txtFirstName, RandomStringUtils.randomAlphabetic(6));
		commonMethods.clearAndSendKeys(txtLastName, RandomStringUtils.randomAlphabetic(5));
		commonMethods.clearAndSendKeys(txtEmailID, strUtil.generateRandomEmailID());
		commonMethods.clearAndSendKeys(txtPwd, "India@123");
		waitHelper.waitForElementVisible(btnCreateAccount);
		commonMethods.click(btnCreateAccount);

	}
	
	public void clickOnAbout6thStreetFooterLink() {
		commonMethods.click(lnkAbout6thStreet);
		log.info("clicked About 6thstreet link in Footer");
	}
	
	public void clickOnConsumerRightsFooterLink() {
		commonMethods.click(lnkConsumerRights);
		log.info("clicked ConsumerRights link in Footer");
	}
	
	public void clickOnDisclaimerFooterLink() {
		commonMethods.click(lnkDisclaimer);
		log.info("clicked Disclaimer link in Footer");
	}
	
	public void clickOnPrivacyPolicyFooterLink() {
		commonMethods.click(lnkPrivacyPolicy);
		log.info("clicked PrivacyPolicy link in Footer");
	}
	
	public void clickOnShippingInfoFooterLink() {
		commonMethods.click(lnkShippingInfo);
		log.info("clicked ShippingInfo link in Footer");
	}
	
	public void clickOnReturnInfoFooterLink() {
		commonMethods.click(lnkReturnInfo);
		log.info("clicked ReturnInfo link in Footer");
	}
	
	public void clickOnOrderTrackFooterLink() {
		commonMethods.click(lnkOrderTrack);
		log.info("clicked OrderTracking lnk in Footer");
	}
	
	public void clickOnFAQsFooterLink() {
		commonMethods.click(lnkFAQs);
		log.info("clicked FAQs link in Footer");
	}
	
	public void clickOnFeedbackFooterLink() {
		commonMethods.click(lnkFeedback);
		log.info("clicked Feedback link in Footer");
	}
	
	/*
	 * public void verifyFooterLinks() { this.clickOnAbout6thStreetFooterLink();
	 * this.clickOnConsumerRightsFooterLink(); this.clickOnDisclaimerFooterLink();
	 * this.clickOnPrivacyPolicyFooterLink(); this.clickOnShippingInfoFooterLink();
	 * this.clickOnReturnInfoFooterLink(); this.clickOnOrderTrackFooterLink();
	 * this.clickOnFAQsFooterLink(); this.clickOnFeedbackFooterLink(); }
	 */
	
}
