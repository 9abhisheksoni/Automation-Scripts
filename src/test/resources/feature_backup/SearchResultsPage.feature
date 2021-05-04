Feature: 6thstreet.com - Filter and search in PLP and add product in  PDP                       

		@Sanity @Regression
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
				|Shirts|
		
		@Sanity	@Regression
		Scenario Outline: TS_Search_02 - Verify whether user is able to sort the products 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And user reads number of products on page 
			And user sort by low to high price 
			Then products should be sorted with low to high price 
			And user sort by high to low price  
			Then products should be sorted with high to low price 
			
			Examples: 
				|SearchTerm|
				|Shoes|
		
		@Sanity @Regression 
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
		
		@Sanity @Regression 
		Scenario: TS_Search_04 - Registered User of 6thstreet.com UAE site should be able to navigate to different levels of category 
			And Home page is displayed 
			And user click first level Category 
			Then first level category should be displayed 
			And user click second level Category 
			Then second level category should be displayed 
			And user click third level Category 
			Then third level category should be displayed 

		@Sanity 	@Regression
		Scenario Outline: TS_Search_05 - Verify search functionality
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			Then products should be displayed 
			And user enters product name as "ABCDEF" in search text box and click search icon
			Then no products should be displayed 
			
			Examples: 
				|SearchTerm|
				|Shoes|

  		@Sanity @Regression
		Scenario: TS_Search_06 - Verify search suggestion
			And user enters product name as "a" in search text box 
			Then search suggestions should be displayed
			
		@Sanity @Regression
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
		
		@Sanity @Regression	
		Scenario Outline: TS_Search_08 - Verify whether user is able to click on valid PDP link 
			And user enters product name as "<SearchTerm>" in search text box and click search icon 
			And click on first valid product in search result
			 
		Examples: 
				|SearchTerm|
				|Shoes|
		
		@CategotyMonitoring 
		Scenario: TS_Search_09 - Verify whether product level3 category navigation have valid links 
			And User Verifies Product CategoryLinks Navigation 
		 
		@CategotyMonitoring 
		Scenario: TS_Search_10 - Verify whether brand level3 category navigation have valid links 
			And User Verifies Brand CategoryLinks Navigation 
		
		@CategotyMonitoring 	
		Scenario: TS_Search_11 - List the broken price products
			And user enters product name as "@" in search text box and click search icon 
			And user reads number of products on page 
			And user sort by low to high price 
			Then products should be sorted with low to high price 
			And scroll two lazy loads
			Then broken price products are collected
			
		@ProductCount	@Test1
		Scenario:  TS_Search_12 - Verify product count in catalog 
			And user enters product name as "@" in search text box and click search icon 
			Then verify whether products count is as expected
		
