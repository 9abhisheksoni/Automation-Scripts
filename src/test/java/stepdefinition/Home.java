package stepdefinition;

import commonHelper.GenericHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.SandboxCheckoutHomePage;

public class Home {
	HomePage homePage = new HomePage();
	GenericHelper genericHelper = new GenericHelper();
	SandboxCheckoutHomePage checkoutHomePage = new SandboxCheckoutHomePage();
	
	@When("^Home page is displayed$")
	public void home_page_is_displayed() {
		homePage.verifyHomePageDisplayed();
	}

	@When("^user enters product name as \"([^\"]*)\" in search text box and click search icon$")
	public void user_enters_product_name_as_in_search_text_box_and_click_search_icon(String productID) {
		homePage.searchProduct(productID);
	}

	@When("^user goes to main window$")
	public void user_goes_to_main_window() {
		genericHelper.switchToBaseWindow();
	}

	@Then("^Create account \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_account_and(String firstName, String lastName, String email, String pwd) {
		homePage.createAccount(firstName, lastName, email, pwd);

	}
	
	@Then("^User should be landed into Checkout Sandbox dashboard$")
	public void user_should_be_landed_into_Checkout_Sandbox_dashboard() {
		checkoutHomePage.verifyCheckoutDashboardDisplayed();
	}
	
	@When("^User clicks on payments menu$")
	public void user_clicks_on_payments_menu() {
		checkoutHomePage.clickPaymentsMenu();
	}
}
