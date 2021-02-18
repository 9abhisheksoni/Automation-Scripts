package pageObjects;

import java.util.List;
import static org.testng.Assert.assertEquals;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import base.Config;
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
	StringUtility strUtil = new StringUtility();
	Config config = new Config();
	SearchPage searchPage = new SearchPage();
	SoftAssert softAssert = new SoftAssert();
	String category = "";

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

	@FindBy(xpath = "//div[@class='logo']//img | //div[@class='logo-center']")
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

	@FindBy(xpath = "//a[@class='algoliasearch-autocomplete-hit']")
	private WebElement FirstSearchEle;

	@FindBy(xpath = "(//div[@class='aa-dataset-products']//div[@class='aa-suggestion'])[1]//span[@class='after_special']")
	private WebElement txtPriceInSearch;

	/* Footer Links */
	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'6th-street')]")
	private WebElement lnkAbout6thStreet;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'consumerrights')]")
	private WebElement lnkConsumerRights;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'disclaimer')]")
	private WebElement lnkDisclaimer;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'privacy-policy')]")
	private WebElement lnkPrivacyPolicy;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'shipping-policy')]")
	private WebElement lnkShippingInfo;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'return-information')]")
	private WebElement lnkReturnInfo;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'track')]")
	private WebElement lnkOrderTrack;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'Faq')]")
	private WebElement lnkFAQs;

	@FindBy(xpath = "//div[@class='footer_nav clear']/a[contains(@href,'contact')]")
	private WebElement lnkFeedback;

	@FindBy(xpath = "//div[@class='footer_nav clear']//a[contains(@href,'customercare')]")
	private WebElement lnkFooterCustomerCareMail;

	@FindBy(xpath = "//div[@class='footer_nav clear']//span[@class='cst_phone_icon']/following-sibling::span")
	private WebElement lblFooterCustomerCarePhoneNo;

	@FindBy(xpath = "//div[@id='top_header_customer_service']")
	private WebElement divCustomerService;

	@FindBy(xpath = "//div[@id='customer-service-header']//a[contains(@href,'customercare')]")
	private WebElement lnkCustomerServiceMail;

	@FindBy(xpath = "//div[@id='customer-service-header']//span[@class='cst_phone_icon']//following-sibling::span")
	private WebElement lblCustomerServicePhone;

	@FindBy(xpath = "//a[contains(@title,'Women')]")
	private WebElement lnkWomen;

	@FindBy(xpath = "//a[contains(@title,'Men')]")
	private WebElement lnkMen;

	@FindBy(xpath = "//a[@title='Kids Store']")
	private WebElement lnkKids;

	@FindBy(xpath = "//img[contains(@src,'banner')]")
	private List<WebElement> lstBanners;

	@FindBy(xpath = "//img[contains(@src,'SHOP-ALL-BRANDS')]")
	private WebElement imgShopAllBrands;

	@FindBy(xpath = "(//a[contains(@data-id,'Shop by Brand')])[last()]")
	private WebElement lnkShopAllBrands;

	@FindBy(xpath = "//a[contains(@data-id,'Shop by Brand')]/img")
	private List<WebElement> lstShopByBrands;

	@FindBy(xpath = "//a[contains(@data-id,'Shop by Category')]")
	private List<WebElement> lstShopByCategory;

	@FindBy(xpath = "//img[@class='img-responsive']")
	private List<WebElement> lstOfferBanners;
	
	/* PWA elements */
	@FindBy(xpath = "//img[@class='Image-Image' and contains(@src,'AllBanners')]")
	private List<WebElement> lstPwaAllBanners;	
	
	@FindBy(xpath = "(//div[@class='GenderButton-Container']/a[contains(@href,'women')])")
	private WebElement lnkPwaWomen;
	
	@FindBy(xpath = "(//div[@class='GenderButton-Container']/a[contains(@href,'/men')])")
	private WebElement lnkPwaMen;
	
	@FindBy(xpath = "(//div[@class='GenderButton-Container']/a[contains(@href,'/kids')])")
	private WebElement lnkPwaKids;
	
	@FindBy(xpath = "(//div[@class='GenderButton-Container']/a[contains(@href,'/kids')])")
	private WebElement imgPwaHomeLogo;
	
	@FindBy(xpath = "//img[contains(@src,'Hero_Banner')]")
	private WebElement imgPwaHeroBanner;
	
	@FindBy(xpath = "//div[@class='FooterMiddle-CustomerSupport']//a[@class='InlineCustomerSupport-Phone']")
	private WebElement divPwaFooterPhone;

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
		commonMethods.click(imgPwaHomeLogo);
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
	public String getPriceValueAtSearch() {
		String specialPrice = null;
		log.info("Fetching the price at the search");
		waitHelper.waitForElementVisible(txtPriceInSearch);
		specialPrice = commonMethods.getText(txtPriceInSearch);

		log.info("The special price at Search is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted special price at Search is" + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the price displaying in the search bar with the price
	 * given by the user
	 */
	public void evaluateSpecialPriceAtSearch(String sellingPrice) {
		log.info("comparing the price displaying at the search");
		log.info("The price at search is " + getPriceValueAtSearch());
		assertEquals(getPriceValueAtSearch(), sellingPrice, "Prices are matching at the search");
	}

	/*
	 * This method compares the price displaying in the search bar with the price
	 * given by the user
	 */
	public void evaluateSpecialPriceAtSearch() {
		log.info("comparing the price displaying at the search");
		log.info("The global special price is " + searchPage.globalSpecialPrice);
		assertEquals(getPriceValueAtSearch(), searchPage.globalSpecialPrice, "Prices are matching at the search");
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

	public void verifySupportPhoneAndEmail(String section) {
		if (section.equalsIgnoreCase("Header")) {
			commonMethods.click(divCustomerService);
			this.verifyHeaderPhoneNumber();
			this.verifyHeaderMailId();
		} else if (section.equalsIgnoreCase("Footer")) {
			this.verifyFooterPhoneNumber();
			this.verifyFooterMailId();
		}
	}

	public void verifyFooterMailId() {
		String emailID = commonMethods.getText(lnkFooterCustomerCareMail);
		jsHelper.scrollToElement(lnkFooterCustomerCareMail);
		try {
			Assert.assertTrue((emailID.equalsIgnoreCase(config.getSupportEmailId())));
			log.info("Email id displayed at Footer : " + emailID + " is as expected");
		} catch (Exception e) {
			log.info("Email id displayed at Footer : " + emailID + " is not as expected");
		}
	}

	public void verifyFooterPhoneNumber() {
		String phoneNo = commonMethods.getText(lblFooterCustomerCarePhoneNo);
		jsHelper.scrollToElement(lblFooterCustomerCarePhoneNo);
		try {
			Assert.assertTrue((phoneNo.equalsIgnoreCase(config.getSupportPhoneNo(browserFactory.getCountry()))));
			log.info("Phone number displayed at Footer : " + phoneNo + " is as expected");
		} catch (Exception e) {
			log.info("Phone number displayed at Footer : " + phoneNo + " is not as expected");
		}
	}

	public void verifyHeaderMailId() {
		String emailID = commonMethods.getText(lnkCustomerServiceMail);
		try {
			Assert.assertTrue((emailID.equalsIgnoreCase(config.getSupportEmailId())));
			log.info("Email id displayed at Header : " + emailID + " is as expected");
		} catch (Exception e) {
			log.info("Email id displayed at Header : " + emailID + " is not as expected");
		}
	}

	public void verifyHeaderPhoneNumber() {
		String phoneNo = commonMethods.getText(lblCustomerServicePhone);
		try {
			Assert.assertTrue((phoneNo.equalsIgnoreCase(config.getSupportPhoneNo(browserFactory.getCountry()))));
			log.info("Phone number displayed at Header : " + phoneNo + " is as expected");
		} catch (Exception e) {
			log.info("Phone number displayed at Header : " + phoneNo + " is not as expected");
		}
	}

	public void clickOnMainBanner() {
		// waitHelper.waitForElementToBeClickable(bannerHomePage);
		waitHelper.staticWait(5000);
		waitHelper.waitForElementVisible(bannerHomePage);
		commonMethods.click(bannerHomePage);
		log.info("clicked Main banner");
	}

	public void clickLevel1Category(String category) {
		this.category = category;
		if (category.equalsIgnoreCase("Women")) {
			commonMethods.click(lnkPwaWomen);
			log.info("clicked Women L1 category");
		} else if (category.equalsIgnoreCase("Men")) {
			commonMethods.click(lnkPwaMen);
			log.info("clicked Men L1 category");
		} else if (category.equalsIgnoreCase("Kids")) {
			commonMethods.click(lnkPwaKids);
			log.info("clicked Kids L1 category");
		}

	}

	public void clickOnAllBannersAndVerifyPLP() {
		//this.clickOnBannersAndVerifyPLP(lstOfferBanners,"Offer","Required");
		//this.clickOnBannersAndVerifyPLP(lstShopByCategory, "Category", "NotRequired");
		//this.clickOnBannersAndVerifyPLP(lstShopByBrands, "Brands", "NotRequired");
		this.clickOnBannersAndVerifyPLP(lstPwaAllBanners, "NotRequired");
		searchPage.customAssertAll();
	}

	public void clickOnBannersAndVerifyPLP(List<WebElement> banner, String staticWait) {
		waitHelper.waitForElementToBeClickable(imgPwaHeroBanner);
		if (staticWait.equalsIgnoreCase("Required")) {
			waitHelper.staticWait(10000);
			jsHelper.scrollToElement(divPwaFooterPhone);
			// waitHelper.staticWait(15000);
		}
		int bannerCount = banner.size();
		System.out.println(" Banner count: " + bannerCount);
		for (int i = 0; i < banner.size(); i++) {
			waitHelper.waitForElementVisible(imgPwaHomeLogo);
			try {
				/*
				 * if (section.equalsIgnoreCase("Brands")) {
				 * jsHelper.scrollToElement((banner.get(i)));
				 * jsHelper.scrollToElement(lnkShopAllBrands); }
				 */
				commonMethods.click(banner.get(i));
			} catch (ElementClickInterceptedException e) {
				waitHelper.waitForElementToBeClickable(banner.get(i));
				commonMethods.clickUsingJS(banner.get(i));
			}
			log.info("clicked banner " + (i + 1) + " of " + bannerCount);
			waitHelper.staticWait(2000);
			searchPage.verifyPLP();
			waitHelper.staticWait(500);
			this.clickHomeLogo();

			if(!this.category.equalsIgnoreCase("Women")) {
			  this.clickLevel1Category(this.category); 
			  }
		}
	}
}
