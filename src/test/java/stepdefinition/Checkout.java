package stepdefinition;

import java.util.Scanner;

import base.Config;
import commonHelper.WaitHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
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
		shippingPage.clickCancelButton();
		shippingPage.selectSavedAddress();
	}

	@When("^user selects payment option as \"([^\"]*)\"$")
	public void user_selects_payment_option_as(String payment) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to proceed? ");
		String input = sc.nextLine();
		waitHelper.waitForSpinnerInvisibility();
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

}
