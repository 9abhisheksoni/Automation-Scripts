package stepdefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.OrderDetailsPage;
import pageObjects.ReturnDetailsPage;
import pageObjects.ReturnHistoryPage;

public class Returns {

	/**
	 * Class object declaration here
	 **/
	OrderDetailsPage orderDetailsPage = new OrderDetailsPage();
	ReturnHistoryPage returnHistoryPage = new ReturnHistoryPage();
	ReturnDetailsPage returnDetailsPage = new ReturnDetailsPage();
	HomePage homePage = new HomePage();
	private Logger log = Logger.getLogger(Returns.class.getName());
	
	@Then("^user clicks on return an item$")
	public void user_clicks_on_return_an_item() {
		orderDetailsPage.clickOnReturnAnItem();
	}

	@Then("^user returns \"([^\"]*)\" item with reason \"([^\"]*)\" and resolution as \"([^\"]*)\"$")
	public void user_returns_item_with_reason_and_resolution_as(String item, String reason, String resolution) {
		returnHistoryPage.SelectAnItemForReturn(item, reason);
		returnHistoryPage.returnAnItemAfterSelect(resolution);
	}
	
	@Then("^user clicks on view returns$")
	public void user_clicks_on_view_returns() {
		returnHistoryPage.clickOnViewReturnForOrder();
	}
		
	@Then("^return history page is displayed$")
	public void return_history_page_is_displayed() {
		returnHistoryPage.verifyReturnHistoryPage();
	}

	@Then("^verify return status in return history to be \"([^\"]*)\"$")
	public void verify_return_status_in_return_history_to_be(String status) {
	    Assert.assertTrue(returnHistoryPage.getReturnStatusInHistory().equalsIgnoreCase(status));
	}

	@When("^user selects return an item option$")
	public void user_selects_return_an_item_option() {
		homePage.clickReturnAnOrder();
	}
	
	@Then("^Verify return status in return details to be \"([^\"]*)\"$")
	public void verify_return_status_in_return_details_to_be(String status) {
		Assert.assertTrue(returnDetailsPage.getReturnStatus().equalsIgnoreCase(status));
	}
	
	@Then("^user return reason should be \"([^\"]*)\"$")
	public void user_return_reason_should_be(String reason) {
		Assert.assertTrue(returnDetailsPage.getReturnReason().equalsIgnoreCase(reason));
	}

}
