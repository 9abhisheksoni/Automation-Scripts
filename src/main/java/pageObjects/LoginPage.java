package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Config;
import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import fileReader.JsonReader;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class LoginPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JsonReader jsonReader = new JsonReader();
	private Logger log = Logger.getLogger(LoginPage.class.getName());
	HomePage homePage = new HomePage();
	StringUtility stringUtility = new StringUtility();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();
	Config config = new Config();
	MagentoAllCustomersPage magentoAllCustomersPage = new MagentoAllCustomersPage();
	MagentoDashboardPage magentoDashboardPage = new MagentoDashboardPage();
	MagentoCustomerDetailsPage magentoCustomerDetailsPage = new MagentoCustomerDetailsPage();

	/**
	 * Constructor to initialize page objects
	 **/
	public LoginPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//span[@class='login-label']")
	private WebElement labelLoginOrRegister;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassword;

	@FindBy(css = "button#login_button")
	private WebElement btnLogin;

	@FindBy(xpath = "//span[@id='customer_name_top_menu']")
	private WebElement lblCustomerName;

	@FindBy(xpath = "//span[@id='customer_name_top_menu']")
	private WebElement lblCurrentCountry;

	@FindBy(css = "#customer-email")
	private WebElement txtGuestEmail;

	@FindBy(xpath = "//button[@class='action login primary button-guest']")
	private WebElement btnContinueAsGuest;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtMerchantEmail;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtMerchantPwd;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnMerchantLogin;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtMagentoUser;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtMagentoPwd;

	@FindBy(xpath = "//button[@class='action-login action-primary']")
	private WebElement btnMagentoLogin;

	@FindBy(xpath = "//button[@class='action-close']")
	private WebElement btnIncomingMessageCls;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtCheckoutSandboxEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtCheckoutSandboxPwd;

	@FindBy(xpath = "//button[@id='login-btn']")
	private WebElement btnCheckoutSandboxLogin;

	@FindBy(xpath = "//li[@class='product-item']//a[@data-role='remove']")
	private List<WebElement> iconWishlistRemove;

	@FindBy(xpath = "//a[@class='top-link-log-out-link']")
	private WebElement lnkLogout;
	
	@FindBy(xpath="//a[@class='top-link-address-link']")
	private WebElement lnkDeliveryAddress;
	
	@FindBy (xpath="//a[contains(@class,'delete')]")
	private List<WebElement> iconRemoveAddress;
	
	@FindBy (xpath="//button[contains(@class,'action-accept')]")
	private WebElement btnConfirmDelete;
	
	@FindBy (xpath="//button[@data-action='save-address']")
	private WebElement btnSaveAddress;
	
	@FindBy (xpath="//a[@class='action edit']/img")
	private WebElement lnkEditAddress;
	
	@FindBy (xpath="//div[@class='field choice set billing']/input[@type='checkbox']/following-sibling::label")
	private WebElement chkDefaultShippingAddress;
	
	@FindBy (xpath="//div[@class='box-content']//span[@class='default-shipping']")
	private WebElement lblDefaultAddress;
	
	@FindBy(xpath = "//span[@class='customer-name']")
    private WebElement txtCustomer;
    
    @FindBy(xpath = "//a[@class='top-link-ca-link']")
    private WebElement lnkClubApparelLoyalty;

    @FindBy(xpath = "//div[@class='club-logo']")
    private WebElement imgCALogo;

    @FindBy(xpath = "//div[@class='info-box box-main'][1]/div[1]/h3")
    private WebElement txtAvailLoyalty;
    
    @FindBy(xpath = "//div[@class='info-box box-main'][1]/div[2]/h3")
    private WebElement txtTiersBenefit;
    
    @FindBy(xpath = "//div[@class='info-box box-main'][1]/div[3]/h3")
    private WebElement txtRedValue;
    
    @FindBy(xpath = "//button[@id='LinkAccount']")
    private WebElement btnLINKYOURACCOUNT;
    
    @FindBy(xpath = "//div[@class='apparel-link']/p")
    private WebElement txtLinkYourCA;
    
    @FindBy(xpath = "//div[@class='iti__selected-dial-code']")
    private WebElement selCountryFlag;
    
    @FindBy(xpath = "//input[@id='country-search']")
    private WebElement txtSearchField;
    
    
    @FindBy(xpath = "//span[text()='']")
    private WebElement txtCountry;
    
    
    @FindBy(xpath = "//li[@class='iti__country iti__standard iti__highlight']")
    private WebElement txtSelectCountry;
    
    @FindBy(xpath = "//input[@name='mobileno']")
    private WebElement txtTelephone;
    
    @FindBy(xpath = "//button[@class='button submit primary sent_otp']")
    private WebElement btnLinkAccount;
    
    @FindBy(xpath = "//div[4]/div[2]/p[1]")
    private WebElement txtEnterOTP;
    
    @FindBy(xpath = "//tbody/tr[@class='totals balance ca-msg']")
    private WebElement txtLinkYourAccountCartMsg;
    
    @FindBy(xpath = "//div[@class='box-a1'][1]")
    private WebElement txtSecAboutClubApparel;
    
    @FindBy(xpath = "//div[@class='box-a1'][2]")
    private WebElement txtSecRewards;
    
    @FindBy(xpath="//li[@class='item My Account']")
    private WebElement lblMyAccount;
    
    @FindBy(xpath="//div[@class='content']//div[@class='store-credit-wrap']")
    private WebElement lblStoreCredit;
    
    @FindBy(xpath="//div[@class='content']//div[@class='store-credit-wrap']//span[@class='price']")
    private WebElement lblStoreCreditAmount;

	/**
	 * WebElement declaration ends here
	 **/

	public String getCurrentCountry() {
		currCountry = lblCurrentCountry.getText();
		if (currCountry.equalsIgnoreCase("UAE")) {
			currCountry = "United Arab Emirates";
			return currCountry;
		}
		log.info("returning current country : " + currCountry);
		return currCountry;
	}

	public void clickOnLoginOrRegisterOption() {
		new HomePage().waitForBannerLoading();
		commonMethods.moveToElementAndClick(this.labelLoginOrRegister);
		log.info("login or registered label in header clicked");
	}

	
	public void inputUserName(String userType) {
		commonMethods.clearAndSendKeys(this.txtUserName, jsonReader.getUserName(userType));
		browserFactory.setLoggedInUserEmail(jsonReader.getUserName(userType));
		log.info("entered user email");
	}

	public void inputPassword(String userType) {
		commonMethods.clearAndSendKeys(this.txtPassword, jsonReader.getPassword(userType));
		log.info("entered user password");
	}

	public void clickLoginButton() {
		commonMethods.click(btnLogin);
		log.info("login button clicked");
		waitHelper.staticWait(10);
		if (commonMethods.isElementPresent(labelLoginOrRegister)) {
			commonMethods.refresh();
		}
	}

	public void verifyLogin() {
		if (commonMethods.isElementPresent(labelLoginOrRegister)) {
			commonMethods.refresh();
		}
		Assert.assertTrue(genericHelper.isDisplayed(lblCustomerName));
		log.info("login is successfull");
	}

	public void enterLoginDetails(String username, String password) {
		this.inputUserName(username);
		this.inputPassword(password);
		log.info("Entered user credentials");
	}

	public void loginDetails(String username, String password) {
		this.enterLoginDetails(username, password);
		this.clickLoginButton();
		log.info("login submitted");
	}

	public void enterGuestEmail(String email) {
		this.inputGuestUserEmail(email);
		log.info("entered guest email");
	}

	public void inputGuestUserEmail(String guestuserType) {
		String guestUserName;
		if(guestuserType.equalsIgnoreCase("tempUser")) {
			guestUserName=new StringUtility().generateRandomEmailID();
		}else {
			guestUserName=jsonReader.getUserName(guestuserType);
		}
		commonMethods.clearAndSendKeys(this.txtGuestEmail, guestUserName);
	}

	public void clickOnContinueAsGuest() {
		commonMethods.click(btnContinueAsGuest);
		log.info("clicked continue as guest");
	}

	public void enterMerchangtEmailandPwd(String merchantEmail, String merchnatPwd) {
		this.inputMerchantEmailandPwd(merchantEmail, merchnatPwd);

		log.info("entered merchant details");
	}

	public void inputMerchantEmailandPwd(String merchantEmailType, String merchantPwdType) {
		commonMethods.clearAndSendKeys(this.txtMerchantEmail, jsonReader.getUserName(merchantEmailType));
		commonMethods.clearAndSendKeys(this.txtMerchantPwd, jsonReader.getPassword(merchantPwdType));
	}

	public void clickOnMerchantLogin() {
		commonMethods.click(btnMerchantLogin);
		log.info("clicked merchant login");
	}

	public void enterMagnetoUserandPwd(String magentoEmail, String magentoPwd) {
		this.inputMagentoEmailandPwd(magentoEmail, magentoPwd);
		log.info("entered magento details");
	}

	public void inputMagentoEmailandPwd(String magentoUserType, String magentoPwdType) {
		commonMethods.clearAndSendKeys(this.txtMagentoUser, jsonReader.getUserName(magentoUserType));
		commonMethods.clearAndSendKeys(this.txtMagentoPwd, jsonReader.getPassword(magentoPwdType));
	}

	public void clickOnMagentoLogin() {
		commonMethods.click(btnMagentoLogin);
		log.info("clicked magento login");
	}

	public void waitForMagentoDashBoard() {
		if (commonMethods.isElementPresent(btnIncomingMessageCls)) {
			commonMethods.click(btnIncomingMessageCls);
			waitHelper.waitForElementInVisiblity(btnIncomingMessageCls);
		}
		waitHelper.waitForElementInVisiblity(btnIncomingMessageCls);
	}

	public void inputUserNameFromFeature(String userName) {
		commonMethods.clearAndSendKeys(this.txtUserName, userName);
		log.info("entered user email");
	}

	public void inputPasswordFromFeature(String password) {
		commonMethods.clearAndSendKeys(this.txtPassword, password);
		log.info("entered user password");
	}

	public void enterLoginDetailsFromFeature(String username, String password) {
		this.inputUserNameFromFeature(username);
		this.inputPasswordFromFeature(password);
		log.info("Entered user credentials");
	}

	public void inputCheckoutSandboxEmailandPwd(String checkoutEmailType, String checkoutPwdType) {
		commonMethods.clearAndSendKeys(this.txtCheckoutSandboxEmail, jsonReader.getUserName(checkoutEmailType));
		commonMethods.clearAndSendKeys(this.txtCheckoutSandboxPwd, jsonReader.getPassword(checkoutPwdType));
	}

	public void enterCheckoutSandboxUserandPwd(String checkoutEmail, String checkoutPwd) {
		this.inputCheckoutSandboxEmailandPwd(checkoutEmail, checkoutPwd);
		log.info("entered Checkout Sandbox details");
	}

	public void clickOnCheckoutSandboxLogin() {
		commonMethods.click(btnCheckoutSandboxLogin);
		log.info("clicked Checkout Sandbox login");
	}

	public void clearWishlist() {
		homePage.clickOnWishlistInHeader();
		int removeiconWishlistCount = iconWishlistRemove.size();
		for (int i = 0; i < removeiconWishlistCount; i++) {
			commonMethods.click(iconWishlistRemove.get(0));
			log.info("Wishlist remove icon clicked");
		}
	}

	public void verifyWishlistProductAdded() {
		homePage.clickOnWishlistInHeader();
		Assert.assertEquals(iconWishlistRemove.size(), 1);
		log.info("Wishlist has 1 product");
	}

	public void clickLogoutLink() {
		commonMethods.click(lblCustomerName);
		commonMethods.click(lnkLogout);
		log.info("logout link clicked");
	}

	public void verifySuccessfulLogout() {
		genericHelper.isDisplayed(labelLoginOrRegister);
		log.info("Logout successfull");
	}
	
	public void clearSavedAddress() {
		commonMethods.click(lblCustomerName);
		commonMethods.click(lnkDeliveryAddress);
		this.deleteAllSavedAddress();
	}
	
	public void saveAddress() {
		ShippingPage shippingPage = new ShippingPage();
		String country = browserFactory.getCountry().toLowerCase();
		log.info("Enter address manually");
		shippingPage.submitShippingAddress(country);
		commonMethods.click(btnSaveAddress);
		log.info("Save address button is clicked");
		}
	
	public void verifyAddressSaved() {
		Assert.assertEquals(iconRemoveAddress.size(),1);
		log.info("address Saved successfully");
	}
	
	public void editAndMakeAddressDefault() {
		ShippingPage shippingPage = new ShippingPage();
		commonMethods.click(lnkEditAddress);
		shippingPage.editAndEnterFirstName("Default Address");
		commonMethods.click(chkDefaultShippingAddress);
		log.info("Default Address checkbox is selected");
		commonMethods.click(btnSaveAddress);
		log.info("Save address button is clicked");
	}
	
	public void verifyAddressDefaulted() {
		this.verifyAddressSaved();
		Assert.assertTrue(genericHelper.isDisplayed(lblDefaultAddress));
		log.info("Default address is Updated successfully");
	}
	
	public void deleteAllSavedAddress() {
		int removeAddressCount = iconRemoveAddress.size();
		for (int i = 0; i < removeAddressCount; i++) {
			commonMethods.moveToElementAndClick(iconRemoveAddress.get(0));
			commonMethods.click(btnConfirmDelete);
			log.info("Address deleted");
		}	
	}
	
	public void verifyEmptyAddressBook() {
		Assert.assertEquals(iconRemoveAddress.size(), 0);
		log.info("Address book is empty");
	}
	
	public void clickCustomer() {
		commonMethods.click(txtCustomer);
		log.info("customer is clicked");
	} 
    

    public void clickClubApparelLoyalty() {
		commonMethods.click(lnkClubApparelLoyalty);
		log.info("Club Apparel Loyalty is clicked");
	}
    
    
	public void verifyCLubApparelLogoDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(imgCALogo));
		log.info("Club Apparel Logo is displayed");
	}
    
	public void verifyAvailLoyaltyDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(txtAvailLoyalty));
		log.info("AVAIL LOYALTY BENEFITS ON 6THSTREET is displayed");
	}
	
	public void verifyTierBenifitDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(txtTiersBenefit));
		log.info("TIERS BENEFIT is displayed");
	}
	
	public void verifyRedemptionValueDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(txtRedValue));
		log.info("REDEMPTION VALUE is displayed");
	}
	
	public void verifyLinkYourAccountButtonDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(btnLINKYOURACCOUNT));
		log.info("LINK YOUR Account button is displayed");
	}
	
	public void verifyLinkYourCADisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(txtLinkYourCA));
		log.info("Link your Club Apparel account and start earning points is displayed");
	}
	
	
	public void clickOnLINKYOURAcct() {
		commonMethods.click(btnLINKYOURACCOUNT);
		log.info("LINK YOUR Account button is clicked");
	}
	
	
	public void clicOnCountryFlag() {
		commonMethods.click(selCountryFlag);
		log.info("Country Flag is clicked");
	}
	
	public void clickOnSearchField() {
		commonMethods.click(txtSearchField);
		log.info("Country search field is clicked");
	}
	
	public void inputCountryFlag(String countryFlag) {
		commonMethods.sendKeys(txtSearchField, countryFlag);
		commonMethods.click(browserFactory.getDriver().findElement(By.xpath("//span[text()='"+countryFlag+"']")));
		
		log.info("Country is entered");
	}
	

	public void inputTelephoneNumber(String tele) {
		commonMethods.sendKeys(txtTelephone, tele);
		log.info("Telephone Number is entered");
	}
	
	public void clickOnLinkAccount() {
		commonMethods.click(btnLinkAccount);
		log.info("Link Account is clicked");
	}
	
	public void verifyEntertheVerificationCode() {
		commonMethods.click(txtEnterOTP);
		log.info("Enter the verification code we sent to is displayed");
	}
	
	
	public void verifyLinkyourAccountMsg() {
		Assert.assertTrue(genericHelper.isDisplayed(txtLinkYourAccountCartMsg));
		log.info("LINK YOUR Account message in cart is displayed");
	}
	
	public void verifyAboutClubApparelSec() {
		Assert.assertTrue(genericHelper.isDisplayed(txtSecAboutClubApparel));
		log.info("About club apparel section is displayed");
	}
	
	public void verifyRewardsSec() {
		Assert.assertTrue(genericHelper.isDisplayed(txtSecRewards));
		log.info("Rewards section is displayed");
	}
	
	public int getStoreCredit() {
		int storeCreditValue = 0;
		if(genericHelper.isDisplayed(lblMyAccount)) {
			if(genericHelper.isDisplayed(lblStoreCredit)) {
				storeCreditValue = stringUtility.getPriceValue(commonMethods.getText(lblStoreCreditAmount));
				System.out.println("storeCreditValue" +storeCreditValue);
			}
		}
		log.info("obtained Store Credit Value: "+storeCreditValue);
		return storeCreditValue;
	}
	
	public void verifyStoreCreditAvailability(String MagentoURL, String magentoUser, String magentoPwd) {
		int storeCredit  = this.getStoreCredit();
		if(storeCredit>0) {
			log.info("Store Credit is available");
		}else {
			orderSuccess.controlT();
			orderSuccess.launchURL(config.getMagentoURL(MagentoURL));
			this.enterMagnetoUserandPwd(magentoUser, magentoPwd);
			this.clickOnMagentoLogin();
			this.waitForMagentoDashBoard();
			magentoDashboardPage.navigateToCustomersPage();
			magentoAllCustomersPage.navigateToCustomerDetailsPage();
			magentoCustomerDetailsPage.updateStoreCreditBalance();	
			genericHelper.switchToBaseWindow();
		}
	}

}
