package com.amazon.pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

	public void filterProduct(String colour, String internalMemory) {
		// Selecting filters - internal memory
		driver.findElement(By.xpath("//span[contains(text(),'" + internalMemory
				+ "')]//preceding::i[contains(@class,'a-icon-checkbox')][1]")).click();

		// Include search for colours
		if (driver.findElements(By.xpath("//a[@title='" + colour + "']")).size() == 0) {
			System.out.println(colour + " Products Unavailable");
		}
	}

	public void searchAndClickProduct(String searchText, String internalMemory, String colour) {
		// Searching for product with color and text
		if (driver.findElements(By.xpath("//span[contains(text(),'" + searchText + "') and contains(text(),'"
				+ internalMemory + "') and contains(text(),'" + colour + "') or contains(text(),'"
				+ colour.toUpperCase() + "')]")).size() > 0) {
			driver.findElement(By.xpath("//span[contains(text(),'" + searchText + "') and contains(text(),'"
					+ internalMemory + "') and contains(text(),'" + colour + "') or contains(text(),'"
					+ colour.toUpperCase() + "')]")).click();
		} else {
			System.out.println(searchText + " Product Not available with - " + internalMemory + " size and " + colour
					+ " Colour.");
		}
	}
}
