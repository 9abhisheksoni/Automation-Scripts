Feature: 6thstreet.com - validate the price in pdp,plp,wishlist,search,minicart and cart 

 
Scenario Outline: TS_Price_01: Given the SKU, base_price and the special_price, then they should be same in all the places of the application 
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		And User clears cart
		And User clears saved address 
		And user clears Wishlist 
	 	And user enters product name as "<Product>" in search text box
		And user checks the "<Special_Price>" in the search for the "<Country>"
		And user enters product name as "<Product>" in search text box and click search icon 
		And User clicks wishlist icon
#		Then wishlist success message should be displayed
		And user checks the "<Base_Price>" and the "<Special_Price>" in PLP for the "<Country>"
		And user clicks on product tile in result 
		And user checks the "<Base_Price>" and the "<Special_Price>" in PDP for the "<Country>"
		And user clicks the wishlist link
		And user checks the "<Special_Price>" in the wishlist for the "<Country>"
		And user adds the item to the cart
		And user selects Country and Size 
		And user clicks on ADDTOBAG button
		And user checks the "<Base_Price>" and the "<Special_Price>" in Cart for the "<Country>"
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user checks the "<Base_Price>" and the "<Special_Price>" in Shipment for the "<Country>"
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful
		And user checks the "<Base_Price>" and the "<Special_Price>" in order success for the "<Country>"
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing"
		And user checks the "<Special_Price>" in order order details for the "<Country>"
	
	Examples: 
		|Country|Product|Base_Price|Special_Price|
#		|KW|17778-0259-SKYS-LIMIT|12.000|7.200|
		|UAE|00501-2713-DARK-CEDAR|320|290|
#		|BH|BP-BHSS2011W-BP-LIGHT-GOLD|17|10.2|
#		|KW|23SARDASARDA-LIGHT-PINK|6.000|3.600|
		
@run
Scenario Outline: TS_Price_02: Given the SKU, then the application should fetch the base_price and special_price from the PLP and compare in all places
		When User clicks on login link 
		When User enters valid login details "validuser" username and "validuser" password in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		And User clears cart
		And User clears saved address 
		And user clears Wishlist 
		And user enters product name as "<Product>" in search text box and click search icon
		And user fetch the Base_Price and the Special_Price for the "<Country>" in PLP
		And User clicks wishlist icon
#		Then wishlist success message should be displayed
		And user clicks on product tile in result
		And valdiate the base_Price and special_Price in PDP for the "<Country>"
		And user enters product name as "<Product>" in search text box
		And user checks the special_price in the search for the "<Country>"
		And user clicks the wishlist link
		And user checks the special_price in the wishlist for the "<Country>"
		And user adds the item to the cart
		And user selects Country and Size 
		And user clicks on ADDTOBAG button
		And user checks the base_Price and the special_Price in Cart for the "<Country>"
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user checks the base_Price and the special_Price in Shipment for the "<Country>"
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful
		And user checks the base_Price and the special_Price in order success for the "<Country>"
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing"
		And user checks the special_price in order order details for the "<Country>"
		
		Examples: 
		|Country|Product|
		|UAE|00501-2713-DARK-CEDAR|