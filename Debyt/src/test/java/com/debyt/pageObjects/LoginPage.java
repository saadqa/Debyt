package com.debyt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 
	 
	 //Page Elements for login page
	 
	 @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/a")	 
	 WebElement signupBtn;
	 
	 @FindBy(xpath = "//*[@id=\"email\"]")
	 @CacheLookup
	 WebElement txt_email;
	 
	 @FindBy(xpath = "//*[@id=\"password\"]")
	 @CacheLookup
	 WebElement txt_pass;
	 
	 @FindBy(id = "remember")
	 @CacheLookup
	 WebElement remChkBox;
	 
	 @FindBy(css = "#root > div:nth-child(2) > div.ant-col.right-col.ant-col-xs-24.ant-col-sm-24.ant-col-md-8.ant-col-xl-8 > div > div > form > div.ant-row-flex > div:nth-child(2) > a")
	 @CacheLookup
	 WebElement forgotPass;
	 
	 @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[4]/div/div/span/button")
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
	 
	 @FindBy (xpath = "//*[@id=\"tosAgreement\"]/div[1]/label/span[1]")
	 @CacheLookup
	 WebElement chkbox_agree;
	 
	 @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/form/div[12]/div/div/span/button")
	 @CacheLookup
	 WebElement btn_cont;
	 
	 //Elements for verification email page
	 
	 @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/h3")
	 @CacheLookup
	 WebElement verify_txt;
	 
	 @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[3]/a/button")
	 @CacheLookup
	 WebElement btn_backHome;
	 
	 
	 //Action Methods for signin page 
	 
	 public void setEmail(String email) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
         
         // waits for the page to load completely
         
         ldriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);;
	 }
	 
	 public void setPass(String pass)
	 {
		 txt_pass.sendKeys(pass);
	 }
	 
	 public void clickLogin()
	 {
		 loginBtn.click();
	 }
	 
	 public void clickSignupBtn() throws InterruptedException
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
	 
	 public void setWorkEmail(String workEmail)
	 {
		 txt_workEmail.sendKeys(workEmail);
	 }
	 
	 public void setPassword(String password)
	 {
		 txt_password.sendKeys(password);
	 }
	 
	 public void setCompanyName(String companyName)
	 {
		 txt_companyName.sendKeys(companyName);
	 }
	 
	 public void clkCompanyPhone()
	 {
		 txt_companyPhone.clear();
	 }
	 
	 public void setCompanyPhone(String companyPhone)
	 {
		 txt_companyPhone.sendKeys(companyPhone);
	 }
	 
	 public void setCompanyWebsite(String companyWebsite)
	 {
		 txt_companyWebsite.sendKeys(companyWebsite);
	 }
	 
	 public void chkAgreeBox()
	 {
		 chkbox_agree.click();
	 }
	 
	 public void clickContinue()
	 {
		 btn_cont.click();
	 }

	 //Verification email page action methods
	 
	 public WebElement getVerifyText()
	 {
		// explicit wait - 
         /*WebDriverWait wait = new WebDriverWait(ldriver,30);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div/div/div/div/div[2]/h3")));
*/         
		  return verify_txt;
	 }
	
	 public void clkBackHome()
	 {
		 btn_backHome.click();
	 }
}
