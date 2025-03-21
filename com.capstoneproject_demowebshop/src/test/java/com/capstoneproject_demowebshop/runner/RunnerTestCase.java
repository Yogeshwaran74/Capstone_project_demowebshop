package com.capstoneproject_demowebshop.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/com.capstoneproject_demowebshop.features/createaccount.feature",
		"src/test/resources/com.capstoneproject_demowebshop.features/homepage.feature",
		"src/test/resources/com.capstoneproject_demowebshop.features/Productdetails.feature",
		"src/test/resources/com.capstoneproject_demowebshop.features/Shoppingcart.feature",
		"src/test/resources/com.capstoneproject_demowebshop.features/Checkout.feature"},
glue= {"com/capstoneproject_demowebshop/stepdefinition","com/capstoneproject_demowebshop/hook"})
public class RunnerTestCase extends AbstractTestNGCucumberTests{

}
