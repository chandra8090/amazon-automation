package com.amazon.script;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.amazon.script.base.BaseTest;

public class AmazonTest extends BaseTest {

	@Test
	public void verifyProductAddTest() {

		// Test data
		String searchText = "iPhone 11";
		String internalMemory = "256";
		String colour = "Red";
		
		
		String username = "";
		String password = "";
		String addName = "Chandra babu";
		String mobileNumber = "1231231231";
		String pincode = "574201";
		String apartment = "abc";
		String area = "sample";
		String landMark = "colony";
		String town = "Puttur";
		String state = "ANDHRA PRADESH";
		
				
		//login
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		
		System.out.println("Application may ask to enter password and captcha");
		
		// Search For the product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
		driver.findElement(By.id("nav-search-submit-button")).click();

		
		// Selecting filters - internal memory
		driver.findElement(
				By.xpath("//span[contains(text(),'" + internalMemory + "')]//preceding::i[contains(@class,'a-icon-checkbox')][1]"))
				.click();

		// Include search for colours
		if (driver.findElements(By.xpath("//a[@title='" + colour + "']")).size() == 0) {
			System.out.println(colour + " Products Unavailable");
		}

		//Searching for product with color and text
		if(driver.findElements(By.xpath("//span[contains(text(),'" + searchText + "') and contains(text(),'"
				+ internalMemory + "') and contains(text(),'" + colour + "') or contains(text(),'"+colour.toUpperCase()+"')]")).size()>0) {
			driver.findElement(By.xpath("//span[contains(text(),'" + searchText + "') and contains(text(),'"
					+ internalMemory + "') and contains(text(),'" + colour + "') or contains(text(),'"+colour.toUpperCase()+"')]")).click();
		}else {
			System.out.println(searchText + " Product Not available with - " + internalMemory + " size and " + colour + " Colour.");
		}
		
		
		//Switch to new window
		String mainHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
			if(!handle.equals(mainHandle)) {
				driver.switchTo().window(handle);
			}
		}

		// Click on buy button
		if(driver.findElements(By.cssSelector("#buy-now-button")).size()>0) {
			driver.findElement(By.cssSelector("#buy-now-button")).click();
		}else {
			System.out.println("Product not available to buy");
		}
		
		// Entering new address
		if(driver.findElements(By.xpath("//a[text()='enter a new delivery address']")).size()>0) {
			System.out.println("Adding new address");
			driver.findElement(By.xpath("//a[text()='enter a new delivery address']")).click();
			
			driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(addName);
			driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(mobileNumber);
			driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(pincode);
			driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(apartment);
			driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys(area);
			driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys(landMark);
			driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(town);
			
			//Select not working as it is not main element
			/*
			 * WebElement stateSelect = driver.findElement(By.id(
			 * "address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")); Select
			 * select = new Select(stateSelect); select.selectByVisibleText(state);
			 */
			
			driver.findElement(By.xpath("//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@data-action='a-dropdown-button']")).click();
			driver.findElement(By.xpath("//a[@data-value='"+state+"']")).click();
			
			// Not clicking on Add address button
			
		}else if(driver.findElements(By.xpath("//li[contains(@class,'displayAddressFullName')]/b[contains(text(),'"+addName+"')]")).size()>0) {
			// Incase, to use existing address
			driver.findElement(By.xpath("//li[contains(@class,'displayAddressFullName')]/b[contains(text(),'"+addName+"')]/following::div[contains(@class,'ship-to-this-address')]//a")).click();
		} 
		
		
	}
}
