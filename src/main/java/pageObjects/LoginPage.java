package pageObjects;

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

public class LoginPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JsonReader jsonReader = new JsonReader();
	private Logger log = Logger.getLogger(LoginPage.class.getName());

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
		commonMethods.click(this.labelLoginOrRegister);
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
		commonMethods.clearAndSendKeys(this.txtGuestEmail, jsonReader.getUserName(guestuserType));
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
}
