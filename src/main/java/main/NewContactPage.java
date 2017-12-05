package main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewContactPage extends BasePage {
	private static final String FIRST_NAME = "0x3";
	private static final String LAST_NAME = "0x5";
	private static final String PHONE_NUMBER = "0xF";
	private static final String EMAIL = "0x11";
	private static final String MENU_BUTTON = "com.android.contacts://[@text='Open navigation drawer']";
	private static final String SAVE = "editor_menu_save_button";
	
	public NewContactPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	
	@AndroidFindBy(id = FIRST_NAME)
	private MobileElement firstName;
	
	@AndroidFindBy(id = LAST_NAME)
	private MobileElement lastName;

	@AndroidFindBy(id = PHONE_NUMBER)
	private MobileElement phoneNumber;
	
	@AndroidFindBy(id = EMAIL)
	private MobileElement email;
	
	@AndroidFindBy(xpath = MENU_BUTTON)
	private MobileElement menuButton;
	
	@AndroidFindBy(id = SAVE)
	private MobileElement save;
	
	public MobileElement getFirstName() {
		return firstName;
	}
	
	public MobileElement getLastName() {
		return lastName;
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
	
}
