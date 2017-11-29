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

public class BaseTest extends BasePage {
	DesiredCapabilities capabilities;
	
	@BeforeClass
	public void setup() {
		capabilities = new DesiredCapabilities();
		
		try {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("browserName", "Android");
			capabilities.setCapability("deviceName", getDeviceId());
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("app", "");
			
			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (Exception e) {
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
