package stepdefinition;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.PDPPage;
import pageObjects.SearhPage;

public class PDP {
	
	PDPPage pdpPage = new PDPPage();
	SearhPage searchPage = new SearhPage();
	HomePage homePage = new HomePage();
	
	@When("^user selects countrySize as \"([^\"]*)\", size as \"([^\"]*)\"$")
	public void user_selects_countrySize_as_size_as(String country, String size) {
		pdpPage.selectSizeCountry(country);
		pdpPage.chooseSize(size);
	}

	@When("^user clicks on ADDTOBAG button$")
	public void user_clicks_on_ADDTOBAG_button() {
		pdpPage.clickAddToBag();
	}

	@When("^Tabby widget verification with monthly division$")
	public void tabby_widget_verification_with_monthly_division() {
	    pdpPage.tabbyWidgetVerify();
	}

	@When("^Click on Tabby Widget$")
	public void click_on_Tabby_Widget() {
		pdpPage.clickonTabbyWidget();
	}

	@When("^Verify the tabby promo from widget$")
	public void verify_the_tabby_promo_from_widget() throws Throwable {
		pdpPage.tabbyPromoVerify();
	}
		
	@When("^user enters product details to add to cart$")
	public void user_enters_product_details_to_add_to_cart(DataTable productDetails) {
		for(Map<String,String> prodDetails:productDetails.asMaps(String.class, String.class)) {
			homePage.searchProduct(prodDetails.get("ProductSKU"));
			searchPage.clickProdcuctInSearchPage();
			pdpPage.selectSizeCountry(prodDetails.get("CounrtySize"));
			pdpPage.chooseSize(prodDetails.get("Size"));
			pdpPage.clickAddToBag();
		}	
	}

}
