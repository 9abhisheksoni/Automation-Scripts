package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FooterLinksRedirectPage;
import pageObjects.HomePage;

public class FooterLinks {	
	
	HomePage home = new HomePage();	
	FooterLinksRedirectPage footerLinks=new FooterLinksRedirectPage();
	
	@When("^User clicks on footer link \"([^\"]*)\"$")
	public void user_clicks_on_footer_link(String footerLink)  {
	    if(footerLink.equalsIgnoreCase("About6thStreet")) {
	    	home.clickOnAbout6thStreetFooterLink();
	    } else if(footerLink.equalsIgnoreCase("ConsumerRights")) {
	    	home.clickOnConsumerRightsFooterLink();
	    } else if(footerLink.equalsIgnoreCase("Disclaimer")) {
	    	home.clickOnDisclaimerFooterLink();
	    } else if(footerLink.equalsIgnoreCase("PrivacyPolicy")) {
	    	home.clickOnPrivacyPolicyFooterLink();
	    } else if(footerLink.equalsIgnoreCase("ShippingInfo")) {
	    	home.clickOnShippingInfoFooterLink();
	    } else if(footerLink.equalsIgnoreCase("ReturnInfo")) {
	    	home.clickOnReturnInfoFooterLink();
	    } else if(footerLink.equalsIgnoreCase("OrderTrack")) {
	    	home.clickOnOrderTrackFooterLink();
	    } else if(footerLink.equalsIgnoreCase("FAQs")) {
	    	home.clickOnFAQsFooterLink();
	    } else if(footerLink.equalsIgnoreCase("Feedback")) {
	    	home.clickOnFeedbackFooterLink();
	    }
	}

	@Then("^User should be landed into \"([^\"]*)\" web page$")
	public void user_should_be_landed_into_web_page(String landingPage)  {		
		if(landingPage.equalsIgnoreCase("About6thStreet")) {
			footerLinks.verifyAbout6thStreetPage();
	    } else if(landingPage.equalsIgnoreCase("ConsumerRights")) {
	    	footerLinks.switchToConsumerRightsPage();
	    	footerLinks.verifyConsumerRightsPage();
	    } else if(landingPage.equalsIgnoreCase("Disclaimer")) {
	    	footerLinks.verifyDisclaimerPage();
	    } else if(landingPage.equalsIgnoreCase("PrivacyPolicy")) {
	    	footerLinks.verifyPrivacyPolicyPage();
	    } else if(landingPage.equalsIgnoreCase("ShippingPolicy")) {
	    	footerLinks.verifyShippingPolicyPage();
	    } else if(landingPage.equalsIgnoreCase("ReturnInfo")) {
	    	footerLinks.verifyReturnInfoPage();
	    } else if(landingPage.equalsIgnoreCase("OrderTracking")) {
	    	footerLinks.verifyTrackingPage();
	    } else if(landingPage.equalsIgnoreCase("FAQs")) {
	    	footerLinks.verifyFAQsPage();
	    } else if(landingPage.equalsIgnoreCase("Feedback")) {
	    	footerLinks.verifyFeedbackPage();
	    }
	}

}
