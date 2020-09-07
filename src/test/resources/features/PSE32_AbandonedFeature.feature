Feature: 6thStreet.com - This feature is to check the abondoned carts
# This is for abondoned carts
@PSE32
Scenario Outline: TS_AddToCart_03 - Registered User of UAT 6thstreet.com site should be able to Add 10 unique items to Cart and abandon
	When User clicks on login link 
	When User enters valid login details "<username>" username and "<password>" password in the login popup from feature
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And user enters product name as "0301921004-BLUE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "S-1 left in stock" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0301921002-NAVY" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "S-1 left in stock" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0301822245-PINK" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "L-1 left in stock" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0101626042-YELLOW" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "S" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0111704665-BLUE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "29"
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0111801566-NAVY" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "31" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "BHG1601765-00W9-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "2M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHB2007320-00-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "16-18" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHG1904612-00-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "2M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CHG2007269-00-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "16-18" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	
	Examples: 
		|username                          |password|
		|uat_automation_tester21@yopmail.com|6Thstreet!|
		|uat_automation_tester22@yopmail.com|6Thstreet!|
		|uat_automation_tester23@yopmail.com|6Thstreet!|
		|uat_automation_tester24@yopmail.com|6Thstreet!|
		|uat_automation_tester25@yopmail.com|6Thstreet!|
		|uat_automation_tester26@yopmail.com|6Thstreet!|
		|uat_automation_tester27@yopmail.com|6Thstreet!|
		|uat_automation_tester28@yopmail.com|6Thstreet!|
		|uat_automation_tester29@yopmail.com|6Thstreet!|
		|uat_automation_tester30@yopmail.com|6Thstreet!|
		|uat_automation_tester31@yopmail.com|6Thstreet!|
		|uat_automation_tester32@yopmail.com|6Thstreet!|
		|uat_automation_tester33@yopmail.com|6Thstreet!|
		|uat_automation_tester34@yopmail.com|6Thstreet!|
		|uat_automation_tester35@yopmail.com|6Thstreet!|
		|uat_automation_tester36@yopmail.com|6Thstreet!|
		|uat_automation_tester37@yopmail.com|6Thstreet!|
		|uat_automation_tester38@yopmail.com|6Thstreet!|
		|uat_automation_tester39@yopmail.com|6Thstreet!|
		|uat_automation_tester40@yopmail.com|6Thstreet!|
		|uat_automation_tester41@yopmail.com|6Thstreet!|
		|uat_automation_tester42@yopmail.com|6Thstreet!|
		|uat_automation_tester43@yopmail.com|6Thstreet!|
		|uat_automation_tester44@yopmail.com|6Thstreet!|
		|uat_automation_tester45@yopmail.com|6Thstreet!|
		|uat_automation_tester46@yopmail.com|6Thstreet!|
		|uat_automation_tester47@yopmail.com|6Thstreet!|
		|uat_automation_tester48@yopmail.com|6Thstreet!|
		|uat_automation_tester49@yopmail.com|6Thstreet!|
		|uat_automation_tester50@yopmail.com|6Thstreet!|