package com.amazon.pages;

import java.util.Set;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

	public void clickBuyNow() {
		// Switch to new window
		String mainHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(mainHandle)) {
				driver.switchTo().window(handle);
			}
		}

		// Click on buy button
		if (driver.findElements(By.cssSelector("#buy-now-button")).size() > 0) {
			driver.findElement(By.cssSelector("#buy-now-button")).click();
		} else {
			System.out.println("Product not available to buy");
		}
	}
}
