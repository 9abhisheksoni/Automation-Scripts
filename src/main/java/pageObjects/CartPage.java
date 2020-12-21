package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class CartPage extends CucumberRunner {

	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	SearhPage searchPage = new SearhPage();
	private Logger log = Logger.getLogger(CartPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public CartPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//tr[@class='totals shipping excl' or @class='totals-tax']")
	private WebElement lblOrderSummary;

	// added element
	@FindBy(xpath = "//span[contains(text(),'Link your Club Apparel account to earn')]")
	private WebElement lblLinkCa;

	@FindBy(xpath = "//tr[@class='totals-tax']")
	private WebElement lblTax;

	@FindBy(xpath = "//tr[@class='totals sub']")
	private WebElement lblSubTotal;
	//

	@FindBy(xpath = "//button[@class='action primary checkout']")
	private WebElement btnCheckout;

	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	private WebElement btnMiniCartCheckout;

	@FindBy(xpath = "//a[@class='action viewcart view_bag']")
	private WebElement btnMiniCartViewBag;

	@FindBy(xpath = "//span[@id='minicart-counter']")
	public WebElement lblCartCount;

	@FindBy(xpath = "//span[@class='cart_icon']")
	private WebElement iconCart;

	@FindBy(xpath = "//div[@class='remove_cart']//span[@class='cart_icon_remove']")
	private List<WebElement> iconRemove;

	@FindBy(xpath = "//div[@class='cart-empty_icon']")
	private WebElement iconEmptyCart;

	@FindBy(xpath = "//select[contains(@class,'change-cart-qty')]")
	private WebElement drpdwnQTY;

	@FindBy(xpath = "//div[@class='block discount']")
	private WebElement drawCouponDrawer;

	@FindBy(xpath = "//input[@id='coupon_code']")
	private WebElement txtCouponCode;

	@FindBy(xpath = "//button[@value='Apply Discount']")
	private WebElement btnApplyDiscount;

	@FindBy(xpath = "//tr[@class='totals sub']/td/span[@class='price']")
	private WebElement lblSubTotalAmount;

	@FindBy(xpath = "//tr[@class='totals']//span[@class='price']")
	private WebElement lblDiscountAmount;

	@FindBy(xpath = "//div[contains(@class,'message-success')]")
	private WebElement msgSuccess;

	@FindBy(xpath = "//span[@class='old-price']")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//span[@class='special-price']//span[@class='price']")
	private WebElement txtSpecialPrice;

	@FindBy(xpath = "//span[@data-th='Subtotal']")
	private WebElement txtSpecialPriceAtSubtotal;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickCheckout() {

		try {
			waitHelper.waitForElementVisible(lblSubTotal);
		} catch (Exception e) {
			try {
				waitHelper.waitForElementVisible(lblLinkCa);
			} catch (Exception excep) {
				waitHelper.waitForElementVisible(lblTax);
			}
		}

		commonMethods.click(btnCheckout);
		log.info("clicked checkout button in cart page");
	}

	public void clearCart() {
		waitHelper.staticWait(5000);
		if (commonMethods.isElementPresent(lblCartCount)) {
			commonMethods.click(iconCart);
			commonMethods.moveToElementAndClick(btnMiniCartViewBag);
			int removeiconCount = iconRemove.size();
			for (int i = 0; i < removeiconCount; i++) {
				commonMethods.click(iconRemove.get(0));
				log.info("remove icon clicked");
			}
		}
	}

	public void isMyBagPageLoaded() {
		Assert.assertTrue(genericHelper.isDisplayed(btnCheckout));
	}

	public void removeProduct() {
		commonMethods.click(iconRemove.get(0));
		log.info("remove icon clicked");
	}

	public void isCartEmpty() {
		Assert.assertTrue(genericHelper.isDisplayed(iconEmptyCart));
		log.info("cart is empty");
	}

	public void increaseProductQTY(String QTY) {
		commonMethods.SelectUsingValue(drpdwnQTY, QTY);
	}

	public void verifyProductQTY(String QTY) {
		Assert.assertEquals(commonMethods.getSelectedValue(drpdwnQTY), QTY);
		log.info("product qty updated correctly");
	}

	public void applyCoupon(String couponCode) {
		if (!genericHelper.isDisplayed(txtCouponCode)) {
			commonMethods.click(drawCouponDrawer);
		}
		commonMethods.clearAndSendKeys(txtCouponCode, couponCode);
		commonMethods.click(btnApplyDiscount);
		log.info("applied discount coupon on cart");
	}

	public void verifyAmountOffApplied(String expectedamount) {
		String actualDiscount = this.getDiscountPrice();
		Assert.assertEquals(expectedamount, actualDiscount);
		log.info(expectedamount + " amount off discount verified successfully");
	}

	public void verifyPercentOffApplied(String percent) {
		String expectedDiscount = ""
				+ Math.round(0.01 * Integer.parseInt(percent) * Integer.parseInt(this.getSubtotal()));
		String actualDiscount = "" + new StringUtility().getIntValue(this.getDiscountPrice());
		Assert.assertEquals(expectedDiscount, actualDiscount);
		log.info(percent + " percent off discount verified successfully");
	}

	public String getDiscountPrice() {
		return "" + new StringUtility().getIntValue(commonMethods.getText(lblDiscountAmount).replace("-", ""));
	}

	public String getSubtotal() {
		return "" + new StringUtility().getIntValue(commonMethods.getText(lblSubTotalAmount).replace("\"", ""));
	}

	public void verifyCouponSuccessMessage() {
		Assert.assertTrue(genericHelper.isElementPresent(msgSuccess));
		log.info("Coupon Code successfully Applied");
	}

	/*
	 * This method fetches the base_price displaying for an item in the Cart
	 */
	public String getBasePriceCart() {
		String basePrice = null;
		log.info("Fethcing the basebrice of the item in the Cart");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);
		
		log.info("The base price at Cart is" + basePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		//basePrice = basePrice.replaceAll(",", "");
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted base price at Cart is" + basePrice);
		return basePrice.trim();
	}

	/*
	 * This method compares the base_price displaying at Cart with the actual_price
	 * provided by the user
	 */
	public void evaluateBasePriceAtCart(String actualBasePrice) {
		log.info("Comparing the base_price displaying at Cart with the actual base_price provided by the user");
		log.info("The base_price provided by the user is " + actualBasePrice);
		assertEquals(getBasePriceCart(), actualBasePrice, "The base_price is matching");
	}
	
	/*
	 * This method compares the base_price displaying at Cart with the actual_price fetched at PLP
	 */
	public void evaluateBasePriceAtCart() {
		log.info("Comparing the base_price displaying at Cart with the actual base_price provided by the user");
		log.info("The base_price fetched at PLP is " + searchPage.globalBasePrice);
		assertEquals(getBasePriceCart(), searchPage.globalBasePrice, "The base_price is matching");
	}

	/*
	 * This method fetches the special_price displaying for an item in the PDP
	 */
	public String getSpecialPriceCart() {
		log.info("Fethcing the special of the item in the Cart");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		
		log.info("The special price at Cart is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		//specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();

		log.info("The extracted special price at Cart is " + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at Cart with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtCart(String actualSpecialPrice) {
		log.info("Comparing the special displaying at Cart with the actual values");
		assertEquals(getSpecialPriceCart(), actualSpecialPrice, "The special_price is matching at Cart");
	}
	

	/*
	 * This method compares the special_price displaying at Cart with the special price fetched at Cart
	 */
	public void evaluateSpecialPriceAtCart() {
		log.info("Comparing the special displaying at Cart with the actual values");
		assertEquals(getSpecialPriceCart(), searchPage.globalSpecialPrice, "The special_price is matching at Cart");
	}

	public String getSpecialPriceAtSubtotal() {
		log.info("Fethcing the special of the item in the Cart");
		waitHelper.waitForElementVisible(txtSpecialPriceAtSubtotal);
		String specialPrice = commonMethods.getText(txtSpecialPriceAtSubtotal);
		
		log.info("The special price at Cart Subtotal is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();	
		log.info("The extracted special price at Cart Subtotal is " + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at Cart Subtotal with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtSubtotal(String actualSpecialPrice) {
		log.info("Comparing the special displaying at Cart Subtotal with the actual values");
		assertEquals(getSpecialPriceAtSubtotal(), actualSpecialPrice, "The special_price is matching at Cart");
	}
	
	/*
	 * This method compares the special_price displaying at Cart with the special price fetched at PLP
	 */
	public void evaluateSpecialPriceAtSubtotal() {
		log.info("Comparing the special displaying at Cart Subtotal with the actual values");
		assertEquals(getSpecialPriceAtSubtotal(), searchPage.globalSpecialPrice, "The special_price is matching at Cart Subtotal");
	}

}
