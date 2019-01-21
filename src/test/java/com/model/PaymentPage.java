package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payment ;
	@FindBy(xpath="//button/span[text()='I confirm my order']")
	WebElement order;
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void paymentMethod() {
		payment.click();
		
		
	}
	public void ordereditems() {
		order.click();
	}
	public String orderStatus() {
		WebElement orderMsg = driver.findElement(By.xpath("//div[@class='box']/p/strong"));
		return orderMsg.getText();
		
	}
	

}
