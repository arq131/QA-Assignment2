package test;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

public class CreateNewContactTest extends BaseTest {
	private static TouchAction action;

	public CreateNewContactTest() {
		super();
		action = new TouchAction(driver);
	}

	/**
	 * Create a new contact test
	 */
	@Test
	public void CreateNewContact() {

		System.out.println("Starting execution for creating new contact.");
		try {
			navigateToNewContact();

			// Insert First name
			insertNewContacts();
			Thread.sleep(500);

			// navigate to more fields
			driver.performTouchAction(action.tap(225, 1725));
			swipe("down");

			// insert 1 of the new fields
			insertExtraFields();

			// click the save button
			newContactPage.getSave().click();

			// Give it permissions
			for (int i = 0; i < 3; i++)
				basePage.getAllow().click();

			System.out.println("Test for registering a user: Success.");

			// go back to front page
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);

		} catch (Exception e) {
			Assert.fail("Unable to complete the flow of creating a new contact. Exception found: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "CreateNewContact")
	public void CheckSettings() {
		try {
			// Click the more option dropdown
			basePage.getOptions().click();
			Thread.sleep(500);

			// Select Option
			driver.performTouchAction(action.tap(650, 650));
			Thread.sleep(500);

			// Select to view more settings
			driver.performTouchAction(action.tap(180, 675));
			Thread.sleep(500);

			// Check if we're on the right page
			assertTrue(driver.findElement(MobileBy.id("title")).isDisplayed());
			Thread.sleep(500);

			System.out.println("Test to check navigation of settings: Success.");

			// Navigate back to original page.
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);

		} catch (Exception e) {
			Assert.fail("Unable to complete the test for checking the settings. Exception found: " + e.getMessage());
		}
	}

	@Test
	public void EditUser() {
		try {
			// Tap on user that we created
			driver.performTouchAction(action.tap(265, 675));
			Thread.sleep(500);
			
			// Click on edit button
			newContactPage.getEdit().click();
			Thread.sleep(500);
			
			// Insert 1 more field
			newContactPage.getPhoneNumber().click();
			newContactPage.getPhoneNumber().sendKeys("098-765-4321");
			driver.hideKeyboard();
			Thread.sleep(500);
			
			// Save settings
			newContactPage.getSave().click();
			Thread.sleep(500);
			
			Assert.assertTrue(newContactPage.getPicture().isDisplayed());
			System.out.println("Test for editing a field for a user: Success.");
			
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);
			
		} catch (Exception e) {
			Assert.fail("Unable to edit the user. Exception found: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "CheckSettings")
	public void FavoriteUser() {
		try {
			// Tap on user that we created
			driver.performTouchAction(action.tap(265, 675));

			newContactPage.getStar().click();
			Thread.sleep(500);

			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);

			basePage.getFavorites().click();
			Thread.sleep(500);

			Assert.assertTrue(basePage.getFavoriteIcon().isDisplayed());
			Thread.sleep(500);

			System.out.println("Test for checking if we've favorite a user: Success.");

			basePage.getAll().click();
			Thread.sleep(500);

		} catch (Exception e) {
			Assert.fail("Unable to complete the test for favoriting a user. Exception found: " + e.getMessage());
		}
	}

	/**
	 * Delete the user we just created
	 */
	@Test(dependsOnMethods = "FavoriteUser")
	public void DeleteUser() {
		try {
			// Tap on user that we created
			driver.performTouchAction(action.tap(265, 675));

			// Open up more options for the user.
			basePage.getOptions().click();
			Thread.sleep(500);

			// Select delete
			driver.performTouchAction(action.tap(625, 130));
			Thread.sleep(500);

			// Confirm delete
			basePage.getDelete().click();
			Thread.sleep(500);

			assertTrue(basePage.getContactId().isDisplayed());
			System.out.println("Test for deleting user: Success.");
		} catch (Exception e) {
			Assert.fail("Unable to complete the test for creating a user. Exception found: " + e.getMessage());
		}
	}

	/**
	 * Navigate over to creating a new contact and click the local message that
	 * shows up
	 */
	public void navigateToNewContact() {
		basePage.getNewContact().click();
		newContactPage.getLocal().click();
	}

	/**
	 * Insert the new contacts information
	 * 
	 * @throws Exception
	 */
	public void insertNewContacts() throws Exception {
		driver.runAppInBackground(1);

		newContactPage.getFirstName().click();
		newContactPage.getFirstName().sendKeys("TestUser");
		driver.hideKeyboard();

		Thread.sleep(500);

		newContactPage.getPhoneNumber().click();
		newContactPage.getPhoneNumber().sendKeys("123-456-7890");
		driver.hideKeyboard();

		swipe("down");

		newContactPage.getEmail().click();
		newContactPage.getEmail().sendKeys("example@abc.com");
		driver.hideKeyboard();

		swipe("down");
	}

	/**
	 * Insert the extra field's information
	 */
	public void insertExtraFields() {
		newContactPage.getAddress().click();
		newContactPage.getAddress().sendKeys("1234 Some Place");
		driver.hideKeyboard();
	}

}
