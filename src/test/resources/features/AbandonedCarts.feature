Feature: UAT - 6thstreet.com - Abandoned Carts 

@AbandonedCart 
Scenario Outline: TS_AddToCart_01 - Registered User of UAT 6thstreet.com site should be able to Add 10 unique items to Cart 
	When User clicks on login link 
	When User enters valid login details "<username>" username and "<password>" password in the login popup from feature
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And user enters product name as "853870000-WHITE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "CK1-61720044-Black" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "35" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "DM7680NAVY BLUE" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "23MIRERRARI-S20-BLACK" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "TU1102494-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "000NM1129E-White" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "M" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "155011-OFPK-OFFWHITE-PINK" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "36" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "0S0739Z4-JC7-NAVY" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "13Y" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "97867L-NVCC-NAVY-CHAR" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "13" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	And user enters product name as "6169126-MULTI" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "0-5Y" 
	And user clicks on ADDTOBAG button 
	And User is in cart page 
	
	Examples: 
		|username                          |password|
		|uat_automation_tester7@yopmail.com|6Thstreet!|
		|uat_automation_tester8@yopmail.com|6Thstreet!|
		|uat_automation_tester9@yopmail.com|6Thstreet!|
		|uat_automation_tester10@yopmail.com|6Thstreet!|
		|uat_automation_tester11@yopmail.com|6Thstreet!|
		|uat_automation_tester12@yopmail.com|6Thstreet!|
		|uat_automation_tester13@yopmail.com|6Thstreet!|
		|uat_automation_tester14@yopmail.com|6Thstreet!|
		|uat_automation_tester15@yopmail.com|6Thstreet!|
		|uat_automation_tester16@yopmail.com|6Thstreet!|
		|uat_automation_tester17@yopmail.com|6Thstreet!|
		|uat_automation_tester18@yopmail.com|6Thstreet!|
		|uat_automation_tester19@yopmail.com|6Thstreet!|
		|uat_automation_tester20@yopmail.com|6Thstreet!|
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
		