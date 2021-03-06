package com.debyt.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debyt.pageObjects.AccountActivation;
import com.debyt.pageObjects.ChooseYourPlan;
import com.debyt.pageObjects.LoginPage;
import com.debyt.utilities.XLUtils;

public class TC_Signup_6_DDT extends BaseClass{
	

	@Test(priority = 7, dataProvider = "LoginData")
	public void signupStep4(String firstname, String lastname, String workemail, String password, String companyname,
			String companyphone, String companywebsite) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(workemail);
		lp.setPass(password);
		lp.clickLogin();
		
		Thread.sleep(1000);

		AccountActivation aa = new AccountActivation(driver);

		aa.clkNoLater();
		aa.clkCont();
		Thread.sleep(2000);

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/debyt/testData/LoginCreds.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.print(logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j));
			}
		}
		return logindata;
	}

}
