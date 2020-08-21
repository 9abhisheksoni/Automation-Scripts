package stepdefinition;

import cucumber.api.java.en.When;
import pageObjects.PDPPage;

public class PDP {
	
	PDPPage pdpPage = new PDPPage();
	
	@When("^user selects countrySize as \"([^\"]*)\", size as \"([^\"]*)\"$")
	public void user_selects_countrySize_as_size_as(String country, String size) {
		pdpPage.selectSizeCountry(country);
		pdpPage.chooseSize(size);
	}

	@When("^user clicks on ADDTOBAG button$")
	public void user_clicks_on_ADDTOBAG_button() {
		pdpPage.clickAddToBag();
	}

}
