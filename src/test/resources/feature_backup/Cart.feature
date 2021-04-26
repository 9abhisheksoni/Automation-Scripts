Feature: 6thstreet.com - User Cart Scenarios 
	
	Background: User logs into application and clears cart - addresses
	When User clicks on login link 
	When User enters "validuser" login details in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart
	
	@Regression @Smoke @run
	Scenario Outline: TS_Cart_01 - User is able to clear cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And click on first valid product in search result
	And user selects variation if available
	And user clicks on ADDTOBAG button
	And user navigates to cart
	And User deletes products in cart
	Then product should be removed from cart
	
	Examples:  
		|Product|
		|Shoes|
	
	@Regression @Smoke
	Scenario Outline: TS_Cart_02 - User is able to update the product qty
	And user enters product name as "<Product>" in search text box and click search icon 
	And click on first valid product in search result
	And user selects variation if available
	And user clicks on ADDTOBAG button
	And user navigates to cart
	And User increases QTY to "<Qty>"
	Then Product QTY should be updated to "<Qty>"
	
	Examples:  
		|Product|QTY|
		|Shoes|2|
		
	@Regression
	Scenario Outline: TS_Cart_03 - User is able to apply percentage off coupon to cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "<CountrySize>", size as "<Size>" 
	And user clicks on ADDTOBAG button 
	And user navigates to cart
	And User applies "6stest"
	Then Discount of "10" percent should be applied
	
	Examples:  
		|Product                   |CountrySize|Size|
		|LCW-0SV017Z8-KUC-NAVY-BLUE |EU|52|
		
	@Regression
	Scenario Outline: TS_Cart_04 - User is able to apply fixed amount off coupon to cart
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "<CountrySize>", size as "<Size>" 
	And user clicks on ADDTOBAG button 
	And user navigates to cart
	And User applies "FRIENDS101"
	Then Discount of "100" amount should be applied
	
	Examples:  
		|Product                   |CountrySize|Size|
		|LCW-0SV017Z8-KUC-NAVY-BLUE |EU|52|
