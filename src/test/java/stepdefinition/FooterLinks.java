package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FooterLinksRedirectPage;
import pageObjects.HomePage;

public class FooterLinks {	
	
	HomePage home = new HomePage();	
	
	@When("^User clicks on footer link \"([^\"]*)\"$")
	public void user_clicks_on_footer_link(String footerLink)  {
	   home.clickOnFooterLink(footerLink);
	}

	@Then("^User should be landed into \"([^\"]*)\" web page$")
	public void user_should_be_landed_into_web_page(String landingPage)  {		
		home.verifyFooterLanding(landingPage);
	}

}
