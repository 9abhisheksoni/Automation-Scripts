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
import utilities.StringUtility;

public class OrderHistoryPage extends CucumberRunner {
	/**
	 * Class object declaration here
	 **/
	private Logger log = Logger.getLogger(CommonMethods.class.getName());
	JsonReader json = new JsonReader();
	WaitHelper waitHelper = new WaitHelper();
	ShippingPage checkoutAddressPage = new ShippingPage();
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();

	/**
	 * Constructor to initialize page objects
	 **/
	public OrderHistoryPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/


	@FindBy(xpath = "//h1[@class='MyAccount-Heading']")
	private WebElement lblOrderHistory;


	@FindBy(xpath = "//button[@class='MyAccountOrderListItem']/p")
	private List<WebElement> lnkOrderNumbers;


	@FindBy(xpath = "//button[@class='MyAccountOrderListItem']/p/span")	
	private List<WebElement> lblOrderStatus;


	@FindBy(xpath = "//button[@class='MyAccountOrderListItem']/p")
	private List<WebElement> imgViewOrder;

	/**
	 * WebElement declaration ends here
	 **/

	public void verifyOrderHistoryPage() {
		waitHelper.waitForElementVisible(lblOrderHistory);
		log.info("Order History page is displayed");
		waitHelper.staticWait(10000);
	}

	public String getOrderStatus() {
		waitHelper.waitForElementVisible(lblOrderHistory);
		String orderStatus = "Order Not found!";
		for (int i = 0; i < lnkOrderNumbers.size(); i++) {
			if (commonMethods.getText(lnkOrderNumbers.get(i)).contains(browserFactory.getOrderNumber())) {
				String orderNumber = Integer
						.toString(new StringUtility().getIntValue(commonMethods.getText(lnkOrderNumbers.get(i))));
				orderStatus = commonMethods.getAttribute(lblOrderStatus.get(i), "innerHTML").replace(" ", "")
						.replace("-", "");
				log.info("Order number " + orderNumber + " found in order history, order status is : " + orderStatus);
				break;
			} else {
				log.info("Order number" + browserFactory.getOrderNumber() + "doesn't exist in order history");
			}
		}
		return orderStatus;
	}

	public void clickViewOrder() {
		for (int i = 0; i < lnkOrderNumbers.size(); i++) {
			if (commonMethods.getText(lnkOrderNumbers.get(i)).contains(browserFactory.getOrderNumber())) {
				log.info(
						"Order number" + browserFactory.getOrderNumber() + " found in order history, order status is ");
				commonMethods.click(imgViewOrder.get(i));
			}

		}
	}
}
