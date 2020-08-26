package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import testRunner.CucumberRunner;

public class ReturnDetailsPage extends CucumberRunner {

	/**
	 * Class object declaration here
	 **/
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	private Logger log = Logger.getLogger(ReturnDetailsPage.class.getName());
	
	/**
	 * Constructor to initialize page objects
	 **/
	public ReturnDetailsPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	/**
	 * WebElement declaration starts here
	 **/
	
	@FindBy(xpath = "//span[contains(@class,'return-details-status')]")
	private WebElement lblReturnStatus;
	
	@FindBy(xpath = "//a[contains(@class,'return-details-status-id')]")
	private WebElement lblReturnOrderID;
	
	@FindBy(xpath = "//div[@class='return-item-details-reason__text']")
	private WebElement msgReturnReason;
	
	@FindBy(xpath = "//a[@class='return-item-details__button-back']")
	private WebElement btnBackToOrderDetails;
	
	/**
	 * WebElement declaration ends here
	 **/
	
	public String getReturnStatus() {
		log.info("Returning return order status");
		return commonMethods.getText(lblReturnStatus);
	}
	
	public String getReturnOrderID() {
		log.info("Returning return order id");
		return commonMethods.getText(lblReturnOrderID);
	}
	
	public String getReturnReason() {
		log.info("Returning return reason");
		return commonMethods.getText(msgReturnReason);
	}
	
	public void clickOnreturnToOrderDetails() {
		commonMethods.click(btnBackToOrderDetails);
		log.info("Clicked on BackToOrderDetails button");
	}

}
