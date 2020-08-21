package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class PDPPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
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

	/**
	 * WebElement declaration ends here
	 **/

	public void selectSizeCountry(String country) {
		waitHelper.waitForElementVisible(imgProductTile);
		commonMethods.SelectUsingValue(drpdwnCountry, country);
		log.info("Selected size country " + country);
	}

	public void chooseSize(String size) {
		waitHelper.waitForElementVisible(imgProductTile);
		commonMethods.SelectUsingVisibleText(drpdwnSize, size);
		log.info("Selected size " + size);
	}

	public void clickAddToBag() {
		commonMethods.click(btnAddToBag);
		log.info("clicked on add to bag");
	}
}
