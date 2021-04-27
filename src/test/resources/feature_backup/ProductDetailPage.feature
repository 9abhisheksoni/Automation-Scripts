Feature: 6thstreet.com - PDP select size 

		@Regression  
		Scenario Outline: TS_PDP_01:User should be able add product with size 
			And user enters product name as "<Product>" in search text box and click search icon 
			And click on first valid product in search result 
			And user selects Country and Size 
			And user clicks on ADDTOBAG button 
			Then mini cart should be displayed 
			
			Examples: 
				|Product|
				|shirt|
		
		@Regression  
		Scenario Outline: TS_PDP_02:User should be able add product without variations 
			And user enters product name as "<Product>" in search text box and click search icon 
			And click on first valid product in search result
			And user clicks on ADDTOBAG button 
			Then mini cart should be displayed 
			
			Examples: 
				|Product|
				|lipsstick|
				
#			@Regression	@RunSanity		
#			Scenario Outline: TS_PDP_03:User should be able add product with color 
#				And user enters product name as "<Product>" in search text box and click search icon 
#				And click on first valid product in search result
#				And user selects color 
#				And user clicks on ADDTOBAG button 
#				Then mini cart should be displayed 
#				
#				Examples: 
#					|Product|
#					|NKAA2146-600-RED|
					
				@Regression @Smoke 
				Scenario Outline: TS_PDP_04:User should be able add any product 
					And user enters product name as "<searchTerm>" in search text box and click search icon 
					And click on first valid product in search result 
					And user selects variation if available 
					And user clicks on ADDTOBAG button 
					Then mini cart should be displayed 
					
					Examples: 
						|searchTerm|
						|Shirts|
						|lipsstick|
						
						
					@Regression @Tabby 
					Scenario Outline: TS_PDP_05 - User of 6thstreet.com site should be able to Review Tabby Widget on PDP 
						And Home page is displayed 
						And user enters product name as "<searchTerm>" in search text box and click search icon 
						And user sort by high to low price 
						And click on first valid product in search result 
					#	And Tabby widget verification with monthly division 
						And Click on Tabby Widget 
						And Verify the tabby promo from widget 
						
						Examples: 
							|searchTerm|
							|Shirts|
							
							
							
