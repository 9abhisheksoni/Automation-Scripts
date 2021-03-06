package pageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class OrderDetailsPage extends CucumberRunner {
	
	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	SearchPage searchPage = new SearchPage();
	private Logger log = Logger.getLogger(OrderDetailsPage.class.getName());
	
	/**
	 * Constructor to initialize page objects
	 **/
	public OrderDetailsPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	
	@FindBy(xpath = "//button[@class='MyAccountOrderView-BackButton']")
	private WebElement lblBackToOrderHistory;
	
	@FindBy(xpath = "//div[@class='MyAccountOrderView-Heading']/button")
	private WebElement btnRetunAnItem;
	
	@FindBy(xpath = "(//div[@class='MyAccountOrderView-Status']/p[1]/span) | (//div[@class='MyAccountOrderView-StatusFailed']//p[1])")
	private WebElement lblOrderStatus;
	
	@FindBy(xpath = "//p[@class='MyAccountOrderView-StatusDate']/span")
	private WebElement lblOrderDate;
	
	@FindBy(xpath = "//div[@class='MyAccountOrderView-PaymentType']/p")
	private WebElement lblPayMentType;
	
	@FindBy(xpath="//div[@class='MyAccountOrderView-Heading']/button")
	private WebElement btnCancelOrder;
	
	@FindBy(xpath="//div[contains(@class,'MyAccountReturnCreateItem-Checkbo')]")
	private WebElement radioCancelProduct;
	
	@FindBy(xpath="//button[contains(@class,'MyAccountReturnCreate-ButtonSubmit')]")
	private WebElement btnCancelItems;
	
	@FindBy(xpath = "//div[contains(@class,'MyAccountOrderView-StatusFailed')]/p")
	private WebElement msgOrderCancelSuccess;
	
	@FindBy (xpath = "//span[@class='cart-price']/span")
	private WebElement txtSpecialPrice;
	
	/**
	 * WebElement declaration ends here
	 **/

	public void returnToOrderHistoryPage() {
		commonMethods.click(lblBackToOrderHistory);
		log.info("Clicked on return to Order History Page");
	}
	
	public void clickOnReturnAnItem() {
		commonMethods.click(btnRetunAnItem);
		log.info("Clicked on return an item");
	}
	
	public String getOrderPaymentType() {
		log.info("Returning Order Payment");
		return commonMethods.getText(lblPayMentType);
	}
	
	public String getOrderStatus() {
		log.info("Returning Order Status of ordrer details page");
		String orderStatusContent = commonMethods.getAttribute(lblOrderStatus,"innerHTML").toUpperCase();
		String orderStatus="";
		if (orderStatusContent.contains("Payment_success".toUpperCase())||orderStatusContent.contains("Payment Success".toUpperCase())){
			orderStatus = "Payment Success";
		} else if (orderStatusContent.contains("Aborted".toUpperCase())){
			orderStatus = "Payment Aborted";
		} else if (orderStatusContent.contains("Processing".toUpperCase())){
			orderStatus = "Processing";
		} else if (orderStatusContent.contains("Complete".toUpperCase())){
			orderStatus = "Complete";
		} else if (orderStatusContent.contains("Cancelled".toUpperCase())){
			orderStatus = "Cancelled";
		} else if (orderStatusContent.contains("Closed".toUpperCase())){
			orderStatus = "Closed";
		} else if (orderStatusContent.contains("Pending".toUpperCase())){
			orderStatus = "Pending";
		}
		else {
			genericHelper.throwUserException("no appropriate status found");
		}
		log.info("Order status in order details page is: "+orderStatus);
		return orderStatus;
	}
	
	public String getOrderOrderDate() {
		log.info("Returning Order Date");
		return commonMethods.getAttribute(lblOrderDate,"innerHtml");
	}
	
	public void cancelOrder() {
		commonMethods.click(btnCancelOrder);
		commonMethods.click(radioCancelProduct);
		log.info("Select item for Cancel");
		commonMethods.click(btnCancelItems);
		log.info("Item Cancelled");
	}
	
	public void verifyOrderCancelSuccessMsg() {
		Assert.assertTrue(genericHelper.isDisplayed(msgOrderCancelSuccess));
		log.info("Order Cancelled Successfully");
	}
	
	
	/*
	 * This method fetches the base_price displaying for an item in the Order Details
	 */
	public String getSpecialPriceAtOrderDetails() {
		log.info("Fethcing the special of the item in the Order Details");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		
		log.info("The special price at PLP is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted special price at PLP is" + specialPrice);
		return specialPrice;
	}
	
	/*
	 * This method compares the special_price displaying at Order Success with
	 * the actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtOrderDetails(String actualSpecialPrice) {
		log.info("Comparing the special_price displaying at Order Details with the actual values");
		assertEquals(getSpecialPriceAtOrderDetails(), actualSpecialPrice, "The special_price is matching at Order Details");
	}
	
	/*
	 * This method compares the special_price displaying at Order Success with the special price fetched at PLP
	 */
	public void evaluateSpecialPriceAtOrderDetails() {
		log.info("Comparing the special_price displaying at Order Details with the actual values");
		assertEquals(getSpecialPriceAtOrderDetails(), searchPage.globalSpecialPrice, "The special_price is matching at Order Details");
	}
	
}
