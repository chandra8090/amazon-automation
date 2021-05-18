package com.amazon.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	public void login(String username, String password) {
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();

		System.out.println("Application may ask to enter password and captcha");

	}
}
