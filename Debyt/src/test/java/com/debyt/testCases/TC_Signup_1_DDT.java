package com.debyt.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debyt.pageObjects.LoginPage;
import com.debyt.utilities.XLUtils;

public class TC_Signup_1_DDT extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String firstname, String lastname, String workemail, String password, String companyname, String companyphone, String companywebsite) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.clickSignupBtn();
		logger.info("Signup Button Clicked");

		lp.setFirstName(firstname);
		logger.info("First name entered");
		
		lp.setLastName(lastname);
		logger.info("Last name entered");
		
		lp.setPassword(password);
		logger.info("Password entered");
		
		lp.setCompanyName(companyname);
		logger.info("Company name entered");
		
		lp.setCompanyPhone(companyphone);
		logger.info("Company phone entered");
		
		lp.setCompanyWebsite(companywebsite);
		logger.info("Company website entered");
		
		lp.chkAgreeBox();
		logger.info("Checkbox clicked");
		
		lp.clickContinue();
		logger.info("Continue Clicked");
		
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
