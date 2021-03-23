package stepdefinition;


import base.Config;
import commonHelper.WaitHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReader.JsonReader;
import pageObjects.OrderHistoryPage;
import pageObjects.OrderSuccessPage;
import pageObjects.PaymentPage;
import pageObjects.ShippingPage;

public class Checkout {

	ShippingPage shippingPage = new ShippingPage();
	PaymentPage paymentPage = new PaymentPage();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();
	JsonReader json = new JsonReader();
	OrderHistoryPage historyPage = new OrderHistoryPage();
	WaitHelper waitHelper = new WaitHelper();
	Config config = new Config();

	@When("^User click on New Address$")
	public void user_click_on_New_Address() {
		shippingPage.clickNewAddress();
	}

	@When("^user enters the valid details for shipping address$")
	public void user_enters_the_valid_details_for_shipping_address() {
		shippingPage.selectSavedAddress();
	}

	@When("^user selects payment option as \"([^\"]*)\"$")
	public void user_selects_payment_option_as(String payment) {
		if (payment.equalsIgnoreCase("COD")) {
			paymentPage.payUsingCOD();
		} else if (payment.equalsIgnoreCase("CC_VISA")) {
			paymentPage.payUsingCreditCard("visa");
		} else if (payment.equalsIgnoreCase("CC_MASTER")) {
			paymentPage.payUsingCreditCard("master");
		} else if (payment.equalsIgnoreCase("CC_AMEX")) {
			paymentPage.payUsingCreditCard("amex");
		} else if (payment.equalsIgnoreCase("TabbyPayLater")) {
			paymentPage.payUsingTabbyPayLater();
		} else if (payment.equalsIgnoreCase("TabbyPayInInstallments")) {
			paymentPage.payUsingTabbyPayInInstallments();
		}
		waitHelper.staticWait(3000);

	}

	@When("^user fills all tabby details$")
	public void user_fills_all_tabby_details() {
		paymentPage.fillTabbyForm(json.getTabbyphone(), json.getTabbyEmail(), json.getTabbyOTP());
	}

	@When("^user clicks on place order button$")
	public void user_clicks_on_place_order_button() {
		paymentPage.clickOnPlaceOrder();
	}

	@Then("^Order placing should be successful$")
	public void order_placing_should_be_successful() {
		orderSuccess.isOrderSuccessFull();
	}

	@When("^Launch Tabby Merchant URL \"([^\"]*)\"$")
	public void launch_Tabby_Merchant_URL(String URL) {
		orderSuccess.controlT();
		orderSuccess.launchURL(config.getMerchantURL(URL));
	}

	@When("^User inputs tabby order number in merchant page$")
	public void user_inputs_tabby_order_number_in_merchant_page() {
		orderSuccess.inputmerchantOrder();
	}

	@When("^Verify country \"([^\"]*)\" status \"([^\"]*)\" order$")
	public void verify_country_status_order(String country, String status) {
		orderSuccess.listMerchantOrderDetails(country, status);
	}

	@When("^Launch Checkout Sandbox URL \"([^\"]*)\"$")
	public void launch_Checkout_Sandbox_URL(String URL) {
		orderSuccess.controlT();
		orderSuccess.launchURL(config.getCheckoutSandboxURL(URL));

	}

	@And("^selects use storecredit toggle if user is eligible to use$")
	public void selects_use_storecredit_toggle_if_user_is_eligible_to_use() {
		paymentPage.turnOnStoreCredit();
	}

	@And("^User applies \"([^\"]*)\" on Payment Page$")
	public void user_applies_something_on_payment_page(String coupon) {
		paymentPage.applyCoupon(coupon);
	}

	@Then("^Discount of \"([^\"]*)\" percent should be applied on Payment Page$")
	public void discount_of_something_percent_should_be_applied_on_payment_page(String percentageDiscount) {
		paymentPage.verifyPercentOffApplied(percentageDiscount);
	}
	
	@Then("^Discount of \"([^\"]*)\" amount should be applied on Payment Page$")
    public void discount_of_something_amount_should_be_applied_on_payment_page(String amountDiscount) {
		paymentPage.verifyAmountOffApplied(amountDiscount);
    }
	
	@And("^user reset Stored Payments$")
	public void user_reset_Stored_Payments() {
		paymentPage.resetStoredPayment();
	}
	
	@And("^user selects saved card and enters cvv$")
	public void user_selects_saved_card_and_enters_cvv() {
		paymentPage.payUsingFirstSavedCreditCard();
	}
	
	@When("^user submits the valid details for shipping address$")
	public void user_submits_the_valid_details_for_shipping_address() {
		shippingPage.fillShippingForm();
	}
	
	@When("^user checks the \"([^\"]*)\" and the \"([^\"]*)\" in Shipment")
	public void user_checks_the_and_the_in_Shipment(String basePrice, String specialPrice) {
		shippingPage.evaluateBasePriceAtShipping(basePrice);
		shippingPage.evaluateSpecialPriceAtShipping(specialPrice);
	}
	
	@Then("^user checks the \"([^\"]*)\" and the \"([^\"]*)\" in order success")
	public void user_checks_the_and_the_in_order_success(String basePrice, String specialPrice) {
		orderSuccess.evaluateBasePriceAtOrderSuccess(basePrice);
		orderSuccess.evaluateSpecialPriceAtOrderSuccess(specialPrice);
	}
	
	@Then("^user checks the base_Price and the special_Price in Shipment")
	public void user_checks_the_base_Price_and_the_special_Price_in_Shipment() {
		shippingPage.evaluateBasePriceAtShipping();
		shippingPage.evaluateSpecialPriceAtShipping();
	}
	
	@Then("^user checks the base_Price and the special_Price in order success")
	public void user_checks_the_base_Price_and_the_special_Price_in_order_success() {
		orderSuccess.evaluateBasePriceAtOrderSuccess();
		orderSuccess.evaluateSpecialPriceAtOrderSuccess();
	}


	@When("^user clicks on place order button with Store Credits and \"([^\"]*)\" if required$")
	public void user_clicks_on_place_order_button_with_Store_Credits_and_another_if_required(String additionalPayment) {
		paymentPage.clickOnPlaceOrderwithSC(additionalPayment);
	}
	
	@Then("^verify available Payment options in payment page$")
	public void verify_available_Payment_options_in_payment_page() {
		paymentPage.verifyAvailablePaymentOptions();
	}
	
	@And("^user selects payment option as \"([^\"]*)\" and clicks on Save Card$")
	public void user_selects_payment_option_and_clicks_on_Save_Card(String payment) {
		if (payment.equalsIgnoreCase("CC_VISA")) {
			paymentPage.payUsingCreditCardAndSave("visa");
		} else if (payment.equalsIgnoreCase("CC_MASTER")) {
			paymentPage.payUsingCreditCardAndSave("master");
		} else if (payment.equalsIgnoreCase("CC_AMEX")) {
			paymentPage.payUsingCreditCardAndSave("amex");
		}
	}

}
