package com.debyt.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.debyt.pageObjects.LoginPage;

import junit.framework.Assert;




public class TC_Signup extends BaseClass{

	@Test
	public void signup() throws IOException, InterruptedException 
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		Thread.sleep(2000);
		
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
	
}
