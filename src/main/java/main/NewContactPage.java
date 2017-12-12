package main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewContactPage extends BasePage {
	private static final String FIRST_NAME = "//android.widget.EditText[@text='Name']";
	private static final String PHONE_NUMBER = "//android.widget.EditText[@text='Phone']";
	private static final String EMAIL = "//android.widget.EditText[@text='Email']";
	private static final String MORE_FIELDS = "//android.widget.EditText[@text='More Fields']";
	private static final String SAVE = "menu_save";
	private static final String LOCAL = "left_button";
	private static final String ADDRESS = "//android.widget.EditText[@text='Address']";
	private static final String STAR = "menu_star";
	private static final String EDIT = "menu_edit";
	private static final String CONTACT_PICTURE = "photo_touch_intercept_overlay";
	
	public NewContactPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = FIRST_NAME)
	private MobileElement firstName;

	@AndroidFindBy(xpath = PHONE_NUMBER)
	private MobileElement phoneNumber;
	
	@AndroidFindBy(xpath = EMAIL)
	private MobileElement email;
	
	@AndroidFindBy(xpath = MORE_FIELDS)
	private MobileElement moreFields;
	
	@AndroidFindBy(id = SAVE)
	private MobileElement save;
	
	@AndroidFindBy(id = LOCAL)
	private MobileElement local;
	
	@AndroidFindBy(xpath = ADDRESS)
	private MobileElement address;
	
	@AndroidFindBy(id = STAR)
	private MobileElement star;
	
	@AndroidFindBy(id = EDIT)
	private MobileElement edit;
	
	@AndroidFindBy(id = CONTACT_PICTURE)
	private MobileElement picture;
	
	public MobileElement getFirstName() {
		return firstName;
	}
	
	public MobileElement getPhoneNumber() {
		return phoneNumber;
	}
	
	public MobileElement getEmail() {
		return email;
	}
	
	public MobileElement getFields() {
		return moreFields;
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
	
	public MobileElement getStar() {
		return star;
	}
	
	public MobileElement getEdit() {
		return edit;
	}
	
	public MobileElement getPicture() {
		return picture;
	}
}
