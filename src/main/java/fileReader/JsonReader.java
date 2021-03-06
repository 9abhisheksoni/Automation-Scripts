package fileReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import base.Config;
import commonHelper.ResourceHelper;

public class JsonReader {

	private Logger log = Logger.getLogger(JsonReader.class.getName());

	/** this method reads json array from file **/
	private JSONArray readJson() {
		log.info("Reading JSON Array");
		JSONParser jsonParser = new JSONParser();
		Object obj = null;
		ResourceHelper resourceHelper = new ResourceHelper();
		Config config = new Config();
		try {
			FileReader reader = new FileReader(resourceHelper.getFilepath(config.getJsonFileName()));
			obj = jsonParser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray dataList = (JSONArray) obj;

		return dataList;
	}

	/** this method returns credit card details **/
	private List<String> getCreditCardDetails(String cardType) {
		log.info("Getting card details for type " + cardType);
		JSONObject payments = (JSONObject) readJson().get(0);
		JSONObject paymentdata = ((JSONObject) payments.get("creditcard"));
		JSONObject card = null;
		if (cardType.equalsIgnoreCase("visa")) {
			card = (JSONObject) paymentdata.get("visa");
		} else if (cardType.equalsIgnoreCase("master")) {
			card = (JSONObject) paymentdata.get("master");
		} else if (cardType.equalsIgnoreCase("amex")) {
			card = (JSONObject) paymentdata.get("amex");
		} else {
			try {
				throw new Exception("Invalid Card Type Requested");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String cardnumber = (String) card.get("cardnumber");
		String cvv = (String) card.get("cvv");

		List<String> userdetail = new ArrayList<String>();
		userdetail.add(cardnumber);
		userdetail.add(cvv);
		return userdetail;
	}

	/** this method returns credit card nuber **/
	public String getCardnumber(String cardType) {
		log.info("Getting card number for type " + cardType);
		return getCreditCardDetails(cardType).get(0);
	}

	/** this method returns credit card cvv **/
	public String getCVV(String cardType) {
		log.info("Getting card CVV for type " + cardType);
		return getCreditCardDetails(cardType).get(1);
	}

	/** this method returns address details **/
	private List<String> getAddressDetails(String country) {
		log.info("Getting address details for country " + country);
		JSONObject countries = (JSONObject) readJson().get(0);
		JSONObject addressdata = ((JSONObject) countries.get("addresses"));
		JSONObject value = null;
		if (country.equalsIgnoreCase("uae")) {
			value = (JSONObject) addressdata.get("uae");
		} else if (country.equalsIgnoreCase("ksa")) {
			value = (JSONObject) addressdata.get("ksa");
		} else if (country.equalsIgnoreCase("kw")) {
			value = (JSONObject) addressdata.get("kw");
		} else if (country.equalsIgnoreCase("om")) {
			value = (JSONObject) addressdata.get("om");
		} else if (country.equalsIgnoreCase("qa")) {
			value = (JSONObject) addressdata.get("qa");
		} else if (country.equalsIgnoreCase("bh")) {
			value = (JSONObject) addressdata.get("bh");
		} else {
			try {
				throw new Exception("Invalid Address Type Requested");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String firstname = (String) value.get("firstname");
		String lastname = (String) value.get("lastname");
		String street = (String) value.get("street");
		String area = (String) value.get("area");
		String city = (String) value.get("city");
		String careercode = (String) value.get("careercode");
		String contactnumber = (String) value.get("contactnumber");

		List<String> userdetail = new ArrayList<String>();
		userdetail.add(firstname);
		userdetail.add(lastname);
		userdetail.add(street);
		userdetail.add(city);
		userdetail.add(area);
		userdetail.add(careercode);
		userdetail.add(contactnumber);
		return userdetail;
	}

	/** this method returns first name **/
	public String getFirstName(String country) {
		log.info("Getting address first name for country " + country);
		return getAddressDetails(country).get(0);
	}

	/** this method returns last name **/
	public String getLastName(String country) {
		log.info("Getting address last name for country " + country);
		return getAddressDetails(country).get(1);
	}

	/** this method returns street name **/
	public String getStreet(String country) {
		log.info("Getting address street for country " + country);
		return getAddressDetails(country).get(2);
	}

	/** this method returns city **/
	public String getCity(String country) {
		log.info("Getting address street for country " + country);
		return getAddressDetails(country).get(3);
	}

	/** this method returns area **/
	public String getArea(String country) {
		log.info("Getting address area for country " + country);
		return getAddressDetails(country).get(4);
	}

	/** this method returns career code **/
	public String getCareerCode(String country) {
		log.info("Getting address career code for country " + country);
		return getAddressDetails(country).get(5);
	}

	/** this method returns phone number **/
	public String getContactnumber(String country) {
		log.info("Getting address contact number for country " + country);
		return getAddressDetails(country).get(6);
	}

	public JSONObject getTabbyDetails() {
		log.info("Getting tabby details");
		JSONObject payments = (JSONObject) readJson().get(0);
		JSONObject paymentdata = ((JSONObject) payments.get("tabbyPayment"));
		return paymentdata;
	}

	/** this method returns tabby payment email **/
	public String getTabbyEmail() {
		log.info("Getting email for tabby payment");
		return (String) this.getTabbyDetails().get("email");
	}

	/** this method returns tabby payment phone **/
	public String getTabbyphone() {
		log.info("Getting email for tabby payment");
		return (String) this.getTabbyDetails().get("phone");
	}

	/** this method returns tabby payment otp **/
	public String getTabbyOTP() {
		log.info("Getting otp for tabby payment");
		return (String) this.getTabbyDetails().get("otp");
	}

	/** this method returns tabby payment username **/
	public String getTabbyFullName() {
		log.info("Getting fullname for tabby payment");
		return (String) this.getTabbyDetails().get("fullname");
	}

	/** this method returns tabby payment ksaid **/
	public String getTabbyID() {
		log.info("Getting id for tabby payment");
		return (String) this.getTabbyDetails().get("id");
	}

	/** this method returns tabby payment nationality **/
	public String getTabbyNationality() {
		log.info("Getting nationality for tabby payment");
		return (String) this.getTabbyDetails().get("nationality");
	}

	/** this method returns tabby payment DOB **/
	public String getTabbyDOB() {
		log.info("Getting date of birth for tabby payment");
		return (String) this.getTabbyDetails().get("dob");
	}

	/** this method returns user credential details **/
	private JSONObject getUserCredentials(String country) {
		log.info("Getting user details object for country " + country);
		JSONObject countries = (JSONObject) readJson().get(0);
		JSONObject userData = ((JSONObject) countries.get("usercredentials"));
		JSONObject value = null;
		if (country.equalsIgnoreCase("uae")) {
			value = (JSONObject) userData.get("uae");
		} else if (country.equalsIgnoreCase("ksa")) {
			value = (JSONObject) userData.get("ksa");
		} else if (country.equalsIgnoreCase("kw")) {
			value = (JSONObject) userData.get("kw");
		} else if (country.equalsIgnoreCase("om")) {
			value = (JSONObject) userData.get("om");
		} else if (country.equalsIgnoreCase("qa")) {
			value = (JSONObject) userData.get("qa");
		} else if (country.equalsIgnoreCase("bh")) {
			value = (JSONObject) userData.get("bh");
		} else {
			try {
				throw new Exception("Invalid User Type Requested");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return value;
	}

	/** this method returns user type object **/
	private JSONObject getUserTypeData(String country, String userType) {
		
		log.info(userType +"" +country);
		log.info("returning user type object");
		JSONObject userdata = this.getUserCredentials(country);
		
		
		return (JSONObject) userdata.get(userType);

	}

	/** this method returns user name **/
	public String getUsername(String country, String userType) {
		log.info("returning username for country " + country + " and user type " + userType);
		return (String) this.getUserTypeData(country, userType).get("username");
	}

	/** this method returns password **/
	public String getPassword(String country, String userType) {
		log.info("returning password for country " + country + " and user type " + userType);
		return (String) this.getUserTypeData(country, userType).get("password");
	}
	
	public JSONObject getCreditCardExpiryDetails() {
		log.info("Getting card expiry details");
		JSONObject creditCardExpiry = (JSONObject) readJson().get(0);
		JSONObject creditCardExpiryData = ((JSONObject) creditCardExpiry.get("creditcardexpiry"));
		return creditCardExpiryData;
	}
	
	/** this method returns credit card expiry Month **/
	public String getCCExpiryMonth() {
		log.info("Getting Credit Card expiry Month");
		return (String) this.getCreditCardExpiryDetails().get("expirymonth");
	}
	
	/** this method returns credit card expiry Year **/
	public String getCCExpiryYear() {
		log.info("Getting Credit Card expiry Year");
		return (String) this.getCreditCardExpiryDetails().get("expiryyear");
	}
	
	@SuppressWarnings("unchecked")
	public void writeCCExpirytoJson(String key, String value) {
		ResourceHelper resourceHelper = new ResourceHelper();
		Config config = new Config();
		try {
		FileReader reader = new FileReader(resourceHelper.getFilepath(config.getJsonFileName()));
		JSONArray jsonData = (JSONArray) JSONValue.parse(reader);
		JSONObject jsonFirstNode = (JSONObject) jsonData.get(0);
		JSONObject creditCardExpiryData = ((JSONObject) jsonFirstNode.get("creditcardexpiry"));
		creditCardExpiryData.put(key, value);
//		String finalJson = users.toJSONString();
		reader.close();
		Writer writer = new FileWriter(resourceHelper.getFilepath(config.getJsonFileName()));
		jsonData.writeJSONString(writer);
		writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}