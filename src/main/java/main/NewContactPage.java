package main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewContactPage extends BasePage {
	private static final String FIRST_NAME = "0x2";
	private static final String PHONE_NUMBER = "0x11";
	private static final String EMAIL = "0x13";
	private static final String MENU_BUTTON = "menu_save";
	private static final String SAVE = "editor_menu_save_button";
	private static final String LOCAL = "left_button";
	private static final String ADDRESS = "0x15";
	
	public NewContactPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = FIRST_NAME)
	private MobileElement firstName;

	@AndroidFindBy(id = PHONE_NUMBER)
	private MobileElement phoneNumber;
	
	@AndroidFindBy(id = EMAIL)
	private MobileElement email;
	
	@AndroidFindBy(id = MENU_BUTTON)
	private MobileElement menuButton;
	
	@AndroidFindBy(id = SAVE)
	private MobileElement save;
	
	@AndroidFindBy(id = LOCAL)
	private MobileElement local;
	
	@AndroidFindBy(id = ADDRESS)
	private MobileElement address;
	
	public MobileElement getFirstName() {
		return firstName;
	}
	
	public MobileElement getPhoneNumber() {
		return phoneNumber;
	}
	
	public MobileElement getEmail() {
		return email;
	}
	
	public MobileElement getMenuButton() {
		return menuButton;
	}
	
	public MobileElement getSave() {
		return save;
	}
	
	public MobileElement getLocal() {
		return local;
	}
	
	public MobileElement getAddress() {
		return address;
	}
}
