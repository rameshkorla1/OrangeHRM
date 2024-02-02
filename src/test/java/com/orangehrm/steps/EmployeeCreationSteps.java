package com.orangehrm.steps;

import com.openoragehrm.pages.DashBoardPage;
import com.openoragehrm.pages.LoginPage;
import com.openoragehrm.pages.PIMPage;
import com.openorangehrm.actions.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeCreationSteps {
	
	LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	DashBoardPage  dashBoard = new DashBoardPage(DriverManager.getDriver());
	PIMPage pimPage = new PIMPage(DriverManager.getDriver());
	
	@Given("User is logged as an HR manager")
	public void user_is_logged_as_an_hr_manager() {
	    
		loginPage.launchURL();
		loginPage.waitForPageLoaded();
		loginPage.Username("Admin");
		loginPage.Password("admin123");
		loginPage.clickOnLogin();
	    loginPage.waitToElementLoad(5);
	}

	@Given("User creates the employee page")
	public void user_creates_the_employee_page() {
	    
		pimPage.clickOnPIMTab();
		pimPage.waitToElementLoad(3);
		pimPage.clickOnAddEmployeeButton();
	}

	@When("User enters all the required employee details")
	public void user_enters_all_the_required_employee_details() {
	    
	    pimPage.employeeDetails("Ramesh", "Naidu", "Korla");
	}

	@When("click on the Create Employee button")
	public void click_on_the_create_employee_button() {
	    
	    pimPage.clickOnSave();
	}

	@Then("the employee record should be saved correctly in the system")
	public void the_employee_record_should_be_saved_correctly_in_the_system() {
	    
		pimPage.clickOnPIMTab();
		pimPage.searchOnEmpName("Ramesh");
	}

	@Given("User is on the employee creation page")
	public void user_is_on_the_employee_creation_page() {
	    
		pimPage.clickOnPIMTab();
		pimPage.waitToElementLoad(3);
		pimPage.clickOnAddEmployeeButton();
	}

	@When("User tries to create an employee record without providing the required fields")
	public void user_tries_to_create_an_employee_record_without_providing_the_required_fields() {
	    
		pimPage.clickOnSave();
	}

	@Then("User should see an error message indicating the missing fields")
	public void user_should_see_an_error_message_indicating_the_missing_fields() {
	    
	    
	}

	@When("User enters invalid data in one or more fields")
	public void user_enters_invalid_data_in_one_or_more_fields() {
	    
	    
	}

	@Then("User should see an error message indicating the invalid data")
	public void user_should_see_an_error_message_indicating_the_invalid_data() {
	    
	    
	}


}
