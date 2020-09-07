package pageObjects;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class CartPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	
	private Logger log = Logger.getLogger(CartPage.class.getName());
	
	
	/**
	 * Constructor to initialize page objects
	 * **/
	public CartPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	
	/**
	 * WebElement declaration starts here
	 * **/
	@FindBy(xpath = "//tr[@class='totals shipping excl' or @class='totals-tax']")
	private WebElement lblOrderSummary;
	
	@FindBy(xpath = "//button[@class='action primary checkout']")
	private WebElement btnCheckout;
	
	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	private WebElement btnMiniCartCheckout;
	
	@FindBy(xpath = "//a[@class='action viewcart view_bag']")
	private WebElement btnMiniCartViewBag;
	
	@FindBy(xpath = "//span[@id='minicart-counter']")
	public WebElement lblCartCount;
	
	@FindBy(xpath="//span[@class='cart_icon']")
	private WebElement iconCart;
	
	@FindBy(xpath="//div[@class='remove_cart']//span[@class='cart_icon_remove']")
	private List<WebElement> iconRemove;
	
	/**
	 * WebElement declaration ends here
	 * **/
	
	
	public void clickCheckout() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to proceed? ");
		String input = sc.nextLine();
		// waitHelper.waitForElementVisible(lblOrderSummary); // The label 'Shipping' is not visible in the Cart page through automation
		commonMethods.click(btnCheckout);
		log.info("clicked checkout button in cart page");
	}	
	
	public void clearCart() {
		waitHelper.staticWait(5000);
		if (commonMethods.isElementPresent(lblCartCount)) {
			commonMethods.click(iconCart);
			commonMethods.moveToElementAndClick(btnMiniCartViewBag);
			int removeiconCount = iconRemove.size();
			for(int i=0;i<removeiconCount;i++) {
				commonMethods.click(iconRemove.get(0));
				log.info("remove icon clicked");
			}
		}
	}
}
