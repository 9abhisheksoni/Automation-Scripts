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

public class PaymentPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	private Logger log = Logger.getLogger(CommonMethods.class.getName());
	JsonReader json = new JsonReader();
	WaitHelper waitHelper = new WaitHelper();
	ShippingPage checkoutAddressPage = new ShippingPage();
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//form[@id='frames-element-card-number']/input[@id='checkout-frames-card-number']")
	private WebElement txtCreditCardNumber;

	@FindBy(xpath = "//form[@id='frames-element-expiry-date']/input[@id='checkout-frames-expiry-date']")
	private WebElement txtCreditCardExpiry;

	@FindBy(xpath = "//form[@id='frames-element-cvv']/input[@id='checkout-frames-cvv']")
	private WebElement txtCreditCardCvv;

	@FindBy(xpath = "//input[@id = 'checkoutcom_card_payment']")
	private WebElement radioCreditCardPayment;

	@FindBy(xpath = "//input[@id = 'msp_cashondelivery']")
	private WebElement radioCodPayment;

	@FindBy(xpath = "//input[@id = 'tabby_checkout']")
	private WebElement radioTabbyPayLater;

	@FindBy(xpath = "//input[@id = 'tabby_installments']")
	private WebElement radioTabbyPayInInstallments;

	@FindBy(xpath = "//input[@id = 'checkoutcom_card_payment']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement divCreditCardPayment;

	@FindBy(xpath = "//input[@id='checkoutcom_vault']/ancestor::div[@class='payment-method-title field choice']/..")
	private WebElement divSavedCardPayment;

	@FindBy(xpath = "//input[@id = 'msp_cashondelivery']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement divCodPayment;

	@FindBy(xpath = "//input[@id = 'tabby_checkout']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement divTabbyPayLater;

	@FindBy(xpath = "//input[@id = 'tabby_installments']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement divTabbyPayInInstallments;

	@FindBy(xpath = "//button[@type = 'submit' and @class='action primary checkout button default']")
	private WebElement btnCodPlaceOrder;

	@FindBy(xpath = "//button[@id='checkoutcom_card_payment_btn']")
	private WebElement btnCcPlaceOrder;

	@FindBy(xpath = "//button[@type = 'submit' and @class='action primary checkout tabby tabby_checkout']")
	private WebElement btnTabbyPayLaterPlaceOrder;

	@FindBy(xpath = "//button[@type = 'submit' and @class='action primary checkout tabby tabby_installments']")
	private WebElement btnTabbyPayInInstallmentsPlaceOrder;

	@FindBy(xpath = "//span[@class='discount_icon']")
	private WebElement drawCouponDrawer;

	@FindBy(xpath = "//input[@id='discount-code']")
	private WebElement txtCouponCode;

	@FindBy(xpath = "//button[contains(@class,'action-apply')]")
	private WebElement btnApplyDiscount;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement txtTabbyPhone;

	@FindBy(xpath = "//input[@placeholder='E-mail']")
	private WebElement txtTabbyEmail;

	@FindBy(xpath = "//input[@type='tel']/following-sibling::button")
	private WebElement lnkTabbyPhoneEdit;

	@FindBy(xpath = "//input[@placeholder='E-mail']/following-sibling::button")
	private WebElement lnkTabbyEmailEdit;

	@FindBy(xpath = "//input[contains(@class,'Checkbox__input')]")
	private WebElement chkTabbyTerms;

	@FindBy(xpath = "//button[contains(@class,'Button__container')]")
	private WebElement btnTabbyCompleteOrder;

	@FindBy(xpath = "//div[contains(@class,'styles_react-code-input')]/input")
	private WebElement txtTabbyOTP;

	@FindBy(xpath = "//iframe[@id='cardNumber']")
	private WebElement frameCreditCard;

	@FindBy(xpath = "//iframe[@id='expiryDate']")
	private WebElement frameExpiryDate;

	@FindBy(xpath = "//iframe[@id='cvv']")
	private WebElement frameCvv;

	@FindBy(xpath = "//div[@class='secure-checkout-right']/span")
	private WebElement lblSecureCheckout;

	@FindBy(xpath = "//button[contains(@class,'Button__disabled')]")
	private WebElement btnTabbyInActiveCompleteOrder;

	@FindBy(xpath = "//iframe[contains(@class,'integration__iframe')]")
	private WebElement frameTabby;

	@FindBy(xpath = "//span[contains(@class,'Dropzone__browse')]")
	private WebElement btnBrowse;

	@FindBy(xpath = "//button[contains(@class,'Button__primary')]")
	private WebElement btnTabbyBuyNow;

	@FindBy(xpath = "//div[@class='order-payment-method-title']")
	private List<WebElement> txtPaymentType;

	/**
	 * WebElement declaration ends here
	 **/

	/**
	 * Constructor to initialize page objects
	 **/
	public PaymentPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public String checkGetActivePayment() {
		waitHelper.waitForSpinnerInvisibility(new ShippingPage().checkoutSpinner);
		if (commonMethods.getAttribute(divCreditCardPayment, "class").contains("active")) {
			return "creditCardPayment";
		} else if (commonMethods.getAttribute(divCreditCardPayment, "class").contains("active")) {
			return "creditCardPayment";
		} else if (commonMethods.getAttribute(divCodPayment, "class").contains("active")) {
			return "codPayment";
		} else if (commonMethods.getAttribute(divTabbyPayLater, "class").contains("active")) {
			return "tabbyPayLater";
		} else if (commonMethods.getAttribute(divTabbyPayInInstallments, "class").contains("active")) {
			return "tabbyPayInInstallments";
		} else if (commonMethods.getAttribute(divSavedCardPayment, "class").contains("active")) {
			return "savedCardsPayment";
		} else {
			log.info("===No active payment methods, hence returning null!!!===");
			return null;
		}
	}

	public void payUsingCreditCard(String cardType) {
		String expiry = "12/21";
		String cardNumber = json.getCardnumber(cardType);
		String cvv = json.getCVV(cardType);

		if (!checkGetActivePayment().equalsIgnoreCase("creditCardPayment")) {
			commonMethods.click(radioCreditCardPayment);
			waitHelper.staticWait(5000);
		}
		genericHelper.switchToFrame(frameCreditCard);
		commonMethods.clearAndSendKeys(txtCreditCardNumber, cardNumber);
		log.info("card number is entered as :" + cardNumber);
		genericHelper.switchToDefaulContent();
		genericHelper.switchToFrame(frameExpiryDate);
		commonMethods.clearAndSendKeys(txtCreditCardExpiry, expiry);
		log.info("Expiry date is entered as : " + expiry);
		genericHelper.switchToDefaulContent();
		genericHelper.switchToFrame(frameCvv);
		commonMethods.clearAndSendKeys(txtCreditCardCvv, cvv);
		genericHelper.switchToDefaulContent();
		log.info("CVV detail is entered as : " + cvv);

	}

	public void payUsingCOD() {
		if (!checkGetActivePayment().equalsIgnoreCase("codPayment")) {
			commonMethods.click(radioCodPayment);
			log.info("Payment method selected as :COD");
		}

	}

	public void fillTabbyForm(String phone, String email, String otp) {
		genericHelper.switchToFrame(frameTabby);
		if (commonMethods.isElementPresent(lnkTabbyPhoneEdit)) {
			commonMethods.click(lnkTabbyPhoneEdit);
		}
		commonMethods.clearAndSendKeys(txtTabbyPhone, phone);
		if (commonMethods.isElementPresent(lnkTabbyEmailEdit)) {
			commonMethods.click(lnkTabbyEmailEdit);
		}
		commonMethods.clearAndSendKeys(txtTabbyEmail, email);
		if (commonMethods.getAttribute(chkTabbyTerms, "checked") == null) {
			commonMethods.click(chkTabbyTerms);
		}
		commonMethods.click(btnTabbyCompleteOrder);
		commonMethods.clearAndSendKeys(txtTabbyOTP, otp);
		commonMethods.click(btnBrowse);
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\tabbyData\\id_tabby.jpg";
		genericHelper.fileUpload(filePath);
		commonMethods.click(btnTabbyBuyNow);
		genericHelper.switchToDefaulContent();
		log.info("entered values in tabby form ");
	}

	public void payUsingTabbyPayLater() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayLater")) {
			commonMethods.click(radioTabbyPayLater);
		}
		log.info("selected using tabby pay later ");
	}

	public void payUsingTabbyPayInInstallments() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayInInstallments")) {
			commonMethods.click(radioTabbyPayInInstallments);
		}
	}

	public void applyCoupon(String couponCode) {
		if (!genericHelper.isDisplayed(txtCouponCode)) {
			commonMethods.click(drawCouponDrawer);
		}
		commonMethods.clearAndSendKeys(txtCouponCode, couponCode);
		commonMethods.click(btnApplyDiscount);
		log.info("applied discount coupon on checkout");
	}

	public void clickOnPlaceOrder() {
		waitHelper.staticWait(5000);
		commonMethods.click(lblSecureCheckout);
		log.info("Active payment: " + this.checkGetActivePayment());
		if (this.checkGetActivePayment().equalsIgnoreCase("codPayment")) {
			commonMethods.moveToElementAndClick(btnCodPlaceOrder);
		} else if (this.checkGetActivePayment().equalsIgnoreCase("creditCardPayment")) {
			commonMethods.moveToElementAndClick(btnCcPlaceOrder);
		} else if (this.checkGetActivePayment().equalsIgnoreCase("tabbyPayLater")) {
			commonMethods.moveToElementAndClick(btnTabbyPayLaterPlaceOrder);
		} else {
			commonMethods.moveToElementAndClick(btnTabbyPayInInstallmentsPlaceOrder);
		}
		log.info("clicked on place order");
	}

	public void verifyPaymentMethod(String paymentMethod) {
		String paymentType;

		for (int i = 0; i < txtPaymentType.size(); i++) {
			paymentType = commonMethods.getAttribute(txtPaymentType.get(i), "innerText").trim().replace("-", "");
			if (paymentType.toUpperCase().contains(paymentMethod.toUpperCase())) {
				log.info("Payment type is: " + paymentType);
				break;
			}
		}
	}

}