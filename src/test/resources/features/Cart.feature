Feature: 6thstreet.com - User Cart Scenarios 

	@Smoke
	Scenario: TS_Cart_01 - Registered User is able to clear cart after login 
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart
	
	@Smoke 
	Scenario Outline: TS_Cart_02 - User is able to clear cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And User deletes products in cart
	Then product should be removed from cart
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	
	@Smoke
	Scenario Outline: TS_Cart_03 - User is able to update the product qty
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And User increases QTY to "2"
	Then Product QTY should be updated to "2"
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Smoke
	Scenario Outline: TS_Cart_04 - User is able to apply amount off coupon to cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And User Applies "AmountOFFCoupon" coupon
	Then Discount of "10" amount should be applied
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Smoke
	Scenario Outline: TS_Cart_04 - User is able to apply percentage off coupon to cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And User Applies "AmountOFFCoupon"
	Then Discount of "10" percent should be applied
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Smoke 
	Scenario Outline: TS_Cart_04 - User is able to apply amount off coupon to cart
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
	And User applies "AmountOFFCoupon"
	Then Discount of "10" amount should be applied
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
	