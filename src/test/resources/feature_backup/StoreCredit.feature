Feature: 6thstreet.com - Registered User Place Order Using SC Scenarios

Background: User logs into application and clears cart - addresses

		When User clicks on login link 
		When User enters valid login details "clubuser" username and "clubuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And User clears saved address
	#	And Configure SC Availability
		
	@Smoke @CODPayment @StoreCredit 
	Scenario Outline: TS_RegisteredCheckout_09 - Registered User of 6thstreet.com site should be able to place order using store credit if it is enabled
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "<Size>" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And selects use storecredit toggle if user is eligible to use
		
			Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	