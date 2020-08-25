package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class MagentoOrdersViewPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	
	private Logger log = Logger.getLogger(MagentoOrdersViewPage.class.getName());
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public MagentoOrdersViewPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	
	@FindBy(xpath = "//button[@class='action-default' and .='Filters']")
	private WebElement btnFilters;
	
	@FindBy(xpath = "(//button[@class='action-tertiary action-clear' and .='Clear all'])[1]")
	private WebElement btnClearFilters;
	
	@FindBy(xpath = "(//input[@class='admin__control-text data-grid-search-control'])[1]")
	private WebElement txtSearchOrder;
	
	@FindBy(xpath = "//td[contains(text(),\"We couldn't find any records.\")]")
	private WebElement lblNoRecordsFound;
	
	@FindBy(xpath = "//div[@class='admin__form-field-control']/input[@name='increment_id']")
	private WebElement txtOrderID;
	
	@FindBy(xpath = "//span[contains(text(),'Apply Filters')]")
	private WebElement btnApplyFilters;
	
	@FindBy(xpath = "//button[@class='action-tertiary']//span[contains(text(),'Cancel')]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "(//tr[@class='data-row']//td[2]/div[@class='data-grid-cell-content'])[1]")
	private WebElement cellOrderID;
	
	@FindBy(xpath = "//a[@class='action-menu-item']")
	private WebElement lnkView;
	
	
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	public void clickClearAllFilters() {
		if(commonMethods.isElementPresent(btnClearFilters)) {
			commonMethods.click(btnClearFilters);
			log.info("clicked Clear all filters button");
		} else {
			log.info("Clear all filters button not visible");
		}
	}
	
	public void verifyOrdersFiltersPageIsDisplayed() {
		if(commonMethods.isElementPresent(btnFilters)) {
			log.info("Orders Filter page is displayed");
		} else {
			log.info("Orders Filter page is not displayed");
		}
	}
	
	public void clickFilters() {
		commonMethods.click(btnFilters);
		log.info("clicked Filters button");
	}
	
	
	public void enterOrderID(String orderID) {
		commonMethods.sendKeys(txtOrderID, orderID);
		log.info("Order ID is entered");
	}
	
	public void clickApplyFilters() {
		commonMethods.click(btnApplyFilters);
		log.info("clicked Apply Filters button");
	}
	
	public void verifySearchResult() {
		if(commonMethods.isElementPresent(lblNoRecordsFound)) {
			log.info("Search result is - No Records found");
		} else if (commonMethods.isElementPresent(cellOrderID)){
			log.info("Search result is - Records found");
		}		
	}
	
	public void clickView() {
		commonMethods.click(lnkView);
		log.info("clicked View link");
	}
	
}
