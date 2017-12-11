package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import main.NewContactPage;

public class AllTests extends BaseTest {

	public AllTests() {
		super();
	}

	@Test
	public void CreateNewContactTest() {
		TouchAction action = new TouchAction(driver);

		System.out.println("Starting execution for creating new contact.");
		try {
			// Navigate to add a new contact
			navigateToNewContact();
			//Assert.assertTrue(newContactPage.getFirstName().isDisplayed());
			System.out.println("Navigated to creating a new contact.");

			// Insert First name
			insertNewContacts();

			// navigate to more fields
			action.tap(5, 1675).perform();
			swipe("down");

			// insert 1 of the new fields
			insertExtraFields();
			
			// click the save button
			newContactPage.getSave().click();
			
			for (int i = 0; i < 3; i++) 
				basePage.getAllow().click();
			
			System.out.println("Reached end of tests. Success!");
			
			// verify that we're at the main page
		} catch (Exception e) {
			Assert.fail("Unable to complete the flow of creating a new contact. Exception found: " + e.getMessage());
		}
	}

	public void navigateToNewContact() {
		basePage.getNewContact().click();
		newContactPage.getLocal().click();
	}

	public void insertNewContacts() {
		newContactPage.getFirstName().click();
		newContactPage.getFirstName().sendKeys("User_1\n");
		newContactPage.getPhoneNumber().sendKeys("123-456-7890\n");
		newContactPage.getEmail().sendKeys("example@abc.com\n");
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

	public void insertExtraFields() {
		newContactPage.getAddress().sendKeys("1234 Some Place");
	}

}
