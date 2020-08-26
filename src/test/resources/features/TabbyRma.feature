Feature: 6thstreet.com - Registered User Place Order and returns

  @TabbyPayInInstallments @RegisteredUser @Smoke
  Scenario Outline: TS_RegisteredCheckout_05 - Registered User of 6thstreet.com site should be able to place order using TabbyPayInInstallments
    When User clicks on login link
    When User enters valid login details "validuser" username and "validuser" password in the login popup
    And User clicks on login button
    And user login is successfull
    And Home page is displayed
    And User clears cart
    And user enters product name as "<Product>" in search text box and click search icon
    And user clicks on product tile in result
    And user selects countrySize as "EU", size as "41"
    And user clicks on ADDTOBAG button
    And user navigates to shopping bag page and clicks on proceedToCheckout button
    And user enters the valid details for "uae" shipping address
    And user selects payment option as "TabbyPayInInstallments"
    And user clicks on place order button
    And user fills all tabby details
    Then Order placing should be successful
    And user clicks on my account top menu
    And user selects order history option
    Then order history page is displayed
    Then verify order status in history to be "processing"
	And click on view order
	Then Verify order status in details to be "processing"
	Then Verify order payment in details to be "Pay in installments"
    When Launch Tabby Merchant URL "<MerchantURL>"
    When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup
    And User clicks on merchant login button
    And User inputs tabby order number in merchant page
    Then Verify country "ARE" status "New" order
    When Launch Admin Magento URL "<MagentoURL>"
	When User enters magento valid login details "magentouser" username and "magentouser" password in the login popup 
	And User clicks on magento login button
    Then user should be landed into Magento dashboard
    When user clicks on sales module
    And user clicks on order sub module
    Then user should be landed into Orders page
    When user clicks on Filters button
    And user enters the order ID
    And user clicks on Apply Filters button
    Then Search result should be displayed
    When user clicks on view link
    And user is in order details page
    And Verify the Payment Method in Magento as "Pay in installments"
    And user clicks on Invoice button
    Then user should be redirected to Invoice page
    When user slects payment capture method as "capture offline"
    And user clicks on submit invoice button
    Then invoice should be generated
    When user clicks ship button
    Then user should be redirected to shipment page
    When user clicks on add tracking number button
    And user selects carrier partner as "DHL"
    And user enters carrier tracking number as "12345"
    And user clicks on submit shipment
    Then shipment should be created
    And user clicks on my account top menu
	And user selects order history option
	Then order history page is displayed
	Then verify order status in history to be "processing"
	And click on view order
	And user clicks on return an item
	And user returns "<Product>" item with reason "Unsuitable Fit" and resolution as "Tabby Refund"
	And user clicks on view returns
	Then user return reason should be "Unsuitable Fit"
    
    Examples:  
		| MagentoURL    | MerchantURL                 |Product |CountrySize|Size|Qty|
		|https://6thadmin-stage.6tst.com/sixadmin| https://merchant.tabby.ai/auth |DSW425730-230-NUDE |EU|41|1|