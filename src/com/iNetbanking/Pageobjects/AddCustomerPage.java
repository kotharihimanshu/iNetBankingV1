package com.iNetbanking.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver Idriver;
	
	public AddCustomerPage(WebDriver rdriver){
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how =How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement linkAddNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement txtaddress;
	
	@FindBy(how=How.NAME, using="city")
	WebElement txtCity;
	
	@FindBy(how= How.NAME, using="state")
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtPIN;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtMobileNumber;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password")
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer(){
		linkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender){
		rdGender.click();
	}
	
	public void custDOB(String mm,String dd, String yy){
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress){
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity){
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate){
		txtState.sendKeys(cstate);
	}
	
	public void custPIN(int cpin)
	{
		txtPIN.sendKeys(String.valueOf(cpin)); // converting int to string
	}
	
	public void custPhoneno(String cphone){
		txtMobileNumber.sendKeys(cphone);
	}
	
	public void custEmailID(String cemail){
		txtEmail.sendKeys(cemail);
	}
	
	public void custPassword(String cpassword){
		txtPassword.sendKeys(cpassword);
	}
	
	public void custsubmit(){
		btnSubmit.click();
	}
	
	

}
