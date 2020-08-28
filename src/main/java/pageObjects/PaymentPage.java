package pageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Config;
import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.ResourceHelper;
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
	private WebElement txtPaymentType;

	@FindBy(xpath = "//button[@id='order-view-cancel-button']")
	private WebElement btnOrderViewCancel;

	@FindBy(xpath = "//button[@class='action-primary action-accept']")
	private WebElement btnCancelOkAccept;

	@FindBy(xpath = "//span[@id='order_status']")
	private WebElement txtOrderStatusMagento;

	@FindBy(xpath = "//div[contains(@class,'IdConfirm__field')]/input")
	private WebElement txtTabbyFullName;

	@FindBy(xpath = "(//div[contains(@class,'IdConfirm__field')]/input)[2]")
	private WebElement txtTabbyID;

	@FindBy(xpath = "(//div[contains(@class,'IdConfirm__field')]/input)[3]")
	private WebElement txtTabbyNationality;

	@FindBy(xpath = "(//div[contains(@class,'IdConfirm__field')]/input)[4]")
	private WebElement txtTabbyDOB;

	@FindBy(xpath = "//input[contains(@class,'storecredit')]")
	private WebElement chkStoreCreditToggle;

	@FindBy(xpath = "//div[contains(@class,'ca-code')]//input")
	private WebElement chkClubApparelToggle;

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
		String paymentMethod = "";
		if (commonMethods.getAttribute(divCreditCardPayment, "class").contains("active")) {
			paymentMethod = "creditCardPayment";
		} else if (commonMethods.getAttribute(divCreditCardPayment, "class").contains("active")) {
			paymentMethod = "creditCardPayment";
		} else if (commonMethods.getAttribute(divCodPayment, "class").contains("active")) {
			paymentMethod = "codPayment";
		} else if (commonMethods.getAttribute(divTabbyPayLater, "class").contains("active")) {
			paymentMethod = "tabbyPayLater";
		} else if (commonMethods.getAttribute(divTabbyPayInInstallments, "class").contains("active")) {
			paymentMethod = "tabbyPayInInstallments";
		} else if (commonMethods.getAttribute(divSavedCardPayment, "class").contains("active")) {
			paymentMethod = "savedCardsPayment";
		} else {
			log.info("No active payment methods, hence returning null!!!");
			paymentMethod = null;
		}
		return paymentMethod;
	}

	public void payUsingCreditCard(String cardType) {
		String expiry = "12/21";
		String cardNumber = json.getCardnumber(cardType);
		String cvv = json.getCVV(cardType);

		if (!checkGetActivePayment().equalsIgnoreCase("creditCardPayment")) {
			commonMethods.click(radioCreditCardPayment);
			waitHelper.waitForSpinnerInvisibility();
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
			waitHelper.waitForSpinnerInvisibility();
			log.info("Payment method selected as :COD");
		}

	}

	public void fillTabbyForm(String phone, String email, String otp) {
		genericHelper.switchToFrame(frameTabby);
		/*
		 * if (commonMethods.isElementPresent(lnkTabbyPhoneEdit)) {
		 * commonMethods.click(lnkTabbyPhoneEdit); }
		 */
		commonMethods.clearAndSendKeys(txtTabbyPhone, phone);
		/*
		 * if (commonMethods.isElementPresent(lnkTabbyEmailEdit)) {
		 * commonMethods.click(lnkTabbyEmailEdit); }
		 */
		commonMethods.clearAndSendKeys(txtTabbyEmail, email);
		if (commonMethods.getAttribute(chkTabbyTerms, "checked") == null) {
			commonMethods.click(chkTabbyTerms);
		}
		commonMethods.click(btnTabbyCompleteOrder);
		commonMethods.clearAndSendKeys(txtTabbyOTP, otp);
		if (browserFactory.getCountry().equalsIgnoreCase("UAE")) {
			commonMethods.click(btnBrowse);
			String filePath = new ResourceHelper().getFilepath(new Config().getTabbyFileName());
			genericHelper.fileUpload(filePath);
		} else if (browserFactory.getCountry().equalsIgnoreCase("KSA")) {
			commonMethods.clearAndSendKeys(txtTabbyFullName, json.getTabbyFullName());
			commonMethods.clearAndSendKeys(txtTabbyID, json.getTabbyID());
			commonMethods.clearAndSendKeys(txtTabbyNationality, json.getTabbyNationality());
			commonMethods.clearAndSendKeys(txtTabbyDOB, json.getTabbyDOB());
		}
		commonMethods.click(btnTabbyBuyNow);
		if (browserFactory.getCountry().equalsIgnoreCase("KSA")) {
			commonMethods.clearAndSendKeys(txtTabbyOTP, otp);
		}
		genericHelper.switchToDefaulContent();
		log.info("entered values in tabby form ");
	}

	public void payUsingTabbyPayLater() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayLater")) {
			commonMethods.click(radioTabbyPayLater);
			waitHelper.waitForSpinnerInvisibility();
		}
		log.info("selected using tabby pay later ");
	}

	public void payUsingTabbyPayInInstallments() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayInInstallments")) {
			commonMethods.click(radioTabbyPayInInstallments);
			waitHelper.waitForSpinnerInvisibility();
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
		String paymentType = commonMethods.getText(txtPaymentType);
		log.info("Payment type is: " + paymentType);
		Assert.assertTrue(paymentType.contains(paymentMethod));
	}

	/*
	 * This method is used to verify the order status in the Magento
	 */
	public void orderStatusMagento(String status) {
		String eleStatus;
		if (commonMethods.isElementPresent(txtOrderStatusMagento)) {
			eleStatus = commonMethods.getText(txtOrderStatusMagento);
			if (eleStatus.equalsIgnoreCase(status))
				log.info("Order status is " + eleStatus + " as expected");
			else
				log.info("Order status is " + eleStatus + "not as expected");
		}
	}

	/*
	 * This method is used to click order Cancel in the Magento
	 */
	public void clickOrderCancelMagento() {
		if (btnOrderViewCancel.isDisplayed()) {
			commonMethods.click(btnOrderViewCancel);
			log.info("Clicked on Cancel button in magento");
		} else {
			log.info("Cancel button is not present as order is already cancelled or shipped");
		}
		waitHelper.waitForElementVisible(btnCancelOkAccept);
		commonMethods.click(btnCancelOkAccept);
	}

	private boolean isStoreCreditActive() {
		boolean result;
		if (genericHelper.isElementPresent(chkStoreCreditToggle)) {
			log.info("Return store credit state");
			result = commonMethods.isSelected(chkStoreCreditToggle);
		} else {
			log.info("Storecredit element not displayed");
			result = false;
		}
		return result;
	}

	private boolean isClubApparelPointsActive() {
		boolean result;
		if (genericHelper.isElementPresent(chkClubApparelToggle)) {
			log.info("Return store credit state");
			result = commonMethods.isSelected(chkClubApparelToggle);
		} else {
			log.info("Storecredit element not displayed");
			result = false;
		}
		return result;
	}

	public void turnOffStoreCredit() {
		log.info("turning store credit off if present");
		if (genericHelper.isElementPresent(chkStoreCreditToggle) && this.isStoreCreditActive()) {
			commonMethods.click(chkStoreCreditToggle);
		}
	}

	public void turnOffCAPoints() {
		log.info("turning CA credit off if present");
		if (genericHelper.isElementPresent(chkClubApparelToggle) && this.isClubApparelPointsActive()) {
			commonMethods.click(chkClubApparelToggle);
		}
	}

	public void turnOnStoreCredit() {
		log.info("turning store credit ON if present");
		if (!this.isStoreCreditActive()) {
			commonMethods.click(chkStoreCreditToggle);
		}
	}

	public void turnOnCAPoints() {
		log.info("turning CA credit ON if present");
		if (!this.isClubApparelPointsActive()) {
			commonMethods.click(chkClubApparelToggle);
		}
	}

}