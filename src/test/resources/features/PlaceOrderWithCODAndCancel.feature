Feature: 6thstreet.com - Guest User Place Order via COD and Admin Cancels the order

	@Smoke @CODPayment @GuestUser
	Scenario Outline: TS_GuestCheckout_01 - Guest User of 6thstreet.com site should be able to place order using cod 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address 
		And user selects payment option as "COD"  
		And user clicks on place order button 
		Then Order placing should be successful
		When Launch Admin Magento URL "MagentoURL" 
		When User enters magento valid login details "magentouser" username and "magentouser" password in the login popup 
		And User clicks on magento login button 
		Then user should be landed into Magento dashboard 
		When user clicks on sales module 
		And user clicks on order sub module 
		Then user should be landed into Orders page 
		When user clicks on Filters button 
		And user enters the order ID
		And user clicks on Apply Filters button 
		Then Search result should be displayed 
		When user clicks on view link 
		And user is in order details page 
		Then Verify Magento Order Status to be "Processing" 
		#And Verify the Payment Method in Magento as "Pay in installments" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Payment Aborted" 
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
		
	@Smoke @CODPayment @GuestUser @TabbyTest
	Scenario Outline: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using cod
	When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
		When Launch Admin Magento URL "MagentoURL" 
		When User enters magento valid login details "magentouser" username and "magentouser" password in the login popup 
		And User clicks on magento login button 
		Then user should be landed into Magento dashboard 
		When user clicks on sales module 
		And user clicks on order sub module 
		Then user should be landed into Orders page 
		When user clicks on Filters button 
		And user enters the order ID
		And user clicks on Apply Filters button 
		Then Search result should be displayed 
		When user clicks on view link 
		And user is in order details page 
		Then Verify Magento Order Status to be "Processing" 
		#And Verify the Payment Method in Magento as "Pay in installments" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Payment Aborted"
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|