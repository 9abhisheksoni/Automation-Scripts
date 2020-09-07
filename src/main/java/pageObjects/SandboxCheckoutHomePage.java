package pageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import testRunner.CucumberRunner;

public class SandboxCheckoutHomePage extends CucumberRunner{
	/**
	 * Class object declaration here
	 **/
	GenericHelper genericHelper = new GenericHelper();
	CommonMethods commonMethods = new CommonMethods();
	private Logger log = Logger.getLogger(HomePage.class.getName());
	
	/**
	 * Constructor to initialize page objects
	 **/
	public SandboxCheckoutHomePage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	/**
	 * WebElement declaration starts here
	 **/
	@FindBy(xpath = "//div[contains(text(),'Dashboard')]")
	private WebElement checkoutSandboxDashboardTitle;
	
	@FindBy(xpath = "//aside//span[contains(text(),'Payments')]")
	private WebElement menuPayments;
	
	/**
	 * WebElement declaration ends here
	 **/
	
	public void verifyCheckoutDashboardDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(checkoutSandboxDashboardTitle));
		log.info("Checkout Sandbox Dashboard is loaded");
	}
	
	public void clickPaymentsMenu() {
		commonMethods.click(menuPayments);
		log.info("Checkout Sandbox Payments menu link is clicked");
	}

}
