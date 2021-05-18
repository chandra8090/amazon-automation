package com.amazon.script;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.pages.AddressPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultsPage;
import com.amazon.script.base.BaseTest;

public class AmazonTest extends BaseTest {

	@Test
	public void verifyProductAddTest() {

		// Test data
		String searchText = applicationProperties.getProperty("searchText");
		String internalMemory = applicationProperties.getProperty("internalMemory");
		String colour = applicationProperties.getProperty("colour");

		// Loing Data
		String username = applicationProperties.getProperty("username");
		String password = applicationProperties.getProperty("password");

		// Address Data
		String addName = applicationProperties.getProperty("addName");
		String mobileNumber = applicationProperties.getProperty("mobileNumber");
		String pincode = applicationProperties.getProperty("pincode");
		String apartment = applicationProperties.getProperty("apartment");
		String area = applicationProperties.getProperty("area");
		String landMark = applicationProperties.getProperty("landMark");
		String town = applicationProperties.getProperty("town");
		String state = applicationProperties.getProperty("state");

		HomePage homePage = new HomePage();
		homePage.loginClick();

		// login
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

		// Search For the product
		homePage.search(searchText);

		
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		//Filter the products with colour, internal memory 
		searchResultsPage.filterProduct(colour, internalMemory);
		//Search for product with name, internal memory and colour
		searchResultsPage.searchAndClickProduct(addName, internalMemory, colour);
		
		//Click the Buy Now button
		ProductPage productPage = new ProductPage();
		productPage.clickBuyNow();

		// Add new Address
		AddressPage addressPage = new AddressPage();
		addressPage.addNewAddress(addName, mobileNumber, pincode, apartment, area, landMark, town, state);

	}
}
