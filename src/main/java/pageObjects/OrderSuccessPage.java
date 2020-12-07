package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class OrderSuccessPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	SearhPage searchPage = new SearhPage();
	private Logger log = Logger.getLogger(OrderSuccessPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public OrderSuccessPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//div[@class='checkout-success']/div[@class='title']")
	private WebElement msgthankYou;

	@FindBy(xpath = "//div[@class='order-number']")
	private WebElement msgordernumber;

	@FindBy(xpath = "//a[@class='check_button']")
	private WebElement btncontinueShopping;

	@FindBy(xpath = "//div[@class='box-order-billing-method']//div[@class='box-content']")
	private WebElement msgpaymentMethod;

	@FindBy(xpath = "//div[@class='Payments__paymentsTable--ee1']//tbody//tr//td//span")
	private List<WebElement> lstMerchantDetails;

	@FindBy(xpath = "//div[@class='Payments__paymentsTable--ee1']//tbody//tr//td//span")
	private WebElement waitMerchantDetails;

	@FindBy(xpath = "//div[@class='Payments__paymentsTable--ee1']//tbody//tr//td/div")
	private List<WebElement> lstMerchantDetailsAmount;

	@FindBy(xpath = "//input[@class='Search__input--bb1']")
	private WebElement txtMerchantSearch;
	
	
	@FindBy (xpath = "//span[@class='old-price']")
	private WebElement txtBasePrice;
	
	@FindBy (xpath = "//span[@class='special-price']")
	private WebElement txtSpecialPrice;
	

	/**
	 * WebElement declaration ends here
	 **/

	public void isOrderSuccessFull() {
		new WaitHelper().waitForElementVisible(msgthankYou);
		Assert.assertTrue(genericHelper.isDisplayed(msgthankYou));
		browserFactory.setOrder(this.getOrderNumber());
		log.info("Order Successfully Placed");
	}

	public String getOrderNumber() {
		String ordernumber = commonMethods.getText(msgordernumber);
		int order = new StringUtility().getIntValue(ordernumber);
		log.info("Order Placed : " + ordernumber);
		return Integer.toString(order);
	}

	public void clickOnContinueShopping() {
		commonMethods.click(btncontinueShopping);
		log.info("clicked continue shopping");
	}

	public String getPaymentMethod() {
		log.info("returning payment method");
		return commonMethods.getText(msgpaymentMethod);
	}

	public void controlT() {

		commonMethods.keyPressControlTab();

	}

	public void launchURL(String merchantURL) {
		String parent = genericHelper.getWindowHandle();
		for (String handle : genericHelper.getWindowHandles()) {

			genericHelper.switchToWindow(handle);
		}

		// Do some operation on child window and get child window handle.
		String child = genericHelper.getWindowHandle();

		// switch to child window of 1st child window.
		for (String winChildHandle : genericHelper.getWindowHandles()) {
			// Switch to child window of the 1st child window.
			if (!winChildHandle.equals(parent) && !winChildHandle.equals(child)) {
				genericHelper.switchToWindow(child);
			}
			commonMethods.navigate(merchantURL);
		}

	}

	public void inputmerchantOrder() {
		String tabbyOrderNo = browserFactory.getOrderNumber();
		new WaitHelper().waitForElementVisible(txtMerchantSearch);
		commonMethods.clearAndSendKeys(txtMerchantSearch, tabbyOrderNo, Keys.ENTER);
	}

	public void listMerchantOrderDetails(String country, String status) {

		try {
			Thread.sleep(1000);
			if (waitMerchantDetails.isDisplayed()) {

				for (int i = 0; i < lstMerchantDetails.size(); i++) {

					if (country.equalsIgnoreCase(lstMerchantDetails.get(i).getText())
							&& status.equalsIgnoreCase(lstMerchantDetails.get(i + 1).getText()) && browserFactory
									.getOrderNumber().equalsIgnoreCase(lstMerchantDetails.get(i + 2).getText())) {
						log.info("MERCHANT DETAILS for the tabby orders with Country: "
								+ lstMerchantDetails.get(i).getText() + " Staus: "
								+ lstMerchantDetails.get(i + 1).getText() + " Order#: "
								+ lstMerchantDetails.get(i + 2).getText());

					}
				}
			}
		} catch (InterruptedException e) {

			log.info("Merchant tabby order is not listed");
		}

	}
	
	/*
	 * This method fetches the base_price displaying for an item in the Order Success
	 */
	public String getBasePriceAtOrderSuccess(String country) {
		
		String basePrice = null;
		log.info("Fethcing the basebrice of the item in the Order Success");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		basePrice = basePrice.replaceAll(",", "");
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode)+3);
		log.info("The base price available in the Order Success is "+basePrice);
		
		if (country.equalsIgnoreCase("UAE") || country.equalsIgnoreCase("KSA") || country.equalsIgnoreCase("QA")) {
			basePrice = basePrice.replaceAll("[^0-9]", "");
		}
		else if (country.equalsIgnoreCase("BH") || country.equalsIgnoreCase("OM") || country.equalsIgnoreCase("KW")){
			basePrice = basePrice.replaceAll("[^\\.0-9]", "");
		}
		else {
			log.info("The country code is not valid");
		}
		log.info("The base price is " + basePrice);		
		return basePrice.trim();
	}
	
	/* This method compares the base_price displaying at Order Success with the
	 * actual_price provided by the user
	 */
	public void evaluateBasePriceAtOrderSuccess(String actualBasePrice, String country) {
		log.info("Comparing the base_price displaying at Order Success with the actual base_price provided by the user");
		log.info("The base_price provided by the user is " + actualBasePrice);
		assertEquals(getBasePriceAtOrderSuccess(country), actualBasePrice, "The base_price is matching");
	}

	
	/* This method compares the base_price displaying at Order Success with the base_price fetched at PLP
	 */
	public void evaluateBasePriceAtOrderSuccess(String country) {
		log.info("Comparing the base_price displaying at Order Success with the actual base_price provided by the user");
		assertEquals(getBasePriceAtOrderSuccess(country), searchPage.globalBasePrice, "The base_price is matching");
	}
	
	public String getSpecialPriceAtOrderSuccess(String country) {
		log.info("Fethcing the special of the item in the Order Success");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode)+3);
		log.info("The special Price at Order Success is "+specialPrice);
		
		if (country.equalsIgnoreCase("UAE") || country.equalsIgnoreCase("KSA") || country.equalsIgnoreCase("QA")) {
			log.info("The special Price at Order Success is "+specialPrice);
			specialPrice = specialPrice.replaceAll("[^0-9]", "");
		}
		else if (country.equalsIgnoreCase("BH") || country.equalsIgnoreCase("OM") || country.equalsIgnoreCase("KW")){
			log.info("The special Price at Order Success is "+specialPrice);
			specialPrice = specialPrice.replaceAll("[^\\.0-9]", "");
		}
		else {
			log.info("The country code is not valid");
		}
		return specialPrice.trim();
	}
	
	/*
	 * This method compares the special_price displaying at Order Success with
	 * the actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtOrderSuccess(String actualSpecialPrice, String country) {
		log.info("Comparing the special_price displaying at Shipping with the actual values");
		assertEquals(getSpecialPriceAtOrderSuccess(country), actualSpecialPrice, "The special_price is matching at Order Success");
	}
	
	/*
	 * This method compares the special_price displaying at Order Success with the fetched special price at PLP
	 */
	public void evaluateSpecialPriceAtOrderSuccess(String country) {
		log.info("Comparing the special_price displaying at Shipping with the special price fetched at PLP");
		assertEquals(getSpecialPriceAtOrderSuccess(country), searchPage.globalSpecialPrice, "The special_price is matching at Order Success");
	}

}
