package stepdefinition;

import commonHelper.GenericHelper;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class Home {
	HomePage homePage = new HomePage();
	GenericHelper genericHelper = new GenericHelper();
	
	@When("^Home page is displayed$")
	public void home_page_is_displayed() {
		homePage.verifyHomePageDisplayed();
	}

	@When("^user enters product name as \"([^\"]*)\" in search text box and click search icon$")
	public void user_enters_product_name_as_in_search_text_box_and_click_search_icon(String productID) {
		homePage.searchProduct(productID);
	}

	@When("^user goes to main window$")
	public void user_goes_to_main_window()  {
	    genericHelper.closeAllWindowsExceptParent();
	}
}
