Feature: 6thstreet.com - Guest User Place Order Scenarios


	@Smoke @CODPayment @Regression	
	Scenario Outline: TS_GuestCheckout_01 - Guest User of 6thstreet.com site should be able to place order using cod 
		And user enters product name as "<Product>" in search text box and click search icon 
		And click on first valid product in search result
		And user selects variation if available
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "tempUser" 
		And User clicks on Guestlogin button 
		And user submits the valid details for shipping address
		And user selects payment option as "COD"  
		And user clicks on place order button 
		Then Order placing should be successful
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Cancelled" 
		And click on view order
		Then Verify order status in details to be "Cancelled" 
	  
		Examples: 
				|Product|
				|Shoes|
		
#	@CreditCardPayment @Regression
#	Scenario Outline: TS_GuestCheckout_02 - Guest User of 6thstreet.com site should be able to place order using visa card 
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And click on first valid product in search result
#		And user selects variation if available 
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And User login as guest user "tempUser" 
#		And User clicks on Guestlogin button 
#		And user enters the valid details for shipping address
#		And user selects payment option as "CC_VISA"  
#		And user clicks on place order button 
#		Then Order placing should be successful 
#		And user clicks on my account top menu
#		When user selects order history option 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
#		And User cancels the Order
#		And user clicks on my account top menu
#		When user selects order history option
#		Then verify order status in history to be "Cancelled" 
#		And click on view order
#		Then Verify order status in details to be "Cancelled"
#
#		Examples: 
#				|Product|
#				|Shoes|
#		
#	@CreditCardPayment @Regression 
#	Scenario Outline: TS_GuestCheckout_03 - Guest User of 6thstreet.com site should be able to place order using master card 
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And click on first valid product in search result
#		And user selects variation if available
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And User login as guest user "tempUser" 
#		And User clicks on Guestlogin button 
#		And user submits the valid details for shipping address
#		And user selects payment option as "CC_Master"  
#		And user clicks on place order button 
#		Then Order placing should be successful
#		And user clicks on my account top menu
#		When user selects order history option 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
#		And User cancels the Order
#		And user clicks on my account top menu
#		When user selects order history option
#		Then verify order status in history to be "Cancelled" 
#		And click on view order
#		Then Verify order status in details to be "Cancelled"
#	
#		Examples: 
#				|Product|
#				|Shoes|
#		
#	@CreditCardPayment @Regression
#	Scenario Outline: TS_GuestCheckout_04 - Guest User of 6thstreet.com site should be able to place order using amex card 
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And click on first valid product in search result
#		And user selects variation if available
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And User login as guest user "tempUser" 
#		And User clicks on Guestlogin button 
#		And user submits the valid details for shipping address
#		And user selects payment option as "CC_Amex"  
#		And user clicks on place order button 
#		Then Order placing should be successful
#		And user clicks on my account top menu
#		When user selects order history option 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
#		And User cancels the Order
#		And user clicks on my account top menu
#		When user selects order history option
#		Then verify order status in history to be "Cancelled" 
#		And click on view order
#		Then Verify order status in details to be "Cancelled"
#	
#		Examples: 
#				|Product|
#				|Shoes|
#		
#	@TabbyPayInInstallments @Regression 
#	Scenario Outline: TS_GuestCheckout_05 - Guest User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And user sort by high to low price
#		And user filters for tabby price range
#		And click on first valid product in search result
#		And user selects variation if available 
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And User login as guest user "tempUser" 
#		And User clicks on Guestlogin button 
#		And user enters the valid details for shipping address
#		And user selects payment option as "TabbyPayInInstallments" 
#		And user clicks on place order button 
#		And user fills all tabby details
#		Then Order placing should be successful 
#		And user clicks on my account top menu 
#		And user selects order history option 
#		Then order history page is displayed 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay in installments" 
#		And User cancels the Order
#		And user clicks on my account top menu
#		When user selects order history option
#		Then verify order status in history to be "Cancelled" 
#		And click on view order
#		Then Verify order status in details to be "Cancelled"
#			
#		Examples: 
#				|Product|
#				|Shoes|
#		
#	@TabbyPayLater @Regression
#	Scenario Outline: TS_GuestCheckout_06 - Guest User of 6thstreet.com site should be able to place order using TabbyPayLater 
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And user sort by high to low price
#		And user filters for tabby price range
#		And click on first valid product in search result
#		And user selects variation if available
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And User login as guest user "tempUser" 
#		And User clicks on Guestlogin button 
#		And user submits the valid details for shipping address
#		And user selects payment option as "TabbyPayLater" 
#		And user clicks on place order button 
#		And user fills all tabby details
#		Then Order placing should be successful 
#		And user clicks on my account top menu 
#		And user selects order history option 
#		Then order history page is displayed 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay Later" 
#		And User cancels the Order
#		And user clicks on my account top menu
#		When user selects order history option
#		Then verify order status in history to be "Cancelled" 
#		And click on view order
#		Then Verify order status in details to be "Cancelled"
#		
#		Examples: 
#				|Product|
#				|Shoes|
		
	
	
