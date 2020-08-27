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

public class MagentoRmaPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(MagentoRmaPage.class.getName());

	/**
	 * Constructor to initialize page objects
	 **/
	public MagentoRmaPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/

	@FindBy(xpath = "//strong[.='Return Information']")
	private WebElement lblReturnInfo;

	@FindBy(xpath = "//select[@name='resolution']")
	private WebElement drpdwnResolution;

	@FindBy(xpath = "//span[contains(text(),'Submit Returns')]")
	private WebElement btnSubmitReturns;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement btnCancelReturns;

	@FindBy(xpath = "//span[contains(text(),'Return Items')]")
	private WebElement menuReturnItems;	
	
	@FindBy(xpath = "//select[@class='admin__control-select' and contains(@name,'items')]")
	private WebElement drpdwnReturnReason;
	
	@FindBy(xpath = "//input[@class='admin__control-checkbox']")
	private WebElement chkSelectItem;
	
	@FindBy(xpath = "//div[contains(text(),'You submitted the RMA request')]")
	private WebElement lblRmaCreationConfirmation;

	/**
	 * WebElement declaration ends here
	 **/

	public void verifyRmaPage() {
		waitHelper.waitForElementToBeClickable(btnSubmitReturns);
		if(commonMethods.isElementPresent(lblReturnInfo)) {
			log.info("RMA creation page is displayed");
		} else {
			log.info("RMA creation page is not displayed");
		}		
	}

	public void selectReturnResolution(String Resolution) {
		if(Resolution.equalsIgnoreCase("Tabby Refund")) {
			commonMethods.SelectUsingVisibleText(drpdwnResolution, "Tabby Refund");
			log.info("Resolution selected as "+ Resolution);
		} else if(Resolution.equalsIgnoreCase("Store Credit")) {
			log.info("Store credit Resolution is not available");
		}
	}
	
	public void clickReturnItemsMenu() {
		waitHelper.waitForElementToBeClickable(menuReturnItems);
		commonMethods.click(menuReturnItems);
		log.info("Return Items menu is clicked");
	}
	
	public void selectReturnReason(String Reason) {
		if(Reason.equalsIgnoreCase("Bought Wrong Item")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27491");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Cancel Before Delivery")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27489");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Delivery took longer than promised")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "28197");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Delivery took too long")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27492");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Duplicate Order")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27493");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Forgot to use Coupon")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27490");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Incorrect Size")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27494");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Initiated return with Customer Service")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "28195");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Item is Damaged")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27487");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Placed order by mistake")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "28196");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Unhappy with Customer Service")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27495");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Unhappy with the Product")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27486");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Unsuitable Fit")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27485");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Wrong Item Was Delivered")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "27488");
			log.info("Reson selected as : "+ Reason);
		} else if(Reason.equalsIgnoreCase("Other")) {
			commonMethods.SelectUsingValue(drpdwnReturnReason, "other");
			log.info("Reson selected as : "+ Reason);
		} else {
			log.info("Reson "+Reason+ " doesn't exist");
		}
	}
	
	public void clickSelectItemCheckbox() {
		if(!commonMethods.isSelected(chkSelectItem) && genericHelper.isEnabled(chkSelectItem)) {
			commonMethods.click(chkSelectItem);
			log.info("Select item checkbox is clicked");
		}
	}
	
	public void clickSubmitReturns() {
		waitHelper.waitForElementToBeClickable(btnSubmitReturns);
		commonMethods.click(btnSubmitReturns);
		log.info("Submit returns button is clicked");
	}
	
	public void clickCancelReturns() {
		waitHelper.waitForElementToBeClickable(btnCancelReturns);
		commonMethods.click(btnCancelReturns);
		log.info("Cancel returns button is clicked");
	}
	
	public void verifyRmaCreationStatus() {
		waitHelper.waitForElementVisible(lblRmaCreationConfirmation);
		if(commonMethods.getAttribute(lblRmaCreationConfirmation, "innerHTML").contains("You submitted the RMA request")) {
			log.info("RMA creation from Magento is success");
		} else {
			log.info("Failed to create RMA from Magento!!!");
		}
		
	}
}
