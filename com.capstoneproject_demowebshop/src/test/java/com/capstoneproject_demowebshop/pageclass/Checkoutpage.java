package com.capstoneproject_demowebshop.pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.capstoneproject_demowebshop.helper.Reports;

public class Checkoutpage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public Checkoutpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	By searchBar = By.xpath("//input[@id='small-searchterms']");
	By searchButton = By.xpath("//input[@value='Search']");
	By lapaddcart = By.xpath("//input[@value='Add to cart']");
	By healthaddcart = By.xpath("//input[@value='Add to cart']");
	By shopcartLink = By.xpath("//span[normalize-space()='Shopping cart']");
	By termsCheckBox = By.xpath("//input[@id='termsofservice']");
	By checkOutButton = By.xpath("//button[@id='checkout']");
	By emailBox = By.xpath("//input[@id='Email']");
	By passBox = By.xpath("//input[@id='Password']");
	By loginButton = By.xpath("//input[@value='Log in']");
	By billContinue = By.xpath("//input[@onclick='Billing.save()']");
	By shipContinue = By.xpath("//input[@onclick='Shipping.save()']");
	By shipMethodcontinue = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	By payContinue = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	By payinfoContinue = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	By confirm = By.xpath("//input[@value='Confirm']");
	By orderSuccessmsg = By.xpath("//div/strong[text()='Your order has been successfully processed!']");

	// Search product
	public void searchfinProduct(String product) {
		driver.findElement(searchBar).sendKeys(product);
		driver.findElement(searchButton).click();
	}

	// Add to cart
	public void addfinProductCart() {
		driver.findElement(healthaddcart).click();
	}

	// Click shopping cart
	public void shoppinglink() {
		driver.findElement(shopcartLink).click();
	}

	// Checkout
	public void checkbox() {
		driver.findElement(termsCheckBox).click();
		driver.findElement(checkOutButton).click();
	}

	// Login
	public void loginproceed() {
		driver.findElement(emailBox).sendKeys("sit20co010@sairamtap.edu.in");
		driver.findElement(passBox).sendKeys("123456");
		driver.findElement(loginButton).click();
	}

	// Billing address
	public void billcontinue() {
		driver.findElement(billContinue).click();
	}

	// Shipping address
	public void shippingContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(shipContinue));
		driver.findElement(shipContinue).click();
	}

	// Shipping method
	public void shipMethodcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(shipMethodcontinue));
		driver.findElement(shipMethodcontinue).click();
	}

	// Payment continue
	public void payContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(payContinue));
		driver.findElement(payContinue).click();
	}

	// Payment info
	public void payinfoContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(payinfoContinue));
		driver.findElement(payinfoContinue).click();
	}

	// Confirm button
	public void clickconfirm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
		driver.findElement(confirm).click();
	}

	// Verify Success
	public boolean successorderdisplay() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessmsg));
			Assert.assertEquals(driver.findElement(orderSuccessmsg).getText(),
					"Your order has been successfully processed!");
			Reports.generateReport(driver, test, Status.PASS, "order successfully processed");
			return true;
		} catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "order successfully processed");
			return false;
		}

	}
}
