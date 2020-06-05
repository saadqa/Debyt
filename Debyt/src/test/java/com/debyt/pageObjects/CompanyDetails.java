package com.debyt.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyDetails {
	
	WebDriver ldriver;
	
	 public CompanyDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	 //Page elements for Company details
	 
	 @FindBy (id = "comapnyDetailWizard_annualRevenue")
	 WebElement txt_fein;
	 
	 @FindBy (xpath = "//*[@id=\"comapnyDetailWizard_legalStructure\"]/div") 
	 @CacheLookup
	 WebElement drp_busstype;
	 
	 @FindBy (linkText = "BACK")
	 WebElement btn_back;
	 
	 //Action methods
	 
	 
	 public void setFein(String fein) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 30);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("comapnyDetailWizard_fein"))
			);
			Thread.sleep(2500);
			element.sendKeys(fein);
			
	}
	 
	 public void setBussType() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div/div/span/div/div[2]/div/div[2]"))
			);
			element.click();
			Thread.sleep(2000);
			Actions keyDown = new Actions(ldriver);
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
			
	 }
	 
	 public void setIncorpYear() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comapnyDetailWizard_dateOfIncorporation\"]/div"))
			);
			element.click();
			Thread.sleep(2000);
			Actions keyDown = new Actions(ldriver);
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
			
	 }
	 	
	 public void setIncorpState() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comapnyDetailWizard_stateOfIncorporation\"]/div"))
			);
			element.click();
			Thread.sleep(2000);
			Actions keyDown = new Actions(ldriver);
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
			element.click();
	 }
	 
	 public void setAnnRev(String annrev) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("comapnyDetailWizard_annualRevenue"))
			);
			element.sendKeys(annrev);
	 } 
	 

	 public void setCompAct(String compact) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("comapnyDetailWizard_companyActivities"))
			);
			element.sendKeys(compact);
	 }
	
	 public void setMerchant() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10);
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comapnyDetailWizard_mcc\"]/div/div"))
			);
			element.click();
			Thread.sleep(2000);
			Actions keyDown = new Actions(ldriver);
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
	 } 
	
	 public void clkCont() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(ldriver, 10); 
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/form/div[6]/div/div/span/button"))
			);
			Thread.sleep(2000);
			element.click();
	 }	 
	 
}
