package stepdefinition;

import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class Cart {
	
	CartPage cartPage = new CartPage();

	
	@When("^user navigates to shopping bag page and clicks on proceedToCheckout button$")
	public void user_navigates_to_shopping_bag_page_and_clicks_on_proceedToCheckout_button() {
		cartPage.clickCheckout();
	}
	
	@When("^User clears cart$")
	public void user_clears_cart() {
		cartPage.clearCart();
	}
}
