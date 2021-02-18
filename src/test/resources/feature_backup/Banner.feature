Feature: 6thstreet.com - Home page banner verification Scenarios 

	@None
	Scenario Outline: BannerVerification_TC01 - User launches application and verify the home page main banner
	When user clicks "<category>"
	When User clicks on main banner
	Then User should be landed to respective PLP
	
	Examples:
	|category|
	|Women|
	|Men|
	|Kids|

	@Demo
	Scenario Outline: BannerVerification_TC02 - User launches application and verify the home page banners
		When user clicks "<category>"
		When User clicks on banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|