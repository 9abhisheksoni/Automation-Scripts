package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import fileReader.JsonReader;
import testRunner.CucumberRunner;

public class ShippingPage extends CucumberRunner {

	/**
	 * Class Objects declaration
	 **/
	JsonReader json = new JsonReader();
	LoginPage login = new LoginPage();
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(ShippingPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public ShippingPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//button[@class='action action-show-popup add_new_address']")
	private WebElement btnNewAddress;

	@FindBy(xpath = "//input[@name='firstname' and @class='input-text']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname' and @class='input-text']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@name='street[0]']")
	private WebElement txtStreetAddress;

	@FindBy(xpath = "//select[@name='city']")
	private WebElement drpdwnCity;

	@FindBy(xpath = "//select[@name='postcode']")
	private WebElement drpdwnArea;

	@FindBy(xpath = "//select[@name='cn_carriercode']")
	private WebElement drpdwnCarrierCode;

	@FindBy(xpath = "//input[@name='contact' and @type='text']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//button[@class='button action continue primary']")
	private WebElement btnDeliveryAddress;

	@FindBy(xpath = "//div[@id='checkout-loader' or @class='loading-mask']")
	WebElement checkoutSpinner;

	@FindBy(xpath = "//input[@id = 'shipping-save-in-address-book' and @type='checkbox']")
	private WebElement chkSaveAddressCheckbox;

	@FindBy(xpath = "//div[contains(@class,'shipping-address-item')]")
	private WebElement sectionSaveAddresses;

	@FindBy(xpath = "//button[@class='action primary action-save-address']")
	private WebElement btnSaveAddress;

	@FindBy(xpath = "//button[@class='action secondary action-hide-popup']")
	private WebElement btnCancelAddressPopUp;

	@FindBy(xpath = "//div[@class='shipping-address-item selected-item']")
	private WebElement sectionSelectedAddress;

	@FindBy(xpath = "//div[@class='shipping-address-items']//div")
	private List<WebElement> listSavedShippingAddress;

	@FindBy(xpath = "//div[@class='shipping-address-items']//div/input")
	private List<WebElement> radioSavedShippingAddress;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickNewAddress() {
		waitHelper.waitForSpinnerInvisibility(checkoutSpinner);
		if (commonMethods.isElementPresent(sectionSaveAddresses)) {
			waitHelper.waitForElementVisible(btnDeliveryAddress);
			commonMethods.click(btnNewAddress);
		}
	}

	public void enterFirstName(String country) {
		commonMethods.clearAndSendKeys(txtFirstName, json.getFirstName(country));
		log.info("First Name is entered");
	}

	public void enterLastName(String country) {
		commonMethods.clearAndSendKeys(txtLastName, json.getLastName(country));
		log.info("Last Name is entered");
	}

	public void enterAddress(String country) {
		commonMethods.clearAndSendKeys(txtStreetAddress, json.getStreet(country));
		log.info("Address is entered");
	}

	public void selectCity(String country) {
		log.info("City is Value " + json.getCity(country));
		commonMethods.SelectUsingValue(drpdwnCity, json.getCity(country));
		log.info("City is selected");
	}

	public void selectArea(String country) {
		commonMethods.SelectUsingValue(drpdwnArea, json.getArea(country));
		log.info("Area is selected");
	}

	public void selectCarrierCode(String country) {
		commonMethods.SelectUsingValue(drpdwnCarrierCode, json.getCareerCode(country));
		log.info("Carrier Code is selected");
	}

	public void enterPhoneNumber(String country) {
		commonMethods.clearAndSendKeys(txtPhoneNumber, json.getContactnumber(country));
		log.info("Phone Number is entered");
	}

	public void clickDeliverToAddress() {
		if (commonMethods.isElementPresent(btnSaveAddress)) {
			commonMethods.click(btnSaveAddress);
		}
		try {
			if (commonMethods.isElementPresent(radioSavedShippingAddress.get(0))) {
				waitHelper.waitForSpinnerInvisibility(checkoutSpinner);
			}
		} catch (Exception e) {
			log.info("no saved address present");
		}
		commonMethods.click(btnDeliveryAddress);
		log.info("Delivered to this adrress button is clicked");
	}

	public void selectSavedAddress(String country) {
		for (int i = 0; i < listSavedShippingAddress.size(); i++) {
			if (commonMethods.getAttribute(listSavedShippingAddress.get(i), "innerHTML").contains(currCountry)) {
				try {
					log.info("Waiting for spinner disappear");
					Thread.sleep(6000);
				} catch (Exception e) {
					log.info("spinner not displayed");
				}
				commonMethods.moveToElementAndClick(radioSavedShippingAddress.get(i));
				log.info("Clicked UAE address radio button");
				this.clickDeliverToAddress();
				break;
			} else {
				this.clickNewAddress();
				this.submitShippingAddress(country);
			}
		}

	}

	public void submitShippingAddress(String country) {
		this.enterFirstName(country);
		this.enterLastName(country);
		this.enterAddress(country);
		this.selectCity(country);
		this.selectArea(country);
		this.selectCarrierCode(country);
		this.enterPhoneNumber(country);
		this.clickDeliverToAddress();
	}

	public void clickSaveAddressCheckbox() {
		if (commonMethods.isElementPresent(sectionSaveAddresses)) {
			commonMethods.click(chkSaveAddressCheckbox);
			log.info("clicked saved address checkbox");
		}
	}

	public void clickCancelButton() {
		if (commonMethods.isElementPresent(btnSaveAddress)) {
			commonMethods.click(btnCancelAddressPopUp);
			log.info("clicked cancel save address popup");
		}
	}
}
