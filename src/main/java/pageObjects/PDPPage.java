package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import junit.framework.Assert;
import testRunner.CucumberRunner;

public class PDPPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	GenericHelper genericHelper = new GenericHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	SearchPage searchPage = new SearchPage();
	private Logger log = Logger.getLogger(PDPPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public PDPPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//select[contains(@class,'SizeTypeSelectElement')]")
	private WebElement drpdwnCountry;

	@FindBy(xpath = "//select[contains(@class,'SizeSelectElement')]")
	private WebElement drpdwnSize;

	@FindBy(xpath = "//button[contains(@class,'AddToCartButton')]")
	private WebElement btnAddToBag;

	@FindBy(xpath = "//div[contains(@class,'PDPGallery-Slider')]//img")
	private WebElement imgProductTile;

	@FindBy(xpath = "//span[contains(@class,'Price-Special_discount')]")
	private WebElement txtSpcialPrice;

	@FindBy(xpath = "//span[contains(@class,'Price-Base')]")
	private WebElement txtRegularPrice;

	@FindBy(xpath = "//button[@class='PDPSummary-Tabby']")
	private WebElement txtTabbyPriceDivison;

	@FindBy(xpath = "//div[@class='TabbyMiniPopup-Content']")
	private WebElement txtTabbyPromo;

	@FindBy(xpath = "//button[@class='TabbyMiniPopup-CloseBtn']")
	private WebElement btnTabbyPromoClose;

	@FindBy(xpath = "///button[@class='CartOverlay-CheckoutButton']")
	private WebElement btnCheckout;

	@FindBy(xpath = "//div[@class='swatch-option color']")
	private WebElement btnSelectColor;
	
	@FindBy(xpath = "//div[@class='PDPSummary-ProductColorBlock']")
	private WebElement txtColorMsg;

	@FindBy(xpath = "//p[@class='PDPSummary-Name']")
	private WebElement msgProductName;

	@FindBy(xpath = "//span[@class='price eav-regular']")
	private WebElement txtBasePrice;

	@FindBy(xpath = "//span[@class='special-price eav-final']")
	private WebElement txtSpecialPrice;

	/**
	 * WebElement declaration ends here
	 **/

	public void selectSizeCountry(String country) {
		waitHelper.waitForElementVisible(imgProductTile);
		if (!(country.isEmpty())) {
			commonMethods.SelectUsingValue(drpdwnCountry, country);
			log.info("Selected size country " + country);
		} else {
			log.info("Selected product is simple product,  size is not required");
		}

	}

	public void chooseSize(String size) {
		waitHelper.waitForElementVisible(imgProductTile);
		if (!(size.isEmpty())) {

			commonMethods.SelectUsingIndex(drpdwnSize, 1);
			// commonMethods.SelectUsingVisibleText(drpdwnSize, size);
			log.info("Selected size " + size);
		} else {
			log.info("Selected product is simple product, size is not required");
		}

	}

	public void clickAddToBag() {
		// commonMethods.click(btnAddToBag);
		// jsHelper.scrollIntoViewAndClick(btnAddToBag);
		commonMethods.sendKeys(btnAddToBag, Keys.ENTER);
		log.info("clicked on add to bag");
		waitHelper.waitForElementVisible(btnCheckout);
	}

	/**
	 * This method is used to verify the tabby widget
	 **/
	public void tabbyWidgetVerify() {
		String[] priceStr, priceStrTabby;
		double priceDob = 0.0, priceDobTabby = 0.0, priceDobDiv = 0.0;
		if (commonMethods.isElementPresent(txtTabbyPriceDivison)) {
			if (commonMethods.isElementPresent(txtSpcialPrice)) {
				log.info("special price");

				priceStr = commonMethods.getText(txtSpcialPrice).split(" ");

				priceDob = Double.parseDouble(priceStr[1]);

			} else {
				log.info("Regular price");
				priceStr = commonMethods.getText(txtRegularPrice).split(" ");
				priceDob = Double.parseDouble(priceStr[1]);
			}

			priceDobDiv = priceDob / 4;

			priceStrTabby = commonMethods.getText(txtTabbyPriceDivison).split(" ");
			priceDobTabby = Double.parseDouble(priceStrTabby[1]);
			double min = priceDobDiv - priceDobTabby;

			if ((Math.abs(min) <= 0.9)) {
				log.info("Product Value " + priceDob + " is devided by 4 as expected " + priceDobDiv + " - "
						+ priceDobTabby + " = " + min);
			}
		} else {
			log.info("Tabby widget is not displayed");
		}
	}

	/**
	 * This method is used to click the tabby widget
	 **/
	public void clickonTabbyWidget() {

		commonMethods.click(txtTabbyPriceDivison);
	}

	/**
	 * This method is used to verify and close the tabby promo popup
	 **/
	public void tabbyPromoVerify() {
		if (genericHelper.isDisplayed(txtTabbyPromo)) {
			log.info("Tabby promo is displayed");
			commonMethods.click(btnTabbyPromoClose);
			log.info("Tabby promo is closed");
		}
	}

	public void selectSizeCountry() {
		waitHelper.waitForElementVisible(imgProductTile);
		commonMethods.SelectUsingIndex(drpdwnCountry, 0);
		log.info("Selected size country");
	}

	public void chooseSize() {
		int count = 0;
		List<String> availableSizes = commonMethods.getAllDropDownValues(drpdwnSize);
		for (String currentSize : availableSizes) {
			if (!currentSize.contains(" ")) {
				commonMethods.SelectUsingVisibleText(drpdwnSize, currentSize);
				log.info("Selected product size");
				count++;
				break;
			}
			// To select the size if they do not have the space and displaying like 28WX28L
			// or in any other format
			else {
				commonMethods.SelectUsingIndex(drpdwnSize, 1);
				log.info("Selected product size");
				break;
			}
		}
		if (count == 0) {
			commonMethods.SelectUsingIndex(drpdwnSize, 1);
		}
	}

	public void addAnyProduct() {
		if (commonMethods.isElementPresent(drpdwnCountry) && commonMethods.isElementPresent(drpdwnSize)) {
			this.selectSizeCountry();
			this.chooseSize();
		} else if (commonMethods.isElementPresent(btnSelectColor)) {
			this.chooseColor();
		} else {
			log.info("Selected product is not having variation");
		}
	}

	public void chooseColor() {
		waitHelper.waitForElementVisible(imgProductTile);
		if (!commonMethods.getAttribute(btnSelectColor, "class").contains("selected")) {
			commonMethods.click(btnSelectColor);
		}
		log.info("Selected the color");
	}

	public void verifyPDPDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(msgProductName));
		log.info("user is on PDP");
	}

	/*
	 * This method fetches the base_price displaying for an item in the PDP
	 */
	public String getBasePricePDP() {
		String basePrice = null;
		log.info("Fethcing the basebrice of the item in the PDP");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);
		log.info("The base price at PDP is" + basePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted base price at PDP is" + basePrice);
		return basePrice;
	}

	/*
	 * This method compares the base_price displaying at PDP with the actual_price
	 * provided by the user
	 */
	public void evaluateBasePriceAtPDP(String actualBasePrice) {
		log.info("Comparing the base_price displaying at PDP with the actual base_price provided by the user");
		log.info("The base_price provided by the user is " + actualBasePrice);
		log.info("The base_price available in the PDP is " + getBasePricePDP());
		assertEquals(getBasePricePDP(), actualBasePrice, "The base_price is matching");
	}

	public void evaluateBasePriceAtPDP() {
		log.info("Comparing the base_price displaying at PDP with the actual base_price provided by the user");
		log.info("The global base price is " + searchPage.globalBasePrice);
		assertEquals(getBasePricePDP(), searchPage.globalBasePrice, "The base_price is matching");
	}

	/*
	 * This method fetches the special_price displaying for an item in the PDP
	 */
	public String getSpecialPricePDP() {
		log.info("Fethcing the special of the item in the PDP");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);

		log.info("The special price at PLP is" + specialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		log.info("The currency code is " + currencyCode);
		specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3).trim();
		log.info("The extracted special price at PLP is" + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at PDP with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtPDP(String actualSpecialPrice) {
		log.info("Comparing the special displaying at PDP with the actual values");
		assertEquals(getSpecialPricePDP(), actualSpecialPrice, "The special_price is matching at PDP");
	}

	public void evaluateSpecialPriceAtPDP() {
		log.info("Comparing the special displaying at PDP with the actual values");
		log.info("The global special price is " + searchPage.globalSpecialPrice);
		assertEquals(getSpecialPricePDP(), searchPage.globalSpecialPrice, "The special_price is matching at PDP");
	}

}
