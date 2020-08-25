package stepdefinition;

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

}
