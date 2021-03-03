package stepdefinition;

import java.util.Map;

import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.SandboxCheckoutHomePage;
import pageObjects.SearchPage;

public class Home {
	HomePage homePage = new HomePage();
	SearchPage searchPage = new SearchPage();
	GenericHelper genericHelper = new GenericHelper();
	SandboxCheckoutHomePage checkoutHomePage = new SandboxCheckoutHomePage();

	@When("^Home page is displayed$")
	public void home_page_is_displayed() {
		homePage.verifyHomePageDisplayed();
	}

	@When("^user enters product name as \"([^\"]*)\" in search text box and click search icon$")
	public void user_enters_product_name_as_in_search_text_box_and_click_search_icon(String productID) {
		// homePage.clickHomeLogo();
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

	@Then("^Create an account using valid details$")
	public void create_an_account_using_valid_details() {
		homePage.createAccount();
	}

	@Then("^User should be landed into Checkout Sandbox dashboard$")
	public void user_should_be_landed_into_Checkout_Sandbox_dashboard() {
		checkoutHomePage.verifyCheckoutDashboardDisplayed();
	}

	@When("^User clicks on payments menu$")
	public void user_clicks_on_payments_menu() {
		checkoutHomePage.clickPaymentsMenu();
	}

	@And("^user enters product name as \"([^\"]*)\" in search text box$")
	public void user_enters_product_name_as_something_in_search_text_box(String product) {
		homePage.typeInSearchField(product);
	}

	@And("^user click on first product on the search suggestions$")
	public void user_click_on_first_product_on_the_search_suggestions() throws Throwable {
		homePage.clickOnFirstItemSearchResult();
	}

	@Then("^User click on Home Logo$")
	public void user_click_on_Home_Logo() throws Throwable {
		homePage.clickHomeLogo();
	}

	@And("^user checks the \"([^\"]*)\" in the search")
	public void user_checks_the_in_the_search(String special_price) {
		homePage.evaluateSpecialPriceAtSearch(special_price);
	}

	@And("^user clicks the wishlist link$")
	public void user_clicks_the_wishlist_link() {
		homePage.clickOnWishlistInHeader();
	}

	@Then("^user checks the special_price in the search")
	public void user_checks_the_special_price_in_the_search() {
		homePage.evaluateSpecialPriceAtSearch();
	}

	@When("^user verifies the customer support details at Header and Footer$")
	public void user_verifies_the_customer_support_details_at_Header_and_Footer(DataTable section) {
		for (Map<String, String> sec : section.asMaps(String.class, String.class)) {
			homePage.verifySupportPhoneAndEmail(sec.get("Section"));
		}
	}

	@When("^user clicks \"([^\"]*)\"$")
	public void user_clicks(String category) {
		homePage.clickLevel1Category(category);
	}

	@When("^User clicks on main banner$")
	public void user_clicks_on_main_banner() {
		homePage.clickOnMainBanner();
	}

	@Then("^User should be landed to respective PLP$")
	public void user_should_be_landed_to_respective_PLP() {
		searchPage.verifyPLPIsDisplayed();
	}

	@When("^User clicks on banner and verifies respective PLP$")
	public void user_clicks_on_banner_and_verifies_respective_PLP() {
		homePage.clickOnAllBannersAndVerifyPLP();
	}

}
