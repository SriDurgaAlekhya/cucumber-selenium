package com.practice;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.model.AddressPage;
import com.model.HeaderSection;
import com.model.LoginPage;
import com.model.PaymentPage;
import com.model.ShippingPage;
import com.model.ShoppingPage;
import com.model.SummaryPage;
import com.utils.AppUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	String password = "********";
	
	WebDriver driver;
	PaymentPage pay;

	@Given("^Given launch firefox browser and open \"([^\"]*)\"$")
	public void given_launch_firefox_browser_and_open(String websiteUrl) {
		driver = AppUtils.createFireFoxDriver();

		driver.manage().window().maximize();
		driver.navigate().to(websiteUrl);

	}

	@Given("^Signin with my existing credentials \"([^\"]*)\"$")
	public void signin_with_my_existing_credentials_and(String userName) {
		HeaderSection header = new HeaderSection(driver);
		header.clickSignIn();

		LoginPage login = new LoginPage(driver);
		PageFactory.initElements(driver, login);

		login.setEmail(userName);
		login.setPassword(password);
		login.login();
	}

	@Then("^Go to womens section and select a t-shirt\\. Also proceed to checkout$")
	public void go_to_womens_section_and_select_a_t_shirt_Also_proceed_to_checkout() {
		ShoppingPage shop = new ShoppingPage(driver);
		shop.women();
		shop.tops();
		shop.tshirts();

		WebElement moveToimage = driver.findElement(By.xpath("//div[@class='product-image-container']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(moveToimage).build().perform();

		driver.findElement(By.linkText("Add to cart")).click();

		shop.proceedToCheckout();
	}

	@Then("^Proceed to checkout in summary page$")
	public void proceed_to_checkout_in_summary_page() {
		SummaryPage summery = new SummaryPage(driver);
		summery.proceedToCheckout();
	}

	@Then("^Proceed to checkout in Address page by selecting delivery address$")
	public void proceed_to_checkout_in_Address_page_by_selecting_delivery_address() {
		AddressPage address = new AddressPage(driver);
		address.address();
		address.proceedToCheckout();
	}

	@Then("^Agree the terms and proceed to checkout in Shipping page$")
	public void agree_the_terms_and_proceed_to_checkout_in_Shipping_page() {
		ShippingPage shippingAndDelivery = new ShippingPage(driver);
		shippingAndDelivery.iAgreeBox();
		shippingAndDelivery.proceedToCheckOut();
	}

	@Then("^Select one of the avaliable payment options$")
	public void confirm_one_of_the_avaliable_payment_options() {
		pay = new PaymentPage(driver);
		pay.paymentMethod();
	}

	@Then("^Confirm the order$")
	public void confirm_the_order() {
		pay.ordereditems();
	}

	@Then("^The order should be placed$")
	public void the_order_should_be_placed() {
		String actual = pay.orderStatus();
		String expected = "Your order on My Store is complete.";
		assertEquals(expected, actual);
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}