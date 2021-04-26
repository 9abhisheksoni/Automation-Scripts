Feature: 6thstreet.com - Home page banner verification Scenarios 

	@Hero @Banner
	Scenario Outline: BannerVerification_TC01 - User launches application and verifies the Hero banner
	When user clicks "<category>"
	When User clicks on main banner
	Then User should be landed to respective PLP
	
	Examples:
	|category|
	|Women|
	|Men|
	|Kids|

	@DynamicContent @Banner
	Scenario Outline: BannerVerification_TC02 - User launches application and verifies the Dynamic content banners
		When user clicks "<category>"
		When User clicks on Dynamic content banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|

	@TopCategories @Banner
	Scenario Outline: BannerVerification_TC03 - User launches application and verifies the Top categories banners
		When user clicks "<category>"
		When User clicks on Top categories banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|
		
	@Brands @Banner
	Scenario Outline: BannerVerification_TC04 - User launches application and verifies the Brands banners
		When user clicks "<category>"
		When User clicks on Brands banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|
		