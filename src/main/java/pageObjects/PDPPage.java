package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class PDPPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	GenericHelper genericHelper = new GenericHelper();
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

	/**
	 * WebElement declaration ends here
	 **/

	public void selectSizeCountry(String country) {
		waitHelper.waitForElementVisible(imgProductTile);
		if(!(country.isEmpty())) {			
			commonMethods.SelectUsingValue(drpdwnCountry, country);
			log.info("Selected size country " + country);
		} else {
			log.info("Selected product is simple product,  size is not required");
		}
		
	}

	public void chooseSize(String size) {
		waitHelper.waitForElementVisible(imgProductTile);
		if(!(size.isEmpty())) {			
			commonMethods.SelectUsingVisibleText(drpdwnSize, size);
			log.info("Selected size " + size);
		} else {
			log.info("Selected product is simple product, size is not required");
		}
		
	}

	public void clickAddToBag() {
		commonMethods.click(btnAddToBag);
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
}
