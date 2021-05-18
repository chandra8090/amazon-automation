package com.amazon.pages;

import org.openqa.selenium.WebDriver;

import com.amazon.script.base.BaseTest;

public class BasePage {

	public static WebDriver driver = null;
	
	public BasePage() {
		driver = BaseTest.getDriver();
	}
}
