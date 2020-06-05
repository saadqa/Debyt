package com.debyt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseYourPlan {
	
	WebDriver ldriver;

	public ChooseYourPlan(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Action Methods
	
	public void clkCont() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[5]/div[2]/div/form/div[1]/div/div/span/button")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div[5]/div[2]/div/form/div[1]/div/div/span/button"))
				.click();
	}

}
