Feature: 6thstreet.com - Registered User Place Order Scenarios

Background: user logs into application with valid credentials
	When User clicks on login link 
	When User enters "validuser" login details in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart

@PSE32
Scenario Outline: TS_Bulkorder_01 - Registered User of 6thstreet.com site should be able to place order for multiple products
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
		And user submits the valid details for shipping address 
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		And user fills all tabby details 
		Then Order placing should be successful

		
	Examples:  
	|username|password|
	| uat_automation_tester51@yopmail.com | 6Thstreet! |
	
@PSE32
Scenario Outline: TS_AddToCart_001 - Registered User of UAT 6thstreet.com site should be able to Add 10 unique items to Cart and abandon
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
	And User is in cart page

	Examples:  
	|username|password|
	| uat_automation_tester51@yopmail.com | 6Thstreet! |