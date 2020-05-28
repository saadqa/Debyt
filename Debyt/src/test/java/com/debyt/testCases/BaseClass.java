package com.debyt.testCases;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.debyt.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String email = readconfig.getEmail();
	public String pwd = readconfig.getPassword();
	public static WebDriver driver; 
	
	public static Logger logger;
	

	@BeforeClass
	@Parameters("browser")
	
	public void setup(String br)
	{
				
		logger = Logger.getLogger("Debyt");
		BasicConfigurator.configure();
		PropertyConfigurator.configure("Log4j (1).properties");
		
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		}
		// add else for other browsers
		
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
