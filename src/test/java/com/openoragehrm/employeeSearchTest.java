package com.openoragehrm;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.openoragehrm.pages.LoginPage;
import com.openoragehrm.pages.PIMPage;
import com.openorangehrm.actions.DriverManager;
import com.openorangehrm.utilities.Screenshot;

@Listeners(com.openorangehrm.customeListener.Log.class)
public class employeeSearchTest extends DriverManager {
	
    LoginPage loginPage;
    PIMPage pimpage;

	@BeforeTest
	public void startup() throws IOException, InterruptedException
	{
		initDriver();
		getDriver().get(prop.getProperty("AppUrl"));
		getDriver().manage().window().maximize();
	}
	
	@Test
	public void selectEmployeeFromList() throws InterruptedException
	{
        loginPage = new LoginPage(getDriver());	
        Screenshot.testName="Login";
		loginPage.Username("Admin");
		loginPage.Password("admin123");
		loginPage.clickOnLogin();
		pimpage.waitToElementLoad(3);
		Screenshot.testName="PIM";
		loginPage.clickOnPIM();
		pimpage.waitToElementLoad(3);
		loginPage.verifyPIMText();	
		pimpage =new PIMPage(getDriver());
		Screenshot.testName="PIM";
		pimpage.waitToElementLoad(3);
		pimpage.employeeSearch("0070");
		pimpage.waitToElementLoad(3);
		pimpage.editRecord();
	}
	
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}

}
