Feature: 6thstreet.com - Filter and search in PLP and add product in  PDP                       


		@Smoke @Regression
		Scenario Outline: TS_Search_01 - Verify whether user is able to filter the products 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And user reads number of products on page 
			And user filters using first group filter 
			Then products count should be decreased 
			And user filters using second group filter 
			Then products count should be decreased 
			And user filters using first group second filter 
			Then products count should be increased 
			
			Examples: 
				|SearchTerm|
				|Dress|
		
		@Smoke	@Regression 
		Scenario Outline: TS_Search_02 - Verify whether user is able to sort the products 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And user reads number of products on page 
			And user sort by low to high price 
			Then products should be sorted with low to high price 
			And user sort by high to low price  
			Then products should be sorted with high to low price 
			
			Examples: 
				|SearchTerm|
				|Wallet|
		
		@Smoke @Regression
		Scenario Outline: TS_Search_03 - Registered User of 6thstreet.com should be able to add product to wishlist 
			When User clicks on login link 
			When User enters "validuser" login details in the login popup  
			And User clicks on login button 
			And user login is successfull 
			And Home page is displayed 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And User clicks wishlist icon
			Then wishlist success message should be displayed
			
			Examples: 
				|SearchTerm|
				|Shoes|
		
		@Smoke @Regression @run
		Scenario: TS_Search_04 - Registered User of 6thstreet.com UAE site should be able to navigate to different levels of category 
			And Home page is displayed 
			And user click first level Category 
			Then first level category should be displayed 
		#	And user click second level Category 
		#	Then second level category should be displayed 
			And user click third level Category 
			Then third level category should be displayed 

		@Smoke 	@Regression
		Scenario Outline: TS_Search_05 - Verify search functionality
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			Then products should be displayed 
			And user enters product name as "ABCDEF" in search text box and click search icon
			Then no products should be displayed 
			
			Examples: 
				|SearchTerm|
				|Shoes|

  		@Smoke @Regression
		Scenario: TS_Search_06 - Verify search suggestion
			And user enters product name as "a" in search text box 
			Then search suggestions should be displayed
			
		@Smoke @Regression
		Scenario Outline: TS_Search_07 - Verify HOME LOGO
			And user enters product name as "<SearchTerm>" in search text box 
			And search suggestions should be displayed 
			And user click on first product on the search suggestions
			Then user is on PDP
			Then User click on Home Logo 
			And Home page is displayed
			
		Examples: 
				|SearchTerm|
				|Shoes|
		
		@Smoke @Regression		
		Scenario Outline: TS_Search_08 - Verify whether user is able to click on valid PDP link 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And click on first valid product in search result
			 
		Examples: 
				|SearchTerm|
				|Shoes|