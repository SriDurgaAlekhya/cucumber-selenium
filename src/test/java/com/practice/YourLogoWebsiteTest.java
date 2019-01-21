package com.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.model.AddressPage;
import com.model.HeaderSection;
import com.model.LoginPage;
import com.model.PaymentPage;
import com.model.ShippingPage;
import com.model.ShoppingPage;
import com.model.SummaryPage;
import com.utils.AppUtils;

public class YourLogoWebsiteTest {

	String baseUrl = "http://automationpractice.com/index.php";
	String userName = "sridurga.alekhya@gmail.com";
	String password = "*******";
	
	@Test
	public void SignIn() throws InterruptedException {
		WebDriver driver = AppUtils.createFireFoxDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		
		HeaderSection header = new HeaderSection(driver);
		header.clickSignIn();

		LoginPage login = new LoginPage(driver);
		PageFactory.initElements(driver, login);

		login.setEmail(userName);
		login.setPassword(password);
		login.login();
		
		ShoppingPage shop = new ShoppingPage(driver);
		shop.women();
		shop.tops();
		shop.tshirts();

		WebElement moveToimage = driver.findElement(By.xpath("//div[@class='product-image-container']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(moveToimage).build().perform();
		
		driver.findElement(By.linkText("Add to cart")).click();

		shop.proceedToCheckout();

		SummaryPage summery = new SummaryPage(driver);
		summery.proceedToCheckout();

		AddressPage address = new AddressPage(driver);
		address.address();
		address.proceedToCheckout();

		ShippingPage shippingAndDelivery = new ShippingPage(driver);
		shippingAndDelivery.iAgreeBox();
		shippingAndDelivery.proceedToCheckOut();

		PaymentPage pay = new PaymentPage(driver);
		pay.paymentMethod();
		pay.ordereditems();

		String actual = pay.orderStatus();
		String expected = "Your order on My Store is complete.";
		assertEquals(expected, actual);

		Thread.sleep(2000);
		driver.quit();

	}

}
