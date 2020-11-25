package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import testRunner.CucumberRunner;

public class MagentoDashboardPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	
	private Logger log = Logger.getLogger(MagentoDashboardPage.class.getName());
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public MagentoDashboardPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	@FindBy(xpath = "//a/span[.='Sales']")
	private WebElement lnkSales;
	
	@FindBy(xpath = "(//a/span[.='Orders'])[1]")
	private WebElement lnkOrders;
	
	@FindBy(xpath="//li[@id='menu-magento-customer-customer']/a")
	private WebElement lnkCustomers;
	
	@FindBy(xpath="//li[@id=\"menu-magento-customer-customer\"]//li[1]/a")
	private WebElement lnkAllCustomers;
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	
	public void clickSalesMenu() {
		commonMethods.click(lnkSales);
		log.info("clicked sales menu in Magento");
	}
	
	public void clickOrdersMenuItem() {
		commonMethods.click(lnkOrders);
		log.info("clicked Sales >> Orders link in Magento");
	}
	
	public void clickCustomersMenu() {
		commonMethods.click(lnkCustomers);
		log.info("clicked Customers menu in Magento");
	}
	
	public void clickAllCustomersMenuItem() {
		commonMethods.click(lnkAllCustomers);
		log.info("clicked Customers >> All Customers link in Magento");
	}
}
