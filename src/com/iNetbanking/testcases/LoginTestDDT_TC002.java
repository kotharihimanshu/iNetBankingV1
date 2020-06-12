package com.iNetbanking.testcases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.*;

import com.iNetbanking.Pageobjects.LoginPage;
import com.iNetbanking.utilities.XLUtils;

public class LoginTestDDT_TC002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException{ // crearing 2 parameters as it will get username and pwd frmo 2d array data provider
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassowrd(pwd);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isALertPresent()==true) // it means login is failed
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); // this command will focus on main page
			//Assert.assertTrue(false); // -failed case
			logger.warn("Login failed");
		}
		else{
			//Assert.assertTrue(true); // passed case
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isALertPresent(){// this will check if alert is present after login or not
		try{
		driver.switchTo().alert();		
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
		
	} 
	
	@DataProvider(name="LoginData") //giving any name to data provider method
	String[][] getData() throws IOException{ // this methd will get the data from xcel and store it in a 2d array
		//will create a 2d array of same size of excel
		String path= System.getProperty("user.dir")+"/src/com/iNetbanking/Testdata/ExcelDataForAutomation.xlsx"; //path of excel
		
		int rownum=XLUtils.getRowCount(path, "Sheet1"); //calling row count method from xlutils file
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount]; //this will create a same 2d array like excel
		
		for(int i=1;i<=rownum;i++){
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); // 1 0
			}
			
		}
		return logindata;
		
	}
}
