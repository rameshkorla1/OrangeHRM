package com.openoragehrm;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.openoragehrm.pages.LoginPage;
import com.openorangehrm.actions.DriverManager;
import com.openorangehrm.utilities.Screenshot;



@Listeners(com.openorangehrm.customeListener.Log.class)
public class orangeLoginTest extends DriverManager{
	
	LoginPage loginPage;
	
	@BeforeTest
	public void startup() throws IOException, InterruptedException
	{
		initDriver();
		getDriver().get(prop.getProperty("AppUrl"));
        Thread.sleep(4000);
	}
	
	@Test
	public void orangehrmLogin() throws InterruptedException
	{
		loginPage = new LoginPage(getDriver());
		Screenshot.testName="Login";
		loginPage.Username("Admin");
		loginPage.Password("admin123");
		loginPage.clickOnLogin();
		Thread.sleep(3000);
		loginPage.verifyDashBoardText();
	}
	
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}

}
