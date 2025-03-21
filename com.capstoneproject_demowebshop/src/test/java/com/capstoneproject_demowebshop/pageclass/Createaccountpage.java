package com.capstoneproject_demowebshop.pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.capstoneproject_demowebshop.helper.Base;
import com.capstoneproject_demowebshop.helper.Reports;

public class Createaccountpage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public Createaccountpage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test=test;
	}
	By register = By.linkText("Register");
	By gender = By.id("gender-male");
	By firstname = By.id("FirstName");
	By lastname = By.id("LastName");
	By email = By.id("Email");
	By password = By.id("Password");
	By confirmpassword = By.id("ConfirmPassword");
	By registerbtn = By.id("register-button");
	By successmsg = By.xpath("//div[@class='result']");
	By continuebtn = By.xpath("//input[@value='Continue']");
	By invalidmsg = By.xpath("//li[normalize-space()='The specified email already exists']");
	By logoutlink = By.linkText("Log out");
	By loginlink = By.linkText("Log in");
	By Loginbtn = By.xpath("//input[@value='Log in']");
	By logininvalid = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
	By forgotpass = By.linkText("Forgot password?");
	By recoverbtn = By.xpath("//input[@name='send-email']");
	By emailsentmsg = By.xpath("//div[@class='result']");
	By emailnotexistmsg = By.xpath("//div[@class='result']");
	
	// Clicking on register
	public void registerlink() {
		driver.findElement(register).click();
	}
	//Selecting gender
	public void genderselect() {
		driver.findElement(gender).click();
	}
	//Firstname
	public void enterfirstname(String fn) {
		driver.findElement(firstname).sendKeys(fn);
	}
	//Lastname
	public void enterlastname(String ln) {
		driver.findElement(lastname).sendKeys(ln);
	}
	//Email
	public void enteremail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	//password
	public void enterpass(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	//Confirm password
	public void enterconfirmpass(String cnfrmpass) {
		driver.findElement(confirmpassword).sendKeys(cnfrmpass);
	}
	//Register Button
	public void registerbutton() {
		driver.findElement(registerbtn).click();
	}
	//Register successful message
	public boolean successmsgdisplay() {
		boolean res = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(successmsg));
			Reports.generateReport(driver, test, Status.PASS, "Registeration success");
		}catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Registeration failed");
			res = false;
		}
		return res;
	}
	//Continue button
	public void clickcontinue() {
		driver.findElement(continuebtn).click();
	}
	//Logout Button
	public void logoutbtn() {
		driver.findElement(logoutlink).click();
	}
	//Invalid message 
	public boolean invalidmsgdisplay() {
		boolean res1 = true;
		try {
			Assert.assertEquals(driver.findElement(invalidmsg).getText(), "The specified email already exists");
			Reports.generateReport(driver, test,Status.PASS,"Specified mail exists" );
		}
		catch(Exception e) {
			Reports.generateReport(driver, test,Status.FAIL,"Testcase failed" );
			res1 =  false;
		}
		return res1;
	}
	//Login
	public void clicklogin() {
		driver.findElement(loginlink).click();
	}
	//Login button
	public void loginbutton() {
		driver.findElement(Loginbtn).click();
	}
	//Login success message
	public boolean loginsuccess() {
		boolean res2 = true;
		try {
			driver.findElement(logoutlink).isDisplayed();
			Reports.generateReport(driver, test,Status.PASS,"Login success" );
		}
		catch(Exception e) {
			Reports.generateReport(driver, test,Status.FAIL,"Login failed" );
			res2= false;
		}
		return res2;
	}
	//Login invalid message
	public boolean invalidlogin() {
		boolean res3 = true;
		try {
			Assert.assertEquals(driver.findElement(logininvalid).getText(), "Login was unsuccessful. Please correct the errors and try again.");
			Reports.generateReport(driver, test,Status.PASS,"Login unsuccess" );
		}
		catch(Exception e) {
			Reports.generateReport(driver, test,Status.FAIL,"Testcase failed" );
			res3= false;
		}
		return res3;
	}
	//Forgot password 
	public void forgotpassword() {
		driver.findElement(forgotpass).click();
	}
	//Recovery Button
	public void recoverybtn() {
		driver.findElement(recoverbtn).click();
	}
	//Email sent successful
	public boolean emailsent() {
		boolean res4 = true;
		try {
			Assert.assertEquals(driver.findElement(emailsentmsg).getText(), "Email with instructions has been sent to you.");
			Reports.generateReport(driver, test,Status.PASS,"Email sent" );
			}
		catch(Exception e) {
			Reports.generateReport(driver, test,Status.FAIL,"Testcase failed" );
			res4 = false;
		}
		return res4;
	}
	//Email not exist message
	public boolean emailnotexist() {
		boolean res5 = true;
		try {
			Assert.assertEquals(driver.findElement(emailnotexistmsg).getText(), "Email not found.");
			Reports.generateReport(driver, test,Status.PASS,"Email not found" );
		}
		catch(Exception e) {
			Reports.generateReport(driver, test,Status.FAIL,"Testcase failed" );
			res5 = false;
		}
		return res5;
	}
}
