package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
	SearchPage searchPage = new SearchPage();
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
	@FindBy(xpath = "//button[@class='MyAccountAddressBook-NewAddress button primary small']")
	private WebElement btnNewAddress;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='street']")
	private WebElement txtStreetAddress;

	@FindBy(id = "city")
	private WebElement drpdwnCity;

	@FindBy(id = "region_string")
	private WebElement drpdwnArea;

	@FindBy(xpath = "//input[@id='telephone']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//div[@class='CheckoutShippingStep-DeliveryButton']/button")
	private WebElement btnDeliverToAddress;

	@FindBy(xpath = "//button[contains(normalize-space(@class),'MyAccountBtn button primary')]")
	private WebElement btnSaveAddress;

	@FindBy(className = "CheckoutAddressBook-Wrapper")
	private WebElement sectionSaveAddresses;

	@FindBy(xpath = "//div[@class='MyAccountAddressCard MyAccountAddressCard_isSelected']")
	private WebElement sectionSelectedAddress;

	@FindBy(xpath = "//div[@class='MyAccountAddressTable ']/div[contains(@class,'MyAccountAddressCard')]")
	private List<WebElement> listSavedShippingAddress;

	@FindBy(className = "MyAccountAddressCard-City")
	private List<WebElement> listSavedShippingAddressCity;

	@FindBy(xpath = "//div[@class='preventAddress mage-error']")
	private WebElement msgSavedShippingAddressError;

	@FindBy(xpath = "//div[@class='original-price']/span")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//div[@class='price with-discount']/span")
	private WebElement txtSpecialPrice;
	
	@FindBy(xpath = "//div[@class='Loader']//img[@class='Loader-Main']")
	public	WebElement checkoutSpinner;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickNewAddress() {
		commonMethods.click(btnNewAddress);
	}

	public void clickNewAddressToSave() {
		commonMethods.click(btnNewAddress);
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
		commonMethods.SelectJSUsingValue(drpdwnCity, json.getCity(country));
		log.info("City is selected");
	}

	public void selectArea(String country) {
		commonMethods.SelectJSUsingValue(drpdwnArea, json.getArea(country));
		log.info("Area is selected");
	}

	public void enterPhoneNumber(String country) {
		commonMethods.clearAndSendKeys(txtPhoneNumber, json.getContactnumber(country));
		log.info("Phone Number is entered");
	}

	public void clickDeliverToAddress() {
		waitHelper.waitForSpinnerInvisibility();
		commonMethods.click(btnDeliverToAddress);
		log.info("Delivered to this adrress button is clicked");
	}

	public void selectSavedAddress() {
		String country = browserFactory.getCountry().toLowerCase();
		if (listSavedShippingAddress.size() > 0) {
			this.submitSavedAddress(country);
		} else {
			log.info("Enter address manually");
			this.submitShippingAddress(country);
			this.clickDeliverToAddress();
		}
	}

	private void submitSavedAddress(String country) {
		for (int i = 0; i < listSavedShippingAddress.size(); i++) {
			if (commonMethods.getAttribute(listSavedShippingAddressCity.get(i), "innerHTML")
					.contains(this.getCurrentCountry())) {
				log.info("Selecting a saved address radio");
				commonMethods.moveToElementAndClick(listSavedShippingAddress.get(i));
				log.info("Clicked " + this.getCurrentCountry() + " address radio button");
				break;
			} else if (i == listSavedShippingAddress.size() - 1) {
				log.info("no saved address for selected country");
				this.saveNewAddress(country);
			}
		}
		this.clickDeliverToAddress();
	}

	private CharSequence getCurrentCountry() {
		String env = browserFactory.getCountry();
		String country = "";
		if (env.equalsIgnoreCase("UAE")) {
			country = "AE";
		} else if (env.equalsIgnoreCase("KSA")) {
			country = "SA";
		} else if (env.equalsIgnoreCase("KW")) {
			country = "KW";
		} else if (env.equalsIgnoreCase("QA")) {
			country = "QA";
		} else if (env.equalsIgnoreCase("OM")) {
			country = "OM";
		} else if (env.equalsIgnoreCase("BH")) {
			country = "BH";
		}
		return country;
	}

	private void saveNewAddress(String country) {
		this.clickNewAddress();
		this.submitShippingAddress(country);
		commonMethods.click(btnSaveAddress);
	}

	public void submitShippingAddress(String country) {
		this.enterFirstName(country);
		this.enterLastName(country);
		this.enterAddress(country);
		this.selectCity(country);
		this.selectArea(country);
		this.enterPhoneNumber(country);
	}

	public void editAndEnterFirstName(String firstName) {
		commonMethods.clearAndSendKeys(txtFirstName, firstName);
		log.info("First Name is Modified");
	}

	public void fillShippingForm() {
		String country = browserFactory.getCountry().toLowerCase();
		log.info("Enter address manually");
		this.submitShippingAddress(browserFactory.getCountry().toLowerCase());
		commonMethods.click(btnSaveAddress);
		this.submitSavedAddress(country);
	}

	/*
	 * This method fetches the base_price displaying for an item in the Shipment
	 */
	public String getBasePriceAtShipping() {
		String basePrice = null;
		log.info("Fethcing the basebrice of the item in the Shipping");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);

		log.info("The base price at Shipment is" + basePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode) + 3);
		log.info("The extracted base price at Shipment is" + basePrice);
		return basePrice.trim();
	}

	/*
	 * This method compares the base_price displaying at Shipment with the
	 * actual_price provided by the user
	 */
	public void evaluateBasePriceAtShipping(String actualBasePrice) {
		log.info("Comparing the base_price displaying at Shipping with the actual base_price provided by the user");
		log.info("The base_price provided by the user is " + actualBasePrice);
		log.info("The base_price available in the Shipping is " + getBasePriceAtShipping());
		assertEquals(getBasePriceAtShipping(), actualBasePrice, "The base_price is matching");
	}

	/*
	 * This method compares the base_price displaying at Shipment with the
	 * base_price fetched at PLP
	 */
	public void evaluateBasePriceAtShipping() {
		log.info("Comparing the base_price displaying at Shipping with the base_price fetched at PLP");
		log.info("The base_price available in the Shipping is " + getBasePriceAtShipping());
		assertEquals(getBasePriceAtShipping(), searchPage.globalBasePrice, "The base_price is matching");
	}

	public String getSpecialPriceAtShipping() {
		log.info("Fethcing the special of the item in the Shipping");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);

		log.info("The special price at PLP is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted special price at PLP is" + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at Shipment with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtShipping(String actualSpecialPrice) {
		log.info("Comparing the special_price displaying at Shipping with the actual values");
		assertEquals(getSpecialPriceAtShipping(), actualSpecialPrice, "The special_price is matching at Shipping");
	}

	/*
	 * This method compares the special_price displaying at Shipment with with
	 * fetched special_price at PLP
	 */
	public void evaluateSpecialPriceAtShipping() {
		log.info("Comparing the special_price displaying at Shipping with the special price fetched at PLP");
		assertEquals(getSpecialPriceAtShipping(), searchPage.globalSpecialPrice,
				"The special_price is matching at Shipping");
	}
}
