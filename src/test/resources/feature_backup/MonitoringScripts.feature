Feature: 6thstreet.com - Acceptance Test Scenarios

	@Monitoring @GuestCheckout
	Scenario Outline: TS_GuestCheckout_01 - Guest User of 6thstreet.com site should be able to place order using cod 
		And user enters product name as "<Product>" in search text box and click search icon 
		And click on first valid product in search result
		And user selects variation if available
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And User login as guest user "tempUser" 
		And User clicks on Guestlogin button 
		And user submits the valid details for shipping address
		And user selects payment option as "COD"  
	  
		Examples: 
				|Product|
				|Shoes|
	
	@Monitoring @RegisteredCheckout
	Scenario Outline: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using visa credit card 
		When User clicks on login link 
		When User enters "validuser" login details in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And User clears saved address
		And user enters product name as "<Product>" in search text box and click search icon 
		And click on first valid product in search result
		And user selects variation if available
		And user clicks on ADDTOBAG button
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user submits the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "CC_Visa"
		
	Examples:  
		|Product|
		|Shoes|
	
	@Monitoring @LoginLogout
	Scenario: TS_LoginLogout_02 - Registered User of 6thstreet.com site should be able to logout 
		When User clicks on login link 
		When User enters "validuser" login details in the login popup 
		And User clicks on login button 
		And user login is successfull 	
		When User Logsout 
		Then Logout is successfull
	
	@Monitoring @FooterLinks
	Scenario Outline: TS_FooterLinkValidation_01 - Verify the whether footer links lead to respective pages
		When User clicks on footer link "<FooterLink>"
		Then User should be landed into "<PageName>" web page	
		
		Examples:
		|FooterLink    |PageName|
		|ConsumerRights|ConsumerRights|
		|About6thStreet|About6thStreet|
		|Disclaimer    |Disclaimer    |
		|PrivacyPolicy |PrivacyPolicy |
		|ShippingInfo  |ShippingPolicy|
		|ReturnInfo    |ReturnInfo    |
		|OrderTrack    |OrderTracking |
		|FAQs          |FAQs          |
		|Feedback      |Feedback      |
	
	@Monitoring @Wishlist
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