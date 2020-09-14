Feature: 6thStreet.com - This feature is to check the abondoned carts
# This is for abondoned carts
@PSE32
Scenario Outline: TS_AddToCart_03 - Registered User of UAT 6thstreet.com site should be able to Add 10 unique items to Cart and abandon
	When User clicks on login link 
	When User enters valid login details "<username>" username and "<password>" password in the login popup from feature
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And user enters product name as "0110820702-GREY" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "38" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0111802410-GREEN" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "30" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0110820219-BROWN" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "36" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0101626042-YELLOW" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "S" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0111704665-BLUE" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "29"
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CAK-IB0IB00402-Light-Grey-Heather" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHG1806275-LIGHT-PINK" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "12" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHB2007320-00-MULTI" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "16-18" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHG1806274-IVORY" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "6-9M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHG2007269-00-MULTI" in search text box and click search icon 
	And User clicks wishlist icon
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "16-18" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	
	Examples: 
		|username                          |password|
		|uat_automation_tester2@yopmail.com|6Thstreet!|
		|uat_automation_tester3@yopmail.com|6Thstreet!|
		|uat_automation_tester4@yopmail.com|6Thstreet!|
		|uat_automation_tester5@yopmail.com|6Thstreet!|
		|uat_automation_tester6@yopmail.com|6Thstreet!|
		|uat_automation_tester7@yopmail.com|6Thstreet!|
		|uat_automation_tester8@yopmail.com|6Thstreet!|
		|uat_automation_tester9@yopmail.com|6Thstreet!|
		|uat_automation_tester10@yopmail.com|6Thstreet!|
		|uat_automation_tester11@yopmail.com|6Thstreet!|
		|uat_automation_tester12@yopmail.com|6Thstreet!|
		|uat_automation_tester13@yopmail.com|6Thstreet!|
		|uat_automation_tester14@yopmail.com|6Thstreet!|
		|uat_automation_tester15@yopmail.com|6Thstreet!|