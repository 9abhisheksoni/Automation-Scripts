package stepdefinition;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.MagentoOrdersDetailPage;
import pageObjects.MagentoRmaPage;


public class MagentoRmaCreation {

	/**
	 * Class object declaration here
	 **/
	MagentoRmaPage magentoRmaPage = new MagentoRmaPage();
	MagentoOrdersDetailPage magentoOrdersDetailPage = new MagentoOrdersDetailPage();
	private Logger log = Logger.getLogger(HomePage.class.getName());
	
	@When("^user clicks on create returns button$")
	public void user_clicks_on_create_returns_button()  {
		magentoOrdersDetailPage.clickCreateReturns();
	}

	@Then("^user should be landed into order return page$")
	public void user_should_be_landed_into_order_return_page()  {
		magentoRmaPage.verifyRmaPage();
	}

	@Then("^user selects the resolution as \"([^\"]*)\"$")
	public void user_selects_the_resolution_as(String resolution)  {
		magentoRmaPage.selectReturnResolution(resolution);
	}

	@Then("^user navigates to return item menu and selects the reason as \"([^\"]*)\" after selecting the item checkbox$")
	public void user_navigates_to_return_item_menu_and_selects_the_reason_as_after_selecting_the_item_checkbox(String reason)  {
		magentoRmaPage.clickReturnItemsMenu();		
		magentoRmaPage.clickSelectItemCheckbox();
		magentoRmaPage.selectReturnReason(reason);
	}

	@Then("^user clicks on submit returns button$")
	public void user_clicks_on_submit_returns_button()  {
		magentoRmaPage.clickSubmitReturns();
	}

	@Then("^RMA request should be created$")
	public void rma_request_should_be_created()  {
		magentoRmaPage.verifyRmaCreationStatus();
	}
	
	@Then("^In magento returns page user enters the orderID$")
	public void in_magento_returns_page_user_enters_the_orderID()  {
		magentoRmaPage.enterRmaOrderID();
	}
	
	@Then("^uses clicks view link in magento returns page$")
	public void uses_clicks_view_link_in_magento_returns_page() {
		magentoRmaPage.clickViewLink();
	}
}
