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
	SearchPage searchPage = new SearchPage();
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

	@FindBy(xpath = "//div[@class= 'CartPage-ClubApparelText']")
	private WebElement lblLinkCa;

	@FindBy(xpath = "//button[contains(@class,'CartPage-CheckoutButton')]")
	private WebElement btnCheckout;

	@FindBy(xpath = "//button[@class='CartOverlay-CheckoutButton']")
	private WebElement btnMiniCartCheckout;

	@FindBy(xpath = "//a[contains(@class,'CartOverlay-CartButton')]")
	private WebElement btnMiniCartViewBag;

	@FindBy(xpath = "//div[@class='HeaderCart-Count']")
	public WebElement lblCartCount;

	@FindBy(xpath = "//button[@class='HeaderCart-Button']")
	private WebElement iconCart;

	@FindBy(xpath = "//button[@id='RemoveItem']")
	private List<WebElement> iconRemove;

	@FindBy(xpath = "//div[@class='CartPage-EmptyCartIcon']")
	private WebElement iconEmptyCart;
	
	@FindBy(xpath = "//div[contains(@class,'CartItem-Qty')]/button[1]")
	private WebElement btnPlusQTY;

	@FindBy(css = "#item_qty")
	private WebElement drpdwnQTY;
	
	@FindBy(xpath = "//div[contains(@class,'CartItem-Qty')]/button[2]")
	private WebElement btnMinusQTY;

	@FindBy(xpath = "//button[contains(@class,'CartPage-ExpandableContentButton')]")
	private WebElement drawCouponDrawer;

	@FindBy(xpath = "//input[@id='couponCode']")
	private WebElement txtCouponCode;

	@FindBy(xpath = "//button[contains(@class,'CartCoupon-Button')]")
	private WebElement btnApplyDiscount;

	@FindBy(xpath = "//ul//strong[text()='Subtotal' or text()='الإجمالي']/following-sibling::strong")
	private WebElement lblSubTotalAmount;

	@FindBy(xpath = "//ul//strong[contains(text(),'Discount') or contains(text(),'خصم')]/following-sibling::strong")
	private WebElement lblDiscountAmount;
	
	@FindBy(xpath = "//ul//strong[text()='Shipping fee' or text()='الشحن']/following-sibling::strong")
	private WebElement lblShippingAmount;

	@FindBy(xpath = "//div[contains(@class,'message-success')]")
	private WebElement msgSuccess;

	@FindBy(xpath = "//div[@class='CartItem-Price']/div/div/span")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//div[@class='CartItem-DiscountPrice']/span")
	private WebElement txtSpecialPrice;

	@FindBy(xpath = "//div[@class='CartPage-Subtotals']//strong[2]")
	private WebElement txtSpecialPriceAtSubtotal;
	
	@FindBy(xpath = "//h1[@class='CartPage-Heading']")
	private WebElement lblMyCart;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickCheckout() {
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
		commonMethods.SelectUsingValue(btnPlusQTY, QTY);
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

	public void isMiniCartVisible() {
		log.info("Verifying whether minicart is displayed");
		Assert.assertTrue("minicart didnt appear",genericHelper.isDisplayed(btnMiniCartViewBag));
	}
	
	public void clickOnViewBag() {
		log.info("Clicking View Bag In Mini Cart");
		log.info("Navigating To Cart");	
		if(!genericHelper.isDisplayed(btnMiniCartViewBag)) {
			commonMethods.click(iconCart);
		}
		commonMethods.moveToElementAndClick(btnMiniCartViewBag);
		Assert.assertTrue(genericHelper.isDisplayed(lblMyCart));
	}
}
