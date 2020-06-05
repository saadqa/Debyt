package com.debyt.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debyt.pageObjects.CompanyInformation;
import com.debyt.pageObjects.LoginPage;
import com.debyt.utilities.XLUtils;

import junit.framework.Assert;

public class TC_Signup_2_DDT extends BaseClass{

		@Test(priority =1, dataProvider = "LoginData")
		public void signupStep2(String firstname, String lastname, String workemail, String password, String companyname, String companyphone, String companywebsite) throws InterruptedException, IOException
		{
		
		LoginPage lp = new LoginPage(driver);
		CompanyInformation ci = new CompanyInformation(driver);
		
		lp.setEmail(workemail);
		lp.setPass(password);
		lp.clickLogin();
		
		Thread.sleep(1000);
		
		boolean check1, check2, check3;
		
		check1= ci.chkCompName().equals(companyname);
		check2 = ci.chkCompPhone().equals(companyphone);
		check3 = ci.chkCompWeb().equals(companywebsite);
		
		if(check1 && check2 && check3)
		{
			Assert.assertTrue(true);
			logger.info("Passed");
		}
		
		else
		{			
			captureScreen(driver, "Signup step 2");
			Assert.assertTrue(false);
			logger.info("failed");
			
		}		
	}
	
	@Test(priority =2, dataProvider = "LoginData1")
	public void enterCompInfoData (String companylegalname, String businessaddress, String suitenumber, String city, String state, String zipcode) throws AWTException, InterruptedException, IOException
	{
		CompanyInformation ci = new CompanyInformation(driver);
		
		ci.setCompLeg(companylegalname);
		
		ci.setBussAdd(businessaddress);
		
		ci.setSuite(suitenumber);
		
		Thread.sleep(1000);
		
		if(ci.chkCity(city) ==null)
		{
			if(ci.chkState(state)==null)
			{
				if(ci.chkZip(zipcode)==null)
				{
					captureScreen(driver, "adress info failed");
					Assert.assertTrue(false);
					logger.info("Failed");
				}
			}
		}
		else
		{
			ci.clkContBtn();
			Thread.sleep(2000);
			logger.info("TC 2 Passed");
				
		}
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
			for (int j=1;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.print(logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j));
			}
		}
		return logindata;
	}
	

	@DataProvider(name="LoginData1")
	String [][] getData2() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/debyt/testData/LoginCreds.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet2");
		int colcount=XLUtils.getCellCount(path, "Sheet2", 1);
				
		String logindata[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j);
				System.out.print(logindata[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j));
			}
		}
		return logindata;
	}

}
