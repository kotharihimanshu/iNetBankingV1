package com.iNetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

//this file is to read variables from config.properties
// for every variable in config.properties file , we have to create a method of each one

	Properties pro; // create object for properties class
	
	//creating constructor
	//Constructor is the first method that is invoke when you create an object. The main reason for having the constructor is to initialize the variables. Let us say you have a class called Employee and you want to make sure that every employee has an name and email. What you will do is have a constructor that will take two parameters as following
	public ReadConfig(){
		File src= new File("./Configuration/config.properties");
		
		try{
			
			FileInputStream fs= new FileInputStream(src); // filinputstream is to read the data 
			pro= new Properties(); // initiating pro object
			pro.load(fs); // it will load the complete config file
		}
		catch(Exception e){
			System.out.println("Exception is " +e.getMessage());
			}
		
	}
	
	public String getApplicationURL(){
		String url = pro.getProperty("baseURL"); // this will capture the value from config file
		return url;
	}
	
	public String getUserName(){
		String username= pro.getProperty("userName");
		return username;
	}
	
	public String getPassword(){
		String password= pro.getProperty("password");
		return password;
		
	}
	
	public String getChromePath(){
		String chromepath= pro.getProperty("Chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath(){
		String firefoxpath=pro.getProperty("FirefoxPath");
		return firefoxpath;
	}
	
}
