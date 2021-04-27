package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.Ordering;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import fileReader.TextFileHandler;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class SearchPage extends CucumberRunner {
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
	@FindBy(xpath = "//li[contains(@class,'ProductItem')]//img")
	private WebElement lnkProduct;

	@FindBy(xpath = "//li[contains(@class,'ProductItem')]//img")
	private List<WebElement> lnksProduct;
	
	@FindBy(xpath = "//p[@class='Price']/parent::a")
	private List<WebElement> lnksProductWithPrice;
	
	@FindBy(xpath = "//span[starts-with(text(),'0.0')]/ancestor::a")
	private List<WebElement> lnksProductWithZeroPrice;
	
	@FindBy(xpath = "//li[contains(@class,'ProductItem')]//a")
	private List<WebElement> lnksProductname;

	@FindBy(xpath = "//div[contains(@class,'PLPFilters-ProductsCount')]/span")
	private WebElement lblSearchResultCount;

	@FindBy(xpath = "//input[contains(@name,'categories')]/ancestor::div[contains(@class,'FieldMultiselect-OptionListContainer')]/preceding-sibling::button")
	private WebElement drpdwnCategoryGroupFilter;

	@FindBy(xpath = "//input[contains(@name,'size')]/ancestor::div[contains(@class,'FieldMultiselect-OptionListContainer')]/preceding-sibling::button")
	private WebElement drpdwnSizeGroupFilter;

	@FindBy(xpath = "//input[@name='categories_without_path']")
	private WebElement chkCategoryGroupFirstFilter;

	@FindBy(xpath = "(//input[@name='categories_without_path'])[2]")
	private WebElement chkCategoryGroupSecondFilter;

	@FindBy(xpath = "//input[contains(@name,'size')]")
	private WebElement chkSizeGroupFirstFilter;

	@FindBy(xpath = "(//input[contains(@name,'size')])[2]")
	private WebElement chkSizeGroupSecondFilter;

	@FindBy(xpath = "//input[@type='radio' and @id='price_lowsort']/ancestor::div[contains(@class,'FieldMultiselect-OptionListContainer')]/preceding-sibling::button")
	private WebElement drpdwnSortBy;

	@FindBy(xpath = "//input[@type='radio' and @id='price_lowsort']")
	private WebElement optionPriceLowToHigh;

	@FindBy(xpath = "//input[@type='radio' and @id='price_highsort']")
	private WebElement optionPriceHighToLow;

	@FindBy(xpath = "//span[not(contains(@class,'Price-Base_discount'))]/span[@class='Price-Currency']/..")
	private WebElement lblprice;

	@FindBy(xpath = "//span[not(contains(@class,'Price-Base_discount'))]/span[@class='Price-Currency']/..")
	private List<WebElement> lblprices;

	@FindBy(xpath = "//div[contains(@class,'WishlistIcon-Icon')]")
	private WebElement iconWishlist;
	
	@FindBy(xpath = "//div[contains(@class,'WishlistIcon-Icon') and contains(@class,'Icon_black')]")
	private WebElement iconWishlistHiglighted;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//button[contains(@class,'GenderButton-Button_isCurrentGender')]/..")
	private WebElement lblFirstLevelActive;

	@FindBy(xpath = "//div[@class='HeaderMainSection']//button[not(contains(@class,'GenderButton-Button_isCurrentGender')) and contains(@class,'GenderButton-Button')]")
	private WebElement lblFirstLevelInActive;

	@FindBy(xpath = "//div[contains(@class,'HeaderBottomBar')]//div[@class='MenuCategory-CategoryLink-Label']/..")
	private WebElement lblSecondLevelCategory;

	@FindBy(xpath = "//div[@class='DynamicContent']//div[contains(@class,'Menu')]//div[contains(@class,'Content')]/a")
	private WebElement lblThirdLevelCategory;

	@FindBy(xpath = "//a[contains(@class,'Breadcrumb-Link')]")
	private List<WebElement> lblBreadcrumb;

	@FindBy(xpath = "//p[@class='EmptySearch-Check']")
	private WebElement msgNoSearchMsg;

	@FindBy(xpath = "//div[@class='SearchSuggestion-Recommended']//a")
	private List<WebElement> lnkProductSuggestion;

	@FindBy(xpath = "//input[contains(@name,'price')]/ancestor::div[contains(@class,'FieldMultiselect-OptionListContainer')]/preceding-sibling::button")
	private WebElement drpdwnPriceRangeFilter;

	@FindBy(xpath = "//input[@type='radio' and contains(@name,'price')]")
	private List<WebElement> radioPriceFilter;

	@FindBy(xpath = "//input[@class = 'ais-refinement-list--radio' and @checked]")
	private WebElement radioPriceFilterActive;

	@FindBy(xpath = "//span[contains(@class,'Price-Base_discount')]")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//span[contains(@class,'Price-Special_discount')]/span[@class='Price-Currency']/../text()")
	private WebElement txtSpecialPrice;

	@FindBy(xpath = "//input[contains(@name,'discount')]/ancestor::div[contains(@class,'FieldMultiselect-OptionListContainer')]/preceding-sibling::button")
	private WebElement drpDiscount;

	@FindBy(xpath = "//input[@type='radio' and @name='discount']")
	private List<WebElement> radioDiscountOptions;

	@FindBy(xpath = "//div[@class='PageNotFound-Image']")
	private WebElement img404Error;

	/**
	 * WebElement declaration ends here
	 **/

	public void clickProdcuctInSearchPage() {
		commonMethods.click(lnkProduct);
		log.info("clicked product on PLP");
	}

	public int getProductsCount() {
		log.info("returning products on page");
		commonMethods.mouseHover(drpdwnCategoryGroupFilter);
		return new StringUtility().getIntValue(commonMethods.getText(lblSearchResultCount));
	}

	public void clickFirstCategoryFilter() {
		commonMethods.click(drpdwnCategoryGroupFilter);
		commonMethods.moveToElementAndClick(chkCategoryGroupFirstFilter);
		waitHelper.staticWait(3000);
		Assert.assertTrue("Filter Not Selected", commonMethods.isSelected(chkCategoryGroupFirstFilter));
		log.info("clicked first category filter");
	}

	public void clickSecondCategoryFilter() {
		commonMethods.click(drpdwnCategoryGroupFilter);
		waitHelper.staticWait(1500);
		commonMethods.click(chkCategoryGroupSecondFilter);
		waitHelper.staticWait(1500);
		Assert.assertTrue("Filter Not Selected", commonMethods.isSelected(chkCategoryGroupSecondFilter));
		log.info("clicked second category filter");
	}

	public void clickFirstSizeFilter() {
		commonMethods.click(drpdwnSizeGroupFilter);
		commonMethods.moveToElementAndClick(chkSizeGroupFirstFilter);
		waitHelper.staticWait(3000);
		Assert.assertTrue("Filter Not Selected", commonMethods.isSelected(chkSizeGroupFirstFilter));
		log.info("clicked first size filter");
	}

	public void clickLowToHighSort() {
		waitHelper.staticWait(3000);
		commonMethods.click(drpdwnSortBy);
		commonMethods.moveToElementAndClick(optionPriceLowToHigh);
		commonMethods.click(drpdwnSortBy);
		waitHelper.waitForElementVisible(lnkProduct);
		log.info("sorted low to high");
	}

	public void clickHighToLowSort() {
		waitHelper.staticWait(3000);
		commonMethods.click(drpdwnSortBy);
		commonMethods.moveToElementAndClick(optionPriceHighToLow);
		commonMethods.click(drpdwnSortBy);
		waitHelper.waitForElementVisible(lnkProduct);
		log.info("sorted high to low");
	}

	public void isPriceLowToHigh() {
		List<Float> prices = getPLPPrices();
		boolean sorted = Ordering.natural().isOrdered(prices);
		Assert.assertTrue(sorted);
		log.info("sorted low to high");
	}

	public void isPriceHighToLow() {
		List<Float> prices = this.getPLPPrices();
		log.info("The Price From PLP Collected Are " + prices);
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
		if (commonMethods.getAttribute(iconWishlist, "class").contains("Icon_black")) {
			commonMethods.click(iconWishlist);
		}
		commonMethods.click(iconWishlist);
		log.info("clicked on wishlist icon");
	}

	public void verifyWishlistSuccessDisplay() {
		waitHelper.waitForElementVisible(iconWishlistHiglighted);
		Assert.assertTrue(commonMethods.getAttribute(iconWishlist, "class").contains("Icon_black"));
		log.info("product wishlisted successfully");
	}

	public void clickOnFirstCategory() {
		commonMethods.click(lblFirstLevelInActive);
		log.info("Clicked first level category");
	}

	public void clickOnSecondCategory() {
		waitHelper.waitForElementVisible(lblSecondLevelCategory);
		commonMethods.moveToElementAndClick(lblSecondLevelCategory);
		log.info("Clicked second level category");
	}

	public void clickOnThirdCategory() {
		waitHelper.staticWait(3000);
		jsHelper.mousehover(lblSecondLevelCategory);
		waitHelper.waitForElementVisible(lblThirdLevelCategory);
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
		Assert.assertTrue(lblBreadcrumb.size() == 4);
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
		return globalSpecialPrice;
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
		if (this.getPriceFromText(commonMethods.getText(lblprice)) > 0) {
			commonMethods.moveToElementAndClick(lnkProduct);
		} else {
			for (int i = 0; i < lblprices.size(); i++) {
				if (this.getPriceFromText(commonMethods.getText(lblprices.get(i))) > 0) {
					index = i;
					break;
				}
			}
			commonMethods.click(lnksProduct.get(index));
		}
		log.info("clicked valid product on PLP");
	}

	public void clickTabbyPriceFilter() {
		commonMethods.click(drpdwnPriceRangeFilter);
		for (WebElement temp : radioPriceFilter) {
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
		log.info("Product Count on PLP: " + lnksProduct.size());
		String plpURL = genericHelper.getCurrentUrl();
		if (lnksProduct.size() > 0) {
			jsHelper.scrollToElement(lnksProduct.get(1));
			log.info("PLP has products");
		} else {
			log.info("Allert! - PLP has no products!!!");
			softAssert.fail("No Products!! -- " + plpURL);
		}

	}

	public void customAssertAll() {
		softAssert.assertAll();
	}

	public boolean isLeadingTo404() {
		return genericHelper.isElementPresent(img404Error);
	}

	public void clickBrowserBackButton() {
		commonMethods.navigateBack();
		log.info("Browse back button is clicked");
	}

	public List<Float> getPLPPrices() {
		List<Float> prices = new ArrayList<Float>();
		waitHelper.waitForElementVisible(lnkProduct);
		waitHelper.staticWait(3000);
		for (WebElement temp : lblprices) {
			float price = this.getPriceFromText(temp.getText());
			prices.add(price);
		}
		log.info("The Price From PLP Collected Are " + prices);
		return prices;
	}

	public boolean verifyProductsVisible() {
		log.info("Verifying product counts");
		return lnksProduct.size() > 0;
	}

	public List<String> getPriceProducts() {
		List <String> nonZeroPriceLinks = new ArrayList<String>();
		for (WebElement ele: lnksProductWithPrice) {
			nonZeroPriceLinks.add(commonMethods.getAttribute(ele, "href"));
		}
		log.info("Price Product Links count "+nonZeroPriceLinks.size());
		return nonZeroPriceLinks;
	}
	
	public List<String> getZeroPriceProducts() {
		List <String> zeroPriceLinks = new ArrayList<String>();
		for (WebElement ele: lnksProductWithZeroPrice) {
			zeroPriceLinks.add(commonMethods.getAttribute(ele, "href"));
		}
		log.info("Zero Price Product Links count "+zeroPriceLinks.size());
		return zeroPriceLinks;
	}
	
	public List<String> getNoPriceProducts() {
		List <String> noPriceLinks = new ArrayList<String>();
		noPriceLinks.addAll(this.getAllProducts());
		noPriceLinks.removeAll(this.getPriceProducts());	
		log.info("No Price Product Links count "+noPriceLinks.size());
		return noPriceLinks;
	}
	
	public List<String> getAllProducts() {
		List <String> allProductLinks = new ArrayList<String>();
		for (WebElement ele: lnksProductname) {
			allProductLinks.add(commonMethods.getAttribute(ele, "href"));
		}
		log.info("All Product Links count "+allProductLinks.size());
		return allProductLinks;
	}
	
	public List<String> getErrorPriceProducts() {
		List <String> errorProductLinks = new ArrayList<String>();
		errorProductLinks.addAll(this.getZeroPriceProducts());
		errorProductLinks.addAll(this.getNoPriceProducts());
		return errorProductLinks;
	}

	public void verifyCatlogPrices() {
		List<String> brokenPriceLinks=new ArrayList<String>();
		TextFileHandler textFileHandler = new TextFileHandler();
		String priceBrokenfilename = browserFactory.getCountry() + "_" + browserFactory.getLanguage() + "brokenpriceLinks"
				+ "brokenPriceLinks";
		textFileHandler.deleteFile(priceBrokenfilename);
		brokenPriceLinks.addAll(getErrorPriceProducts());
		for (String ele : brokenPriceLinks) {
			textFileHandler.writeToFile(ele, priceBrokenfilename);
		}
		
		Assert.assertTrue("Broken Price Links Were Found ", brokenPriceLinks.size() == 0);
	}

	public void loadMoreProducts() {
		jsHelper.scrollDownVertically();
		jsHelper.scrollDownVertically();		
	}
}
