package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SearchPage;

public class SearchResults {

	int productCount;
	SearchPage searchPage = new SearchPage();

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
		Assert.assertTrue(searchPage.getProductsCount() <= this.productCount);
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
		Assert.assertTrue(searchPage.getProductsCount() >= this.productCount);
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

	@And("^products should be displayed$")
	public void products_should_be_displayed() {
		productCount = searchPage.getProductsCount();
		Assert.assertTrue(productCount > 0, "No Products to display");
	}

	@And("^no products should be displayed$")
	public void no_products_should_be_displayed() {
		searchPage.verifyNoResultDisplayed();
	}

	@Then("^search suggestions should be displayed$")
	public void search_suggestions_should_be_displayed() {
		searchPage.verifySearchSuggestionDisplay();
	}

	@And("^user checks the \"([^\"]*)\" and the \"([^\"]*)\" in PLP")
	public void user_checks_the_and_the_in_PLP(String base_price, String special_price) {
		searchPage.evaluateBasePriceAtPLP(base_price);
		searchPage.evaluateSpecialPriceAtPLP(special_price);
	}

	@And("^user fetch the Base_Price and the Special_Price in PLP$")
	public void user_fetch_the_baseprice_and_the_specialprice_for_the_something_in_PLP() {
		searchPage.getBasePricePLP();
		searchPage.getSpecialPricePLP();
	}

	@And("^click on first valid product in search result$")
	public void click_on_first_valid_product_in_search_result() {
		searchPage.clickFirstValidInResult();
	}

	@And("^user filters for tabby price range$")
	public void user_filters_for_tabby_price_range() {
		searchPage.clickTabbyPriceFilter();
	}

	@When("^user filters the product based on the highest discount$")
	public void user_filters_the_product_based_on_the_highest_discount() {
		searchPage.clickHighestDiscountPercentage();
	}

    @And("^verifies the \"([^\"]*)\" in the PLP$")
    public void verifies_the_something_in_the_plp(String productcount) {
    	searchPage.verifyPLPIsDisplayed(productcount);
    }


	@Then("^broken price products are collected$")
	public void broken_price_products_are_collected() {
		searchPage.verifyCatlogPrices();
	}

	@And("^scroll two lazy loads$")
	public void scroll_two_lazy_loads() {
		searchPage.loadMoreProducts();
	}
	
	 @Then("^verify whether products count is as expected$")
	 public void verify_whether_products_count_is_as_expected() throws Throwable {
		 searchPage.verifyProductCounts();
	 }
}
