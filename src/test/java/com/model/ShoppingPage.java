package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage {

	WebDriver driver;
	@FindBy(linkText = "Women")
	WebElement women;

	WebElement tops;
	WebElement tshirts;

	WebElement checkout;

	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void women() {
		women.click();
	}

	public void tops() {
		tops = driver.findElement(By.linkText("Tops"));

		tops.click();
	}

	public void tshirts() {
		tshirts = driver.findElement(By.linkText("T-shirts"));
		tshirts.click();

	}

	public void proceedToCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'layer_cart_cart')]/div[@class='button-container']/a")));

		checkout.click();

	}

}
