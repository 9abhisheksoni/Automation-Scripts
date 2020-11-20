Feature: 6thstreet.com - Registered User Place Order Scenarios

Background: User logs into application and clears cart - addresses

		When User clicks on login link 
		When User enters valid login details "clubuser" username and "clubuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And User clears saved address

    @Smoke @CODPayment @RegisteredUser @SCtest
	Scenario Outline: TS_RegisteredCheckout_01 - Registered User of 6thstreet.com site should be able to place order using cod 
		
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|

	@Smoke @CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using visa credit card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "CC_Visa" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"	
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_03 - Registered User of 6thstreet.com site should be able to place order using master credit card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "CC_Master" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	@CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_04 - Registered User of 6thstreet.com site should be able to place order using amex credit card 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "CC_Amex" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
		
	@TabbyPayInInstallments @RegisteredUser 
	Scenario Outline: TS_RegisteredCheckout_05 - Registered User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address
		And user reset Stored Payments 
		And user selects payment option as "TabbyPayInInstallments" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay in installments" 
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
	Examples:  
		| MerchantURL                 |Product |CountrySize|Size|Qty|
		| https://merchant.tabby.ai/auth |DSW425728-230-NUDE|EU|41|1|
		
	@Smoke @TabbyPayLater @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_06 - Registered User of 6thstreet.com site should be able to place order using TabbyPayLater 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart 
		And User clears saved address
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "41" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay Later" 
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
	Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425728-230-NUDE|EU|41|1|
		
	
		
		
	@Smoke @CODPayment @StoreCredit @run
	Scenario Outline: TS_RegisteredCheckout_09 - Registered User of 6thstreet.com site should be able to place order using store credit if it is enabled
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And selects use storecredit toggle if user is eligible to use
		
			Examples:  
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	