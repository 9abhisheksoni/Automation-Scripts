package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import commonHelper.BrowserFactory;
import fileReader.DataHandlers;
import testRunner.CucumberRunner;

public class Config {

	Properties config;
	private final Logger log = Logger.getLogger(Config.class.getName());
	private Properties prop;
	private String filepath;
	

	/** This methods creates config object  **/
	public Properties createConfigObject() {
		log.info("Creating config object");
		FileInputStream ip;
		this.setConfigPath();
		try {
			ip = new FileInputStream(new File(filepath));
			prop = new Properties();
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/** This methods sets values to prop.properties **/
	public void setConfigFileValue(String key, String value) {
		checkToCreateProp();
		log.info("Setting values to config file for key " + key + " and value " + value);
		try {
			this.setConfigPath();
			createConfigObject();
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(new File(filepath));
			prop.store(fos, "save");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** This methods returns implicit wait from property file **/
	public int getImplicitTimeoutInSec() {
		checkToCreateProp();
		log.info("getting implicit wait from property file in sec");
		return Integer.parseInt(prop.getProperty("ImplicitTimeoutInSec"));
	}

	/** This methods returns explicit wait from property file **/
	public int getExplicitTimeoutInSec() {
		checkToCreateProp();
		log.info("getting explicit wait from property file in sec");
		return Integer.parseInt(prop.getProperty("ExplicitTimeOutInSec"));
	}

	/** This methods returns page load wait from property file **/
	public int getPageLoadTimeoutInSec() {
		checkToCreateProp();
		log.info("getting page load timeout from property file in sec");
		return Integer.parseInt(prop.getProperty("PageLoadTimeoutInSec"));
	}

	/** This methods returns polling wait from property file **/
	public int getPollingTimeoutInMilliSec() {
		checkToCreateProp();
		log.info("getting polling wait from property file in milli sec");
		return Integer.parseInt(prop.getProperty("PollingTimeoutInMilliSec"));
	}

	/** This methods returns site url from property file **/
	public String getSiteURL(String country, String language, String environment) {
		checkToCreateProp();
		log.info("getting base URL from property file");
		String baseURL = null;
		if (environment.toUpperCase().contains("STAGE")) {
			baseURL = prop.getProperty("StageURL");
		} else if (environment.toUpperCase().contains("PROD")) {
			baseURL = prop.getProperty("ProdURL");
		} else if (environment.toUpperCase().contains("UAT")) {
			baseURL = prop.getProperty("UatURL");
		} 
		String siteUrl;
		String appender;
		if (baseURL.contains("stage") || baseURL.contains("6tst")) {
			appender = "-";
		} else {
			appender = ".";
		}
		if (country.equalsIgnoreCase("UAE") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-ae" + appender + baseURL;
		} else if (country.equalsIgnoreCase("UAE") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-ae" + appender + baseURL;
		} else if (country.equalsIgnoreCase("KSA") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-sa" + appender + baseURL;
		} else if (country.equalsIgnoreCase("KSA") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-sa" + appender + baseURL;
		} else if (country.equalsIgnoreCase("KW") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-kw" + appender + baseURL;
		} else if (country.equalsIgnoreCase("KW") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-kw" + appender + baseURL;
		} else if (country.equalsIgnoreCase("OM") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-om" + appender + baseURL;
		} else if (country.equalsIgnoreCase("OM") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-om" + appender + baseURL;
		} else if (country.equalsIgnoreCase("BH") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-bh" + appender + baseURL;
		} else if (country.equalsIgnoreCase("BH") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-bh" + appender + baseURL;
		} else if (country.equalsIgnoreCase("QA") && language.equalsIgnoreCase("EN")) {
			siteUrl = "https://en-qa" + appender + baseURL;
		} else if (country.equalsIgnoreCase("QA") && language.equalsIgnoreCase("AR")) {
			siteUrl = "https://ar-qa" + appender + baseURL;
		} else {
			siteUrl = "https://" + baseURL;
		}
		log.info("the site URL for given country " + country + " and language " + language + " is " + siteUrl);
		return siteUrl;
	}

	/** Returns Excel Data For Key **/
	public String getExcelValue(String key) {
		log.info("getting excel value against key value having sheet and key");
		String country = key.substring(0, key.indexOf("_"));
		String sheet = country;
		String keyValue = key.replace(country, "").replace("_", "");
		DataHandlers data = new DataHandlers();
		return data.getMapData(sheet, keyValue);
	}

	/** This methods sets excel value against key value having key and value **/
	public void setExcelValue(String key, String value) {
		log.info("setting excel value against key value having sheet and key");
		String country = key.substring(0, key.indexOf("_"));
		String sheet = country;
		try {
			DataHandlers data = new DataHandlers();
			data.setCellValue(sheet, key, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** This methods returns excel file name from property file **/
	public String getExcelFileName() {
		checkToCreateProp();
		log.info("getting excel file name from property file");
		return prop.getProperty("ExcelFileName");
	}

	/** This methods returns json file name from property file **/
	public String getJsonFileName() {
		checkToCreateProp();
		log.info("getting Json file name from property file");
		return prop.getProperty("JsonFileName");
	}

	/** returns value for input key from property file **/
	public String getConfigValue(String key) {
		checkToCreateProp();
		String value = prop.getProperty(key);
		log.info("The value for key " + key + " is " + value);
		return value;
	}

	/** creates prop object if null **/
	private void checkToCreateProp() {
		if (prop == null) {
			log.info("Setting Config object if null");
			this.createConfigObject();
		}
	}

	/** setting config file path **/
	private void setConfigPath() {
		log.info("Setting Config Path");
		filepath = "src/main/resources/config/Config.properties";
	}

	/** setting new excel key value **/
	public void setNewExcelValue(String key, String value) {
		log.info("setting excel value against key value having sheet and key");
		String country = key.substring(0, key.indexOf("_"));
		String sheet = country;
		String keyValue = key.substring(key.indexOf("_") + 1);
		DataHandlers data = new DataHandlers();
		data.setNewCellValue(sheet, keyValue, value);
	}
/*
	public String getBaseUrl() {
		log.info("Getting base url");
		return createConfigObject().getProperty("BaseURL");  //commenting since the BaseURL is no more used
	}
*/   
	/** This methods returns site url from property file **/
	public String getMagentoURL(String MagentoURL) {
		checkToCreateProp();
		log.info("getting base URL from property file");
		MagentoURL = prop.getProperty("MagentoURL");
		return MagentoURL;
	}

	/** This methods returns site url from property file **/
	public String getMerchantURL(String MerchantURL) {
		checkToCreateProp();
		log.info("getting base URL from property file");
		MerchantURL = prop.getProperty("MerchantURL");
		return MerchantURL;
	}
	
	/** This methods returns Tabby ID file name from property file **/
	public String getTabbyFileName() {
		checkToCreateProp();
		log.info("getting tabby file name from property file");
		return prop.getProperty("TabbyID");
	}
	
	/** This methods returns Checkout Sandbox url from property file **/
	public String getCheckoutSandboxURL(String CheckoutSandboxURL) {
		checkToCreateProp();
		log.info("getting CheckoutSandboxURL URL from property file");
		CheckoutSandboxURL = prop.getProperty("CheckoutSandboxURL");
		return CheckoutSandboxURL;
	}
	
	/** This methods returns customer support phone number from property file **/
	public String getSupportPhoneNo(String country) {
		String phoneNo;
		checkToCreateProp();
		log.info("getting support phone number from property file");
		switch(country.toUpperCase()) {
		case "BH": phoneNo = prop.getProperty("BHSupportPhoneNo");
					break;
		case "QA": phoneNo = prop.getProperty("QASupportPhoneNo");
					break;
		default : phoneNo = prop.getProperty("UAESupportPhoneNo");
		}
		return phoneNo;
	}
	
	/** This methods returns customer support email id from property file **/
	public String getSupportEmailId() {		
		checkToCreateProp();
		log.info("getting support email id from property file");		
		return prop.getProperty("supportEmail");
	}

	public int getProductCountOnActiveLocale(String country) {
		log.info("getting products count for "+country);
		checkToCreateProp();
		int productCountFromProperty = Integer.parseInt(prop.getProperty(country+"ProductCount"));
		return productCountFromProperty;
	}

}
