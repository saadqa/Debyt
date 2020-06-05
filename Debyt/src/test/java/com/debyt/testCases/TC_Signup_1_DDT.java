package com.debyt.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debyt.database.ConnectSQLServer;
import com.debyt.pageObjects.LoginPage;
import com.debyt.utilities.XLUtils;

import junit.framework.Assert;

public class TC_Signup_1_DDT extends BaseClass{
	
	@Test(priority = 0,dataProvider = "LoginData")
	public void loginDDT(String firstname, String lastname, String workemail, String password, String companyname, String companyphone, String companywebsite) throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException
	{
		LoginPage lp = new LoginPage(driver);
		
		ConnectSQLServer con = new ConnectSQLServer();
		
		//Start the signup process - step1
		
		lp.clickSignupBtn();
		logger.info("Signup Button Clicked");

		lp.setFirstName(firstname);
		logger.info("First name entered");
		
		lp.setLastName(lastname);
		logger.info("Last name entered");
		
		lp.setEmail(workemail);
		logger.info("email entered");
				
		lp.setPassword(password);
		logger.info("Password entered");
		
		lp.setCompanyName(companyname);
		logger.info("Company name entered");
		
		lp.clkCompanyPhone();
		logger.info("Company phone clicked");
		
		lp.setCompanyPhone(companyphone);
		logger.info("Company phone entered");
		
		lp.setCompanyWebsite(companywebsite);
		logger.info("Company website entered");
		
		lp.chkAgreeBox();
		logger.info("Checkbox clicked");
		
		lp.clickContinue();
		logger.info("Continue Clicked");
		
		Thread.sleep(1500);
		
	
		//now verify the email address by accessing token from database
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.get("https://qafront01.azurewebsites.net/verifyemail/"+con.testDB(workemail));
		
		Robot robot = new Robot();
		// press key Ctrl+r
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_R);
		// release key Ctrl+r
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_R);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		driver.switchTo().window(tabs.get(0)); // switch back to main screen        
	   
		//Move back to signin screen and enter creds 
		
		lp.clkBackHome();
		logger.info("Signin page opened");
		
		lp.setEmail(workemail);
		logger.info("email entered");
			
		lp.setPass(password);
		logger.info("password entered");
			
		lp.clickLogin();
		logger.info("Signin button clicked");
	
		
	}

	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/debyt/testData/LoginCreds.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
				
		String logindata[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.print(logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j));
			}
		}
		return logindata;
	}


}
