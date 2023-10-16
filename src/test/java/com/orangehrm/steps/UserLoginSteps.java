package com.orangehrm.steps;

import com.openoragehrm.pages.DashBoardPage;
import com.openoragehrm.pages.LoginPage;
import com.openorangehrm.actions.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps {
	
	LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	DashBoardPage  dashBoard = new DashBoardPage(DriverManager.getDriver());
	
	@Given("User is on the OrangeHRM login page")
	public void user_is_on_the_orange_hrm_login_page() {
	   
		loginPage.launchURL();
		loginPage.waitForPageLoaded();				
	}

	@When("User enter valid credentials")
	public void user_enter_valid_credentials() {
	   
		loginPage.Username("Admin");
		loginPage.Password("admin123");
	}

	@When("click on the Login button")
	public void click_on_the_login_button() {
		loginPage = new LoginPage(DriverManager.getDriver());
	    loginPage.clickOnLogin();
	    loginPage.waitToElementLoad(5);
	}

	@Then("User should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() {

		dashBoard = new DashBoardPage(DriverManager.getDriver());
		dashBoard.waitToElementLoad(5);
		dashBoard.verifyTheDashBoardTitle("Dashboard");
	}

	@When("User enter invalid credentials")
	public void user_enter_invalid_credentials() {
	   
		loginPage.Username("Admin");
		loginPage.Password("admin1234");
	}

	@Then("User should see an error message")
	public void user_should_see_an_error_message() {
		loginPage = new LoginPage(DriverManager.getDriver());
	    String alertMesage = "";
		if(alertMesage.equals("Invalid credentials")) {
	    loginPage.verifyTheAlertMessage("Invalid credentials");
		}
		else if(alertMesage.equals("Required"))
		{
			loginPage.verifyFieldAlertMessage("Required");
		}
	}

	@When("User click on the Login button without providing credentials")
	public void user_click_on_the_login_button_without_providing_credentials() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickOnLogin();
		loginPage.waitToElementLoad(5);
	}

	@When("User enter the password without providing a username")
	public void user_enter_the_password_without_providing_a_username() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.Password("admin1234");
	}

	@When("User enter the username without providing a password")
	public void user_enter_the_username_without_providing_a_password() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.Username("Admin");
	}

}
