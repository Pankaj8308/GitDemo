package MavenPracticeProject;


import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponent.BaseTest;
import TestComponent.ReTry;
	
	public class ErrorValidation extends BaseTest {

		@Test(groups={"errorVal"},retryAnalyzer= ReTry.class)
	public void errorv()
	{
			
			// Object creation for Launch and Basic web driver is done in BaseTest class
			LP.loginApp("Pankajkumartiwari8308@gmail.in", "Qwerty@123");
			Assert.assertEquals("Incorrect email or password.", LP.getErr());
			
			
	}

}
