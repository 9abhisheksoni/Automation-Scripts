Feature: 6thstreet.com - Home page banner verification Scenarios 

	@HeroBanner
	Scenario Outline: BannerVerification_TC01 - User launches application and verifies the Hero banner
	When user clicks "<category>"
	When User clicks on hero banner
	Then User should be landed to respective PLP
	
	Examples:
	|category|
	|Women|
	|Men|
	|Kids|

	@DynamicBanner
	Scenario Outline: BannerVerification_TC02 - User launches application and verifies the Dynamic content banners
		When user clicks "<category>"
		When User clicks on Dynamic content banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|

	@TopCategoriesBanner
	Scenario Outline: BannerVerification_TC03 - User launches application and verifies the Top categories banners
		When user clicks "<category>"
		When User clicks on Top categories banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|
		
	@BrandsBanner
	Scenario Outline: BannerVerification_TC04 - User launches application and verifies the Brands banners
		When user clicks "<category>"
		When User clicks on Brands banner and verifies respective PLP
		
		Examples:
		|category|
		|Women|
		|Men|
		|Kids|
		
	@WhtasHot
	Scenario Outline: BannerVerification_TC04 - User launches application and verifies the Brands banners
		When user clicks "<category>"
		When User clicks on whats hot banner and verifies respective PLP
				
		Examples:
		|category|
		|Kids|