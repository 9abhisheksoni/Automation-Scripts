package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SearhPage;

public class SearchResults {
	
	int productCount;
	SearhPage searchPage = new SearhPage();
	
	@When("^user clicks on product tile in result$")
	public void user_clicks_on_product_tile_in_result() {
		searchPage.clickProdcuctInSearchPage();
	}
	
	@And("^user reads number of products on page$")
	public void user_reads_number_of_products_on_page() {
	   productCount = searchPage.getProductsCount();
	}

	@And("^user filters using first group filter$")
	public void user_filters_using_first_group_filter() {
		searchPage.clickFirstCategoryFilter();
	}

	@Then("^products count should be decreased$")
	public void products_count_should_be_decreased() {
		Assert.assertTrue(searchPage.getProductsCount()<this.productCount); 
		this.productCount = searchPage.getProductsCount();
	}

	@Then("^user filters using second group filter$")
	public void user_filters_using_second_group_filter() {
		searchPage.clickFirstSizeFilter();
	}

	@Then("^user filters using first group second filter$")
	public void user_filters_using_first_group_second_filter() {
		searchPage.clickSecondCategoryFilter();
	}

	@Then("^products count should be increased$")
	public void products_count_should_be_increased() {
		Assert.assertTrue(searchPage.getProductsCount()>this.productCount); 
		this.productCount = searchPage.getProductsCount();
	}

	@And("^user sort by low to high price$")
	public void user_sort_by_low_to_high_price() {
		searchPage.clickLowToHighSort();
	}

	@Then("^products should be sorted with low to high price$")
	public void products_should_be_sorted_with_low_to_high_price() {
		searchPage.isPriceLowToHigh();
	}

	@Then("^user sort by high to low price$")
	public void user_sort_by_high_to_low_price() {
		searchPage.clickHighToLowSort();
	}

	@Then("^products should be sorted with high to low price$")
	public void products_should_be_sorted_with_high_to_low_price() {
		searchPage.isPriceHighToLow();
	}
	
	@When("^User clicks wishlist icon$")
	public void user_clicks_wishlist_icon() {
		searchPage.clickOnWishListIcon();
	}

	@Then("^wishlist success message should be displayed$")
	public void wishlist_success_message_should_be_displayed() {
		searchPage.verifyWishlistSuccessDisplay();
	}

	@When("^user click first level Category$")
	public void user_click_first_level_Category() {
		searchPage.clickOnFirstCategory();
	}

	@Then("^first level category should be displayed$")
	public void first_level_category_should_be_displayed() {
		searchPage.verifyOnFirstCategory();
	}

	@Then("^user click second level Category$")
	public void user_click_second_level_Category() {
		searchPage.clickOnSecondCategory();
	}

	@Then("^second level category should be displayed$")
	public void second_level_category_should_be_displayed() {
		searchPage.verifyOnSecondCategory();
	}

	@Then("^user click third level Category$")
	public void user_click_third_level_Category() {
		searchPage.clickOnThirdCategory();
	}

	@Then("^third level category should be displayed$")
	public void third_level_category_should_be_displayed() {
		searchPage.verifyOnThirdCategory();
	}
}