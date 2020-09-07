package stepdefinition;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SandboxCheckoutPaymentsPage;

public class SandboxCheckoutPayment {
	SandboxCheckoutPaymentsPage checkoutPaymentPage = new SandboxCheckoutPaymentsPage();
	
	@When("^User inputs order number in Checkout payments page$")
	public void user_inputs_order_number_in_Checkout_payments_page() {
		checkoutPaymentPage.inputSandboxCheckoutOrderNum();
	}
	
	@When("^User clicks on Checkout Payment Details$")
	public void user_clicks_on_Checkout_Payment_Details() {
		checkoutPaymentPage.clickOnCheckoutPaymentDetails();
	}

	@Then("^Verify status \"([^\"]*)\" and \"([^\"]*)\" in Checkout payment details$")
	public void verify_status_and_in_Checkout_payment_details(String paymentAuthorized, String paymentCaptured) {
		Assert.assertTrue(checkoutPaymentPage.getPaymentAuthorized().contains(paymentAuthorized));
		Assert.assertTrue(checkoutPaymentPage.getPaymentCaptured().contains(paymentCaptured));
	}
	
	@Then("^Verify status \"([^\"]*)\" refund in Checkout payment details$")
	public void verify_status_refund_in_Checkout_payment_details(String paymentRefunded) {
		Assert.assertTrue(checkoutPaymentPage.getPaymentRefunded().contains(paymentRefunded));
	}


}
