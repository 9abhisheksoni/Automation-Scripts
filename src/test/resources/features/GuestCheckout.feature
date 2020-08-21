Feature: 6thstreet.com - Guest User Place Order Scenarios


	@Smoke @CODPayment @GuestUser 
	Scenario Outline: TS_GuestCheckout_01 - Guest User of 6thstreet.com site should be able to place order using cod 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "COD"  
		And user clicks on place order button 
		Then Order placing should be successful 
	
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Smoke @CreditCardPayment @GuestUser  
	Scenario Outline: TS_GuestCheckout_02 - Guest User of 6thstreet.com site should be able to place order using visa card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "CC_VISA"  
		And user clicks on place order button 
		Then Order placing should be successful 
	
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @GuestUser 
	Scenario Outline: TS_GuestCheckout_03 - Guest User of 6thstreet.com site should be able to place order using master card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "CC_Master"  
		And user clicks on place order button 
		Then Order placing should be successful 
	
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @GuestUser 
	Scenario Outline: TS_GuestCheckout_04 - Guest User of 6thstreet.com site should be able to place order using amex card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "CC_Amex"  
		And user clicks on place order button 
		Then Order placing should be successful 
	
	Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Smoke @TabbyPayInInstallments @GuestUser 
	Scenario Outline: TS_GuestCheckout_05 - Guest User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "TabbyPayInInstallments" 
		And user clicks on place order button 
		And user fills all tabby details
		Then Order placing should be successful 
		When Launch Tabby Merchant URL "<MerchantURL>"
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button
		And User inputs tabby order number in merchant page
		And Verify country "ARE" status "New" order
			
	Examples:  
		| MerchantURL                 |Product |CountrySize|Size|Qty|
		| https://merchant.tabby.ai/auth |DSW425730-230-NUDE |EU|41|1|
		
	@Smoke @TabbyPayLater @GuestUser  
	Scenario Outline: TS_GuestCheckout_06 - Guest User of 6thstreet.com site should be able to place order using TabbyPayLater 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And guest user enters the valid details for "uae" shipping address 
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details
		Then Order placing should be successful 
		When Launch Tabby Merchant URL "<MerchantURL>"
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button
		And User inputs tabby order number in merchant page
		And Verify country "ARE" status "New" order 
		
	Examples:  
		| MerchantURL                 |Product |CountrySize|Size|Qty|
		| https://merchant.tabby.ai/auth |DSW425730-230-NUDE |EU|41|1|
	
	