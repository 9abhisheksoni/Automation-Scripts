Feature: 6thstreet.com - Home page banner verification Scenarios 

	@Demo
	Scenario Outline: User launches application and verify the home page main banner
	When user clicks "<category>"
	When User clicks on main banner
	Then User should be landed to respective PLP
	
	Examples:
	|category|
	|Women|
	|Men|
	|Kids|

@Giri
Scenario Outline: User launches application and verify the home page banners
	When user clicks "<category>"
	When User clicks on banner and verifies respective PLP
#	Then User should be landed to respective PLP
	
	Examples:
	|category|
	|Women|
#	|Men|
#	|Kids|