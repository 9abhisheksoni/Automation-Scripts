Feature: 6thstreet.com - Registered User Tabby End 2 End Order Scenarios

@Smoke @TabbyPayLater @RegisteredUser
	Scenario Outline: TS_RegisteredCheckout_06 - Registered User of 6thstreet.com site should be able to place order using TabbyPayLater 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
#		And User clears cart
#		And user enters product name as "<Product>" in search text box and click search icon 
#		And user clicks on product tile in result 
#		And user selects countrySize as "EU", size as "41" 
#		And user clicks on ADDTOBAG button 
#		And user navigates to shopping bag page and clicks on proceedToCheckout button 
#		And user enters the valid details for "uae" shipping address 
#		And user selects payment option as "TabbyPayLater" 
#		And user clicks on place order button 
#		And user fills all tabby details
#		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then order history page is displayed
		Then verify order status in history to be "processing"
		And click on view order
		Then Verify order status in details to be "processing"
		Then Verify order payment in details to be "Pay Later"
#		When Launch Tabby Merchant URL "<MerchantURL>"
#		When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
#		And User clicks on merchant login button
#		And User inputs tabby order number in merchant page
#		And Verify country "ARE" status "New" order
#		And user login to magento for 6ST
#		And user searches order in magento
#		Then Verify order status in magento to be "processing"
#		Then user verifies payment in magento to be "TabbyPayLater"
#		And user invoices order in magento
#		And user ships order in magento
		And user clicks on return an item
		And user returns "Tassel Details Slides - Nude DSW425730 (41)" item with reason "Unsuitable Fit" and resolution as "Tabby Refund"
		And user clicks on view returns
		Then user return reason should be "Unsuitable Fit"
		
	Examples:  
		| MerchantURL                 |Product |CountrySize|Size|Qty|
		| https://merchant.tabby.ai/auth |DSW425730-230-NUDE |EU|41|1|
	