package main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BasePage {
	
	private static final String CONTACT_ID = "Replace me";
	
	@AndroidFindBy(id = CONTACT_ID)
	private MobileElement contact_id;
	
	public MobileElement getContactId() {
		return contact_id;
	}

}
