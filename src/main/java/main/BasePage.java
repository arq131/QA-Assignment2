package main;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

	private static final String ALLOW = "com.android.packageinstaller:id/permission_allow_button";
	private static final String CONTACT_ID = "Replace me";
	private static final String NEW_CONTACT = "floating_action_button";
	private static final String SETTINGS = "nav_settings"; // Coords: 420 , 63 
	
	public BasePage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = ALLOW)
	private MobileElement allow;
	
	@AndroidFindBy(id = CONTACT_ID)
	private MobileElement contact_id;
	
	@AndroidFindBy(id = NEW_CONTACT)
	private MobileElement new_contact;
	
	@AndroidFindBy(id = SETTINGS)
	private MobileElement settings;
	
	public MobileElement getAllow() {
		return allow;
	}
	
	public MobileElement getContactId() {
		return contact_id;
	}
	
	public MobileElement getNewContact() {
		return new_contact;
	}
	
	public MobileElement getSettings() {
		return settings;
	}
	

}
