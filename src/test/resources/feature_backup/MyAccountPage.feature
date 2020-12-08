Feature: 6thStreet.com -  wishlist, address, create acc, Order History and login/logout

	@Regression
	Scenario: TS_Account_Creation _01 - Create user account with email_id and Password
		When User clicks on login link 
		Then Create an account using valid details
		Then user login is successfull
	
	@Smoke @Regression 
	Scenario: TS_LoginLogout_02 - Registered User of 6thstreet.com site should be able to logout 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 	
		When User Logsout 
		Then Logout is successfull
#		Then Logout is successfull
		

    @Regression 
	Scenario Outline: TS_OrderHistory_03 - Registered User of 6thstreet.com site should be able to place order using cod 
		When User clicks on login link 
		When User enters "validuser" login details in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And user enters product name as "<searchTerm>" in search text box and click search icon 
		And click on first valid product in search result
		And user selects variation if available
		And user clicks on ADDTOBAG button
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
		And User cancels the Order
		And user clicks on my account top menu
		When user selects order history option
		Then verify order status in history to be "Closed" 
		And click on view order
		Then Verify order status in details to be "Closed"
		
		Examples:  
		|searchTerm|
		|Shoes|
		
		@Smoke @Regression
		Scenario Outline: TS_Wishlist_04 - Registered User of 6thstreet.com should be able to add product to wishlist 
			When User clicks on login link 
			When User enters "validuser" login details in the login popup 
			And User clicks on login button 
			And user login is successfull 
			And Home page is displayed 
			And user clears Wishlist
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And User clicks wishlist icon
			Then wishlist success message should be displayed
			Then user should be able to see product in Wishlist
			
			Examples: 
				|SearchTerm|
				|Shoes|		
				
		 @Smoke @Regression	
		Scenario: TS_MyAccountAddress_05 - Registered User of 6thstreet.com site should be able to update the address
			When User clicks on login link 
			When User enters "validuser" login details in the login popup 
			And User clicks on login button 
			And user login is successfull 
			And Home page is displayed 
			And User clears cart
			And User clears saved address	
			And User saves valid Address
			Then Address should be saved
			And User edits, makes address Default	
			Then Default address should be updated
			And User Deletes saved address	
			Then address should be deleted