package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.BrowserFactory;
import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class MagentoCustomerDetailsPage extends CucumberRunner{
	
	CommonMethods commonMethods = new CommonMethods();
	
	private Logger log = Logger.getLogger(MagentoDashboardPage.class.getName());
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public MagentoCustomerDetailsPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	/**
	 * WebElement declaration starts here
	 * **/
	@FindBy(xpath="//strong[text()='Customer Information']")
	private WebElement lblCustomersDetails;
	
	@FindBy(xpath="//span[text()='Store Credit']")
	private WebElement lnkStoreCredit;
	
	@FindBy(xpath="//fieldset[@id='_customerbalancestorecredit_fieldset']/legend/span[text()='Update Balance']")
	private WebElement lblUpdateBalance;
	
	@FindBy(xpath="//select[@id='_customerbalancewebsite_id'][@title='Website']")
	private WebElement drpdwnWebsite;
	
	@FindBy(xpath="//input[@id='_customerbalanceamount_delta'][@title='Update Balance']")
	private WebElement txtUpdateSCBalance;
	
	@FindBy(xpath="//button[@id='save'][@title='Save Customer']")
	private WebElement btnSaveCustomer;

	/**
	 * WebElement declaration ends here
	 * **/
	
	public void verifyCustomersPageTitle() {
		if(genericHelper.isDisplayed(lblCustomersDetails)) {
			log.info("Magento Customers Details Page is displayed");
		}	
	}
	
	public void clickOnStoreCreditNavLink() {
		waitHelper.waitForElementVisible(lblCustomersDetails);
		waitHelper.waitForSpinnerInvisibility();
		commonMethods.click(lnkStoreCredit);
		log.info("clicked Store Credit Navigation link for the customer in Magento");
	}
	
	public void selectWebsite() {
		waitHelper.waitForElementVisible(lblUpdateBalance);
		String country = this.getCurrentCountry();
		commonMethods.SelectUsingVisibleText(drpdwnWebsite, country);
		log.info("Selected the country to update Store Credit Balance: " +country);
	}
	
	public void updateStoreCreditBalance() {
		String SCBalance = "1000";
		this.clickOnStoreCreditNavLink();
		this.selectWebsite();
		commonMethods.clearAndSendKeys(txtUpdateSCBalance, SCBalance);
		this.clickSaveCustomer();
	}
	
	private String getCurrentCountry() {
		String env = browserFactory.getCountry();
		String country = "";
		if (env.equalsIgnoreCase("UAE")) {
			country = "UAE";
		} else if (env.equalsIgnoreCase("KSA")) {
			country = "Saudi Arabia";
		} else if (env.equalsIgnoreCase("KW")) {
			country = "Kuwait";
		}else if (env.equalsIgnoreCase("QA")) {
			country = "Qatar";
		}else if (env.equalsIgnoreCase("OM")) {
			country = "Oman";
		}else if (env.equalsIgnoreCase("BH")) {
			country = "Bahrain";
		}
		return country;
	}
	
	public void clickSaveCustomer() {
		commonMethods.click(btnSaveCustomer);
		log.info("clicked Save Customer button in Customer Details page in Magento");
		waitHelper.waitForSpinnerInvisibility();
	}
	
}
