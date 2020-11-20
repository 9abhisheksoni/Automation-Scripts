package base;

import fileReader.JsonReader;

public class TestClass {

	public static void main(String[] args) {
		JsonReader json=new JsonReader();
		System.out.println("club username "+json.getUserName("clubuser"));
		System.out.println("club password "+json.getPassword("clubuser"));
	}

}
