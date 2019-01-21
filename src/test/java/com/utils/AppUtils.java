package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AppUtils {
	public static WebDriver createFireFoxDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(options);
		
		
		
		
		//WebDriver driver = new FirefoxDriver();

		return driver;
	}

}
