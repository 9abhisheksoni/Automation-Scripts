package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class ReturnHistoryPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
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

	@FindBy(xpath = "//div[contains(@class,'Checkbox')]/label")
	private WebElement radioItemToBeReturned; 

	@FindBy(xpath = "//div[contains(@class,'Checkbox')]/input")
	private WebElement radioItemToBeReturnedState;  

	@FindBy(xpath = "//div[contains(@class,'Reasons')]/div/select")
	private WebElement drpdwnReturnReason; 

	@FindBy(xpath = "//div[contains(@class,'Resolutions')]/div/select")
	private WebElement drpdwnReturnResolution; 

	@FindBy(xpath = "//*[contains(text(),'Return') and @type='submit']")
	private WebElement btnReturnSubmit; 

	@FindBy(xpath = "//a[@class=' MyAccountReturnListItem']/span[1]")
	private WebElement lblReturnID; 

	@FindBy(xpath = "//div[contains(@class,'OrderNumber')]")
	private WebElement lblShippingOrderID; 

	@FindBy(xpath = "//a[contains(@class,'MyAccountReturnListItem')]")
	private WebElement iconViewReturn; 

	@FindBy(xpath = "//a[@class=' MyAccountReturnListItem']/child::span[1]")
	private List<WebElement> lblReturnIDs; 

	@FindBy(xpath = "//span[@class='MyAccountReturnListItem-Status']")
	private List<WebElement> iconViewReturns; 

	@FindBy(xpath = "//div[@class='MyAccountReturnListItem-OrderNumber']")
	private List<WebElement> lblShippingOrderIDs; 

	@FindBy(xpath = "//h1[@class='MyAccount-Heading']")
	private WebElement lblReturnHistory; 

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
				.getElement("//span[contains(text(),'" + itemID.substring(0, itemID.indexOf('-') - 1)
						+ "')]/ancestor::div[2]/preceding-sibling::div[2]//div/input");
		WebElement itemRadio = genericHelper
				.getElement("//span[contains(text(),'" + itemID.substring(0, itemID.indexOf('-') - 1)
						+ "')]/ancestor::div[2]/preceding-sibling::div[2]//div/label");
		WebElement itemReason = genericHelper
				.getElement("//span[contains(text(),'" + itemID.substring(0, itemID.indexOf('-') - 1)
						+ "')]/ancestor::div[@class='row details_row']/following-sibling::fieldset//select");
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
		String ordernumber = browserFactory.getOrderNumber();
		browserFactory.setReturnNumber(this.getReturnId());
		WebElement ele = genericHelper.getElement("//td/a[text()='" + ordernumber
				+ "']/ancestor::tr/td[contains(@class,'actions')]/a[@class='action view']");
		commonMethods.click(ele);
		log.info("clicked view returns");
	}

	public String getReturnId() {
		String ordernumber = browserFactory.getOrderNumber();
		WebElement ele = genericHelper.getElement(
				"//td/a[text()='" + ordernumber + "']/../preceding-sibling::td[contains(@class,'return_id')]/a");
		return commonMethods.getText(ele);
	}

	public void verifyReturnHistoryPage() {
		waitHelper.waitForElementVisible(lblReturnHistory);
		log.info("Order History page is displayed");
	}

	public String getReturnStatusInHistory() {
		String ordernumber = browserFactory.getOrderNumber();
		WebElement ele = genericHelper
				.getElement("//td/a[text()='" + ordernumber + "']/../following-sibling::td[contains(@class,'status')]");
		return commonMethods.getText(ele);
	}

}
