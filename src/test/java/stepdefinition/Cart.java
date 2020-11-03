package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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

	@And("^User is in cart page$")
	public void user_is_in_cart_page() {
		cartPage.isMyBagPageLoaded();
	}

	@And("^User deletes products in cart$")
	public void user_deletes_products_in_cart() {
		cartPage.removeProduct();
	}

	@Then("^product should be removed from cart$")
	public void product_should_be_removed_from_cart() throws Throwable {
		cartPage.isCartEmpty();
	}

	@And("^User increases QTY to \"([^\"]*)\"$")
	public void user_increases_qty_to_something(String QTY) {
		cartPage.increaseProductQTY(QTY);
	}

	@Then("^Product QTY should be updated to \"([^\"]*)\"$")
	public void product_qty_should_be_updated_to_something(String QTY) {
		cartPage.verifyProductQTY(QTY);
	}

	@Then("^Discount of \"([^\"]*)\" amount should be applied$")
	public void discount_of_something_amount_should_be_applied(String amount) {
		cartPage.verifyAmountOffApplied(amount);
	}

	@And("^User applies \"([^\"]*)\"$")
	public void user_applies(String coupon) {
		cartPage.applyCoupon(coupon);
	}

	@Then("^Discount of \"([^\"]*)\" percent should be applied$")
	public void discount_of_something_percent_should_be_applied(String percent) {
		cartPage.verifyPercentOffApplied(percent);
	}
}
