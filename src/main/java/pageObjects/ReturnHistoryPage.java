package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import testRunner.CucumberRunner;

public class ReturnHistoryPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(ReturnHistoryPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public ReturnHistoryPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/

	@FindBy(xpath = "//div[@class='round']/label[contains(@for,'item')]")
	private WebElement radioItemToBeReturned;

	@FindBy(xpath = "//div[@class='round']/input")
	private WebElement radioItemToBeReturnedState;

	@FindBy(xpath = "//select[contains(@id,'items:reason')]")
	private WebElement drpdwnReturnReason;

	@FindBy(xpath = "//select[@id='rma_resolution']")
	private WebElement drpdwnReturnResolution;

	@FindBy(xpath = "//button[@id='submit.save']")
	private WebElement btnReturnSubmit;

	@FindBy(xpath = "//td[contains(@class,'return_id')]/a")
	private WebElement lblReturnID;

	@FindBy(xpath = "//td[contains(@class,'shipping')]/a")
	private WebElement lblShippingOrderID;

	@FindBy(xpath = "//td[contains(@class,'actions')]/a[@class='action view']")
	private WebElement iconViewReturn;

	@FindBy(xpath = "//td[contains(@class,'return_id')]/a")
	private List<WebElement> lblReturnIDs;

	@FindBy(xpath = "//td[contains(@class,'actions')]/a[@class='action view']")
	private List<WebElement> iconViewReturns;

	@FindBy(xpath = "//td[contains(@class,'shipping')]/a")
	private List<WebElement> lblShippingOrderIDs;

	/**
	 * WebElement declaration ends here
	 **/

	public void returnAnItem(String reason, String resolution) {
		if (genericHelper.isEnabled(radioItemToBeReturnedState)) {
			commonMethods.click(radioItemToBeReturned);
		}
		commonMethods.SelectUsingVisibleText(drpdwnReturnReason, reason);
		commonMethods.SelectUsingVisibleText(drpdwnReturnResolution, resolution);
		commonMethods.click(btnReturnSubmit);
		log.info("Returned a selected product");
	}

	public String getReturnID() {
		log.info("Returning Return ID");
		return commonMethods.getText(lblReturnID);
	}

	public String getReturnedOrderID() {
		log.info("Returning Return Order ID");
		return commonMethods.getText(lblShippingOrderID);
	}

	public void clickOnViewReturn() {
		commonMethods.click(iconViewReturn);
		log.info("clicked view returns");
	}

	public void clickOnViewReturn(String returnID) {
		for (int i = 0; i < lblReturnIDs.size(); i++) {
			if (commonMethods.getText(lblReturnIDs.get(i)).equalsIgnoreCase(returnID)) {
				commonMethods.click(iconViewReturns.get(i));
			}
		}
		log.info("clicked view returns");
	}

	public String getReturnedOrderID(String returnID) {
		String orderID = "";
		for (int i = 0; i < lblReturnIDs.size(); i++) {
			if (commonMethods.getText(lblReturnIDs.get(i)).equalsIgnoreCase(returnID)) {
				orderID = commonMethods.getText(lblShippingOrderIDs.get(i));
			}
		}
		return orderID;
	}

	public void SelectAnItemForReturn(String itemID, String reason) {
		WebElement itemRadioState = genericHelper
				.getElement("//span[text()='" + itemID + "']/ancestor::div[2]/preceding-sibling::div[2]//div/input");
		WebElement itemRadio = genericHelper
				.getElement("//span[text()='" + itemID + "']/ancestor::div[2]/preceding-sibling::div[2]//div/label");
		WebElement itemReason = genericHelper.getElement("//span[text()='" + itemID
				+ "']/ancestor::div[@class='row details_row']/following-sibling::fieldset//select");
		if (genericHelper.isEnabled(itemRadioState)) {
			commonMethods.click(itemRadio);
			commonMethods.SelectUsingVisibleText(itemReason, reason);
		} else {
			genericHelper.throwUserException("element already returned");
		}
	}

	public void returnAnItemAfterSelect(String resolution) {
		commonMethods.SelectUsingVisibleText(drpdwnReturnResolution, resolution);
		commonMethods.click(btnReturnSubmit);
		log.info("Returned a selected product");
	}

	public void clickOnViewReturnForOrder() {
		String ordernumber = "500225298";
		// String ordernumber = browserFactory.getOrderNumber();
		WebElement ele = genericHelper.getElement("//td/a[text()='" + ordernumber
				+ "']/ancestor::tr/td[contains(@class,'actions')]/a[@class='action view']");
		commonMethods.click(ele);
		log.info("clicked view returns");
	}
}
