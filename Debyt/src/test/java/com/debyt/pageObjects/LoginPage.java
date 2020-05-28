package com.debyt.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 
	 
	 //Page Elements for login page
	 
	 @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/a")
	 @CacheLookup
	 WebElement signupBtn;
	 
	 @FindBy(id = "email")
	 @CacheLookup
	 WebElement txt_email;
	 
	 @FindBy(id = "password")
	 @CacheLookup
	 WebElement txt_pass;
	 
	 @FindBy(id = "remember")
	 @CacheLookup
	 WebElement remChkBox;
	 
	 @FindBy(css = "#root > div:nth-child(2) > div.ant-col.right-col.ant-col-xs-24.ant-col-sm-24.ant-col-md-8.ant-col-xl-8 > div > div > form > div.ant-row-flex > div:nth-child(2) > a")
	 @CacheLookup
	 WebElement forgotPass;
	 
	 @FindBy(css = "#root > div:nth-child(2) > div.ant-col.right-col.ant-col-xs-24.ant-col-sm-24.ant-col-md-8.ant-col-xl-8 > div > div > form > div:nth-child(5) > div > div > span > button")
	 @CacheLookup
	 WebElement loginBtn;
	 
	 //Page elements for Create your account
	 
	 @FindBy(id = "firstName")
	 @CacheLookup
	 WebElement txt_firstName;
	 
	 @FindBy(id = "lastName")
	 @CacheLookup
	 WebElement txt_lastName;
	 
	 @FindBy(id = "email")
	 @CacheLookup
	 WebElement txt_workEmail;
	 
	 @FindBy (id  = "password")
	 @CacheLookup
	 WebElement txt_password;
	 
	 @FindBy (id = "companyName")
	 @CacheLookup
	 WebElement txt_companyName;
	 
	 @FindBy (id = "companyPhone")
	 @CacheLookup
	 WebElement txt_companyPhone;
	 
	 @FindBy (id = "companyWebsite")
	 @CacheLookup
	 WebElement txt_companyWebsite;
	 
	 @FindBy (xpath = "//*[@id=\"tosAgreement\"]/div[1]/label/span[1]/span")
	 @CacheLookup
	 WebElement chkbox_agree;
	 
	 //Action Methods for signin page 
	 
	 public void setEmail(String email)
	 {
		 txt_email.sendKeys(email);
	 }
	 
	 public void setPass(String pass)
	 {
		 txt_pass.sendKeys(pass);
	 }
	 
	 public void clickLogin()
	 {
		 loginBtn.click();
	 }
	 
	 public void clickSignupBtn()
	 {
		 signupBtn.click();
	 }
	 
	 public void clickRem()
	 {
		 remChkBox.click();
	 }
	 
	 public void clickForgotPass()
	 {
		 signupBtn.click();
	 }

	//Action methods for create account page
	 
	 public void setFirstName(String firstName)
	 {
		 txt_firstName.sendKeys(firstName);
	 }
	 
	 public void setLastName(String lastName)
	 {
		 txt_lastName.sendKeys(lastName);
	 }
	 
	 
}
