Feature: 6thstreet.com - Registered Club Appareal functionality 

@CA 
Scenario Outline: TS_RegisteredCA_01 - Verify Club Appareal functionality 
	When User clicks on login link 
	When User enters valid login details "<username>" username and "<password>" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
#   And Verify Link your club apparel message is displayed on cart page
	And Click on Customer 
	And Click on Club Apparel Loyalty 
	And Verify Club apparel logo displayed 
	And Verify AVAIL LOYALTY BENEFITS ON 6THSTREET is displayed 
	And Verify TIERS BENEFIT is displayed 
	And Verify REDEMPTION VALUE is displayed 
	And Verify Link your Club Apparel account and start earning points is displayed 
	And verify About club apparel section is displayed 
	And verfy Rewards section is displayed 
	And Verify LINK YOUR ACCOUNT button is displayed 
	And Click on LINK YOUR Account button 
	And Verify Club apparel logo displayed 
	And Click on Select flag 
	And input country "India" 
	And input Telephone Number "9164160299" 
	And Click on LINK ACCOUNT 
	And Verify Enter the verification code we sent to is displayed 
	
	Examples: 
		|username|password|
		| praveen.saudiar99@gmail.com | 6Thstreet! 	|	
		
		
		
