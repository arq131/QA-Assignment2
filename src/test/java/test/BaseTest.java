package test;

import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

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
	
	/**
	 * Set capabilities for the appium driver, then create a driver.
	 */
	@BeforeClass
	public static void setup() {
		capabilities = new DesiredCapabilities();
		System.out.println("Creating capabilities");
		try {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_25");
			capabilities.setCapability("app", "com.android.contacts");
			capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
			capabilities.setCapability("avd", "Nexus_5X_API_25");
			capabilities.setCapability("clearSystemFiles", "true");
			System.out.println("Capabilities set. Attempting to create driver...");
			
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (Exception e) {
			System.out.println("Unable to create driver. Exception found: " + e.getMessage());
			Assert.fail("Unable to set capabilities for appium server. Error found: " + e);
		}
		
		basePage = new BasePage(driver);
		newContactPage = new NewContactPage(driver);
		
	}
	
	/**
	 * Quit the driver after all test cases have ran.
	 */
	@AfterClass
	public static void quit() {
		driver.quit();
	}
	
	/**
	 * Wait for a specific element on the page.
	 * @param element element to wait for
	 * @param seconds seconds to wait
	 * @return
	 */
	public boolean waitForElement(MobileElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Assert.fail("Unable to locate element. Exception found: " + e.getMessage());
		}
		return true;
	}
	
	public void swipe(String direction) {
		Dimension size = driver.manage().window().getSize();
		
		int starty= (int) (size.height * .8);
		int endy = (int) (size.height * .2);
		int startx = size.width / 2;
		
		// swipe upwards
		if (direction.toLowerCase().equals("down")) 
			driver.swipe(startx, starty, startx, endy, 3000);
		else if (direction.toLowerCase().equals("up"))
			driver.swipe(startx, endy, startx, starty, 3000);
	}

}
