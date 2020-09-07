package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class SandboxCheckoutPaymentsPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	GenericHelper genericHelper = new GenericHelper();
	CommonMethods commonMethods = new CommonMethods();
	private Logger log = Logger.getLogger(HomePage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public SandboxCheckoutPaymentsPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchCheckoutPayments;

	@FindBy(xpath = "//span[contains(text(),'capture - 3Ds2')]")
	private WebElement paymentDetailsActionCapture;

	@FindBy(xpath = "//p[@class='text'][contains(text(),'Payment captured')]")
	private WebElement paymentCaptured;

	@FindBy(xpath = "//p[@class='text'][contains(text(),'Payment authorized')]")
	private WebElement paymentAuthorized;

	@FindBy(xpath = "//span[@class='more-btn'][contains(text(),'Show more')]")
	private WebElement btnShowMore;

	@FindBy(xpath = "//p[@class='text'][contains(text(),'Payment refunded')]")
	private WebElement paymentRefunded;

	@FindBy(xpath = "//p[@class='text'][contains(text(),'Payment partial refund')]")
	private WebElement paymentPartialRefund;

	/**
	 * WebElement declaration ends here
	 **/

	public void inputSandboxCheckoutOrderNum() {
//		String checkoutOrderNo = browserFactory.getOrderNumber();
		String checkoutOrderNo = "500225897";
		new WaitHelper().waitForElementVisible(searchCheckoutPayments);
		commonMethods.clearAndSendKeys(searchCheckoutPayments, checkoutOrderNo, Keys.ENTER);
	}

	public void clickOnCheckoutPaymentDetails() {
		commonMethods.staleElementClick(paymentDetailsActionCapture);
		log.info("clicked Sandbox Checkout Payment Details");
	}

	public String getPaymentCaptured() {
		commonMethods.isElementPresent(paymentCaptured);
		log.info("Payment Captured is present in Checkout Payment Details");
		return commonMethods.getText(paymentCaptured);
	}

	public String getPaymentAuthorized() {
		commonMethods.isElementPresent(paymentAuthorized);
		log.info("Payment Authorized is present in Checkout Payment Details");
		return commonMethods.getText(paymentAuthorized);
	}

	public void clickOnShowmore() {
		commonMethods.click(btnShowMore);
		log.info("clicked Sandbox Checkout Show more");
	}

	public String getPaymentRefunded() {
		String paymentRefundStatus = null;
		if (commonMethods.isElementPresent(paymentRefunded)) {
			log.info("Complete Payment Refunded is present in Checkout Payment Details");
			paymentRefundStatus = commonMethods.getText(paymentRefunded);
		} else if (commonMethods.isElementPresent(paymentPartialRefund)) {
			log.info("Partial Payment Refunded is present in Checkout Payment Details");
			paymentRefundStatus = commonMethods.getText(paymentPartialRefund);
		}else {
			log.info("Payment Refunded is not captured in Checkout Payment Details");
		}
		return paymentRefundStatus;
	}

}
