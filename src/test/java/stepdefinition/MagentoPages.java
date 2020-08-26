package stepdefinition;

import commonHelper.GenericHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MagentoDashboardPage;
import pageObjects.MagentoOrdersDetailPage;
import pageObjects.MagentoOrdersViewPage;
import pageObjects.OrderSuccessPage;
import pageObjects.PaymentPage;

public class MagentoPages {

	MagentoDashboardPage dashboardPage = new MagentoDashboardPage();
	MagentoOrdersViewPage orderViewPage = new MagentoOrdersViewPage();
	MagentoOrdersDetailPage magentoOrderDetailsPage = new MagentoOrdersDetailPage();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();
	LoginPage loginPage = new LoginPage();
	PaymentPage paymentPage = new PaymentPage();
	GenericHelper genericHelper = new GenericHelper();

	@When("^user clicks on sales module$")
	public void user_clicks_on_sales_module() {
		dashboardPage.clickSalesMenu();
	}

	@When("^user clicks on order sub module$")
	public void user_clicks_on_order_sub_module() {
		dashboardPage.clickOrdersMenuItem();
	}

	@Then("^user should be landed into Orders page$")
	public void user_should_be_landed_into_Orders_page() {
		orderViewPage.verifyOrdersFiltersPageIsDisplayed();
	}

	@When("^user clicks on Filters button$")
	public void user_clicks_on_Filters_button() {
		orderViewPage.clickClearAllFilters();
		orderViewPage.clickFilters();
	}

	@When("^user enters the order ID$")
	public void user_enters_the_order_ID() {
		orderViewPage.enterOrderID();
	}

	@When("^user clicks on Apply Filters button$")
	public void user_clicks_on_Apply_Filters_button() {
		orderViewPage.clickApplyFilters();
	}

	@Then("^Search result should be displayed$")
	public void search_result_should_be_displayed() {
		orderViewPage.verifySearchResult();
	}

	@When("^user clicks on view link$")
	public void user_clicks_on_view_link() {
		orderViewPage.clickView();
	}

	@When("^user is in order details page$")
	public void user_is_in_order_details_page() {
		magentoOrderDetailsPage.verifyOrderDetailsPage();
	}

	@When("^user clicks on Invoice button$")
	public void user_clicks_on_Invoice_button() {
		magentoOrderDetailsPage.clickInvoice();
	}

	@Then("^user should be redirected to Invoice page$")
	public void user_should_be_redirected_to_Invoice_page() {
		magentoOrderDetailsPage.verifyInvoicePage();
	}

	@When("^user slects payment capture method as \"([^\"]*)\"$")
	public void user_slects_payment_capture_method_as(String captureType) {
		if (captureType.equalsIgnoreCase("Capture Offline")) {
			magentoOrderDetailsPage.captureOffline();
		} else if (captureType.equalsIgnoreCase("Capture Online")) {
			magentoOrderDetailsPage.captureOnline();
		} else if (captureType.equalsIgnoreCase("Not Capture")) {
			magentoOrderDetailsPage.notCapture();
		} else {
			System.out.println("Payment capture type is undefined");
		}
	}

	@When("^user clicks on submit invoice button$")
	public void user_clicks_on_submit_invoice_button() {
		magentoOrderDetailsPage.clickSubmitInvoice();
	}

	@Then("^invoice should be generated$")
	public void invoice_should_be_generated() {
		magentoOrderDetailsPage.verifyInvoiceCreationStatus();
	}

	@When("^user clicks ship button$")
	public void user_clicks_ship_button() {
		magentoOrderDetailsPage.clickShip();
	}

	@Then("^user should be redirected to shipment page$")
	public void user_should_be_redirected_to_shipment_page() {
		magentoOrderDetailsPage.verifyShipmentPage();
	}

	@When("^user clicks on add tracking number button$")
	public void user_clicks_on_add_tracking_number_button() {
		magentoOrderDetailsPage.clickAddTrackingNumber();
	}

	@When("^user selects carrier partner as \"([^\"]*)\"$")
	public void user_selects_carrier_partner_as(String carrierPartner) {
		if (carrierPartner.equalsIgnoreCase("DHL")) {
			magentoOrderDetailsPage.selectCarrierDhl();
		} else if (carrierPartner.equalsIgnoreCase("Fetchr")) {
			magentoOrderDetailsPage.selectCarrierFetchr();
		} else if (carrierPartner.equalsIgnoreCase("Custom")) {
			magentoOrderDetailsPage.selectCarrierCustom();
		} else if (carrierPartner.equalsIgnoreCase("United Parcel Service")) {
			magentoOrderDetailsPage.selectCarrierUnitedParcelService();
		} else if (carrierPartner.equalsIgnoreCase("Fedex")) {
			magentoOrderDetailsPage.selectCarrierFedex();
		} else if (carrierPartner.equalsIgnoreCase("Federal Express")) {
			magentoOrderDetailsPage.selectCarrierFederalExpress();
		} else if (carrierPartner.equalsIgnoreCase("United States Postal Service")) {
			magentoOrderDetailsPage.selectCarrierUnitedStatesPostalService();
		}

	}

	@When("^user enters carrier tracking number as \"([^\"]*)\"$")
	public void user_enters_carrier_tracking_number_as(String trackingNumber) {
		magentoOrderDetailsPage.enterTrackingNumber(trackingNumber);
	}

	@When("^user clicks on submit shipment$")
	public void user_clicks_on_submit_shipment() {
		magentoOrderDetailsPage.clickSubmitShipment();
	}

	@Then("^shipment should be created$")
	public void shipment_should_be_created() {
		magentoOrderDetailsPage.verifyShipmentCreationStatus();
	}

	@When("^User enters magento valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup$")
	public void user_enters_magento_valid_login_details_username_and_password_in_the_login_popup(String magentoUser,
			String magentoPwd) {
		loginPage.enterMagnetoUserandPwd(magentoUser, magentoPwd);
	}

	@When("^User clicks on magento login button$")
	public void user_clicks_on_magento_login_button() {
		loginPage.clickOnMagentoLogin();
	}

	@When("^Launch Admin Magento URL \"([^\"]*)\"$")
	public void launch_Admin_Magento_URL(String URL) {
		orderSuccess.controlT();
		orderSuccess.launchURL(URL);
	}

	@Then("^user should be landed into Magento dashboard$")
	public void user_should_be_landed_into_Magento_dashboard() {
		loginPage.waitForMagentoDashBoard();
	}

	@When("^Verify the Payment Method in Magento as \"([^\"]*)\"$")
	public void verify_the_Payment_Method_in_Magento_as(String paymentMethod) {
		paymentPage.verifyPaymentMethod(paymentMethod);
	}

	@Then("^user goes to magento window$")
	public void user_goes_to_magento_window() {
		genericHelper.switchToWindow(genericHelper.getWindowOfUrl("admin"));
	}

	@When("^click on return tab in magento$")
	public void click_on_return_tab_in_magento() {
		magentoOrderDetailsPage.clickOnReturnsTab();
	}

	@Then("^verify the return id against frontend$")
	public void verify_the_return_id_against_frontend() {
		magentoOrderDetailsPage.verifyMagentoReturnIDAgainstFrontEnd();
	}

	@Then("^click on view return link in magento$")
	public void click_on_view_return_link_in_magento() {
		magentoOrderDetailsPage.clickOnViewReturns();
	}

	@Then("^change return status to \"([^\"]*)\"$")
	public void change_return_status_to(String status) {
		magentoOrderDetailsPage.changeReturnStatus(status);
	}

	@Then("^click on save in magento$")
	public void click_on_save_in_magento() {
		magentoOrderDetailsPage.clickOnSave();
	}

}
