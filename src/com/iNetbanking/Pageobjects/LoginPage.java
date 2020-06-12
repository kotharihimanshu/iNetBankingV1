package com.iNetbanking.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Idriver;
	
	public LoginPage(WebDriver rdriver) //constructor
	{
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this); // pagefactory is initialising web elements
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement linklogout;
	
	
	//Here we are creating action methods 
	public void setUserName(String uname){
		txtUserName.sendKeys(uname);
	}
	
	public void setPassowrd(String pwd){
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit(){
		btnLogin.click();
	}
	public void clickLogout(){
		linklogout.click();
	}
	
}
