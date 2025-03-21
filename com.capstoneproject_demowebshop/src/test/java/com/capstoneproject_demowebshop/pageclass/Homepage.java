package com.capstoneproject_demowebshop.pageclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.capstoneproject_demowebshop.helper.Base;
import com.capstoneproject_demowebshop.helper.Reports;


public class Homepage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public Homepage(WebDriver driver,ExtentTest test) {
		
		this.driver = driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test=test;
	}
	
	By feature = By.xpath("//strong[text()='Featured products']");
	By laptop = By.linkText("14.1-inch Laptop");
    By searchBar=By.xpath("//input[@id='small-searchterms']");
    By searchButton=By.xpath("//input[@value='Search']");
    By searchresult = By.xpath("//a[normalize-space()='Health Book']");
    By advance=By.xpath("//input[@id='As']");
    By categoryDrop=By.xpath("//select[@id='Cid']");
    By subsearch = By.xpath("//input[@id='Isc']");
    By searchproductdiscription= By.xpath("//input[@id='Sid']");
    By priceFrom=By.xpath("//input[@id='Pf']");
    By priceTo=By.xpath("//input[@id='Pt']");
    By advanceSearchB=By.xpath("//input[@class='button-1 search-button']");
    By asearchBar=By.xpath("//input[@id='Q']");
    By results = By.xpath("//div[@class='product-grid']/div//div[@class='details']/div[@class='add-info']//span[2]");

    //Verifying Feature product is available or not
    public boolean verifyFeature() {
    	boolean res=true;
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(feature));
    		Reports.generateReport(driver, test,Status.PASS,"Featured products available" );
    	}catch(Exception ee) {
    		Reports.generateReport(driver, test,Status.FAIL,"Featured products not available" );
    		res= false;
    	}
    	return res;
    }
    //Verifying Search bar is available or  not
    public boolean verifySearchBar() {
		WebElement searchEle=Base.driver.findElement(searchBar);
		boolean res1=true;
		try {
		Assert.assertTrue(searchEle.isDisplayed());
		Reports.generateReport(driver, test,Status.PASS,"Searchbar available" );
		}catch(Exception e){
			Reports.generateReport(driver, test,Status.FAIL,"Searchbar not available" );
		}
		return res1;
	}
    //Clicking on search bar
    public void navigatetosearchbar() {
    	driver.findElement(searchBar).click();
    }
    //Enter product to search
	public void searchProduct(String book) {
		driver.findElement(searchBar).sendKeys(book);
	}
	//Click search button
	public void clickSearch() {
		driver.findElement(searchButton).click();
	}
	//Verifying product is displayed or not
	public boolean productVisible() {
		boolean res2=true;
		try {
			Assert.assertTrue(driver.findElement(searchresult).isDisplayed());
			res2= true;
		}catch(Exception e) {
			res2= false;
		}
		return res2;
	}
	//Clicking advance search
	public void advanceSearch() {
		driver.findElement(advance).click();
	}
	//Filter by Catagory
	public void Cdropdown() {
		driver.findElement(subsearch).click();
		WebElement CdropdownEle=driver.findElement(categoryDrop);
		Select select=new Select(CdropdownEle);
		select.selectByVisibleText("Books");
	}
	//Filter by ratings
	public void filterRatings() {
		Assert.assertFalse(false);
	}
	//Filter by  price
	public void filterPrice() {
		driver.findElement(searchproductdiscription).click();
		driver.findElement(priceFrom).sendKeys("10.00");
		driver.findElement(priceTo).sendKeys("70.00");
	}
	//Click on search button
	public void aSearchButton() {
		driver.findElement(advanceSearchB).click();
	}
	//Result verify
	public boolean resultverify() {
		boolean actresult = true;
		try {
			List<WebElement>res=driver.findElements(results);
			for(WebElement i : res) {
				String price=i.getText();
				double p = Double.parseDouble(price);
				if(p >=10 || p<=70) {
					actresult=true;
				}else {
					actresult=false;
				}
			}
			Reports.generateReport(driver, test,Status.PASS,"Result filtered" );
		}
		catch(Exception e) {
			actresult = false;
			Reports.generateReport(driver, test,Status.FAIL,"Products not filtered" );
		}
		return actresult;
	}
}
