Feature: 6thstreet.com - Prod Deployment Checklist: Search, Login, PLP Sort, PDP, Place Order - Guest and Registered User

		@Smoke		
		Scenario Outline: TS_ProdDepChecklist_01 - Verify whether user is able to sort the products 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And user reads number of products on page 
			And user sort by low to high price 
			Then products should be sorted with low to high price 
			And user sort by high to low price  
			Then products should be sorted with high to low price 
			
			Examples: 
				|SearchTerm|
				|Shoes| 

		@Smoke		
		Scenario Outline: TS_ProdDepChecklist_02 - Registered User of 6thstreet.com should be able to add product to wishlist 
			When User clicks on login link 
			When User enters valid login details "validuser" username and "validuser" password in the login popup 
			And User clicks on login button 
			And user login is successfull 
			And Home page is displayed 
			And user enters product name as "<Product>" in search text box and click search icon 
			And User clicks wishlist icon
			Then wishlist success message should be displayed
			
			Examples: 
				|SearchTerm|
				|Shoes|
				
		@Smoke 
		Scenario: TS_ProdDepChecklist_03 - Registered User of 6thstreet.com UAE site should be able to navigate to level1 page 
			And Home page is displayed 
			And user click first level Category 
			Then first level category should be displayed 
			And user click second level Category 
			Then second level category should be displayed 
			And user click third level Category 
			Then third level category should be displayed 

	@Smoke @CODPayment @GuestUser
	Scenario Outline: TS_ProdDepChecklist_04 - Guest User of 6thstreet.com site should be able to place order using cod 
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects countrySize as "EU", size as "10Y" 
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "guestuser" 
		And User clicks on Guestlogin button 
		And user enters the valid details for shipping address 
		And user selects payment option as "COD"  
		And user clicks on place order button 
		Then Order placing should be successful 
	
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|
		
    @Smoke @CODPayment @RegisteredUser
	Scenario Outline: TS_ProdDepChecklist_05 - Registered User of 6thstreet.com site should be able to place order using cod 
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
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
		
	Examples:  
		|Product                   |CountrySize|Size|Qty|
		|LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1|

