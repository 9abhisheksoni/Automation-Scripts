Feature: 6thstreet.com - Various Payment options in Payment page

    @Smoke @RegisteredUser 
	Scenario Outline: TS_RegisteredCheckout_01 - Verify the various payment options available in payment page for a Registered User of 6thstreet.com site 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And User clears saved address
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		Then verify available Payment options in payment page

	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
