package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	WebDriver driver;
	
	@FindBy(id="cgv")
	WebElement checkbox;
	@FindBy(name="processCarrier")
	WebElement checkout;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void iAgreeBox() {
		if(checkbox.isSelected()) {
			
		}else {
			checkbox.click();
		}

	}
	public void proceedToCheckOut() {
		checkout.click();
		
	}

}
