Feature: 6thstreet.com - User applies different promotion codes in cart and checkout page
		
	@Regression
	Scenario Outline: TS_ApplyPromotionCOdes_01 - Registered User is able to apply %off coupon codes to avail discounts on sub total
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart
	And User clears saved address
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
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
	And user reset Stored Payments 
	And User applies "6stest" on Payment Page
	Then Discount of "10" percent should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		

	@Regression
	Scenario Outline: TS_ApplyPromotionCOdes_02 - Registered User is able to apply fixed amount off coupon codes to avail discounts on sub total
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart
	And User clears saved address
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
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
	And user reset Stored Payments
	And User applies "FRIENDS101" on Payment Page
	Then Discount of "100" amount should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Regression
	Scenario Outline: TS_ApplyPromotionCOdes_03 - Guest user is able to apply %off coupon codes to avail discounts on sub total
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And user navigates to shopping bag page and clicks on proceedToCheckout button 
	And user enters the valid details for shipping address 
	And User applies "6stest" on Payment Page
	Then Discount of "10" percent should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
	@Regression
	Scenario Outline: TS_ApplyPromotionCOdes_04 - Guest user is able to apply fixed amount off coupon codes to avail discounts on sub total
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And user navigates to shopping bag page and clicks on proceedToCheckout button 
	And user enters the valid details for shipping address 
	And User applies "FRIENDS101" on Payment Page
	Then Discount of "100" amount should be applied on Payment Page
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|