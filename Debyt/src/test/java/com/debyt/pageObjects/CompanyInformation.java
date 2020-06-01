package com.debyt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyInformation {
	
	WebDriver ldriver;
	
	 public CompanyInformation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	 
	 //Page Elements for company information page
	 
	 @FindBy(id = "companyWizard_companyName")
	 @CacheLookup
	 WebElement txt_compName;
	 
	 @FindBy (id = "companyWizard_companyPhone")
	 @CacheLookup
	 WebElement txt_compPhone;
	 
	 @FindBy (id = "companyWizard_companyWebsite")
	 @CacheLookup
	 WebElement txt_compWebsite;
	 
	 @FindBy (id = "companyWizard_companyLegalName")
	 @CacheLookup
	 WebElement txt_compLegalName;
	 
	 @FindBy (xpath = "//*[@id=\"companyWizard_businessAddress\"]/div/div/ul/li/div/input")
	 @CacheLookup
	 WebElement txt_busAddress;
	 
	 @FindBy (id = "companyWizard_suitNumber")
	 @CacheLookup
	 WebElement txt_suiteNumber;
	 
	 @FindBy (id = "companyWizard_city")
	 @CacheLookup
	 WebElement txt_city;
	 
	 @FindBy (id = "companyWizard_state")
	 @CacheLookup
	 WebElement txt_state;
	 
	 @FindBy (id = "companyWizard_zipCode")
	 @CacheLookup
	 WebElement txt_zipCode;
	 
	 @FindBy (xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/form/div[6]/div/div/span/button")
	 @CacheLookup
	 WebElement btn_cont;
	 
	 //Action methods for company information page
	 
	 public String chkCompName() throws InterruptedException {
		 
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_companyName")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_companyName")).getAttribute("value");
		 
		
	 }

	 public String chkCompPhone() throws InterruptedException {
		 
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_companyPhone")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_companyPhone")).getAttribute("value");
		 
		
	 }
	 
	 public String chkCompWeb() throws InterruptedException {
		 
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_companyWebsite")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_companyWebsite")).getAttribute("value");
		 
		
	 }
	 
	 public void setCompLeg(String compleg) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_companyLegalName")));
         // waits for the page to load completely
         
         Thread.sleep(3000);
         
          ldriver.findElement(By.id("companyWizard_companyLegalName")).sendKeys(compleg);;
	 }
	 
	 public void setBussAdd(String bussadd) throws InterruptedException
	 {
		 txt_busAddress.sendKeys(bussadd);
		 txt_busAddress.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(1000);
		 txt_busAddress.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
	 }
	 
	 public void setSuite(String suite)
	 {
		 txt_suiteNumber.sendKeys(suite);
	 }
	 
	 public String chkState(String state) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_state")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_state")).getAttribute("value");
	 }
	 
	 public String chkCity(String city) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_city")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_city")).getAttribute("value");
	 }

	 public String chkZip(String zip) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver,30);
		 
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyWizard_zipCode")));
         // waits for the page to load completely
         
         Thread.sleep(2000);
         
         return ldriver.findElement(By.id("companyWizard_zipCode")).getAttribute("value");

	 }

	 public void clkContBtn()
	 {
		 btn_cont.click();
	 }
}
