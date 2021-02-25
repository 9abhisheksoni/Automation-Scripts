package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.Ordering;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class SearchPage extends CucumberRunner {
	private static final String String = null;
	public static String globalBasePrice = null;
	public static String globalSpecialPrice = null;
	/**
	 * Class object declaration here
	 **/

	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	StringUtility stringUtility = new StringUtility();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(SearchPage.class.getName());
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	private SoftAssert softAssert = new SoftAssert();

	/**
	 * Constructor to initialize page objects
	 **/
	public SearchPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//div[@class='product_image arw-hover-actions arw-hover-image']/a")
	private WebElement lnkProduct;

	@FindBy(xpath = "//div[@class='product_image arw-hover-actions arw-hover-image' or @class='PLPPage']//a[@class='product photo product-item-photo' or @class]")
	private List<WebElement> lnksProduct;

	@FindBy(xpath = "//div[@class='ais-body ais-stats--body']//strong")
	private WebElement lblSearchResultCount;

	@FindBy(xpath = "//div[@data-tab='categories_without_path']/div")
	private WebElement drpdwnCategoryGroupFilter;

	@FindBy(xpath = "//div[@data-tab='size']/div")
	private WebElement drpdwnSizeGroupFilter;

	@FindBy(xpath = "//div[@data-tab='categories_without_path']//label")
	private WebElement chkCategoryGroupFirstFilter;

	@FindBy(xpath = "(//div[@data-tab='categories_without_path']//label)[2]")
	private WebElement chkCategoryGroupSecondFilter;

	@FindBy(xpath = "//div[@data-tab='size']//label")
	private WebElement chkSizeGroupFirstFilter;

	@FindBy(xpath = "(//div[@data-tab='size']//label)[2]")
	private WebElement chkSizeGroupSecondFilter;

	@FindBy(xpath = "//div[@data-tab='categories_without_path']//div[@class='ais-refinement-list--item ais-refinement-list--item__active']")
	private WebElement chkFirstCategoryFilterActive;

	@FindBy(xpath = "(//div[@data-tab='categories_without_path']//div[@class='ais-refinement-list--item ais-refinement-list--item__active'])[2]")
	private WebElement chkSecondCategoryFilterActive;

	@FindBy(xpath = "//div[@data-tab='size']//div[@class='ais-refinement-list--item ais-refinement-list--item__active']")
	private WebElement chkFirstSizeFilterActive;

	@FindBy(xpath = "//div[@data-tab='sort-by']/div")
	private WebElement drpdwnSortBy;

	@FindBy(xpath = "//div[contains(@item-key,'products_price_default_asc')]//label")
	private WebElement optionPriceLowToHigh;

	@FindBy(xpath = "//div[contains(@item-key,'products_price_default_desc')]//label")
	private WebElement optionPriceHighToLow;

	@FindBy(xpath = "//span[@class='price']")
	private List<WebElement> lblprice;

	@FindBy(xpath = "//div[contains(@class,'list_wishlist')]")
	private WebElement iconWishlist;

	@FindBy(xpath = "//div[contains(@class,'message-success')]")
	private WebElement msgWishlistSuccess;

	@FindBy(xpath = "//li[@class='active']/a")
	private WebElement lblFirstLevelActive;

	@FindBy(xpath = "//ul[@class='main-categories first-level']/li[not(@class)]/a")
	private WebElement lblFirstLevelInActive;

	@FindBy(xpath = "//ul[@class='nav second-level men-section']/li[@class='second-sub']")
	private WebElement lblSecondLevelCategory;

	@FindBy(xpath = "(//li[@class='second-sub hover']//a[@data-level='second-level-item-1'])[2]")
	private WebElement lblThirdLevelCategory;

	@FindBy(xpath = "//ul[@class='breadcrumb clearfix']/li")
	private List<WebElement> lblBreadcrumb;

	@FindBy(xpath = "//span[@id='you_searched_for']/following-sibling::h4")
	private WebElement msgNoSearchMsg;

	@FindBy(xpath = "//div[@class='aa-dataset-suggestions']/div")
	private List<WebElement> lnkProductSuggestion;

	@FindBy(xpath = "//div[contains(@data-tab,'price')]/div")
	private WebElement drpdwnPriceRangeFilter;

	@FindBy(xpath = "//input[@class='ais-refinement-list--radio']/..")
	private List<WebElement> chkTabbyPriceFilter;

	@FindBy(xpath = "//input[@class = 'ais-refinement-list--radio' and @checked]")
	private WebElement chkTabbyPriceFilterActive;

	@FindBy(xpath = "//span[@data-price-type='oldPrice']")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//span[@data-price-type='finalPrice']/span[@class='price']")
	private WebElement txtSpecialPrice;

	@FindBy(xpath = "//div[@data-tab='discount']/div")
	private WebElement drpDiscount;

	@FindBy(xpath = "//div[@id='algo-filter-item--abs-discount']//input[@class='ais-refinement-list--radio']")
	private List<WebElement> radioDiscountOptions;

	@FindBy(xpath = "//img[contains(@src,'404-image')]")
	private WebElement img404Error;

	@FindBy(xpath = "//div[@class='col-md-12']/h2")
	private WebElement divAllBrands;

	/* PWA elements */

	@FindBy(xpath = "//div[@class='PageNotFound-Image']")
	private WebElement imgPwa404Error;

	@FindBy(xpath = "//div[@class='Image Image_ratio_square Image_imageStatus_1 Image_hasSrc  ']")
	private List<WebElement> lstPwaProducts;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickProdcuctInSearchPage() {
		commonMethods.click(lnkProduct);
		log.info("clicked product on PLP");
	}

	public int getProductsCount() {
		log.info("returning products on page");
		return new StringUtility().getIntValue(commonMethods.getText(lblSearchResultCount));
	}

	public void clickFirstCategoryFilter() {
		commonMethods.click(drpdwnCategoryGroupFilter);
		commonMethods.click(chkCategoryGroupFirstFilter);
		waitHelper.waitForElementVisible(chkFirstCategoryFilterActive);
		log.info("clicked first category filter");
	}

	public void clickSecondCategoryFilter() {
		commonMethods.click(drpdwnCategoryGroupFilter);
		commonMethods.click(chkCategoryGroupSecondFilter);
		waitHelper.waitForElementVisible(chkSecondCategoryFilterActive);
		log.info("clicked second category filter");
	}

	public void clickFirstSizeFilter() {
		commonMethods.click(drpdwnSizeGroupFilter);
		waitHelper.waitForElementToBeClickable(chkSizeGroupFirstFilter);
		commonMethods.click(chkSizeGroupFirstFilter);
		waitHelper.waitForElementVisible(chkFirstSizeFilterActive);
		log.info("clicked first size filter");
	}

	public void clickLowToHighSort() {
		commonMethods.click(drpdwnSortBy);
		commonMethods.click(optionPriceLowToHigh);
		waitHelper.staticWait(3000);
		log.info("sorted low to high");
	}

	public void clickHighToLowSort() {
		commonMethods.click(drpdwnSortBy);
		commonMethods.click(optionPriceHighToLow);
		waitHelper.staticWait(5000);
		log.info("sorted high to low");
	}

	public void isPriceLowToHigh() {
		List<Float> prices = new ArrayList<Float>();
		for (WebElement temp : lblprice) {
			float price = this.getPriceFromText(temp.getText());
			prices.add(price);
		}
		boolean sorted = Ordering.natural().isOrdered(prices);

		Assert.assertTrue(sorted);
		log.info("sorted low to high");
	}

	public void isPriceHighToLow() {
		List<Float> prices = new ArrayList<Float>();
		for (WebElement temp : lblprice) {
			float price = this.getPriceFromText(temp.getText());
			prices.add(price);
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(prices);

		Assert.assertTrue(sorted);
		log.info("sorted high to low");
	}

	public float getPriceFromText(String text) {
		float price = (stringUtility.getDecimalValue(text));
		log.info("returning price from text : " + price);
		return price;
	}

	public void clickOnWishListIcon() {
		commonMethods.click(iconWishlist);
		log.info("clicked on wishlist icon");
	}

	public void verifyWishlistSuccessDisplay() {
		Assert.assertTrue(genericHelper.isElementPresentInDOM(msgWishlistSuccess));
		log.info("product wishlisted successfully");
	}

	public void clickOnFirstCategory() {
		commonMethods.click(lblFirstLevelInActive);
		log.info("Clicked first level category");
	}

	public void clickOnSecondCategory() {
		commonMethods.click(lblSecondLevelCategory);
		log.info("Clicked second level category");
	}

	public void clickOnThirdCategory() {
		commonMethods.mouseHover(lblSecondLevelCategory);
		commonMethods.moveToElementAndClick(lblThirdLevelCategory);
		log.info("Clicked third level category");
	}

	public void verifyOnFirstCategory() {
		String url = genericHelper.getCurrentUrl();
		String activeUrl = commonMethods.getAttribute(lblFirstLevelActive, "href");
		Assert.assertTrue(url.equals(activeUrl));
		Assert.assertTrue(genericHelper.isDisplayed(lblFirstLevelActive));
		log.info("first level category page displayed");
	}

	public void verifyOnSecondCategory() {
		Assert.assertTrue(lblBreadcrumb.size() == 3);
		log.info("second level category page displayed");
	}

	public void verifyOnThirdCategory() {
		Assert.assertTrue(lblBreadcrumb.size() == 2);
		log.info("third level category page displayed");
	}

	public void verifyNoResultDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(msgNoSearchMsg));
		log.info("No result page displayed");
	}

	public void verifySearchSuggestionDisplay() {
		Assert.assertTrue(lnkProductSuggestion.size() > 0);
		log.info("Search suggestions displayed");
	}

	/*
	 * This method fetches the base_price displaying for an item in the PLP
	 */
	public String getBasePricePLP() {
		String basePrice = null;
		log.info("Fethcing the base brice of the item in the PLP");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);
		log.info("The base price at PLP is" + basePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted base price at PLP is " + basePrice);
		this.globalBasePrice = basePrice;
		return basePrice;
	}

	/*
	 * This method compares the base_price displaying at PLP with the actual_price
	 * provided by the user
	 */
	public void evaluateBasePriceAtPLP(String actualBasePrice) {
		log.info("Comparing the base_price displaying at PLP with the actual values");
		log.info("The base_price provided by the user is " + actualBasePrice);
		Assert.assertEquals(getBasePricePLP(), actualBasePrice, "The base_price is matching");
	}

	/*
	 * This method fetches the special_price displaying for an item in the PLP
	 */
	public String getSpecialPricePLP() {
		log.info("Fethcing the special of the item in the PLP");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		log.info("The special price at PLP is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted special price at PLP is " + specialPrice);
		this.globalSpecialPrice = specialPrice.trim();
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at PLP with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtPLP(String actualSpecialPrice) {
		log.info("Comparing the special displaying at PLP with the actual values");
		String SpecialAtPDP = getSpecialPricePLP();
		Assert.assertEquals(SpecialAtPDP, actualSpecialPrice, "The special_price is matching at PLP");
	}

	public void clickFirstValidInResult() {
		int index = 0;
		for (int i = 0; i < lblprice.size(); i++) {
			if (this.getPriceFromText(commonMethods.getText(lblprice.get(i))) > 0) {
				index = i;
				break;
			}
		}
		commonMethods.click(lnksProduct.get(index));
		log.info("clicked valid product on PLP");
	}

	public void clickTabbyPriceFilter() {
		commonMethods.click(drpdwnPriceRangeFilter);
		for (WebElement temp : chkTabbyPriceFilter) {
			if (commonMethods.getText(temp).contains("700") && commonMethods.getText(temp).contains("800")) {
				waitHelper.waitForElementToBeClickable(temp);
				commonMethods.click(temp);
				break;
			}
		}
		waitHelper.staticWait(3000);
		log.info("clicked tabby range filter");
	}

	// Filter the items having the discount above 70%
	public void clickHighestDiscountPercentage() {
		waitHelper.waitForElementToBeClickable(drpDiscount);
		commonMethods.moveToElementAndClick(drpDiscount);
		int index = radioDiscountOptions.size() - 1;
		commonMethods.moveToElementAndClick(radioDiscountOptions.get(index));
	}

	/*
	 * To verify whether the PLP has products or not, if no products test case fails
	 * by skipping the further steps
	 */
	public void verifyPLPIsDisplayed() {
		System.out.println("Product Count: " + lnksProduct.size());
		try {
			Assert.assertTrue(lnksProduct.size() > 0);
			log.info("PLP is displayed");
		} catch (Exception e) {
			log.info("PLP is not displayed");
		}
	}

	/*
	 * To verify whether the PLP has products or not, if no products test case will
	 * be failed after checking all the banners
	 */
	public void verifyPLP() {
		log.info("\n<<<<<<<Product Count: " + lnksProduct.size());
		String plpURL = genericHelper.getCurrentUrl();
		if (lnksProduct.size() > 0 ) {			
				jsHelper.scrollToElement(lnksProduct.get(1));
				log.info("PLP has products");			

		} /*
			 * else if (!genericHelper.isElementPresent(msgNoSearchMsg) &&
			 * !this.isLeadingTo404()){ log.info("ATTENTION! - PLP is blank!!!");
			 * softAssert.fail("ATTENTION! - PLP is blank!!! >>> " + plpURL); } else
			 * if(this.isLeadingTo404()) { log.info("ATTENTION!!! - encountered 404 error");
			 * softAssert.fail("ATTENTION!!! - encountered 404 error>>>>> " + plpURL); }
			 * else if(genericHelper.isElementPresent(msgNoSearchMsg)) {
			 * log.info("Allert! - PLP has no products!!!");
			 * softAssert.fail("No Products!! >>> " + plpURL); }
			 */
		else {
			log.info("Allert! - PLP has no products!!!");
			softAssert.fail("No Products!! >>> " + plpURL);
		}

	}

	public void customAssertAll() {
		softAssert.assertAll();
	}

	public boolean isLeadingTo404() {
		return genericHelper.isElementPresent(imgPwa404Error);
	}

	public void clickBrowserBackButton() {
		commonMethods.navigateBack();
		log.info("Browse back button is clicked");
	}

}
