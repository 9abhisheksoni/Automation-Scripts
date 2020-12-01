Feature: 6thstreet.com - validate the price in pdp,plp,wishlist,search,minicart and cart 

@run 
Scenario Outline: TS_Price_01: The base_price and the special_price should be same in all the places of the application 
#		When User clicks on login link 
#		When User enters valid login details "validuser" username and "validuser" password in the login popup 
#		And User clicks on login button 
#		And user login is successfull 
#		And Home page is displayed
#		And User clears cart
#		And User clears saved address 
#		And user clears Wishlist 
	 	And user enters product name as "<Product>" in search text box
		And user checks the "<Special_Price>" in the search
		And user enters product name as "<Product>" in search text box and click search icon 
		#And User clicks wishlist icon
		#Then wishlist success message should be displayed
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
		|BP-BHSS2011W-BP-LIGHT-GOLD|17|10.2|
