Feature: 6thstreet.com - Registered User Place Order Scenarios

@Smoke @CreditCardPayment @RegisteredUser
	Scenario: TS_RegisteredCheckoutUAT_01 - Registered User of 6thstreet.com site should be able to add multiple products into cart 
		When User clicks on login link 
		When User enters valid login details "uatvaliduser" username and "uatvaliduser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		#And User clears cart
		And user enters product name as "853870000-WHITE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "M"
		And user clicks on ADDTOBAG button
		And user enters product name as "LCW-0SR002Z8-CVL" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "M"
		And user clicks on ADDTOBAG button
		And user enters product name as "CK1-61720044-Black" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "35"
		And user clicks on ADDTOBAG button
		And user enters product name as "DM7680NAVY BLUE" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "0009500110045052-BLACK" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "23MIRERRARI-S20-BLACK" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "", size as ""
		And user clicks on ADDTOBAG button
		And user enters product name as "0S0739Z4-JC7-NAVY" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "13Y"
		And user clicks on ADDTOBAG button
		And user enters product name as "97867L-NVCC-NAVY-CHAR" in search text box and click search icon		
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "13"
		And user clicks on ADDTOBAG button
		And user enters product name as "TU1102494-MULTI" in search text box and click search icon		
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
		
#	Examples:  
#		|Product                   |CountrySize|Size|Qty|
#		#|853870000-WHITE|EU|M|
#		#|LCW-0SR002Z8-CVL|EU|M|
#		#|CK1-61720044-Black|EU|35|
#		#|DM7680NAVY BLUE|||
#		#|0009500110045052-BLACK|||
#		#|23MIRERRARI-S20-BLACK|||
#		#|29122761001-Multicolour|||
#		#|AR75012805F19-NOVELTY|||
#		|TU1102494-MULTI|||

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