package pageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class WishlistPage extends CucumberRunner {
	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	private Logger log = Logger.getLogger(WishlistPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public WishlistPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//span[@data-price-type='finalPrice']")
	WebElement txtSpecialPrice;

	@FindBy(xpath = "//span[@class='wishlist-tocart']")
	WebElement btnAddToBag;

	/**
	 * WebElement declaration ends here
	 **/

	/*
	 * This method fetches the special_price displaying for an item in the PLP
	 */
	public String getSpecialPricePLP() {
		log.info("Fethcing the special of the item in the PDP");
		waitHelper.waitForElementVisible(txtSpecialPrice);
		String specialPrice = commonMethods.getText(txtSpecialPrice);
		String currencyCode = specialPrice.replaceAll("[^A-Za-z]+", "");
		specialPrice = specialPrice.replaceAll(",", "");
		specialPrice = specialPrice.substring(specialPrice.indexOf(currencyCode) + 3);
		specialPrice = specialPrice.trim();
		log.info("The special price available at Wishlist is " + specialPrice);
		return specialPrice;
	}

	/*
	 * This method compares the special_price displaying at PDP with the
	 * actual_price provided by the user
	 */
	public void evaluateSpecialPriceAtPLP(String actualSpecialPrice) {
		log.info("Comparing the special displaying at PDP with the actual values");
		String SpecialAtPDP = getSpecialPricePLP();
		assertEquals(SpecialAtPDP, actualSpecialPrice, "The special_price is matching at PDP");
	}
	
	public void addItemToBag() {
		waitHelper.waitForElementToBeClickable(btnAddToBag);
		//commonMethods.click(btnAddToBag);
		commonMethods.clickUsingJS(btnAddToBag);
	}
}
