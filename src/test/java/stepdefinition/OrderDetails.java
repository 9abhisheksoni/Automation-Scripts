package stepdefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import pageObjects.HomePage;
import pageObjects.OrderDetailsPage;

public class OrderDetails {

	/**
	 * Class object declaration here
	 **/
	OrderDetailsPage orderDetailsPage = new OrderDetailsPage();
	private Logger log = Logger.getLogger(HomePage.class.getName());
	
	@Then("^Verify order status in details to be \"([^\"]*)\"$")
	public void verify_order_status_in_details_to_be(String orderStatus) {
		Assert.assertTrue(orderDetailsPage.getOrderStatus().equalsIgnoreCase(orderStatus));
	}

	@Then("^Verify order payment in details to be \"([^\"]*)\"$")
	public void verify_order_payment_in_details_to_be(String payment) {
		System.out.println(orderDetailsPage.getOrderPaymentType());
		System.out.println(payment);
		Assert.assertTrue(orderDetailsPage.getOrderPaymentType().equalsIgnoreCase(payment));
	}
	
}
