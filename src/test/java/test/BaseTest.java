package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import main.BasePage;
import main.NewContactPage;

public class BaseTest {
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	
	// Global Pages
	protected static NewContactPage newContactPage;
	protected static BasePage basePage;
	
	public BaseTest() {
		super();
	}
	
	@BeforeClass
	public static void setup() {
		capabilities = new DesiredCapabilities();
		System.out.println("Creating capabilities");
		try {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("browserName", "Android");
			capabilities.setCapability("deviceName", "Nexus_5X_API_25");
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("app", "com.android.contacts");
			capabilities.setCapability("avd", "Nexus_5X_API_25");
			System.out.println("Capabilities set. Attempting to create driver...");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (Exception e) {
			System.out.println("Unable to create driver. Exception found: " + e.getMessage());
			Assert.fail("Unable to set capabilities for appium server. Error found: " + e);
		}
		newContactPage = new NewContactPage(driver);
		
	}

}
