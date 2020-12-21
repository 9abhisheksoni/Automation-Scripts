package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.WishlistPage;

public class Wishlist {
	
	WishlistPage wishlistPage = new WishlistPage();
	
	@And("^user checks the \"([^\"]*)\" in the wishlist")
	public void user_checks_the_in_the_wishlist(String specialPrice) {
		wishlistPage.evaluateSpecialPriceAtWishlist(specialPrice);
	}
	
	@When("^user adds the item to the cart$")
	public void user_adds_the_item_to_the_cart() {
		wishlistPage.addItemToBag();
	}
	
	@And("^user checks the special_price in the wishlist")
	public void user_checks_the_special_price_in_the_wishlist() {
		wishlistPage.evaluateSpecialPriceAtWishlist();
	}
}	
