Feature: 6thstreet.com - Guest User Place Order Scenarios


	@Sanity @CODPayment @GuestUser
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
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Sanity @CreditCardPayment @GuestUser @CheckoutPaymentSuccess 
	Scenario Outline: TS_GuestCheckout_02 - Guest User of 6thstreet.com site should be able to place order using visa card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address
		And user selects payment option as "CC_VISA"  
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"

	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @GuestUser
	Scenario Outline: TS_GuestCheckout_03 - Guest User of 6thstreet.com site should be able to place order using master card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address 
		And user selects payment option as "CC_Master"  
		And user clicks on place order button 
		Then Order placing should be successful
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @GuestUser
	Scenario Outline: TS_GuestCheckout_04 - Guest User of 6thstreet.com site should be able to place order using amex card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address 
		And user selects payment option as "CC_Amex"  
		And user clicks on place order button 
		Then Order placing should be successful
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Sanity @TabbyPayInInstallments @GuestUser 
	Scenario Outline: TS_GuestCheckout_05 - Guest User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address
		And user selects payment option as "TabbyPayInInstallments" 
		And user clicks on place order button 
		And user fills all tabby details
		Then Order placing should be successful 
		When Launch Tabby Merchant URL "MerchantURL"
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button
		And User inputs tabby order number in merchant page
		And Verify country "ARE" status "New" order
			
	Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425728-230-NUDE|EU|41|1|
		
	@Sanity @TabbyPayLater @GuestUser  
	Scenario Outline: TS_GuestCheckout_06 - Guest User of 6thstreet.com site should be able to place order using TabbyPayLater 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details
		Then Order placing should be successful 
		When Launch Tabby Merchant URL "MerchantURL"
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button
		And User inputs tabby order number in merchant page
		And Verify country "ARE" status "New" order 
		
	Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425728-230-NUDE|EU|41|1|
	
	