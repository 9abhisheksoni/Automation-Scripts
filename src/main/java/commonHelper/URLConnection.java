package commonHelper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.log4j.Logger;

import pageObjects.CartPage;

public class URLConnection {

	HttpURLConnection huc = null;
	private Logger log = Logger.getLogger(URLConnection.class.getName());

	private void getConnection(String url) {
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			System.out.println(huc.getContent().toString());
		} catch (Exception e) {
			System.out.println("Error occured during connection request");
		}
	}

	private int getConnectionResponseCode(String url) {
		getConnection(url);
		int respCode = 200;
		try {
			respCode = huc.getResponseCode();
			System.out.println(huc.getContent());
			System.out.println("Resonse Code " + respCode);
		} catch (Exception e) {
			System.out.println("Error occured during connection request");
		}
		
		return respCode;
	}
	
	public String getResponseMessage(String url) {
		getConnectionResponseCode(url);
		String responseMessage = "";
		try {
			responseMessage = huc.getResponseMessage();
			System.out.println("Response Message "+responseMessage);
		} catch (Exception e) {
			
		}
		
		return responseMessage;
	}
	
	public boolean validateResponseCode(String url) {
		int responseCode = getConnectionResponseCode(url);
		
		boolean result = false;
		if(responseCode >= 200 && responseCode <= 299) {
			result = true;
		}
		System.out.println("The link broken state is: "+result);
		return result;
		
	}
	
	
	public static void main(String[] args) {
		
		URLConnection uc = new URLConnection();
		uc.getResponseMessage("https://en-bh.6thstreet.com/catalogsearch/gfhkjhkkjgfhdhgjlkj/?q=%2B#&idx=enterprise_magento_english_products&p=0&dFR%5Bbrand_name%5D%5B0%5D=Rituals&nR%5Bvisibility_search%5D%5B%3D%5D%5B0%5D=1");
	}
}
