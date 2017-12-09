package test;


import org.junit.Test;

import main.NewContactPage;

public class AllTests extends BaseTest{
	
	public AllTests() {
		super(driver);
	}

	@Test
	public void CreateNewContactTest() {
		newContactPage = new NewContactPage(driver);
		System.out.println("Hello");
	}

}
