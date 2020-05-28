package com.debyt.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.debyt.pageObjects.LoginPage;

import junit.framework.Assert;




public class TC_Signup extends BaseClass{

	//Data to be used for the form fields
	
	String[] firstName = {"Nicholas","January","Grayce","Graham","Salena","Arden","Vanda","Marnie","Linda","Cicely",
			"Victorina","Emma","Cleta","Leonila","Eun","Darnell","Laurine","Dolores","Della","Dessie","Natt"};
	
	String[] lastName = {"Stigall","Maese","Retana","Cleaver","Biery","Vallo","Moffett","Havard","Spurgeon",
			"Ardito","Burts","Knouse","Irwin","Womer","Googe","Oller","Magar","Weedman","Yarborough","Coy"};
	
	//Object created for LoginPage elements and methods
	
	
	
	
	//Actions for signup flow
	
	@Test(priority = 0) 
	public void signup() throws IOException, InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("URL is opened");
		
		
		lp.clickSignupBtn();
		logger.info("Signup button clicked");
		
		if (driver.getTitle().equals("Debyt - Sign Up"))
		{
			Assert.assertTrue(true);
			logger.info("Signup Form Opened");
		}
		
		else
		{
			captureScreen(driver, "signup");
			Assert.assertTrue(false);
			logger.info("Page not loaded");
		}
	}
	
	@Test(priority = 1)
	public void createAccount() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		
		Thread.sleep(1000);
		
		lp.setFirstName(firstName[0]);
		logger.info("First Name Entered");		
	}
	
}
