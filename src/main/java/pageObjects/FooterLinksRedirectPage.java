package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import junit.framework.Assert;
import testRunner.CucumberRunner;

public class FooterLinksRedirectPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper=new WaitHelper();
	GenericHelper genericHelper=new GenericHelper();
	
	private Logger log = Logger.getLogger(FooterLinksRedirectPage.class.getName());
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public FooterLinksRedirectPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	@FindBy(xpath = "//h3[contains(text(),'ABOUT 6TH STREET')]")
	private WebElement lblAbout6thStreet;
	
	@FindBy(xpath = "//a[contains(text(),'Consumer')]")
	private WebElement lblConsumer;
	
	@FindBy(xpath = "//h1[contains(text(),'Disclaimer')]")
	private WebElement lblDisclaimer;
		
	@FindBy(xpath = "//h1[contains(text(),'Privacy Policy')]")
	private WebElement lblPrivacyPolicy;
	
	@FindBy(xpath = "//h1[contains(text(),'Shipping Policy')]")
	private WebElement lblShippingPolicy;
	
	@FindBy(xpath = "//h1[contains(text(),'Return Information')]")
	private WebElement lblReturnInfo;
	
	@FindBy(xpath = "//input[@id='tracking_id']")
	private WebElement txtTrackID;
	
	@FindBy(xpath = "//h1[contains(text(),\"FAQ'S\")]")
	private WebElement lblFAQs;	
	
	@FindBy(xpath = "//button[@title='Submit']")
	private WebElement btnSubmitFeedback;
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	
	public void verifyAbout6thStreetPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblAbout6thStreet));
			log.info("About 6thstreet page is displayed");
		} catch(Exception e) {
			log.info("About 6thstreet page is not displayed!");
		}
	}
	
	public void verifyConsumerRightsPage() {
		try {
			waitHelper.waitForElementVisible(lblConsumer);
			log.info("Looking for element"+ commonMethods.getText(lblConsumer) +" in Consumer Rights page ");
			log.info("Title is "+ browserFactory.getDriver().getCurrentUrl() +" in Consumer Rights page ");
			Assert.assertTrue(commonMethods.isElementPresent(lblConsumer));
			log.info("Consumer Rights page is displayed");
		} catch(Exception e) {
			log.info("Consumer Rights page is not displayed!");
		}
	}
	
	public void switchToConsumerRightsPage() {
		String parentWindow=genericHelper.getWindowHandle();
    	Set<String>windows=genericHelper.getWindowHandles();

    	// Now iterate using Iterator
    	Iterator<String> iterate= windows.iterator();

    	while(iterate.hasNext()){
    	String childWindow=iterate.next();
    	if(!parentWindow.equals(childWindow)){
    		genericHelper.switchToWindow(childWindow);
    		System.out.println(">>>>>>>>>>>>>>>>>>Switched to child window>>>>>>>>>>>>>>");
    		}
    	}
	}
	
	public void verifyDisclaimerPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblDisclaimer));
			log.info("Disclaimer page is displayed");
		} catch(Exception e) {
			log.info("Disclaimer page is not displayed!");
		}
	}
	
	public void verifyPrivacyPolicyPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblPrivacyPolicy));
			log.info("Privacy Policy page is displayed");
		} catch(Exception e) {
			log.info("Privacy Policy page is not displayed!");
		}
	}
	
	public void verifyShippingPolicyPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblShippingPolicy));
			log.info("Shipping Policy page is displayed");
		} catch(Exception e) {
			log.info("Shipping Policy page is not displayed!");
		}
	}
	
	public void verifyReturnInfoPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblReturnInfo));
			log.info("Return Info page is displayed");
		} catch(Exception e) {
			log.info("Return Info page is not displayed!");
		}
	}
	
	public void verifyTrackingPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(txtTrackID));
			log.info("Tracking page is displayed");
		} catch(Exception e) {
			log.info("Tracking page is not displayed!");
		}
	}
	
	public void verifyFAQsPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(lblFAQs));
			log.info("FAQs page is displayed");
		} catch(Exception e) {
			log.info("FAQs page is not displayed!");
		}
	}
	
	public void verifyFeedbackPage() {
		try {
			Assert.assertTrue(commonMethods.isElementPresent(btnSubmitFeedback));
			log.info("Feedback page is displayed");
		} catch(Exception e) {
			log.info("Feedback page is not displayed!");
		}
	}	
}
