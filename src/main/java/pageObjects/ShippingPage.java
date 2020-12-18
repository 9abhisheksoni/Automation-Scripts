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

	@FindBy(xpath = "//input[@name='firstname' and contains(@class,'input-text')]")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname' and contains(@class,'input-text')]")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[contains(@name,'street')]")
	private WebElement txtStreetAddress;

	@FindBy(xpath = "//select[@name='city']")
	private WebElement drpdwnCity;

	@FindBy(xpath = "//select[@name='postcode']")
	private WebElement drpdwnArea;

	@FindBy(xpath = "//select[@name='cn_carriercode']")
	private WebElement drpdwnCarrierCode;

	@FindBy(xpath = "//input[contains(@name,'contact') and @type='text']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//button[@class='button action continue primary']")
	private WebElement btnDeliverToAddress;

	@FindBy(xpath = "//div[@id='checkout-loader' or @class='loading-mask' or @data-role='spinner']")
	public	WebElement checkoutSpinner;

	@FindBy(xpath = "//input[@id = 'shipping-save-in-address-book' and @type='checkbox']")
	private WebElement chkSaveAddressCheckbox;

	@FindBy(xpath = "//div[contains(@class,'shipping-address-item')]")
	private WebElement sectionSaveAddresses;

	@FindBy(xpath = "//button[@class='action primary action-save-address']")
	private WebElement btnSaveAddress;

	@FindBy(xpath = "//button[@class='action secondary action-hide-popup']")
	private WebElement btnCancelAddressPopUp;
	
	
	@FindBy(xpath = "//h1/following-sibling::button[@class='action-close']")
	private WebElement iconCancelAddressPopUp;

	@FindBy(xpath = "//div[@class='shipping-address-item selected-item']")
	private WebElement sectionSelectedAddress;

	@FindBy(xpath = "//div[@class='shipping-address-items']//div")
	private List<WebElement> listSavedShippingAddress;

	@FindBy(xpath = "//div[@class='shipping-address-items']//div/input")
	private List<WebElement> radioSavedShippingAddress;
	
	@FindBy(xpath = "//div[@class='preventAddress mage-error']")
	private WebElement msgSavedShippingAddressError;
	
	/**
	 * WebElement declaration ends here
	 **/

	public void clickNewAddress() {
			commonMethods.click(btnNewAddress);
			this.deSelectSaveAddressCheckbox();
	}
	
	public void clickNewAddressToSave() {
		commonMethods.click(btnNewAddress);
		this.selectSaveAddressCheckbox();
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
		waitHelper.waitForElementVisible(drpdwnArea);
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
		commonMethods.click(btnDeliverToAddress);
		log.info("Delivered to this adrress button is clicked");
	}

	public void selectSavedAddress() {
		String country = browserFactory.getCountry().toLowerCase();
		if(listSavedShippingAddress.size()>0) {
			this.submitSavedAddress(country);
		}  else {
			log.info("Enter address manually");
			this.submitShippingAddress(country);
			this.clickDeliverToAddress();
		}
	}
	
	private void submitSavedAddress(String country) {
		for (int i = 0; i < listSavedShippingAddress.size(); i++) {
			if (commonMethods.getAttribute(listSavedShippingAddress.get(i), "innerHTML").contains(this.getCurrentCountry())) {
				log.info("Selecting a saved address radio");
				commonMethods.moveToElementAndClick(radioSavedShippingAddress.get(i));
				log.info("Clicked "+this.getCurrentCountry()+" address radio button");
				break;
			} else if (i==listSavedShippingAddress.size()-1) {
				log.info("no saved address for selected country");
				this.saveNewAddress(country);
			}
		} 		
		waitHelper.waitForSpinnerInvisibility();
		this.clickDeliverToAddress();
	}

	private CharSequence getCurrentCountry() {
		String env = browserFactory.getCountry();
		String country = "";
		if (env.equalsIgnoreCase("UAE")) {
			country = "United Arab Emirates";
		} else if (env.equalsIgnoreCase("KSA")) {
			country = "Saudi Arabia";
		} else if (env.equalsIgnoreCase("KW")) {
			country = "Kuwait";
		}else if (env.equalsIgnoreCase("QA")) {
			country = "Qatar";
		}else if (env.equalsIgnoreCase("OM")) {
			country = "Oman";
		}else if (env.equalsIgnoreCase("BH")) {
			country = "Bahrain";
		}
		return country;
	}

	private void saveNewAddress(String country) {
		this.clickNewAddress();
		this.deSelectSaveAddressCheckbox();
		this.submitShippingAddress(country);
		commonMethods.click(btnSaveAddress);
	}
	
	public void submitShippingAddress(String country) {
		this.enterFirstName(country);
		this.enterLastName(country);
		this.enterAddress(country);
		this.selectCity(country);
		this.selectArea(country);
		this.selectCarrierCode(country);
		this.enterPhoneNumber(country);
	}

	public void selectSaveAddressCheckbox() {
			if (!commonMethods.isSelected(chkSaveAddressCheckbox)) {
			commonMethods.click(chkSaveAddressCheckbox);
			log.info("save address checkbox is selected");
			} else {
				log.info("Save address checkbox already selected");
			}
	}
	
	public void deSelectSaveAddressCheckbox() {
		if (commonMethods.isSelected(chkSaveAddressCheckbox)) {
		commonMethods.click(chkSaveAddressCheckbox);
		log.info("deselected saved address checkbox");
		} else {
			log.info("Save address checkbox already deselected");
		}
}

	public void clickCancelButton() {
		if (commonMethods.isElementPresent(btnSaveAddress)) {
			waitHelper.waitForSpinnerInvisibility();
			commonMethods.click(btnCancelAddressPopUp);
			log.info("clicked cancel save address popup");
		}
	}
	
	public void editAndEnterFirstName(String firstName) {
		commonMethods.clearAndSendKeys(txtFirstName, firstName);
		log.info("First Name is Modified");
	}
	
	public void fillShippingForm() {
		log.info("Enter address manually");
		this.submitShippingAddress(browserFactory.getCountry().toLowerCase());
		this.clickDeliverToAddress();
	}
}
