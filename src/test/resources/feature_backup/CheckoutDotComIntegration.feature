Feature: 6thstreet.com - test Checkout Sandbox 

@CheckoutPaymentSuccess 
Scenario: TS_checkout_01: Checkout application Payment Success
	When Launch Checkout Sandbox URL "CheckoutSandboxURL" 
	When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
	And User clicks on Checkout Sandbox login button 
	Then User should be landed into Checkout Sandbox dashboard 
	When User clicks on payments menu
	And User inputs order number in Checkout payments page
	And User clicks on Checkout Payment Details
	Then Verify status "Payment authorized" and "Payment captured" in Checkout payment details

@CheckoutPaymentRefund 
Scenario: TS_Checkout_02:Checkout application Payment Success
	When Launch Checkout Sandbox URL "CheckoutSandboxURL" 
	When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
	And User clicks on Checkout Sandbox login button 
	Then User should be landed into Checkout Sandbox dashboard 
	When User clicks on payments menu
	And User inputs order number in Checkout payments page
	And User clicks on Checkout Payment Details
	Then Verify status "Payment refunded" refund in Checkout payment details
	
@CheckoutPaymentPartialRefund 
Scenario: TS_checkout_03:Checkout application Payment Success
	When Launch Checkout Sandbox URL "CheckoutSandboxURL" 
	When User enters Checkout Sandbox valid login details "checkoutsandboxuser" username and "checkoutsandboxuser" password in the login popup 
	And User clicks on Checkout Sandbox login button 
	Then User should be landed into Checkout Sandbox dashboard 
	When User clicks on payments menu
	And User inputs order number in Checkout payments page
	And User clicks on Checkout Payment Details
	Then Verify status "Payment partial refund" partial refund in Checkout payment details	