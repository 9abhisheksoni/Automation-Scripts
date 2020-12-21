Feature: 6thstreet.com - validate the price in pdp,plp,wishlist,search,minicart and cart 

@run
Scenario Outline: TS_Price_01: Given the SKU, base_price and the special_price, then they should be same in all the places of the application 
		When User clicks on login link 
		When User enters "validuser" login details in the login popup 
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		And User clears cart
		And User clears saved address 
		And user clears Wishlist 
	 	And user enters product name as "<Product>" in search text box
		And user checks the "<Special_Price>" in the search
		And user enters product name as "<Product>" in search text box and click search icon 
		And User clicks wishlist icon
		Then wishlist success message should be displayed
		And user checks the "<Base_Price>" and the "<Special_Price>" in PLP
		And user clicks on product tile in result 
		And user checks the "<Base_Price>" and the "<Special_Price>" in PDP
		And user clicks the wishlist link
		And user checks the "<Special_Price>" in the wishlist
		And user adds the item to the cart
		And user selects Country and Size 
		And user clicks on ADDTOBAG button
		And user checks the "<Base_Price>" and the "<Special_Price>" in Cart
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user checks the "<Base_Price>" and the "<Special_Price>" in Shipment
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful
		And user checks the "<Base_Price>" and the "<Special_Price>" in order success
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing"
		And user checks the "<Special_Price>" in order order details
	
	Examples: 
		|Product|Base_Price|Special_Price|
		|FM3288-BLACK/WHITE|360|270|
		

Scenario Outline: TS_Price_02: Given the SKU, then the application should fetch the base_price and special_price from the PLP and compare in all places
		When User clicks on login link 
		When User enters "validuser" login details in the login popup
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		And User clears cart
		And User clears saved address 
		And user clears Wishlist 
		And user enters product name as "<Product>" in search text box and click search icon
		And user fetch the Base_Price and the Special_Price in PLP
		And User clicks wishlist icon
		Then wishlist success message should be displayed
		And user clicks on product tile in result
		And valdiate the base_Price and special_Price in PDP
		And user enters product name as "<Product>" in search text box
		And user checks the special_price in the search
		And user clicks the wishlist link
		And user checks the special_price in the wishlist
		And user adds the item to the cart
		And user selects Country and Size 
		And user clicks on ADDTOBAG button
		And user checks the base_Price and the special_Price in Cart
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user checks the base_Price and the special_Price in Shipment
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful
		And user checks the base_Price and the special_Price in order success
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing"
		And user checks the special_price in order order details
		
		Examples: 
		|Product|
		|19866-0029-WLRUS-MLT|


		
Scenario Outline: TS_Price_03: The script should filter the items based on the keyword provided and fetch the price from the first item in the plp
		When User clicks on login link 
		When User enters "validuser" login details in the login popup
		And User clicks on login button 
		And user login is successfull 
		And Home page is displayed
		And User clears cart
		And User clears saved address 
		And user clears Wishlist
		And user enters product name as "<SearchTerm>" in search text box and click search icon
		And user filters the product based on the highest discount
		And user fetch the Base_Price and the Special_Price in PLP
		And User clicks wishlist icon
		Then wishlist success message should be displayed
		And click on first valid product in search result
		And valdiate the base_Price and special_Price in PDP
		And user clicks the wishlist link
		And user checks the special_price in the wishlist
		And user adds the item to the cart
		And user selects Country and Size 
		And user clicks on ADDTOBAG button
		And user checks the base_Price and the special_Price in Cart
		And user navigates to shopping bag page and clicks on proceedToCheckout button
		And user checks the base_Price and the special_Price in Shipment
		And user enters the valid details for shipping address 
		And user reset Stored Payments
		And user selects payment option as "COD" 
		And user clicks on place order button 
		Then Order placing should be successful
		And user checks the base_Price and the special_Price in order success
		And user clicks on my account top menu
		When user selects order history option 
		Then verify order status in history to be "Processing" 
		And click on view order 
		Then Verify order status in details to be "Processing"
		And user checks the special_price in order order details
		
		Examples: 
		|Country|SearchTerm|
		|UAE|Shoes|