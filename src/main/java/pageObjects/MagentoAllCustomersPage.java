package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class MagentoAllCustomersPage extends CucumberRunner {

	CommonMethods commonMethods = new CommonMethods();
	
	private Logger log = Logger.getLogger(MagentoDashboardPage.class.getName());
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public MagentoAllCustomersPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	@FindBy(xpath="//button[@class='action-default'][text()='Filters']")
	private WebElement btnCustomersFilters;
	
	@FindBy(xpath="//div[@class='admin__form-field-control']//input[@name='email']")
	private WebElement txtEmailID;
	
	@FindBy(xpath="//button[@class='action-secondary']/span[text()='Apply Filters']")
	private WebElement btnCustomersApplyFilters;
	
	@FindBy(xpath="//h1[@class='page-title'][text()='Customers']")
	private WebElement lblAllCustomersPage;
	
	@FindBy(xpath="//table//a[contains(@href,'edit')][1]")
	private WebElement lnkEditCustomer;
	
	@FindBy(xpath="//div[@class='admin__data-grid-header']//button[@class='action-tertiary action-clear' and text()='Clear all']")
	private WebElement btnClearAll;
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	public void clickCustomersFilters() {
		waitHelper.waitForElementVisible(lblAllCustomersPage);
		waitHelper.waitForSpinnerInvisibility();
		commonMethods.click(btnCustomersFilters);
		log.info("clicked Filters button in Customers page in Magento");
	}
	
	public void enterEmail() {
		commonMethods.clearAndSendKeys(txtEmailID, browserFactory.getLoggedInUserEmail());
		log.info("Email ID is entered: "+browserFactory.getLoggedInUserEmail());
	}
	
	public void verifyCustomersPageTitle() {
		if(genericHelper.isDisplayed(lblAllCustomersPage)) {
			log.info("Magento All Customers Page is displayed");
		}	
	}
	
	public void clickOnApplyFilters() {
		commonMethods.click(btnCustomersApplyFilters);
		log.info("clicked Apply Filters button in Customers page Filter in Magento");
	}
	
	public void clickOnEditCustomer() {
		waitHelper.waitForElementToBeClickable(lnkEditCustomer);
		commonMethods.moveToElementAndClick(lnkEditCustomer);
		log.info("clicked Edit link for the customer in Magento");
	}
	
	public void clickClearAll() {
		waitHelper.waitForSpinnerInvisibility();
		if(genericHelper.isDisplayed(btnClearAll)) {
			commonMethods.click(btnClearAll);
			log.info("clicked Clear All button in All Customers page in Magento");
		}
	}
	
	public void navigateToCustomerDetailsPage() {
		this.clickClearAll();
		this.clickCustomersFilters();
		this.enterEmail();
		this.clickOnApplyFilters();
		this.clickOnEditCustomer();
	}
}
