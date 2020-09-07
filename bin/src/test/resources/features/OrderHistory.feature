Feature: 6thstreet.com - Registered User Order History Scenarios

    @Smoke 
	Scenario Outline: TS_OrderHistory_01 - Registered User of 6thstreet.com site should be able to place order using cod 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for "uae" shipping address 
		And user selects payment option as "COD" 
		And user clicks on place order button 
		And Order placing should be successful 
		And user clicks on continue shipping button
		And user clicks on my account top menu
		And user selects order history option
		Then order history page is displayed
		Then verify order status
		
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|

	