package test;

import org.testng.annotations.Test;

import main.NewContactPage;

public class AllTests extends BaseTest{
	
	public AllTests() {
		super();
	}

	@Test
	public void CreateNewContactTest() {
		newContactPage = new NewContactPage(driver);
		System.out.println("Hello");
	}

}
