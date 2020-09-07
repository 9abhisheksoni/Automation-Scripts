Feature: 6thstreet.com - Registered User Place Order Scenarios

@Smoke @CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckoutUAT_01 - Registered User of 6thstreet.com site should be able to add multiple products into cart 
		When User clicks on login link 
		When User enters valid login details "<username>" username and "<password>" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		#And User clears cart
		And user enters product name as "0301822241-DARK-BLUE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "L-1 left in stock"
		And user clicks on ADDTOBAG button
		And user enters product name as "111704665-WASHED-MED-INDIGO" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "M-low stock"
		And user clicks on ADDTOBAG button
		And user enters product name as "0111804164-BLUE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "30-low stock"
		And user clicks on ADDTOBAG button
		And user enters product name as "0111801515-BEIGE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as "38"
		And user clicks on ADDTOBAG button
		And user enters product name as "0101901802-BLACK" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as "S"
		And user clicks on ADDTOBAG button
		And user enters product name as "0101832245-RED" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as "S"
		And user clicks on ADDTOBAG button
		And user enters product name as "BHG1601775-W19-WHITE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "3Y-1 left in stock"
		And user clicks on ADDTOBAG button
		And user enters product name as "CHB1804818-BLUE" in search text box and click search icon		
		And user clicks on product tile in result 
		#And user selects countrySize as "EU", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "CHG1904606-LIGHT-PINK" in search text box and click search icon		
		And user clicks on product tile in result 
		#And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And user enters the valid details for shipping address 
#		And user selects payment option as "CC_Visa" 
#		And user clicks on place order button 
#		Then Order placing should be successful 
#		And user clicks on my account top menu
#		And user selects order history option 
#		Then order history page is displayed 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		
	Examples:  
	|username|password|
	| uat_automation_tester51@yopmail.com | 6Thstreet! |
	| uat_automation_tester52@yopmail.com | 6Thstreet! |
	| uat_automation_tester53@yopmail.com | 6Thstreet! |
	| uat_automation_tester54@yopmail.com | 6Thstreet! |
	| uat_automation_tester55@yopmail.com | 6Thstreet! |
	| uat_automation_tester56@yopmail.com | 6Thstreet! |
	| uat_automation_tester57@yopmail.com | 6Thstreet! |
	| uat_automation_tester58@yopmail.com | 6Thstreet! |
	| uat_automation_tester59@yopmail.com | 6Thstreet! |
	| uat_automation_tester60@yopmail.com | 6Thstreet! |
	

@Smoke
Scenario Outline: TS_RegisteredCheckoutUAT_02 - Registered User of 6thstreet.com site should be able to place order for multiple products 
#		When User clicks on login link 
#		When User enters valid login details "uatvaliduser" username and "uatvaliduser" password in the login popup 
#		And User clicks on login button 
#		And user login is successfull 
#		And Home page is displayed 
		#And User clears cart
		And user enters product name as "<Product>" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "<CountrySize>", size as "<Size>"
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
#		And user clicks on my account top menu
#		And user selects order history option 
#		Then order history page is displayed 
#		Then verify order status in history to be "Payment_success" 
#		And click on view order 
#		Then Verify order status in details to be "Payment Success" 
#		Then Verify order payment in details to be "Pay by Credit / Debit Card"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|BHG1905167-00-MIX|EU|18M-low stock|	