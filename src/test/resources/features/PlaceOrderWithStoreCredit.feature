Feature: 6thstreet.com - Registered user place order with StoreCredit


	@Sanity @CODPayment @StoreCredit
	Scenario Outline: TS_RegisteredCheckout_01 - Registered User of 6thstreet.com site should be able to place order using store credit if it is enabled
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
		And selects use storecredit toggle if user is eligible to use
		
			Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|