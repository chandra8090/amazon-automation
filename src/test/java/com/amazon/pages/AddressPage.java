package com.amazon.pages;

import org.openqa.selenium.By;

public class AddressPage extends BasePage {

	public void addNewAddress(String addName, String mobileNumber, String pincode, String apartment, String area, String landMark, String town, String state) {

		// Entering new address
		if (driver.findElements(By.xpath("//a[text()='enter a new delivery address']")).size() > 0) {
			System.out.println("Adding new address");
			driver.findElement(By.xpath("//a[text()='enter a new delivery address']")).click();

			driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(addName);
			driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(mobileNumber);
			driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(pincode);
			driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(apartment);
			driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys(area);
			driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys(landMark);
			driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(town);

			// Select not working as it is not main element
			/*
			 * WebElement stateSelect = driver.findElement(By.id(
			 * "address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")); Select
			 * select = new Select(stateSelect); select.selectByVisibleText(state);
			 */

			driver.findElement(By.xpath(
					"//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@data-action='a-dropdown-button']"))
					.click();
			driver.findElement(By.xpath("//a[@data-value='" + state + "']")).click();

			// Not clicking on Add address button

		} else if (driver
				.findElements(By
						.xpath("//li[contains(@class,'displayAddressFullName')]/b[contains(text(),'" + addName + "')]"))
				.size() > 0) {
			// Incase, to use existing address
			driver.findElement(By.xpath("//li[contains(@class,'displayAddressFullName')]/b[contains(text(),'" + addName
					+ "')]/following::div[contains(@class,'ship-to-this-address')]//a")).click();
		}

	}

}
