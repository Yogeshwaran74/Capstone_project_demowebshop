package com.capstoneproject_demowebshop.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.capstoneproject_demowebshop.helper.Base;
import com.capstoneproject_demowebshop.hook.Hooks;
import com.capstoneproject_demowebshop.pageclass.Checkoutpage;
import com.capstoneproject_demowebshop.pageclass.Createaccountpage;
import com.capstoneproject_demowebshop.pageclass.Homepage;
import com.capstoneproject_demowebshop.pageclass.Productpage;
import com.capstoneproject_demowebshop.pageclass.Shoppingcartpage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	Createaccountpage cp = new Createaccountpage(Base.driver, test);
	Homepage hp = new Homepage(Base.driver, test);
	Productpage pp = new Productpage(Base.driver, test);
	Shoppingcartpage sp = new Shoppingcartpage(Base.driver, test);
	Checkoutpage cop = new Checkoutpage(Base.driver,test);

	@Given("Home page of website")
	public void home_page_of_website() {
		System.out.println("Visited homepage");
	}

	@When("click on regiter")
	public void click_on_regiter() {
		cp.registerlink();
		System.out.println("Clicked on register");
	}

	@When("Choose gender")
	public void choose_gender() {
		cp.genderselect();
		System.out.println("Gender choosen");
	}

	@When("Enter {string} in first name field")
	public void enter_in_first_name_field(String fn) {
		cp.enterfirstname(fn);
		System.out.println("Firstname entered");
	}

	@When("Enter {string} in second name field")
	public void enter_in_second_name_field(String ln) {
		cp.enterlastname(ln);
		System.out.println("Lastname entered");
	}

	@When("Enter {string} in email field")
	public void enter_in_email_field(String em) {
		cp.enteremail(em);
		System.out.println("Email entered");
	}

	@When("Enter {string} in password field")
	public void enter_in_password_field(String pass) {
		cp.enterpass(pass);
		System.out.println("Password entered");
	}

	@When("Enter {string} in confirm password field")
	public void enter_in_confirm_password_field(String cnfrmpass) {
		cp.enterconfirmpass(cnfrmpass);
		System.out.println("Confirmpassword entered");
	}

	@When("click on register button")
	public void click_on_register_button() {
		cp.registerbutton();
		System.out.println("Clicked register button");
	}

	@Then("Registered successfuly")
	public void registered_successfuly() {
		Assert.assertTrue(cp.successmsgdisplay());
		cp.clickcontinue();
		System.out.println("Registeration successful");
	}

	@Then("Invalid email")
	public void invalid_email() {
		Assert.assertTrue(cp.invalidmsgdisplay());
		System.out.println("Invalid email");
	}

	@When("Click on login")
	public void click_on_login() {
		cp.clicklogin();
		System.out.println("Clicked login");
	}

	@When("Click on login button")
	public void click_on_login_button() {
		cp.loginbutton();
		System.out.println("Clicked login button");
	}

	@Then("Logged in successfully")
	public void logged_in_successfully() {
		Assert.assertTrue(cp.loginsuccess());
		System.out.println("Login successful");
	}

	@Then("invalid login credentials")
	public void invalid_login_credentials() {
		Assert.assertTrue(cp.invalidlogin());
		System.out.println("invalid login credentials");
	}

	@When("Click on Forgot password")
	public void click_on_forgot_password() {
		cp.forgotpassword();
		System.out.println("Clicked on forgot password");
	}

	@When("Click on recover button")
	public void click_on_recover_button() {
		cp.recoverybtn();
		System.out.println("Clicked on recover button");
	}

	@Then("Email sent message displayed")
	public void email_sent_message_displayed() {
		Assert.assertTrue(cp.emailsent());
		System.out.println("Email sent successfully");
	}

	@Then("Email does not exist  message displayed")
	public void email_does_not_exist_message_displayed() {
		Assert.assertTrue(cp.emailnotexist());
		System.out.println("Email does not exist");
	}

	@When("I verify the Featured Products")
	public void i_verify_the_featured_products() {
		boolean res = hp.verifyFeature();
		Assert.assertTrue(res);
		System.out.println("Feature Products verified");
	}

	@When("I verify the search bar")
	public void i_verify_the_search_bar() {
		hp.verifySearchBar();
		System.out.println("Search bar verified");
	}

	@When("I navigated to search bar")
	public void i_navigated_to_search_bar() {
		hp.navigatetosearchbar();
		System.out.println("Navigated to search bar");
	}

	@And("I search for {string}")
	public void i_search_for(String book) {
		hp.searchProduct(book);
		System.out.println("Entered product");
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		hp.clickSearch();
		System.out.println("Clicked search button");
	}

	@Then("I see the search results")
	public void i_see_the_search_results() {
		hp.productVisible();
		System.out.println("Verified search results");
	}

	@When("I click on advanced search")
	public void i_click_on_advanced_search() {
		hp.advanceSearch();
		System.out.println("Clicked on advanced search");
	}

	@When("I filter the results by category")
	public void i_filter_the_results_by_category() {
		hp.Cdropdown();
		System.out.println("Filter using catagory");
	}

	@When("I filter the results by price")
	public void i_filter_the_results_by_price() {
		hp.filterPrice();
		System.out.println("Filter using price");
	}

	@When("I filter the results by ratings")
	public void i_filter_the_results_by_ratings() {
		hp.filterRatings();
	}

	@Then("I see the filtered product displayed")
	public void i_see_the_filtered_product_displayed() throws InterruptedException {
		hp.aSearchButton();
//		wait.until(ExpectedConditions.visibilityOfE)
		Assert.assertTrue(hp.resultverify());
		System.out.println("Filtered products are displayed");
	}

	@Given("Searching for {string}")
	public void searching_for(String string) {
		pp.searchbar(string);
		System.out.println("Searched for product");
	}

	@When("I click on the product")
	public void i_click_on_the_product() {
		pp.searchHBook();
		pp.ClickHbook();
		System.out.println("Clicked on the product");
	}

	@Then("I see the product title")
	public void i_see_the_product_title() {
		pp.verifyPtitle();
		System.out.println("Product title Visible");
	}

	@Then("I see the product description")
	public void i_see_the_product_description() {
		pp.verifyPdescription();
		System.out.println("Product description visible");
	}

	@Then("I see the product price")
	public void i_see_the_product_price() {
		pp.verifyPprice();
		System.out.println("Product price visible");
	}

	@Then("I see the product images")
	public void i_see_the_product_images() {
		pp.verifyPimage();
		System.out.println("Product images visible");
	}

	@Then("I see the product availabity")
	public void i_see_the_product_availabity() {
		pp.verifyPavailability();
		System.out.println("Product is available");
	}

	@When("I click on add to wishlist")
	public void i_click_on_add_to_wishlist() {
		pp.clickAddWish();
		System.out.println("Clicked on add to wishlist");
	}

	@And("I click on add to cart")
	public void i_click_on_add_to_cart() throws InterruptedException {
		Thread.sleep(6000);
		pp.clickAddCart();
		System.out.println("Clicked on add to cart");
	}

	@Then("product is added")
	public void product_is_added() {
		Assert.assertTrue(pp.addtowishlistverify());
		Assert.assertTrue(pp.addtocartverify());
		System.out.println("Product is added");
	}

	@Given("Search {string}")
	public void search(String product1) {
		sp.search1(product1);
		sp.phone();
		System.out.println("Search product1");
	}

	@When("Click on add to cart1")
	public void click_on_add_to_cart1() {
		sp.phoneaddtocart();
		System.out.println("product1 added to cart");
	}
	
	@When("Click on shopping cart")
	public void click_on_shopping_cart() {
		sp.shoppincart();
		System.out.println("Clicked on add to cart");
	}

	@When("Click remove product")
	public void click_remove_product() {
		sp.remove();
		System.out.println("Clicked remove product");
	}

	@When("Click update shopping cart")
	public void click_update_shopping_cart() {
		sp.updatecart();
		System.out.println("Updated shopping cart");
	}

	@When("verify shopping cart")
	public void verify_shopping_cart() {
		Assert.assertTrue(sp.removemsg());
		System.out.println("Verified updated shopping cart");
	}
	
	@When("Click update quantity")
	public void click_update_quantity() {
		sp.quantity();
	    System.out.println("Updated quantities");
	}
	@When("verify update shopping cart")
	public void verify_update_shopping_cart() {
		Assert.assertTrue(sp.updatequantitysuccess());
		System.out.println("Verified update quantites");
	}
	@Then("Verify checkout button")
	public void verify_checkout_button() {
		Assert.assertTrue(sp.verifycheckout());
	    System.out.println("Verified checkout button");
	}
	@Given("I search {string} for adding to cart")
	public void i_search_for_adding_to_cart(String string) {
		cop.searchfinProduct(string);
	    System.out.println("Searched for product");
	}

	@When("I add the product to cart")
	public void i_add_the_product_to_cart() {
		cop.addfinProductCart();
	    System.out.println("Added to cart");
	}

	@When("I click on shopping cart link")
	public void i_click_on_shopping_cart_link() {
		cop.shoppinglink();
		System.out.println("Clicked on shoppinng cart");
	}

	@When("I click on checkout")
	public void i_click_on_checkout() {
		cop.checkbox();
	    System.out.println("Clicked on checkout button");
	}

	@When("I login and proceed to checkout")
	public void i_login_and_proceed_to_checkout() {
		cop.loginproceed();
		cop.checkbox();
	    System.out.println("I logged in and proceeded with checkout");
	}

	@When("I enter billing address")
	public void i_enter_billing_address() {
		cop.billcontinue();
	    System.out.println("Entered billing address");
	}

	@When("I continue with shipping address")
	public void i_continue_with_shipping_address() {
		cop.shippingContinue();
	    System.out.println("Continued with shipping address");
	}

	@When("I continue with shipping method")
	public void i_continue_with_shipping_method() {
		cop.shipMethodcon();
	    System.out.println("Continue with shipping method");
	}

	@When("I continue with payment methods")
	public void i_continue_with_payment_methods() {
		cop.payContinue();
		cop.payinfoContinue();
	    System.out.println("Continued with payment methods");
	}

	@When("I confirm order")
	public void i_confirm_order() {
		cop.clickconfirm();
	    System.out.println("Clicked confirm order");
	}

	@Then("I validate the successfully processed order")
	public void i_validate_the_successfully_processed_order() {
		Assert.assertTrue(cop.successorderdisplay());
	    System.out.println("Validated the success message");
	}
}
