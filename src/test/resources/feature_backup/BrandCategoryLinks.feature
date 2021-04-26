Feature: 6thstreet.com - Registered User Place Order Scenarios
	
	@Brand
	Scenario Outline: User should be able to check the number of products in the PLP count
		And Home page is displayed
		#When the user hovers the mouse on the "<L1>" menu
		#And hovers the mouse on the "<L2>" menu
		And checks the "<ProductCount>" in the PLP based on "<L1>" menu and "<L2>" menu
		#And verifies the "<ProductCount>" in the PLP
		
		Examples:
		|L1|L2|ProductCount|
		|women|clothing|20|
		#|Women|shoes|20|