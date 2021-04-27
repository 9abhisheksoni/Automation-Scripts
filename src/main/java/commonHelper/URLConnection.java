package commonHelper;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

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

			BufferedReader br = new BufferedReader(new InputStreamReader((huc.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

		} catch (Exception e) {

		}

		return responseMessage;
	}

	public boolean validateResponseCode(String url) {
		int responseCode = getConnectionResponseCode(url);

		boolean result = false;
		if (responseCode >= 200 && responseCode <= 299) {
			result = true;
		}
		System.out.println("The link broken state is: " + result);
		return result;

	}

	public static void main(String... test) {

		URLConnection uc = new URLConnection();
		uc.getResponseMessage("https://en-ae.6thstreet.com/women-adidas-clothing.html");
	}
}

