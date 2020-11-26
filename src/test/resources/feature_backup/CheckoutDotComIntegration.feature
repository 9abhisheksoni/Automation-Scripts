Feature: 6thstreet.com - test Checkout Sandbox 

Background: User log into application
		When User clicks on login link 
		When User enters valid login details "clubuser" username and "clubuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And User clears saved address	
		

@CheckoutIntegration @Regression
Scenario Outline: TS_checkout_01: Checkout application Payment Success	 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "<Size>" 
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

@CheckoutIntegration @Regression
Scenario Outline: TS_Checkout_02:Checkout application Payment Refund
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "<Size>" 
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
		When Launch Checkout Sandbox URL "CheckoutSandboxURL" 
		When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
		And User clicks on Checkout Sandbox login button 
		Then User should be landed into Checkout Sandbox dashboard
		When User clicks on payments menu
		And User inputs order number in Checkout payments page
		And User clicks on Checkout Payment Details
		Then Verify status "Payment refunded" refund in Checkout payment details
		
	Examples:  
	|Product                   |CountrySize|Size|Qty|
	|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	