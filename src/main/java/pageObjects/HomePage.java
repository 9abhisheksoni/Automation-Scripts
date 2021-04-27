package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import base.Config;
import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import fileReader.TextFileHandler;
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
	FooterLinksRedirectPage footerLinks = new FooterLinksRedirectPage();
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
	@FindBy(xpath = "//input[@id='search-field']")
	private WebElement txtSearchProduct;

	@FindBy(xpath = "//a[contains(@class,' HeaderLogo')]//img")
	private WebElement imgHomeLogo;

	@FindBy(xpath = "//button[@class='HeaderSearch-SubmitBtn']")
	private WebElement icnSearch;

	@FindBy(xpath = "//button[@class='HeaderAccount-Button']/label")
	private WebElement menuUserNameTop;

	@FindBy(xpath = "//a[contains(@class,'MyAccountSignedInOverlay-LinkHistory')]")
	private WebElement optionOrderHistory;

	@FindBy(xpath = "//a[contains(@class,'MyAccountSignedInOverlay-ReturnAnItem')]")
	private WebElement optionReturnHistory;

	@FindBy(xpath = "//div[@class='MyAccountOverlay-Buttons']/button[@class!='Button Button_isSignIn']")
	private WebElement btnSignUp;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmailID;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPwd;

	@FindBy(xpath = "//div[contains(@class,'MyAccountOverlay-Button_isCreateAccountButton')]/button")
	private WebElement btnCreateAccount;

	@FindBy(xpath = "//div[contains(@class,'HeaderMainSection')]//div[contains(@class,'HeaderWishlist')]/button")
	private WebElement lnkWishlist;

	@FindBy(xpath = "//div[@class='SearchSuggestion-Recommended']//li/a")
	private WebElement FirstSearchEle;

	@FindBy(xpath = "(//div[@class='aa-dataset-products']//div[@class='aa-suggestion'])[1]//span[@class='after_special']")
	private WebElement txtPriceInSearch;

	/* Footer Links */
	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'6th-street')]")
	private WebElement lnkAbout6thStreet;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'consumerrights')]")
	private WebElement lnkConsumerRights;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'disclaimer')]")
	private WebElement lnkDisclaimer;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'privacy-policy')]")
	private WebElement lnkPrivacyPolicy;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'shipping-policy')]")
	private WebElement lnkShippingInfo;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'return-information')]")
	private WebElement lnkReturnInfo;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'track')]")
	private WebElement lnkOrderTrack;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'faq')]")
	private WebElement lnkFAQs;

	@FindBy(xpath = "//div[@class='FooterMain-Nav']//a[contains(@href,'contact')]")
	private WebElement lnkFeedback;

	@FindBy(xpath = "//div[@class='FooterCustomerSupport']//a[contains(@href,'customercare')]")
	private WebElement lnkFooterCustomerCareMail;

	@FindBy(xpath = "//a[@class='FooterCustomerSupport-Phone']")
	private WebElement lblFooterCustomerCarePhoneNo;

	@FindBy(xpath = "//header//button[contains(@class,'InlineCustomerSupport-Button')]")
	private WebElement divCustomerService;

	@FindBy(xpath = "//div[@class='HeaderTopBar']//a[contains(@href,'customercare')]")
	private WebElement lnkCustomerServiceMail;

	@FindBy(xpath = "//div[@class='HeaderTopBar']//div[@class='InlineCustomerSupport-DisplayPhone']//a[contains(@href,'tel')]")
	private WebElement lblCustomerServicePhone;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//div[@class='GenderButton-Container']//a[contains(@href,'women')]/button")
	private WebElement lnkWomen;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//div[@class='GenderButton-Container']//a[contains(@href,'/men')]/button")
	private WebElement lnkMen;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//div[@class='GenderButton-Container']//a[contains(@href,'kids')]/button")
	private WebElement lnkKids;

	@FindBy(xpath = "//div[@class='DynamicContent']//img")
	private List<WebElement> lstBanners;

	@FindBy(xpath = "//div[contains(@class,'tns-slider') and contains(@class,'tns-carousel')]")
	private WebElement imgHeroBanner;

	@FindBy(xpath = "//div[@id='ori-chatbot-root']//img")
	private WebElement imgChatBot;

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

	@FindBy(xpath = "//div[@class='CategoryItem-Content']")
	private WebElement spinner;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//div[@class='GenderButton-Container']//a/button")
	private List<WebElement> lnkLevel1Categories;

	@FindBy(xpath = "//div[@class='DynamicContentBanner']//img")
	private List<WebElement> lstDynamicBanners;

	@FindBy(xpath = "//div[@class='DynamicContentGrid'][1]//div[@class='CategoryItem-Content']")
	private List<WebElement> lstTopCategoriesBanner;

	@FindBy(xpath = "//div[@class='DynamicContentGrid'][2]//div[@class='CategoryItem-Content']")
	private List<WebElement> lstBrandsBanner;

	@FindBy(xpath = "//div[@class='DynamicContentGrid'][3]//div[@class='CategoryItem-Content']")
	private List<WebElement> lstWhatsHotBanner;

	/**
	 * WebElement declaration ends here
	 **/

	public void searchProduct(String product) {
		commonMethods.clearAndSendKeys(txtSearchProduct, product, Keys.ENTER);
		log.info("submitting search term");
	}

	public void verifyHomePageDisplayed() {
		this.waitForBannerLoading();
		Assert.assertTrue(genericHelper.isDisplayed(imgHeroBanner));
		log.info("home page is loaded");
	}

	public void waitForBannerLoading() {
		waitHelper.staticWait(5000);
		waitHelper.waitForElementVisible(imgChatBot);
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
		commonMethods.moveToElementAndClick(txtSearchProduct);
		commonMethods.clearAndSendKeys(txtSearchProduct, product);
		log.info("Entering text in Search field");
	}

	public void clickHomeLogo() {
		commonMethods.moveToElementAndClick(imgHomeLogo);
		this.verifyHomePageDisplayed();
		log.info("Clicked on Home Logo");
	}

	public void clickOnWishlistInHeader() {
		commonMethods.click(lnkWishlist);
		log.info("clicked Wishlist in Header");
	}

	public void clickOnFirstItemSearchResult() {
		waitHelper.waitForElementVisible(FirstSearchEle);
		commonMethods.clickUsingJS(FirstSearchEle);
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
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(browserFactory.getDriver());
		eventFiringWebDriver.executeScript(
				"document.querySelector('div[class=\"MyAccountOverlay-Action MyAccountOverlay-Action_state_createAccount\"]').scrollTop=500");

		commonMethods.moveToElementAndClick(btnCreateAccount);

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
			commonMethods.moveToElementAndClick(divCustomerService);
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
		waitHelper.waitForElementVisible(imgHeroBanner);
		commonMethods.click(imgHeroBanner);
		log.info("clicked Main banner");
	}

	public void clickLevel1Category(String category) {
		this.category = category;
		if (category.equalsIgnoreCase("Women")) {
			commonMethods.click(lnkWomen);
			log.info("clicked Women L1 category");
		} else if (category.equalsIgnoreCase("Men")) {
			commonMethods.click(lnkMen);
			log.info("clicked Men L1 category");
		} else if (category.equalsIgnoreCase("Kids")) {
			commonMethods.click(lnkKids);
			log.info("clicked Kids L1 category");
		}
	}

	public void clickOnAllBannersAndVerifyPLP(String bannerType) {
		if (bannerType.equalsIgnoreCase("Dynamic")) {
			this.clickOnBannersAndVerifyPLP(lstDynamicBanners, "Required");
		} else if (bannerType.equalsIgnoreCase("TopCategories")) {
			this.clickOnBannersAndVerifyPLP(lstTopCategoriesBanner, "Required");
		} else if (bannerType.equalsIgnoreCase("Brands")) {
			this.clickOnBannersAndVerifyPLP(lstBrandsBanner, "Required");
		} else if (bannerType.equalsIgnoreCase("WhatsHot")) {
			this.clickOnBannersAndVerifyPLP(lstWhatsHotBanner, "Required");
		}
		searchPage.customAssertAll();
	}

	public void clickOnBannersAndVerifyPLP(List<WebElement> banner, String staticWait) {
		waitHelper.waitForElementToBeClickable(imgHeroBanner);
		if (staticWait.equalsIgnoreCase("Required")) {
			waitHelper.staticWait(10000);
			jsHelper.scrollToElement(lblFooterCustomerCarePhoneNo);
		}
		waitHelper.staticWait(5000);
		int bannerCount = banner.size();
		System.out.println(" Banner count: " + bannerCount);
		for (int i = 0; i < bannerCount; i++) {
			waitHelper.waitForElementVisible(imgHomeLogo);
			try {
				jsHelper.scrollToElement((banner.get(i)));
				commonMethods.moveToElementAndClick(banner.get(i));
				log.info("clicked banner " + (i + 1) + " of " + bannerCount);
			} catch (ElementClickInterceptedException e) {
				waitHelper.waitForElementToBeClickable(banner.get(i));
				commonMethods.clickUsingJS(banner.get(i));
				log.info("clicked banner " + (i + 1) + " of " + bannerCount);
			}
			waitHelper.staticWait(2000);
			searchPage.verifyPLP();
			waitHelper.staticWait(500);
			this.clickHomeLogo();
			waitHelper.staticWait(5000);
			if (!this.category.equalsIgnoreCase("Women")) {
				this.clickLevel1Category(this.category);
			}
		}
	}

	public void clickOnFooterLink(String footerLink) {
		waitHelper.staticWait(5000);
		if (footerLink.equalsIgnoreCase("About6thStreet")) {
			clickOnAbout6thStreetFooterLink();
		} else if (footerLink.equalsIgnoreCase("ConsumerRights")) {
			clickOnConsumerRightsFooterLink();
		} else if (footerLink.equalsIgnoreCase("Disclaimer")) {
			clickOnDisclaimerFooterLink();
		} else if (footerLink.equalsIgnoreCase("PrivacyPolicy")) {
			clickOnPrivacyPolicyFooterLink();
		} else if (footerLink.equalsIgnoreCase("ShippingInfo")) {
			clickOnShippingInfoFooterLink();
		} else if (footerLink.equalsIgnoreCase("ReturnInfo")) {
			clickOnReturnInfoFooterLink();
		} else if (footerLink.equalsIgnoreCase("OrderTrack")) {
			clickOnOrderTrackFooterLink();
		} else if (footerLink.equalsIgnoreCase("FAQs")) {
			clickOnFAQsFooterLink();
		} else if (footerLink.equalsIgnoreCase("Feedback")) {
			clickOnFeedbackFooterLink();
		}
	}

	public void verifyFooterLanding(String landingPage) {
		if (landingPage.equalsIgnoreCase("About6thStreet")) {
			footerLinks.verifyAbout6thStreetPage();
		} else if (landingPage.equalsIgnoreCase("ConsumerRights")) {
			footerLinks.switchToConsumerRightsPage();
			footerLinks.verifyConsumerRightsPage();
		} else if (landingPage.equalsIgnoreCase("Disclaimer")) {
			footerLinks.verifyDisclaimerPage();
		} else if (landingPage.equalsIgnoreCase("PrivacyPolicy")) {
			footerLinks.verifyPrivacyPolicyPage();
		} else if (landingPage.equalsIgnoreCase("ShippingPolicy")) {
			footerLinks.verifyShippingPolicyPage();
		} else if (landingPage.equalsIgnoreCase("ReturnInfo")) {
			footerLinks.verifyReturnInfoPage();
		} else if (landingPage.equalsIgnoreCase("OrderTracking")) {
			footerLinks.verifyTrackingPage();
		} else if (landingPage.equalsIgnoreCase("FAQs")) {
			footerLinks.verifyFAQsPage();
		} else if (landingPage.equalsIgnoreCase("Feedback")) {
			footerLinks.verifyFeedbackPage();
		}
	}

	public void verifyProductCategoryLinks() {
		TextFileHandler textFileHandler = new TextFileHandler();
		String filename = browserFactory.getCountry() + "_" + browserFactory.getLanguage() + "_brokenCategoryLinks";
		textFileHandler.deleteFile(filename);
		List<String> brokenLinks = new ArrayList<String>();
		int level1Size = lnkLevel1Categories.size();
		log.info("There Are Following Number Of Root Categories : " + level1Size);
		for (int i = 0; i < level1Size; i++) {
			commonMethods.moveToElementAndClick(lnkLevel1Categories.get(i));
			waitHelper.staticWait(5000);
			int level2Size = this.getLevel2Links().size();
			log.info("There Are Following Number Of Level 2 Categories : " + level2Size);
			for (int j = 0; j < level2Size; j++) {
				commonMethods.mouseHoverOn(this.getLevel2Links().get(j));
				int level3Size = this.getLevel3ProductLinks().size();
				log.info("There Are Following Number Of Level 3 Categories : " + level3Size);
				for (int k = 0; k < level3Size; k++) {
					waitHelper.waitForElementVisible(this.getLevel2Links().get(j));
					commonMethods.mouseHoverOn(this.getLevel2Links().get(j));
					try {
						commonMethods.moveToElementAndClick(this.getLevel3ProductLinks().get(k));
					} catch (org.openqa.selenium.TimeoutException e) {
						log.info("Broken Link Found");
						brokenLinks.add(browserFactory.getDriver().getCurrentUrl());
						textFileHandler.writeToFile(browserFactory.getDriver().getCurrentUrl(), filename);
					}
					if (!(new SearchPage().verifyProductsVisible())) {
						brokenLinks.add(browserFactory.getDriver().getCurrentUrl());
						textFileHandler.writeToFile(browserFactory.getDriver().getCurrentUrl(), filename);
					}
					this.clickHomeLogo();
					if (!commonMethods.getAttribute(lnkLevel1Categories.get(i), "class").contains("isCurrentGender")) {
						commonMethods.moveToElementAndClick(lnkLevel1Categories.get(i));
					}
				}
			}

		}
		Assert.assertTrue("Broken Category Links Were Found ", brokenLinks.size() == 0);
	}

	public void verifyBrandCategoryLinks() {
		TextFileHandler textFileHandler = new TextFileHandler();
		String filename = browserFactory.getCountry() + "_" + browserFactory.getLanguage() + "brokenBrandLinks";
		textFileHandler.deleteFile(filename);
		List<String> brokenLinks = new ArrayList<String>();
		int level1Size = lnkLevel1Categories.size();
		log.info("There Are Following Number Of Root Categories : " + level1Size);
		for (int i = 0; i < level1Size; i++) {
			commonMethods.moveToElementAndClick(lnkLevel1Categories.get(i));
			waitHelper.staticWait(5000);
			int level2Size = this.getLevel2Links().size();
			log.info("There Are Following Number Of Level 2 Categories : " + level2Size);
			for (int j = 0; j < level2Size; j++) {
				waitHelper.waitForElementVisible(this.getLevel2Links().get(j));
				commonMethods.mouseHoverOn(this.getLevel2Links().get(j));
				int level3Size = this.getLevel3BrandLinks().size();
				log.info("There Are Following Number Of Level 3 Categories : " + level3Size);
				for (int k = 0; k < level3Size; k++) {
					commonMethods.mouseHoverOn(this.getLevel2Links().get(j));
					try {
						commonMethods.moveToElementAndClick(this.getLevel3BrandLinks().get(k));
					} catch (org.openqa.selenium.TimeoutException e) {
						log.info("Broken Link Found");
						brokenLinks.add(browserFactory.getDriver().getCurrentUrl());
						textFileHandler.writeToFile(browserFactory.getDriver().getCurrentUrl(), filename);
					}
					if (!(new SearchPage().verifyProductsVisible())) {
						brokenLinks.add(browserFactory.getDriver().getCurrentUrl());
						textFileHandler.writeToFile(browserFactory.getDriver().getCurrentUrl(), filename);
					}
					this.clickHomeLogo();
					if (!commonMethods.getAttribute(lnkLevel1Categories.get(i), "class").contains("isCurrentGender")) {
						commonMethods.moveToElementAndClick(lnkLevel1Categories.get(i));
					}
				}
			}

		}
		Assert.assertTrue("Broken Brand Links Were Found ", brokenLinks.size() == 0);
	}

	public List<WebElement> getLevel2Links() {
		waitHelper.staticWait(3000);
		return browserFactory.getDriver().findElements(
				By.xpath("//div[contains(@class,'HeaderBottomBar-Content')]//div[contains(@class,'MenuCategory')]//a"));
	}

	public List<WebElement> getLevel3ProductLinks() {
		waitHelper.staticWait(1500);
		return browserFactory.getDriver()
				.findElements(By.xpath("//div[contains(@class,'MenuGrid-Column-Content')]/a/div/../../a"));
	}

	public List<WebElement> getLevel3BrandLinks() {
		waitHelper.staticWait(1500);
		return browserFactory.getDriver().findElements(By.xpath("//div[@class='MenuBrands']//a"));
	}

}
