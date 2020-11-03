Feature: 6thstreet.com - PDP select size

Scenario Outline: User should be able add product with size
 		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects Country and Size
		And user clicks on ADDTOBAG button
	
	Examples: 
				|Product|
				|AR73965592-RED-600|

Scenario Outline: User should be able add product without variations
 		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user clicks on ADDTOBAG button
		
	Examples: 
				|Product|
				|ADWONI-270-002-034-RUGBY-TAN|
				
Scenario Outline: User should be able add product with color
		And user enters product name as "<Product>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects color
		And user clicks on ADDTOBAG button
	
	Examples: 
				|Product|
				|23ETHERANDRA-WHITE|

@testvariation				
Scenario Outline: User should be able add any product
		And user enters product name as "<searchTerm>" in search text box and click search icon 
		And user clicks on product tile in result 
		And user selects variation if available
		And user clicks on ADDTOBAG button
	
	Examples: 
				|searchTerm|
				|23ETHERANDRA-WHITE|
				|AR73965592-RED-600|
				|ADWONI-270-002-034-RUGBY-TAN|