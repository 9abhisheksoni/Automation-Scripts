Feature: 6thstreet.com - Tabby Cancel Scenarios

  	@TabbyPayInInstallments @RegisteredUser 
  Scenario Outline: TS_TabbyRMA_03 - Registered User of 6thstreet.com site should be able to cancel from backend for TabbyPayInInstallments
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
    Then verify order status in history to be "Payment_success"
	And click on view order
	Then Verify order status in details to be "Payment Success"
	Then Verify order payment in details to be "Pay in installments"
    When Launch Admin Magento URL "MagentoURL"
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
    Then Verify Magento Order Status to be "Payment Success"
    And Verify the Payment Method in Magento as "Pay in installments"
    And Clicks on order cancel in Magento
    Then Verify Magento Order Status to be "Canceled"
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|
	
	@TabbyPayLater @RegisteredUser 
  Scenario Outline: TS_TabbyRMA_04 - Registered User of 6thstreet.com site should be able to cancel from backend for TabbyPayLater
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
    And user selects payment option as "TabbyPayLater"
    And user clicks on place order button
    And user fills all tabby details
    Then Order placing should be successful
    And user clicks on my account top menu
    And user selects order history option
    Then order history page is displayed
    Then verify order status in history to be "Payment_success"
	And click on view order
	Then Verify order status in details to be "Payment Success"
	Then Verify order payment in details to be "Pay Later"
	 When Launch Admin Magento URL "MagentoURL"
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
    Then Verify Magento Order Status to be "Payment Success"
    And Verify the Payment Method in Magento as "Pay Later"
    And Clicks on order cancel in Magento
    Then Verify Magento Order Status to be "Canceled"
  
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|	