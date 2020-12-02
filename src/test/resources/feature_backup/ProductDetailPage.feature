Feature: 6thstreet.com - PDP select size

@Smoke @Regression	
Scenario Outline: TS_PDP_01:User should be able add product with size
 		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects Country and Size
		And user clicks on ADDTOBAG button
	
	Examples: 
				|Product|
				|LCW-0SV017Z8-KUC-NAVY-BLUE|

@Smoke @Regression 
Scenario Outline: TS_PDP_02:User should be able add product without variations
 		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user clicks on ADDTOBAG button
		
	Examples: 
				|Product|
				|11240403-GREY|

@Regression			
Scenario Outline: TS_PDP_03:User should be able add product with color
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects color
		And user clicks on ADDTOBAG button
	
	Examples: 
				|Product|
				|NKAA2146-600-RED|

@Regression
Scenario Outline: TS_PDP_04:User should be able add any product
		And user enters product name as "<searchTerm>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects variation if available
		And user clicks on ADDTOBAG button
	
	Examples: 
				|searchTerm|
				|LCW-0SV017Z8-KUC-NAVY-BLUE|
				|IG5907755311267-BROWN|
				|ADWONI-270-002-034-RUGBY-TAN|
				
@Regression	@Tabby 
Scenario Outline: TS_PDP_05 - User of 6thstreet.com site should be able to Review Tabby Widget on PDP
	And Home page is displayed 
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And Tabby widget verification with monthly division
	And Click on Tabby Widget
	And Verify the tabby promo from widget
	
	 Examples:   
		|Product |CountrySize|Size|Qty|
		|20SIERIAFLEX-BLACK|EU|23|1|



	
