package stepdefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.Then;
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
	private Logger log = Logger.getLogger(HomePage.class.getName());
	
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
	
	@Then("^user return reason should be \"([^\"]*)\"$")
	public void user_return_reason_should_be_and_resolution_should_be(String reason) {
		Assert.assertTrue(returnDetailsPage.getReturnReason().equalsIgnoreCase(reason));
	}
	
	@Then("^the return status should be \"([^\"]*)\"$")
	public void the_return_status_should_be(String status) {
		Assert.assertTrue(returnDetailsPage.getReturnStatus().equalsIgnoreCase(status));
	}
}
