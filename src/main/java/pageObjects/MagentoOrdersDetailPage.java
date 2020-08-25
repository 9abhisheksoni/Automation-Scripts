package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class MagentoOrdersDetailPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	
	private Logger log = Logger.getLogger(MagentoOrdersDetailPage.class.getName());
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public MagentoOrdersDetailPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	
	@FindBy(xpath = "(//div[@class='admin__page-section-item-title']/span[@class='title'])[1]")
	private WebElement divOrderID;
	
	@FindBy(xpath = "//span[@id='order_status']")
	private WebElement lblOrderStatus;
	
	@FindBy(xpath = "//button[@id='order_invoice']//span[contains(text(),'Invoice')]")
	private WebElement btnInvoice;
	
	@FindBy(xpath = "//button[@id='order_ship']//span[contains(text(),'Ship')]")
	private WebElement btnShip;
	
	@FindBy(xpath = "//button[@id='back']//span[contains(text(),'Back')]")
	private WebElement btnBack;
	
	@FindBy(xpath = "//button[@id='order-view-cancel-button']//span[contains(text(),'Cancel')]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//span[contains(text(),'Send Email')]")
	private WebElement btnSendEmail;
	
	@FindBy(xpath = "//select[@name='invoice[capture_case]']")
	private WebElement drpdwnPaymentCapture;
	
	@FindBy(xpath = "//button[@title='Submit Invoice']")
	private WebElement btnSubmitInvoice;
	
	@FindBy(xpath = "//button[contains(@title,'Update Qty')]")
	private WebElement btnUpdateQty;
	
	@FindBy(xpath = "//input[contains(@name,'invoice[items]')]")
	private WebElement txtQtyToInvoice;
	
	@FindBy(xpath = "//input[contains(@name,'shipment[items]')]")
	private WebElement txtQtyToShip;
	
	@FindBy(xpath = "//span[contains(text(),'Add Tracking Number')]")
	private WebElement btnAddTrackingNumber;
	
	@FindBy(xpath = "//select[@id='trackingC1']")
	private WebElement drpdwnCarreir;
	
	@FindBy(xpath = "//input[@id='trackingT1']")
	private WebElement txtTitle;
	
	@FindBy(xpath = "//input[@id='trackingN1']")
	private WebElement txtNumber;
	
	@FindBy(xpath = "//button[@class='action-default action-delete']")
	private WebElement btnDelete;
	
	@FindBy(xpath = "//input[@id='send_email']")
	private WebElement chkSendEmailCopy;	
	
	@FindBy(xpath = "//span[contains(text(),'Submit Shipment')]")
	private WebElement btnSubmitShipment;	
	
	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement lblNewInvoice;
	
	@FindBy(xpath = "//div[contains(text(),'The invoice has been created.')]")
	private WebElement lblInvoiceCreated;
	
	@FindBy(xpath = "//th[contains(text(),'Invoiced')]")
	private WebElement lblInvoiced;
	
	@FindBy(xpath = "//div[contains(text(),'The shipment has been created.')]")
	private WebElement lblShipmentCreated;
	
	@FindBy(xpath = "//th[contains(text(),'Shipped')]")
	private WebElement lblShipped;
	
	@FindBy(xpath = "//span[contains(text(),'Order & Account Information')]")
	private WebElement lblOrderInfo;
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	
	
	public void verifyOrderID() {
		if(commonMethods.getAttribute(divOrderID, "innerHTML").contains(browserFactory.getOrderNumber())) {
			log.info("Order id " +browserFactory.getOrderNumber()+ " matches");
		} else {
			log.info("Order id " +browserFactory.getOrderNumber()+ " doesn't matches");
		}		
	}
	
	public void verifyOrderStatus(String orderStatus) {
		if(commonMethods.getAttribute(lblOrderStatus, "innerHTML").contains(orderStatus)) {
			log.info("Order status " +orderStatus+ " matches");
		} else {
			log.info("Order status " +orderStatus+ " doesn't matches");
		}		
	}
	
	public void clickInvoice() {
		commonMethods.click(btnInvoice);
		log.info("Invoice button is clicked");
	}
	
	public void clickShip() {
		commonMethods.click(btnShip);
		log.info("Ship button is clicked");
	}
	
	public void clickCancel() {
		commonMethods.click(btnCancel);
		log.info("Cancel button is clicked");
	}
	
	public void clickBack() {
		commonMethods.click(btnBack);
		log.info("Back button is clicked");
	}
	
	public void clickSendEmail() {
		commonMethods.click(btnSendEmail);
		log.info("Back button is clicked");
	}
	
	public void captureOnline() {
		commonMethods.SelectUsingValue(drpdwnPaymentCapture, "online");
		log.info("Capture online is selected");
	}
	
	public void captureOffline() {
		commonMethods.SelectUsingValue(drpdwnPaymentCapture, "offline");
		log.info("Capture offline is selected");
	}
	
	public void notCapture() {
		commonMethods.SelectUsingValue(drpdwnPaymentCapture, "not_capture");
		log.info("Capture offline is selected");
	}	
	
	public void enterQtyToInvoice(String qty) {
		commonMethods.sendKeys(txtQtyToInvoice, qty);
		log.info("Invoice Quatity has been set as "+qty);
	}
	
	public void clickUpdateQty() {
		commonMethods.click(btnUpdateQty);
		log.info("Update qty button is clicked");
	}
	
	public void clickSubmitInvoice() {
		commonMethods.click(btnSubmitInvoice);
		log.info("Submit Invoice button is clicked");
	}
	
	public void enterQtyToShip(String qty) {
		commonMethods.sendKeys(txtQtyToShip, qty);
		log.info("Shipment Quatity has been set as "+qty);
	}
	
	public void clickAddTrackingNumber() {
		commonMethods.click(btnAddTrackingNumber);
		log.info("Add Tracking Number button is clicked");
	}
	
	public void selectCarrierCustom() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "custom");
		log.info("Carrier is selected as custom");
		this.enterCarrierTitle();
	}
	
	public void selectCarrierDhl() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "dhl");
		log.info("Carrier is selected as DHL");
	}
	
	public void selectCarrierFetchr() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "fetchr");
		log.info("Carrier is selected as Fetcher");
	}
	
	public void selectCarrierFedex() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "fedex");
		log.info("Carrier is selected as Fedex");
	}
	
	public void selectCarrierUnitedParcelService() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "ups");
		log.info("Carrier is selected as United Parcel Service");
	}
	
	public void selectCarrierFederalExpress() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "fedex");
		log.info("Carrier is selected as Federal Express");
	}
	
	public void selectCarrierUnitedStatesPostalService() {
		commonMethods.SelectUsingValue(drpdwnCarreir, "usps");
		log.info("Carrier is selected as United States Postal Service");
	}
	
	public void enterCarrierTitle() {
		commonMethods.sendKeys(txtTitle, "6thstreet");
		log.info("Carrier Title is entered as 6thstreet");
	}
	
	public void enterTrackingNumber(String trackingNum) {
		commonMethods.sendKeys(txtNumber, trackingNum);
		log.info("Carrier Title is entered as : "+trackingNum);
	}
	
	public void clickDeleteIcon() {
		commonMethods.click(btnDelete);
		log.info("Delete icon clicked");
	}
	
	
	public void clickSendEmailCopyOfShipment() {
		if(!commonMethods.isSelected(chkSendEmailCopy)) {
			commonMethods.click(chkSendEmailCopy);
			log.info("Send email copy of shipment checkbos is clicked");
		}		
	}
	
	public void clickSubmitShipment() {
		commonMethods.click(btnSubmitShipment);
		log.info("Submit Shipment button clicked");
	}
	
	public void verifyInvoicePage() {
		waitHelper.waitForElementVisible(btnSubmitInvoice);
		if(commonMethods.getAttribute(lblNewInvoice, "innerHTML").contains("New Invoice")) {
			log.info("Invoce page is displayed");
		} else {
			log.info("Invoce page is not displayed");
		}		
	}
	
	
	public void verifyInvoiceCreationStatus() {
		waitHelper.waitForElementInVisiblity(lblInvoiced);
		if(commonMethods.getAttribute(lblInvoiceCreated, "innerHTML").contains("The invoice has been created")) {
			log.info("Invoice creation is success");
		} else {
			log.info("Invoice creation failed");
		}		
	}
	
	public void verifyOrderDetailsPage() {
		waitHelper.waitForElementInVisiblity(lblOrderInfo);
		if(commonMethods.getAttribute(divOrderID, "innerHTML").contains(browserFactory.getOrderNumber())) {
			log.info("Order details page is displayed");
		} else {
			log.info("Order details page is not displayed");
		}		
	}
	
	public void verifyShipmentCreationStatus() {
		waitHelper.waitForElementInVisiblity(lblShipped);
		if(commonMethods.getAttribute(lblShipmentCreated, "innerHTML").contains("The shipment has been created")) {
			log.info("Shipment creation is success");
		} else {
			log.info("Shipment creation failed");
		}		
	}
	
	public void verifyShipmentPage() {
		waitHelper.waitForElementInVisiblity(lblShipped);
		if(commonMethods.isElementPresent(btnSubmitShipment)) {
			log.info("Shipment page is displayed");
		} else {
			log.info("Shipment page is not displayed");
		}		
	}
	
}
