package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllTests extends BaseTest{

	@Test
	void CreateNewContactTest() {
		newContactPage = new NewContactPage();
	}

}
