	Feature: 6thstreet.com - Guest User Place Order Scenarios
	
	
	@Smoke
	Scenario Outline: TS_GuestCheckout_05 - Guest User of 6thstreet.com site should be able to place order using TabbyPayInInstallments 
		When Launch Admin Magento URL "<MagentotURL>"
		When User enters magento valid login details "magentouser" username and "magentouser" password in the login popup 
		And User clicks on magento login button
		
			
	Examples:  
		| MerchantURL                 |Product |CountrySize|Size|Qty|MagentotURL|
		| https://merchant.tabby.ai/auth |DSW425730-230-NUDE |EU|41|1|https://6thadmin-stage.6tst.com/sixadmin|