Feature: 6thstreet.com - User Able To Login Master

		Scenario Outline: TS_LoginLogout_02 - Registered User of 6thstreet.com site should be able to logout 
		When User clicks on login link 
		When User enters "<username>" and "<password>" in the login popup 
		And User clicks on login button 
		And user login is successfull 	
		When User Logsout 
		Then Logout is successfull
		
		Examples: 
				|username|password|
				|qa6street@gmail.com|master1234|
				|prasanna.kumar@6thstreet.com|master1234|
				|tommy.qatester1@gmail.com|master1234|