	Feature: 6thstreet.com - Registered User Place Order Scenarios
	                         Registered User Place Order via various payment methods and Admin Cancels the order
	
	Background: user logs into application then adds a product into cart and navigates till shipping page
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed 
		And User clears cart
		And user enters product name as "Shoes" in search text box and click search icon 
		And user sort by high to low price
		And click on first valid product in search result
		And user selects variation if available
		And user clicks on ADDTOBAG button 
		And user navigates to shopping bag page and clicks on proceedToCheckout button 
		And user enters the valid details for shipping address 
			
	@Regression @CODPayment  
	Scenario: TS_RegisteredCheckout_01 - Registered User of 6thstreet.com site should be able to place order using cod
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing" 
		Then Verify order payment in details to be "Cash on delivery"
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
		Then Verify Magento Order Status to be "Processing" 
		And Verify the Payment Method in Magento as "Cash on delivery" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Canceled"
		
	@Regression @CreditCardPayment 
	Scenario: TS_RegisteredCheckout_02 - Registered User of 6thstreet.com site should be able to place order using VISA credit card
		And user selects payment option as "CC_VISA" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then verify order status in history to be "Payment success" 
		And click on view order 
		Then Verify order status in details to be "Payment success" 
		Then Verify order payment in details to be "Pay by Credit / Debit Card"
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
		Then Verify Magento Order Status to be "Payment success" 
		And Verify the Payment Method in Magento as "Pay by Credit / Debit Card" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Canceled"
		
	@Regression @TabbyPayLater  
	Scenario: TS_RegisteredCheckout_03 - Registered User of 6thstreet.com site should be able to place order using Tabby Pay later
		And user selects payment option as "TabbyPayLater" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then verify order status in history to be "Payment success" 
		And click on view order 
		Then Verify order status in details to be "Payment success" 
		Then Verify order payment in details to be "Pay later"
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
		Then Verify Magento Order Status to be "Payment success" 
		And Verify the Payment Method in Magento as "Pay later" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Canceled"
		
		
	@Regression @TabbyPayInInstallments  
	Scenario: TS_RegisteredCheckout_03 - Registered User of 6thstreet.com site should be able to place order using Tabby Pay installments
		And user selects payment option as "TabbyPayInInstallments" 
		And user clicks on place order button 
		Then Order placing should be successful 
		And user clicks on my account top menu
		And user selects order history option
		Then verify order status in history to be "Payment success" 
		And click on view order 
		Then Verify order status in details to be "Payment success" 
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
		Then Verify Magento Order Status to be "Payment success" 
		And Verify the Payment Method in Magento as "Pay in installments" 
		And Clicks on order cancel in Magento 
		Then Verify Magento Order Status to be "Canceled"