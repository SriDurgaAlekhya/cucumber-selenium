package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

	WebDriver driver;
	@FindBy(xpath="//p[contains(@class,'cart_navigation')]/a")
	WebElement proceedcheckout;
	

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void proceedToCheckout() {
		proceedcheckout.click();

	}
}
