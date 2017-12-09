package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import main.BasePage;
import main.NewContactPage;

public class BaseTest extends BasePage {
	
	public BaseTest(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	
	// Global Pages
	NewContactPage newContactPage;
	
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
		
	}
	
	/**
	 * Get the ID of the device currently running (or first device ID if there are
	 * multiple running)
	 * @return device id
	 */
	private String getDeviceId() {
		String deviceId;
		String command = "adb devices";
		try {
			// run command to get the current devices running
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			
			// skip first line.
			br.readLine();
			deviceId = br.readLine();
			if (deviceId != null)
				return deviceId;
			
		} catch (Exception e) {
			Assert.fail("Unable to get the device of the id. Error found:" + e);
		}
		return null;
	}

}
