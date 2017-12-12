package main;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

	private static final String ALLOW = "com.android.packageinstaller:id/permission_allow_button";
	private static final String CONTACT_BANNER = "//android.widget.TextView[@text='Contacts']";
	private static final String NEW_CONTACT = "floating_action_button";
	private static final String SETTINGS = "nav_settings"; // Coords: 420 , 63 
	private static final String OPTIONS = "//android.widget.ImageButton[@content-desc='More options']";
	private static final String DELETE = "//android.widget.Button[@text='DELETE']";
	private static final String FAVORITES = "//android.widget.TextView[@text='FAVORITES']";
	private static final String FAVORITE_PICTURE = "contact_tile_image";
	private static final String ALL = "//android.widget.TextView[@text='ALL']";
	
	public BasePage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = ALLOW)
	private MobileElement allow;
	
	@AndroidFindBy(xpath = CONTACT_BANNER)
	private MobileElement contact_banner;
	
	@AndroidFindBy(id = NEW_CONTACT)
	private MobileElement new_contact;
	
	@AndroidFindBy(id = SETTINGS)
	private MobileElement settings;
	
	@AndroidFindBy(xpath = OPTIONS)
	private MobileElement options;
	
	@AndroidFindBy(xpath = DELETE)
	private MobileElement delete;
	
	@AndroidFindBy(xpath = FAVORITES)
	private MobileElement favorites;
	
	@AndroidFindBy(id = FAVORITE_PICTURE)
	private MobileElement favorite_picture;
	
	@AndroidFindBy(xpath = ALL)
	private MobileElement all;
	
	public MobileElement getAllow() {
		return allow;
	}
	
	public MobileElement getContactId() {
		return contact_banner;
	}
	
	public MobileElement getNewContact() {
		return new_contact;
	}
	
	public MobileElement getSettings() {
		return settings;
	}
	
	public MobileElement getOptions() {
		return options;
	}
	
	public MobileElement getDelete() {
		return delete;
	}
	
	public MobileElement getFavorites() {
		return favorites;
	}
	
	public MobileElement getFavoriteIcon() {
		return favorite_picture;
	}
	
	public MobileElement getAll() {
		return all;
	}
}
