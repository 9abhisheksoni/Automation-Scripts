Feature: 6thstreet.com - Tabby Widget on PDP

  @TabbyPayInInstallments @RegisteredUser @Sanity
  Scenario Outline: TS_TabbyRMA_01 - User of 6thstreet.com site should be able to Review Tabby Widget on PDP
	And Home page is displayed 
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And Tabby widget verification with monthly division
	And Click on Tabby Widget
	And Verify the tabby promo from widget
	
	 Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425728-230-NUDE|EU|41|1|

		
		
		
		
		
		
		

		