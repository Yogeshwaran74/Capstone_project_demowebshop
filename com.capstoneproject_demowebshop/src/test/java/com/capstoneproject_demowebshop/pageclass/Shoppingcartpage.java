package com.capstoneproject_demowebshop.pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.capstoneproject_demowebshop.helper.Reports;

public class Shoppingcartpage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public Shoppingcartpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	By searchbar = By.xpath("//input[@id='small-searchterms']");
	By searchbtn = By.xpath("//input[@value='Search']");
	By smartphone = By.linkText("Smartphone");
	By phoneaddtocart = By.xpath("//input[@id='add-to-cart-button-43']");
	By shoppingcart = By.xpath("//a[@class='ico-cart']/span[1]");
	By remove = By.xpath("//input[@name='removefromcart']");
	By removemsg = By.xpath("//div[@class='order-summary-content']");
	By quantity = By.xpath("//form/table[@class='cart']/tbody/tr/td[@class='qty nobr']/input[@class='qty-input']");
	By updatecart = By.xpath("//input[@name='updatecart']");
	By updatequantityverify = By.xpath("//form/table[@class='cart']/tbody/tr/td[@class='subtotal nobr end']/span[2]");
	By checkout = By.xpath("//button[@id='checkout']");

	// Search product1
	public void search1(String product1) {
		driver.findElement(searchbar).sendKeys(product1);
		driver.findElement(searchbtn).click();
	}

	// Search product2
	public void search2(String product2) {
		driver.findElement(searchbar).sendKeys(product2);
		driver.findElement(searchbtn).click();
	}

	// Click on phone
	public void phone() {
		driver.findElement(smartphone).click();
	}

	// Click on add to cart for phone
	public void phoneaddtocart() {
		driver.findElement(phoneaddtocart).click();
	}

	// Click on shopping cart
	public void shoppincart() {
		driver.findElement(shoppingcart).click();
	}

	// Remove product from shopping cart
	public void remove() {
		driver.findElement(remove).click();
	}

	// Update quantity
	public void quantity() {
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("3");
	}

	// update shopping cart
	public void updatecart() {
		driver.findElement(updatecart).click();
	}

	// Remove success msg
	public boolean removemsg() {
		boolean actresult = true;
		try {
			WebElement ele = driver.findElement(removemsg);
			Assert.assertEquals(ele.getText(), "Your Shopping Cart is empty!");
			Reports.generateReport(driver, test, Status.PASS, "removed successfully");
		} catch (Exception e) {
			actresult = false;
			Reports.generateReport(driver, test, Status.FAIL, "remove failed");
		}
		return actresult;
	}

	// Update quantity verify
	public boolean updatequantitysuccess() {
		boolean actresult = true;
		try {
			Assert.assertEquals("300.00", driver.findElement(updatequantityverify).getText());
			Reports.generateReport(driver, test, Status.PASS, "Quantites updated");
		} catch (Exception e) {
			actresult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Quantites not updated");
		}
		return actresult;
	}
	// Verifying checkout button
	public boolean verifycheckout() {
		boolean actresult=true;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkout));
			Reports.generateReport(driver, test, Status.PASS, "Checkout verified");
		}catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Checkout failed");
			actresult= false;
		}
		return actresult;
	}
}
