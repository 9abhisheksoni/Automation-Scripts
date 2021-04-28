Feature: 6thStreet.com - My Account Scenarios

	
	@Sanity 
	Scenario Outline: TS_MyAccount_01 - Registered User of 6thstreet.com site should be able to place order using cod 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|