package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);

	}

	public void login() throws InterruptedException {

		login.click();

	}

	public void setEmail(String email) {
		emailId.sendKeys(email);

	}

	public void setPassword(String passwordId) {
		password.sendKeys(passwordId);

	}

}
