Feature: 6thstreet.com - Registered User Place Order Scenarios

@PSE32
Scenario Outline: TS_RegisteredCheckoutUAT_01 - Registered User of 6thstreet.com site should be able to add multiple products into cart 
		When User clicks on login link 
		When User enters valid login details "<username>" username and "<password>" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		#And User clears cart
		#And user search for product "<productSKU>",navigates to PDP, selects countrySize as "<counrtySize>", size as "<size>" and clicks ADDTOBAG
		And user enters product details to add to cart
		|ProductSKU|CounrtySize|Size|
		|0111804162-BLUE|EU|30|
		|0111802411-NUDE|EU|30|
		|0111804164-BLUE|EU|30|
		|0111801515-BEIGE|EU|38|
		|0101901802-BLACK|EU|S|
		|0101832245-RED|EU|S|
		|CHG1806274-IVORY|EU|6-9M|
		|CHG2007283-GREY|EU|68-74|
		|CHG2007265-00-PINK|EU|13-15|
		|BHB1601800-00-S-MULTI|EU|12-18M|		
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
#		And user selects payment option as "CC_VISA" 
#		And user clicks on place order button 
#		Then Order placing should be successful  
#		And user selects payment option as "TabbyPayInInstallments"
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful

		
	Examples:  
	|username|password|
	| uat_automation_tester51@yopmail.com | 6Thstreet! |
	| uat_automation_tester51@yopmail.com | 6Thstreet! |
#	| uat_automation_tester52@yopmail.com | 6Thstreet! |
#	| uat_automation_tester52@yopmail.com | 6Thstreet! |
#	| uat_automation_tester53@yopmail.com | 6Thstreet! |
#	| uat_automation_tester54@yopmail.com | 6Thstreet! |
#	| uat_automation_tester56@yopmail.com | 6Thstreet! |
#	| uat_automation_tester58@yopmail.com | 6Thstreet! |
#	| uat_automation_tester59@yopmail.com | 6Thstreet! |
#	| uat_automation_tester60@yopmail.com | 6Thstreet! |
#	| uat_automation_tester63@yopmail.com | 6Thstreet! |
#	| uat_automation_tester64@yopmail.com | 6Thstreet! |
