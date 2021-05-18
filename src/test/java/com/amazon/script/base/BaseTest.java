package com.amazon.script.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.utils.PropertyManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public PropertyManager applicationProperties = null;
	public String applicationUrl = null;
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser(ITestContext context) {
		applicationProperties = new PropertyManager();
		applicationUrl = applicationProperties.getProperty("application_url");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
