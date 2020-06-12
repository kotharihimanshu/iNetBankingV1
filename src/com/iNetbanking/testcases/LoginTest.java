package com.iNetbanking.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.iNetbanking.Pageobjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
 	public void loginTest() throws IOException{
		
		
		logger.info("URL is opened"); // after initiating logger class in baseclass , we can write log msg for any step
		
		LoginPage lp= new LoginPage(driver); // creating object of pageobject class as it is outside this package
		lp.setUserName(userName);
		logger.info("Entered username");
		
		lp.setPassowrd(password);
		logger.info("Entered password");
		
		lp.clickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);	
			logger.info("Login test passed");
		}
		else
		{
			capturescreen(driver, "loginTest"); // calling the screenshots taker method from base class
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
