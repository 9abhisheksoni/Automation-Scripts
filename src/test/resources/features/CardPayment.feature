Feature: 6thstreet.com - Registered User Place Order Scenarios

@Smoke @CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using visa credit card 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
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
		And user selects payment option as "CC_Visa" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
@CreditCardPayment @SavedCardPayment
	Scenario Outline: TS_RegisteredCheckout_03 - Registered User of 6thstreet.com site should be able to place order using Saved credit card 
		When User clicks on login link 
		When User enters "Savedcarduser" login details in the login popup 
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
		And user selects saved card and enters cvv
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option 
		Then order history page is displayed 
		Then verify order status in history to be "Payment_success" 
		And click on view order 
		Then Verify order status in details to be "Payment Success" 
		Then Verify order payment in details to be "Saved Cards"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|	