package stepdefinition;

import cucumber.api.java.en.When;
import pageObjects.WishlistPage;

public class Wishlist {
	
	WishlistPage wishlistPage = new WishlistPage();
	
	@When("^user checks the \"([^\"]*)\" in the wishlist$")
	public void user_checks_the_in_the_wishlist(String specialPrice) {
		wishlistPage.evaluateSpecialPriceAtPLP(specialPrice);
	}
	
	@When("^user adds the item to the cart$")
	public void user_adds_the_item_to_the_cart() {
		wishlistPage.addItemToBag();
	}
}	
