Feature: 6thstreet.com - User Cart Scenarios 

	@Smoke
	Scenario: TS_Cart_01 - Registered User is able to clear cart after login 
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And User clears cart
	