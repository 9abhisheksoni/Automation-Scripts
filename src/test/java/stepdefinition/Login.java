package stepdefinition;

import java.util.Scanner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class Login {

	LoginPage loginPage = new LoginPage();

	@When("^User clicks on login link$")
	public void user_clicks_on_link() {
		loginPage.clickOnLoginOrRegisterOption();
	}

	@When("^User enters valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup$")
	public void user_enters_valid_login_details_and_in_the_login_popup(String username, String password) {
		loginPage.enterLoginDetails(username, password);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	}

	@When("^user login is successfull$")
	public void user_login_is_successfull() {
		loginPage.verifyLogin();
	}

	@Then("^User login as guest user \"([^\"]*)\"$")
	public void user_login_as_guest_user(String username) {
		loginPage.enterGuestEmail(username);
	}

	@Then("^User clicks on Guestlogin button$")
	public void user_clicks_on_Guestlogin_button() {
		loginPage.clickOnContinueAsGuest();
	}

	@When("^User enters merchant valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup$")
	public void user_enters_merchant_valid_login_details_username_and_password_in_the_login_popup(String merchantEmail,
			String merchnatPwd) {
		loginPage.enterMerchangtEmailandPwd(merchantEmail, merchnatPwd);
	}

	@When("^User clicks on merchant login button$")
	public void user_clicks_on_merchant_login_button() {
		loginPage.clickOnMerchantLogin();
	}

	@When("^User enters valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup from feature$")
	public void user_enters_valid_login_details_and_in_the_login_popup_from_feature(String username, String password) {
		loginPage.enterLoginDetailsFromFeature(username, password);
	}

	@When("^User enters Checkout Sandbox valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup$")
	public void user_enters_Checkout_Sandbox_valid_login_details_username_and_password_in_the_login_page(
			String checkoutEmail, String checkoutPwd) {
		loginPage.enterCheckoutSandboxUserandPwd(checkoutEmail, checkoutPwd);
	}

	@When("^User clicks on Checkout Sandbox login button$")
	public void user_clicks_on_Checkout_Sandbox_login_button() {
		loginPage.clickOnCheckoutSandboxLogin();
	}

	@And("^user clears Wishlist$")
	public void user_clears_Wishlist() {
		loginPage.clearWishlist();
	}

	@Then("^user should be able to see product in Wishlist$")
	public void user_should_be_able_to_see_product_in_Wishlist() {
		loginPage.verifyWishlistProductAdded();
	}

	@And("^User Logsout$")
	public void User_Logsout() {
		loginPage.clickLogoutLink();
	}

	@Then("^Logout is successfull$")
	public void Logout_is_successfull() {
		loginPage.verifySuccessfulLogout();
	}

	@Then("^User clears saved address$")
	public void User_clears_saved_address() {
		loginPage.clearSavedAddress();
	}

	@Then("^Address should be saved$")
	public void address_should_be_saved() {
		loginPage.verifyAddressSaved();
	}

	@Then("^Default address should be updated$")
	public void default_address_should_be_updated() {
		loginPage.verifyAddressDefaulted();
	}

	@And("^User saves valid Address$")
	public void user_saves_valid_address() {
		loginPage.saveAddress();
	}

	@And("^User edits, makes address Default$")
	public void user_edits_makes_address_default() {
		loginPage.editAndMakeAddressDefault();
	}

	@And("^User Deletes saved address$")
	public void user_deletes_saved_address() {
		loginPage.deleteAllSavedAddress();
	}
	
	@Then("^address should be deleted$")
	public void address_should_be_deleted() {
		loginPage.verifyEmptyAddressBook();
	}
	
	@When("^Click on Customer$")
	public void click_on_Customer() {
		loginPage.clickCustomer();
		
	}

	
	@When("^Click on Club Apparel Loyalty$")
	public void click_on_Club_Apparel_Loyalty() {
		loginPage.clickClubApparelLoyalty();
	}
	
	
	@When("^Verify Club apparel logo displayed$")
	public void verify_Club_apparel_logo_displayed() {
		loginPage.verifyCLubApparelLogoDisplayed();
	}

	@When("^Verify AVAIL LOYALTY BENEFITS ON (\\d+)THSTREET is displayed$")
	public void verify_AVAIL_LOYALTY_BENEFITS_ON_THSTREET_is_displayed(int arg1) 
	{
		loginPage.verifyAvailLoyaltyDisplayed();
	}

	@When("^Verify TIERS BENEFIT is displayed$")
	public void verify_TIERS_BENEFIT_is_displayed() {
		loginPage.verifyTierBenifitDisplayed();
	}

	@When("^Verify REDEMPTION VALUE is displayed$")
	public void verify_REDEMPTION_VALUE_is_displayed() {
		loginPage.verifyRedemptionValueDisplayed();
	}

	@When("^Verify Link your Club Apparel account and start earning points is displayed$")
	public void verify_Link_your_Club_Apparel_account_and_start_earning_points_is_displayed() {
		loginPage.verifyLinkYourCADisplayed();
	}


	@When("^Verify LINK YOUR ACCOUNT button is displayed$")
	public void verify_LINK_YOUR_ACCOUNT_button_is_displayed() {
		loginPage.verifyLinkYourAccountButtonDisplayed();
	}
	
	@When("^Click on LINK YOUR Account button$")
	public void click_on_LINK_YOUR_Account_button() {
		loginPage.clickOnLINKYOURAcct();
	}

	@When("^Click on Select flag$")
	public void click_on_Select_flag() {
		loginPage.clicOnCountryFlag();
	}

	@When("^input country \"([^\"]*)\"$")
	public void input_country(String countryFlag) {
		loginPage.inputCountryFlag(countryFlag);
	}

	@When("^input Telephone Number \"([^\"]*)\"$")
	public void input_Telephone_Number(String tele) {
		loginPage.inputTelephoneNumber(tele);
	}

	@When("^Click on LINK ACCOUNT$")
	public void click_on_LINK_ACCOUNT() {
		loginPage.clickOnLinkAccount();
	}

	@When("^Verify Enter the verification code we sent to is displayed$")
	public void verify_Enter_the_verification_code_we_sent_to_is_displayed() {
		loginPage.verifyEntertheVerificationCode();
	}
	
	@When("^Verify Link your club apparel message is displayed on cart page$")
	public void verify_Link_your_club_apparel_message_is_displayed_on_cart_page() {
		loginPage.verifyLinkyourAccountMsg();
	}
	
	@When("^verify About club apparel section is displayed$")
	public void verify_About_club_apparel_section_is_displayed() {
		loginPage.verifyAboutClubApparelSec();
	}

	@When("^verfy Rewards section is displayed$")
	public void verfy_Rewards_section_is_displayed() {
		loginPage.verifyRewardsSec();
	}
	
	@And("^Login manually$")
	public void Login_manually() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@And("^Configure SC Availability using Magento \"([^\"]*)\" username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void configure_SC_Availability_using_Magento(String MagentoURL, String magentoUser, String magentoPwd) {
		loginPage.verifyStoreCreditAvailability(MagentoURL, magentoUser, magentoPwd);
	}
	
	
}
