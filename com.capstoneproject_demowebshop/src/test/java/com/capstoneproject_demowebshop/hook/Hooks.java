package com.capstoneproject_demowebshop.hook;



import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.capstoneproject_demowebshop.helper.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;



public class Hooks extends Base{
	static WebDriver driver = Base.driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeAll()
	public static void beforeAll() {
		
		try {
			sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@AfterAll()
	public static void afterAll() {
		extent.flush();
		
	}

	@Before()
	public void before() {
		test=extent.createTest("Demo webshop");
		getBrowser(); // Launches Browser, Url
	}

	@After()
	public void after() {
			Base.driver.quit();
		
	}
	

}