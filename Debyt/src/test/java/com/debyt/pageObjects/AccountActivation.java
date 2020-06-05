package com.debyt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivation {

	WebDriver ldriver;

	public AccountActivation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Action Methods
	
	public void clkNoLater() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/label[2]/span[2]")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/label[2]/span[2]"))
				.click();
	}
	
	public void clkCont() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/button")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/button"))
				.click();
	}
}
