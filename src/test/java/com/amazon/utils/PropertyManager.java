package com.amazon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class PropertyManager {

	Properties props = null;



	public PropertyManager() {
		File file = new File("./src/test/resources/application.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			Assert.fail("application properties file not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = "";
		if (key == "" || key == null || key.equals("")) {
			Assert.fail(key + " is not availble ");
		} else {
			value = props.getProperty(key);
		}
		return value;
	}

	
}
