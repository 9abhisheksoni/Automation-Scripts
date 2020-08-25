package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MagentoDashboardPage;
import pageObjects.MagentoOrdersDetailPage;
import pageObjects.MagentoOrdersViewPage;
import pageObjects.OrderSuccessPage;
import pageObjects.PaymentPage;

public class InvoceAndShipment {
	
	MagentoDashboardPage dashboardPage=new MagentoDashboardPage();
	MagentoOrdersViewPage orderViewPage=new MagentoOrdersViewPage();
	MagentoOrdersDetailPage orderDetailsPage=new MagentoOrdersDetailPage();
	OrderSuccessPage orderSuccess = new OrderSuccessPage();
	LoginPage loginPage = new LoginPage();
	PaymentPage paymentPage = new PaymentPage();
	
	@When("^user clicks on sales module$")
	public void user_clicks_on_sales_module()  {
		dashboardPage.clickSalesMenu();
	}

	@When("^user clicks on order sub module$")
	public void user_clicks_on_order_sub_module()  {
		dashboardPage.clickOrdersMenuItem();
	}

	@Then("^user should be landed into Orders page$")
	public void user_should_be_landed_into_Orders_page()  {
		orderViewPage.verifyOrdersFiltersPageIsDisplayed();
	}

	@When("^user clicks on Filters button$")
	public void user_clicks_on_Filters_button() throws Throwable {
		orderViewPage.clickFilters();
	}

	@When("^user enters the order ID$")
	public void user_enters_the_order_ID()  {
		orderViewPage.clickClearAllFilters();
		orderViewPage.enterOrderID();
	}

	@When("^user clicks on Apply Filters button$")
	public void user_clicks_on_Apply_Filters_button()  {
		orderViewPage.clickApplyFilters();
	}

	@Then("^Search result should be displayed$")
	public void search_result_should_be_displayed()  {
		orderViewPage.verifySearchResult();
	}

	@When("^user clicks on view link$")
	public void user_clicks_on_view_link()  {
		orderViewPage.clickView();
	}

	@When("^user is in order details page$")
	public void user_is_in_order_details_page()  {
		orderDetailsPage.verifyOrderDetailsPage();
	}

	@When("^user clicks on Invoice button$")
	public void user_clicks_on_Invoice_button()  {
		orderDetailsPage.clickInvoice();
	}

	@Then("^user should be redirected to Invoice page$")
	public void user_should_be_redirected_to_Invoice_page()  {
		orderDetailsPage.verifyInvoicePage();
	}

	@When("^user slects payment capture method as \"([^\"]*)\"$")
	public void user_slects_payment_capture_method_as(String captureType) {
	   if(captureType.equalsIgnoreCase("Capture Offline")) {
		   orderDetailsPage.captureOffline();
	   } else if(captureType.equalsIgnoreCase("Capture Online")) {
		   orderDetailsPage.captureOnline();
	   } else if(captureType.equalsIgnoreCase("Not Capture")) {
		   orderDetailsPage.notCapture();
	   } else {
		   System.out.println("Payment capture type is undefined");
	   }
	}

	@When("^user clicks on submit invoice button$")
	public void user_clicks_on_submit_invoice_button()  {
		orderDetailsPage.clickSubmitInvoice();
	}

	@Then("^invoice should be generated$")
	public void invoice_should_be_generated()  {
		orderDetailsPage.verifyInvoiceCreationStatus();
	}

	@When("^user clicks ship button$")
	public void user_clicks_ship_button()  {
		orderDetailsPage.clickShip();
	}

	@Then("^user should be redirected to shipment page$")
	public void user_should_be_redirected_to_shipment_page()  {
		orderDetailsPage.verifyShipmentPage();
	}

	@When("^user clicks on add tracking number button$")
	public void user_clicks_on_add_tracking_number_button()  {
		orderDetailsPage.clickAddTrackingNumber();
	}

	@When("^user selects carrier partner as \"([^\"]*)\"$")
	public void user_selects_carrier_partner_as(String carrierPartner) {
	    if(carrierPartner.equalsIgnoreCase("DHL")) {
	    	orderDetailsPage.selectCarrierDhl();
	    } else if(carrierPartner.equalsIgnoreCase("Fetchr")) {
	    	orderDetailsPage.selectCarrierFetchr();
	    } else if(carrierPartner.equalsIgnoreCase("Custom")) {
	    	orderDetailsPage.selectCarrierCustom();
	    } else if(carrierPartner.equalsIgnoreCase("United Parcel Service")) {
	    	orderDetailsPage.selectCarrierUnitedParcelService();
	    } else if(carrierPartner.equalsIgnoreCase("Fedex")) {
	    	orderDetailsPage.selectCarrierFedex();
	    } else if(carrierPartner.equalsIgnoreCase("Federal Express")) {
	    	orderDetailsPage.selectCarrierFederalExpress();
	    } else if(carrierPartner.equalsIgnoreCase("United States Postal Service")) {
	    	orderDetailsPage.selectCarrierUnitedStatesPostalService();
	    }
	    	
	}

	/*
	 * @When("^user enters carrier title$") public void user_enters_carrier_title()
	 * { orderDetailsPage.enterCarrierTitle(); }
	 */

	@When("^user enters carrier tracking number as \"([^\"]*)\"$")
	public void user_enters_carrier_tracking_number_as(String trackingNumber)  {
		orderDetailsPage.enterTrackingNumber(trackingNumber);
	}

	@When("^user clicks on submit shipment$")
	public void user_clicks_on_submit_shipment()  {
		orderDetailsPage.clickSubmitShipment();
	}

	@Then("^shipment should be created$")
	public void shipment_should_be_created()  {
		orderDetailsPage.verifyShipmentCreationStatus();
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
}
