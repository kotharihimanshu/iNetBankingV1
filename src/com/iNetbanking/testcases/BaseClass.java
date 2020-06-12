package com.iNetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.iNetbanking.utilities.ReadConfig;

public class BaseClass {

	//common things for every test case
	
	//public String baseURL= "http://demo.guru99.com/V4/";
	//public String userName= "mngr63447";
	//public String password="ymugUmy";
	public static WebDriver driver;
	
	// calling methods from readconfig
	
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String userName=readconfig.getUserName();
	public String password= readconfig.getPassword();	
	
	public static Logger logger; //defining logger variable as global , as we need it globally for logs
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){ // br is the variable for browser
		//Logger logger =Logger.getLogger("ebanking"); // initiated the logger class object to get the logs
		logger=Logger.getLogger("ebanking"); // initiated the logger class object to get the logs
		PropertyConfigurator.configure("Log4j.properties");
				
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//System.getProperty("user.dir") - this means project directory
		driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver= new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	public void capturescreen(WebDriver driver, String tname) throws IOException{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("screenshot taken");
		}
	
    public String randomString(){
    	String generatedstring= RandomStringUtils.randomAlphabetic(10); // this will create a string which have 10 characters randomly
    	return generatedstring;
    }
    
    // generate random number
    public String randomnum(){
    	String generatednumber=RandomStringUtils.randomNumeric(5);
    	return generatednumber;
    
    }
}
