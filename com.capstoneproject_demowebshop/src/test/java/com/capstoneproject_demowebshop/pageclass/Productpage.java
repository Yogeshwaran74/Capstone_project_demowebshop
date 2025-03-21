package com.capstoneproject_demowebshop.pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.capstoneproject_demowebshop.helper.Base;
import com.capstoneproject_demowebshop.helper.Reports;

public class Productpage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public Productpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}
	
	By searchbar = By.xpath("//input[@id='small-searchterms']");
	By searchbtn = By.xpath("//input[@value='Search']");
	By healthBook = By.linkText("Health Book");
	By productTitle = By.xpath("//h1[@itemprop='name']");
	By productDescription = By.xpath("//div[@class='short-description']");
	By productPrice = By.xpath("//label[normalize-space()='Price:']");
	By productImage = By.xpath("//img[@id='main-product-img-22']");
	By productInStock = By.xpath("//span[normalize-space()='In stock']");
	By addwishlist = By.xpath("//input[@id='add-to-wishlist-button-22']");
	By addToCart = By.id("add-to-cart-button-22");
	By shoppingcart = By.xpath("//a[@class='ico-cart']/span[1]");
	By wishlist = By.xpath("//a[@class='ico-wishlist']/span[1]");
	
	//Search product
	public void searchbar(String product) {
		driver.findElement(searchbar).sendKeys(product);
		driver.findElement(searchbtn).click();
	}
	//Scrolldown to see product
	public void searchHBook() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("found health book");
	}
	
	//Click book
	public void ClickHbook() {
		driver.findElement(healthBook).click();
	}
	//Verify title
	public boolean verifyPtitle() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
			 Reports.generateReport(driver, test, Status.PASS, "feature product is visible");
		} catch (TimeoutException ee) {
			actResult = false;
			 Reports.generateReport(driver, test, Status.FAIL, "featured product is not visible");
		}
		return actResult;
	}
	//Verify description
	public boolean verifyPdescription() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
			Reports.generateReport(driver, test, Status.PASS, "verified description");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "description is not verified");
		}
		return actResult;
	}
	//Verify price
	public boolean verifyPprice() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
			Reports.generateReport(driver, test, Status.PASS, "price verified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "price is not verified");
		}
		return actResult;
	}
	//Verify image
	public boolean verifyPimage() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));
			Reports.generateReport(driver, test, Status.PASS, "image isverified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "image is not verified");
		}
		return actResult;
	}
	//Verify availability
	public boolean verifyPavailability() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(productInStock));
			Reports.generateReport(driver, test, Status.PASS, "availability verified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "availability is not verified");
		}
		return actResult;
	}
	//Add to wishlist
	public void clickAddWish() {
		driver.findElement(addwishlist).click();
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
	}
	//Add to cart
	public void clickAddCart() {
		driver.findElement(addToCart).click();
	}
	//Verify add to cart
	public boolean addtocartverify() {
		boolean actresult = true;
		try {
			driver.findElement(shoppingcart).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(healthBook));
			Reports.generateReport(driver, test, Status.PASS, "Added to cart");
		}catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Add to cart failed");
			actresult= false;
		}
		return actresult;
	}
	//Verify add to wishlist
	public boolean addtowishlistverify() {
		boolean actresult = true;
		try {
			driver.findElement(wishlist).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(healthBook));
			Reports.generateReport(driver, test, Status.PASS, "Added to wishlist");
		}catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Add to wishlist failed");
			actresult= false;
		}
		return actresult;
	}
}
