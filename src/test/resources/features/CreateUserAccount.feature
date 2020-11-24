Feature: 6thStreet.com - Create User Account Scenarios 

@PSE32
Scenario Outline: Create user account with email_id and Password
	When User clicks on login link 
	Then Create account "<FirstName>""<LastName>""<EMAIL>" and "<Password>"
	
	Examples: 
		|FirstName|LastName| EMAIL                |Password                   |
#		| uat_automation_tester| 85 | uat_automation_tester85@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 86 | uat_automation_tester86@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 87 | uat_automation_tester87@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 88 | uat_automation_tester88@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 89 | uat_automation_tester89@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 90 | uat_automation_tester90@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 91 | uat_automation_tester91@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 92 | uat_automation_tester92@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 93 | uat_automation_tester93@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 94 | uat_automation_tester94@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 95 | uat_automation_tester95@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 96 | uat_automation_tester96@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 97 | uat_automation_tester97@yopmail.com | 6Thstreet! |
#		| uat_automation_tester| 98 | uat_automation_tester98@yopmail.com | 6Thstreet! |
		| uat_automation_tester| 99 | uat_automation_tester99@yopmail.com | 6Thstreet! |
		| uat_automation_tester| 100 | uat_automation_tester100@yopmail.com | 6Thstreet! |