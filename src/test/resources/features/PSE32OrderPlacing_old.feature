Feature: 6thstreet.com - Registered User Place Order Scenarios

@Smoke @CreditCardPayment @RegisteredUser
	Scenario Outline: TS_RegisteredCheckoutUAT_01 - Registered User of 6thstreet.com site should be able to add multiple products into cart 
		When User clicks on login link 
		When User enters valid login details "<username>" username and "<password>" password in the login popup from feature
		#When User enters valid login details "<uatvaliduser>" username and "<uatvaliduser>" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		#And User clears cart
		And user enters product name as "853870000-WHITE" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "M"
		And user clicks on ADDTOBAG button
		And user enters product name as "LCW-0SR002Z8-CVL" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "M"
		And user clicks on ADDTOBAG button
		And user enters product name as "CK1-61720044-Black" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "35"
		And user clicks on ADDTOBAG button
		And user enters product name as "DM7680NAVY BLUE" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "0009500110045052-BLACK" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "23MIRERRARI-S20-BLACK" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "0S0739Z4-JC7-NAVY" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "13Y"
		And user clicks on ADDTOBAG button
		And user enters product name as "97867L-NVCC-NAVY-CHAR" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "13"
		And user clicks on ADDTOBAG button
		And user enters product name as "TU1102494-MULTI" in search text box and click search icon
		And User clicks wishlist icon
		Then wishlist success message should be displayed		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
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
		|qauae1@yopmail.com|6Thstreet!|
		|ashwinbmsit@gmail.com|Modex123|

@Smoke
Scenario Outline: TS_RegisteredCheckoutUAT_02 - Registered User of 6thstreet.com site should be able to place order for multiple products 
		When User clicks on login link 
		When User enters valid login details "uatvaliduser" username and "uatvaliduser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
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
		|000NM1129E-White|EU|M|
		
@Smoke
Scenario Outline: TS_AddToCart_03 - Registered User of UAT 6thstreet.com site should be able to Add 10 unique items to Cart and abandon
	When User clicks on login link 
	When User enters valid login details "<username>" username and "<password>" password in the login popup from feature
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And user enters product name as "853870000-WHITE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CK1-61720044-Black" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "35" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "DM7680NAVY BLUE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "23MIRERRARI-S20-BLACK" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "TU1102494-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "000NM1129E-White" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "155011-OFPK-OFFWHITE-PINK" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "36" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0S0739Z4-JC7-NAVY" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "13Y" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "97867L-NVCC-NAVY-CHAR" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "13" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "6169126-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "0-5Y" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	
	Examples: 
		|username                          |password|
		|uat_automation_tester21@yopmail.com|6Thstreet!|
		|uat_automation_tester22@yopmail.com|6Thstreet!|
		|uat_automation_tester23@yopmail.com|6Thstreet!|
		|uat_automation_tester24@yopmail.com|6Thstreet!|
		|uat_automation_tester25@yopmail.com|6Thstreet!|
		|uat_automation_tester26@yopmail.com|6Thstreet!|
		|uat_automation_tester27@yopmail.com|6Thstreet!|
		|uat_automation_tester28@yopmail.com|6Thstreet!|
		|uat_automation_tester29@yopmail.com|6Thstreet!|
		|uat_automation_tester30@yopmail.com|6Thstreet!|
		|uat_automation_tester31@yopmail.com|6Thstreet!|
		|uat_automation_tester32@yopmail.com|6Thstreet!|
		|uat_automation_tester33@yopmail.com|6Thstreet!|
		|uat_automation_tester34@yopmail.com|6Thstreet!|
		|uat_automation_tester35@yopmail.com|6Thstreet!|
		|uat_automation_tester36@yopmail.com|6Thstreet!|
		|uat_automation_tester37@yopmail.com|6Thstreet!|
		|uat_automation_tester38@yopmail.com|6Thstreet!|
		|uat_automation_tester39@yopmail.com|6Thstreet!|
		|uat_automation_tester40@yopmail.com|6Thstreet!|
		|uat_automation_tester41@yopmail.com|6Thstreet!|
		|uat_automation_tester42@yopmail.com|6Thstreet!|
		|uat_automation_tester43@yopmail.com|6Thstreet!|
		|uat_automation_tester44@yopmail.com|6Thstreet!|
		|uat_automation_tester45@yopmail.com|6Thstreet!|
		|uat_automation_tester46@yopmail.com|6Thstreet!|
		|uat_automation_tester47@yopmail.com|6Thstreet!|
		|uat_automation_tester48@yopmail.com|6Thstreet!|
		|uat_automation_tester49@yopmail.com|6Thstreet!|
		|uat_automation_tester50@yopmail.com|6Thstreet!|