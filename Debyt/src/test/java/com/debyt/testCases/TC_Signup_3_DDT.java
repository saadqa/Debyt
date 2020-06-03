package com.debyt.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debyt.pageObjects.CompanyDetails;
import com.debyt.pageObjects.LoginPage;
import com.debyt.utilities.XLUtils;

public class TC_Signup_3_DDT extends BaseClass{

	@Test(priority = 0, dataProvider = "LoginData")
	public void signupStep3 (String firstname, String lastname, String workemail, String password, String companyname, String companyphone, String companywebsite) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setEmail(workemail);
		lp.setPass(password);
		lp.clickLogin();
		
		
	}
	
	@Test (priority = 1, dataProvider = "LoginData1")
	public void compdetailData (String fein, String annrev, String compact) throws InterruptedException
	{
		CompanyDetails cd = new CompanyDetails(driver);
		
		cd.setFein(fein);
		cd.setBussType();
		cd.setIncorpYear();
		cd.setIncorpState();
		cd.setAnnRev(annrev);
		cd.setCompAct(compact);
		cd.setMerchant();		
		cd.clkCont();
		
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
	String [][] getCompDetData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/debyt/testData/LoginCreds.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet3");
		int colcount=XLUtils.getCellCount(path, "Sheet3", 1);
				
		String logindata[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet3", i, j);
				System.out.print(logindata[i-1][j]=XLUtils.getCellData(path, "Sheet3", i, j));
			}
		}
		return logindata;
	}
	
}
