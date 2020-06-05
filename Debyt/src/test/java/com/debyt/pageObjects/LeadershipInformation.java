package com.debyt.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadershipInformation {

	WebDriver ldriver;

	public LeadershipInformation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Page Elements for leadershipinfo

	// Actions Methods

	public void clkRadFirst() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/label[1]/span[2]")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/label[1]/span[2]"))
				.click();

	}

	public void clkRadSecond() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/label[1]/span[2]")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/label[1]/span[2]"))
				.click();

	}
	
	public void clkRadThird() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[3]/div/div/label[2]/span[2]")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[3]/div/div/label[2]/span[2]"))
				.click();

	}
	
	public void clkCont() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[4]/form/div/div/div/span/button")));
		// waits for the page to load completely

		Thread.sleep(2000);

		ldriver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[4]/form/div/div/div/span/button"))
				.click();

	}
}
