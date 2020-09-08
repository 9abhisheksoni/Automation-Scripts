package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import testRunner.CucumberRunner;

public class OrderDetailsPage extends CucumberRunner {
	
	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
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
	
	@FindBy(xpath = "//a[@class='order-details-order']")
	private WebElement lblBackToOrderHistory;
	
	@FindBy(xpath = "//span[@class='order-details-return']")
	private WebElement btnRetunAnItem;
	
	@FindBy(xpath = "//div[@class='order-details-items ordered']/div")
	private WebElement lblOrderStatus;
	
	@FindBy(xpath = "//div[@class='order-details-items ordered']/div[2]")
	private WebElement lblOrderDate;
	
	@FindBy(xpath = "//div[@class='cash-content']")
	private WebElement lblPayMentType;
	
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
		} else if (orderStatusContent.contains("Canceled".toUpperCase())){
			orderStatus = "Canceled";
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
}
