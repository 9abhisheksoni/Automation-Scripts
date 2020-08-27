Feature: 6thstreet.com - Tabby RMA Scenarios

  @TabbyPayInInstallments @RegisteredUser @Smoke
  Scenario Outline: TS_TabbyRMA_01 - Registered User of 6thstreet.com site should be able to perform RMA for TabbyPayInInstallments
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
	When Launch Tabby Merchant URL "MerchantURL" 
	When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
	And User clicks on merchant login button 
	And User inputs tabby order number in merchant page 
	Then Verify country "ARE" status "New" order 
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
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects order history option 
	Then order history page is displayed 
	Then verify order status in history to be "Processing" 
	And click on view order 
	Then Verify order status in details to be "Processing" 
	And user clicks on return an item 
	And user returns "<Product>" item with reason "Unsuitable Fit" and resolution as "Tabby Refund" 
	Then verify return status in return history to be "Pending" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Pending" 
	Then user return reason should be "Unsuitable Fit" 
	And user goes to magento window 
	When user clicks on sales module 
	And user clicks on order sub module 
	Then user should be landed into Orders page 
	When user clicks on Filters button 
	And user enters the order ID 
	And user clicks on Apply Filters button 
	Then Search result should be displayed 
	When user clicks on view link 
	And user is in order details page 
	And click on return tab in magento 
	Then verify the return id against frontend 
	And click on view return link in magento 
	And change return status to "Tabby Refunded" 
	And click on save in magento 
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Tabby Refunded" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Tabby Refunded" 
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|
		
	
	@TabbyPayLater @RegisteredUser @Smoke
  Scenario Outline: TS_TabbyRMA_02 - Registered User of 6thstreet.com site should be able to perform RMA for TabbyPayLater
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
	When Launch Tabby Merchant URL "MerchantURL" 
	When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup 
	And User clicks on merchant login button 
	And User inputs tabby order number in merchant page 
	Then Verify country "ARE" status "New" order 
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
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects order history option 
	Then order history page is displayed 
	Then verify order status in history to be "Processing" 
	And click on view order 
	Then Verify order status in details to be "Processing" 
	And user clicks on return an item 
	And user returns "<Product>" item with reason "Unsuitable Fit" and resolution as "Tabby Refund" 
	Then verify return status in return history to be "Pending" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Pending" 
	Then user return reason should be "Unsuitable Fit" 
	And user goes to magento window 
	When user clicks on sales module 
	And user clicks on order sub module 
	Then user should be landed into Orders page 
	When user clicks on Filters button 
	And user enters the order ID 
	And user clicks on Apply Filters button 
	Then Search result should be displayed 
	When user clicks on view link 
	And user is in order details page 
	And click on return tab in magento 
	Then verify the return id against frontend 
	And click on view return link in magento 
	And change return status to "Tabby Refunded" 
	And click on save in magento 
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Tabby Refunded" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Tabby Refunded" 
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|
		
	@TabbyPayInInstallments @RegisteredUser 
  Scenario Outline: TS_TabbyRMA_03 - Registered User of 6thstreet.com site should be able to create RMA from backend TabbyPayInInstallments
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
    When Launch Tabby Merchant URL "MerchantURL"
    When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup
    And User clicks on merchant login button
    And User inputs tabby order number in merchant page
    Then Verify country "ARE" status "New" order
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
    When user goes to main window 
	And user clicks on my account top menu 
	And user selects order history option 
	Then order history page is displayed 
	Then verify order status in history to be "Processing" 
	And click on view order 
	Then Verify order status in details to be "Processing" 
	And user goes to magento window 
    When user clicks on create returns button
    Then user should be landed into order return page
    And user selects the resolution as "Tabby Refund"
    And user navigates to return item menu and selects the reason as "Unsuitable Fit" after selecting the item checkbox
    And user clicks on submit returns button
    Then RMA request should be created
    When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Pending" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Pending" 
	Then user return reason should be "Unsuitable Fit"
	And user goes to magento window 
	When user clicks on sales module 
	And user clicks on order sub module 
	Then user should be landed into Orders page 
	When user clicks on Filters button 
	And user enters the order ID 
	And user clicks on Apply Filters button 
	Then Search result should be displayed 
	When user clicks on view link 
	And user is in order details page 
	And click on return tab in magento 
	Then verify the return id against frontend 
	And click on view return link in magento 
	And change return status to "Tabby Refunded" 
	And click on save in magento 
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Tabby Refunded" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Tabby Refunded" 
    
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|	
	
	@TabbyPayLater @RegisteredUser 
  Scenario Outline: TS_TabbyRMA_04 - Registered User of 6thstreet.com site should be able to create RMA from backend TabbyPayLater
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
    When Launch Tabby Merchant URL "MerchantURL"
    When User enters merchant valid login details "merchantuser" username and "merchantuser" password in the login popup
    And User clicks on merchant login button
    And User inputs tabby order number in merchant page
    Then Verify country "ARE" status "New" order
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
    When user goes to main window 
	And user clicks on my account top menu 
	And user selects order history option 
	Then order history page is displayed 
	Then verify order status in history to be "Processing" 
	And click on view order 
	Then Verify order status in details to be "Processing" 
	And user goes to magento window 
    When user clicks on create returns button
    Then user should be landed into order return page
    And user selects the resolution as "Tabby Refund"
    And user navigates to return item menu and selects the reason as "Unsuitable Fit" after selecting the item checkbox
    And user clicks on submit returns button
    Then RMA request should be created
    When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Pending" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Pending" 
	Then user return reason should be "Unsuitable Fit"
	And user goes to magento window 
	When user clicks on sales module 
	And user clicks on order sub module 
	Then user should be landed into Orders page 
	When user clicks on Filters button 
	And user enters the order ID 
	And user clicks on Apply Filters button 
	Then Search result should be displayed 
	When user clicks on view link 
	And user is in order details page 
	And click on return tab in magento 
	Then verify the return id against frontend 
	And click on view return link in magento 
	And change return status to "Tabby Refunded" 
	And click on save in magento 
	When user goes to main window 
	And user clicks on my account top menu 
	And user selects return an item option 
	Then return history page is displayed 
	Then verify return status in return history to be "Tabby Refunded" 
	And user clicks on view returns 
	Then Verify return status in return details to be "Tabby Refunded" 
    
    
    Examples:  
		|Product |CountrySize|Size|Qty|
		|DSW425730-230-NUDE |EU|41|1|	