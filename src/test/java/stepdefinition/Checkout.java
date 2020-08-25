package stepdefinition;

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

	@When("^User click on New Address$")
	public void user_click_on_New_Address() {
		shippingPage.clickNewAddress();
	}

	@When("^user enters the valid details for \"([^\"]*)\" shipping address$")
	public void user_enters_the_valid_details_for_shipping_address(String uae) {
		shippingPage.clickCancelButton();
		shippingPage.selectSavedAddress(uae);
	}

	@When("^guest user enters the valid details for \"([^\"]*)\" shipping address$")
	public void guest_user_enters_the_valid_details_for_shipping_address(String uae) {
		shippingPage.submitShippingAddress(uae);
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
	public void launch_Tabby_Merchant_URL(String URL) throws Throwable {

		orderSuccess.controlT();
		orderSuccess.launchURL(URL);
	}

	@When("^User inputs tabby order number in merchant page$")
	public void user_inputs_tabby_order_number_in_merchant_page() throws Throwable {
		orderSuccess.inputmerchantOrder();
	}

	@When("^Verify country \"([^\"]*)\" status \"([^\"]*)\" order$")
	public void verify_country_status_order(String country, String status)
			throws Throwable {
		orderSuccess.listMerchantOrderDetails(country, status);
	}
////////////
	
	@When("^Launch Admin Magento URL \"([^\"]*)\"$")
	public void launch_Admin_Magento_URL(String URL) throws Throwable {

		orderSuccess.controlT();
		orderSuccess.launchURL(URL);
	}
}
