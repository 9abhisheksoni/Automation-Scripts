Feature: 6thstreet.com - Registered User Save Card

@TestSaveCreditCard @Regression
	Scenario Outline: TS_SaveCreditCard_01 - Registered User of 6thstreet.com site should be able to save the card 
		When User clicks on login link 
		When User enters "Savedcarduser" login details in the login popup  
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
		And user selects payment option as "CC_Visa" and clicks on Save Card
		And user clicks on place order button 
		Then Order placing should be successful 
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|