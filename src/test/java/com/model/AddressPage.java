package com.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	WebDriver driver;

	@FindBy(id = "addressesAreEquals")
	WebElement fullAddress;

	@FindBy(name = "processAddress")
	WebElement checkout;

	public AddressPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void address() {

		if (fullAddress.isSelected()) {
		} else {
			fullAddress.click();

		}
	}

	public void proceedToCheckout() {
		checkout.submit();

	}

}
