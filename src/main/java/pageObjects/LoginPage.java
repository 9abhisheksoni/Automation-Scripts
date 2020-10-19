package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
