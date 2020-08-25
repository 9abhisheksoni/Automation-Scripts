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
	
	@FindBy(xpath = "//a[@href='https://6thadmin-stage.6tst.com/sixadmin/sales/order/index/key/1e14b4b5447f2184dd4c85fbc08feea191ee472b2db13843fba0dfd3defc262a/']/span[.='Orders']")
	private WebElement lnkOrders;
	
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
	
}
