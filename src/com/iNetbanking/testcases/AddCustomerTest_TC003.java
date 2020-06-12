package com.iNetbanking.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetbanking.Pageobjects.AddCustomerPage;
import com.iNetbanking.Pageobjects.LoginPage;

public class AddCustomerTest_TC003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassowrd(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Himanshu");
		addcust.custGender("male");
		addcust.custDOB("08", "23", "1993");
		Thread.sleep(3000);
		addcust.custAddress("savitry greens");
		addcust.custCity("mohali");
		addcust.custState("Punjab");
		addcust.custPIN(100119);
		addcust.custPhoneno("987577889");
		
		String email =randomString()+"@gmail.com";
		addcust.custEmailID(email);
		
		addcust.custPassword("abcdefggh");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info("Validation started");
		boolean result= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true){
			Assert.assertTrue(true);
			logger.info("Test case Passed");
		}
		else
		{
			capturescreen(driver, "addnewcustomer");
			Assert.assertTrue(false);
			logger.info("Test case Failed");
		}
		
	}
	
	//generate the random email id as email wont take same values again
	//methods are in base class for genrate random number and string
	
	
}
