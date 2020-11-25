package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import testRunner.CucumberRunner;

public class MagentoAllCustomersPage extends CucumberRunner {

	CommonMethods commonMethods = new CommonMethods();
	
	private Logger log = Logger.getLogger(MagentoDashboardPage.class.getName());
	
	
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
	/**
	 * WebElement declaration ends here
	 * **/
	
	public void clickCustomersFilters() {
		commonMethods.click(btnCustomersFilters);
		log.info("clicked Filters button in Customers page in Magento");
	}
	
	public void enterEmail() {
		commonMethods.clearAndSendKeys(txtEmailID, browserFactory.getLoggedInUserEmail());
		log.info("Email ID is entered: "+browserFactory.getLoggedInUserEmail());
	}
}
