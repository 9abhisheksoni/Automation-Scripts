package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Ordering;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;
import utilities.StringUtility;

public class SearhPage extends CucumberRunner {
	/**
	 * Class object declaration here
	 **/
	
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	StringUtility stringUtility = new StringUtility();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(SearhPage.class.getName());
	
	/**
	 * Constructor to initialize page objects
	 **/
	public SearhPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	
	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//div[@class='product_image arw-hover-actions arw-hover-image']/a")
	private WebElement lnkProduct;

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

	@FindBy(xpath = "//div[@item-key='stage_magento_english_products_price_default_asc']//label")
	private WebElement optionPriceLowToHigh;

	@FindBy(xpath = "//div[@item-key='stage_magento_english_products_price_default_desc']//label")
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

	@FindBy(xpath="//ul[@class='breadcrumb clearfix']/li")
	private List<WebElement> lblBreadcrumb;

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
		waitHelper.staticWait(3000);
		log.info("sorted high to low");
	}

	public void isPriceLowToHigh() {
		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement temp : lblprice) {
			int price = this.getPriceFromText(temp.getText());
			prices.add(price);
		}
		boolean sorted = Ordering.natural().isOrdered(prices);

		Assert.assertTrue(sorted);
		log.info("sorted low to high");
	}

	public void isPriceHighToLow() {
		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement temp : lblprice) {
			int price = this.getPriceFromText(temp.getText());
			prices.add(price);
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(prices);

		Assert.assertTrue(sorted);
		log.info("sorted high to low");
	}

	public int getPriceFromText(String text) {
		int price = 0 + stringUtility.getIntValue(text.substring(text.lastIndexOf(' ') + 1));
		log.info("returning price from text : "+price);
		return price;
	}

	public void clickOnWishListIcon() {
		commonMethods.click(iconWishlist);
		log.info("clicked on wishlist icon");
	}

	public void verifyWishlistSuccessDisplay() {
		Assert.assertTrue(genericHelper.isDisplayed(msgWishlistSuccess));
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
		Assert.assertTrue(lblBreadcrumb.size()==3);
		log.info("second level category page displayed");
	}
	
	public void verifyOnThirdCategory() {
		Assert.assertTrue(lblBreadcrumb.size()==2);
		log.info("third level category page displayed");
	}

}