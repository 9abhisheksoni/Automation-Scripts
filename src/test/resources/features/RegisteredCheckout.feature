Feature: 6thstreet.com - Registered User Place Order Scenarios

    @Smoke @CODPayment @RegisteredUser @SCtesting
	Scenario Outline: TS_RegisteredCheckout_01 - Registered User of 6thstreet.com site should be able to place order using cod 
		When User clicks on login link 
#		When User enters valid login details "validuser" username and "validuser" password in the login popup 
#		And User clicks on login button 
#		And user login is successfull 
#		And Home page is displayed 
#		And User clears cart
#		And User clears saved address
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And user clicks on product tile in result 
#		And user selects countrySize as "EU", size as "10Y" 
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And user enters the valid details for shipping address 
		And user reset Stored Payments
#		And user selects payment option as "COD" 
#		And user clicks on place order button 
#		Then Order placing should be successful 
#		And user clicks on my account top menu 
#		Then verify order status in history to be "Processing" 
#		And click on view order 
#		Then Verify order status in details to be "Processing" 
#		Then Verify order payment in details to be "Cash on delivery"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|

	@Smoke @CreditCardPayment @RegisteredUser 
	Scenario Outline: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using visa credit card 
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
		And user selects payment option as "CC_Visa" 
#		And user clicks on place order button 
#		Then Order placing should be successful 
#		And user clicks on my account top menu 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
#		When Launch Checkout Sandbox URL "CheckoutSandboxURL"
#		When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
#		And User clicks on Checkout Sandbox login button
#		Then User should be landed into Checkout Sandbox dashboard 
#		When User clicks on payments menu
#		And User inputs order number in Checkout payments page
#		And User clicks on Checkout Payment Details 
#		Then Verify status "Payment authorized" and "Payment captured" in Checkout payment details
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_03 - Registered User of 6thstreet.com site should be able to place order using master credit card 
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
		And user selects payment option as "CC_Master" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		When Launch Checkout Sandbox URL "CheckoutSandboxURL"
		When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
		And User clicks on Checkout Sandbox login button
		Then User should be landed into Checkout Sandbox dashboard 
		When User clicks on payments menu
		And User inputs order number in Checkout payments page
		And User clicks on Checkout Payment Details 
		Then Verify status "Payment authorized" and "Payment captured" in Checkout payment details
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	@CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_04 - Registered User of 6thstreet.com site should be able to place order using amex credit card 
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
		And user selects payment option as "CC_Amex" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		When Launch Checkout Sandbox URL "CheckoutSandboxURL"
		When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
		And User clicks on Checkout Sandbox login button
		Then User should be landed into Checkout Sandbox dashboard 
		When User clicks on payments menu
		And User inputs order number in Checkout payments page
		And User clicks on Checkout Payment Details 
		Then Verify status "Payment authorized" and "Payment captured" in Checkout payment details
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
		
	@TabbyPayInInstallments @RegisteredUser 
	Scenario Outline: TS_RegisteredCheckout_05 - Registered User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
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
		And user selects payment option as "TabbyPayInInstallments" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Pay in installments" 
		When Launch Tabby Merchant URL "MerchantURL" 
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button 
		And User inputs tabby order number in merchant page 
		Then Verify country "ARE" status "New" order 
		
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
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Pay Later" 
		When Launch Tabby Merchant URL "MerchantURL" 
		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
		And User clicks on merchant login button 
		And User inputs tabby order number in merchant page 
		Then Verify country "ARE" status "New" order 
		
	Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425728-230-NUDE|EU|41|1|
		
	@Smoke @Coupon
	Scenario Outline: TS_RegisteredCheckout_07 - User is able to apply percentage off coupon to payment
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
	And User applies "6stest" on Payment Page
	Then Discount of "10" percent should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		

	@Smoke @Coupon
	Scenario Outline: TS_RegisteredCheckout_08 - User is able to apply amount off coupon to payment
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
	And User applies "FRIENDS101" on Payment Page
	Then Discount of "100" amount should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	