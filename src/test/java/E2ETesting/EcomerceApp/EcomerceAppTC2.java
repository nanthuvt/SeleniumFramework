package E2ETesting.EcomerceApp;

import org.testng.Assert;
import org.testng.annotations.Test;

import E2ETesting.TestingComponent.TestingComponent;


public class EcomerceAppTC2 extends TestingComponent {
	
	@Test
	public void EcomerceAppNegative(){
	
		login.loginPage("nanthuvt@gmail.com", "Rahulstty1!");
		Assert.assertEquals(login.checkUser(), "Incorrect email or password.");
	
		
	}

}
