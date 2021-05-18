package com.amazon.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

	public void loginClick() {
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	}

	public void search(String searchText) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
}
