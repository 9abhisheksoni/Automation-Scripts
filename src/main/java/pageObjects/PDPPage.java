package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

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
	@FindBy(xpath = "//select[@id='countrySize']")
	private WebElement drpdwnCountry;

	@FindBy(xpath = "//select[@id='countrySize']/parent::div/../..//select[@class='super-attribute-select']")
	private WebElement drpdwnSize;

	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	private WebElement btnAddToBag;

	@FindBy(xpath = "//div[@class='gallery-placeholder']")
	private WebElement imgProductTile;

	@FindBy(xpath = "//span[@class='special-price eav-final']")
	private WebElement txtSpcialPriceCart;

	@FindBy(xpath = "//span[@class='regular-price eav-regular']")
	private WebElement txtRegularPriceCart;

	@FindBy(xpath = "//div[@class='priceInstaDiv']")
	private WebElement txtTabbyPriceDivison;

	@FindBy(xpath = "//div[@id='tabby-promo']")
	private WebElement txtTabbyPromo;

	@FindBy(xpath = "//span[@id='tabby-promo-close']")
	private WebElement btnTabbyPromoClose;

	//
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	private WebElement btnCheckout;

	@FindBy(xpath = "//div[@class='swatch-option color']")
	private WebElement btnSelectColor;
	
	@FindBy(xpath="//span[contains(@class,'product_name')]")
	private WebElement msgProductName;
	
	@FindBy (xpath = "//span[@class='price eav-regular']")
	private WebElement txtBasePrice;
	
	@FindBy (xpath = "//span[@class='special-price eav-final']")
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
			if (commonMethods.isElementPresent(txtSpcialPriceCart)) {
				log.info("special price");

				priceStr = commonMethods.getText(txtSpcialPriceCart).split(" ");

				priceDob = Double.parseDouble(priceStr[1]);

			} else {
				log.info("Regular price");
				priceStr = commonMethods.getText(txtRegularPriceCart).split(" ");
				System.out.println("priceRegularStr" + priceStr[1]);
				priceDob = Double.parseDouble(priceStr[1]);
				System.out.println("price amount regular" + priceDob);
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
		waitHelper.waitForElementVisible(imgProductTile);
		List<String> availableSizes = commonMethods.getAllDropDownValues(drpdwnSize);
		for (String currentSize : availableSizes) {
			if (!currentSize.contains(" ")) {
				commonMethods.SelectUsingVisibleText(drpdwnSize, currentSize);
				log.info("Selected product size");
				break;
			}
		}
	}

	public void addAnyProduct() {
		waitHelper.waitForSpinnerInvisibility();
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
		commonMethods.click(btnSelectColor);
		log.info("Selected the color");
	}
	
	public void verifyPDPDisplayed() {
		waitHelper.waitForElementVisible(msgProductName);
		Assert.assertTrue(genericHelper.isDisplayed(msgProductName));
		log.info("user is on PDP");
	}
	
	/*
	 * This method fetches the base_price displaying for an item in the PDP
	 */
	public String getBasePricePDP(String country) {
		String basePrice = null;
		log.info("Fethcing the basebrice of the item in the PDP");
		waitHelper.waitForElementVisible(txtBasePrice);
		basePrice = commonMethods.getText(txtBasePrice);
		String currencyCode = basePrice.replaceAll("[^A-Za-z]+", "");
		basePrice = basePrice.replaceAll(",", "");
		basePrice = basePrice.substring(basePrice.indexOf(currencyCode)+3);
		log.info("The base price available in the PDP is "+basePrice);
		
		if (country.equalsIgnoreCase("UAE") || country.equalsIgnoreCase("KSA") || country.equalsIgnoreCase("QA")) {
			basePrice = basePrice.replaceAll("[^0-9]", "");
		}
		else if (country.equalsIgnoreCase("BH") || country.equalsIgnoreCase("OM") || country.equalsIgnoreCase("KW")){
			basePrice = basePrice.replaceAll("[^\\.0-9]", "");
		}
		else {
			log.info("The country code is not valid");
		}
		log.info("The base price is " + basePrice);	
		return basePrice;
	}
	
	/* This method compares the base_price displaying at PDP with the
	 * actual_price provided by the user
	 */
	public void evaluateBasePriceAtPDP(String actualBasePrice, String country) {
		log.info("Comparing the base_price displaying at PDP with the actual base_price provided by the user");
		log.info("The base_price provided by the user is " + actualBasePrice);
		String basePriceAtPDP = getBasePricePDP(country);
		log.info("The base_price available in the PDP is " + basePriceAtPDP);
		assertEquals(basePriceAtPDP, actualBasePrice, "The base_price is matching");
	}
	
	/*
	 * This method fetches the special_price displaying for an item
	 * in the PDP
	 */
	public String getSpecialPricePLP(String country) {
	log.info("Fethcing the special of the item in the PDP");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode)+3);
		log.info("The special Price at PDP is "+specialPrice);
		
		if (country.equalsIgnoreCase("UAE") || country.equalsIgnoreCase("KSA") || country.equalsIgnoreCase("QA")) {
			log.info("The special Price at PDP is "+specialPrice);
			specialPrice = specialPrice.replaceAll("[^0-9]", "");
		}
		else if (country.equalsIgnoreCase("BH") || country.equalsIgnoreCase("OM") || country.equalsIgnoreCase("KW")){
			log.info("The special Price at PDP is "+specialPrice);
			specialPrice = specialPrice.replaceAll("[^\\.0-9]", "");
		}
		else {
			log.info("The country code is not valid");
		}
		
		specialPrice = specialPrice.trim();
		log.info("The special price is " + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at PDP with
	 * the actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtPDP(String actualSpecialPrice, String country) {
		log.info("Comparing the special displaying at PDP with the actual values");
		String SpecialAtPDP = getSpecialPricePLP(country);
		assertEquals(SpecialAtPDP, actualSpecialPrice, "The special_price is matching at PDP");
	}

}
