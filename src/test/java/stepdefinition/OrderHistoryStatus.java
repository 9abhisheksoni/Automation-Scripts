package stepdefinition;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.OrderHistoryPage;
import pageObjects.OrderSuccessPage;

public class OrderHistoryStatus {
	
	/**
	 * Class object declaration here
	 **/
	OrderHistoryPage historyPage = new OrderHistoryPage();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();
	HomePage homePage=new HomePage();
	private Logger log = Logger.getLogger(HomePage.class.getName());

	
	@When("^user clicks on continue shipping button$")
	public void user_clicks_on_continue_shipping_button() {
		orderSuccess.clickOnContinueShopping();	    
	}

	@When("^user clicks on my account top menu$")
	public void user_clicks_on_my_account_top_menu() {
		homePage.clickMyAccountMenu();
	}

	@When("^user selects order history option$")
	public void user_selects_order_history_option() {
		homePage.selectOrderHistory();
	}

	@Then("^order history page is displayed$")
	public void order_history_page_is_displayed() {
		historyPage.verifyOrderHistoryPage();
	}

	@Then("^verify order status$")
	public void verify_order_status() {
		log.info(historyPage.getOrderStatus());	   
	}
}
