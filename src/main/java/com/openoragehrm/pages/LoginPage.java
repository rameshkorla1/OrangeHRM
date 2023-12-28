package com.openoragehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.openorangehrm.actions.orangehrmActions;
import com.openorangehrm.utilities.ConfigFileReader;

public class LoginPage extends orangehrmActions{
	
	public WebDriver driver;
	ConfigFileReader configFileReader;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver =driver;
		configFileReader = new ConfigFileReader();
	}
	
	By Username = By.xpath("//input[@name='username']");
	By Password = By.xpath("//input[@name='password']");
	//By LoginBtn = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	By LoginBtn = By.cssSelector("button[class*='orangehrm-login-button']");
	
	By pimlink = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
	
	By pim = By.xpath("//div[@class='oxd-topbar-header']//div[1]");
	By alertMessage = By.cssSelector("div[class='oxd-alert oxd-alert--error']");
	By fieldAlert = By.cssSelector("span[class*='oxd-input-field-error-message']");
	
	public void Username(String text)
	{
		writeText(Username, text, "UsernameTextBox");
	}
	
	public void Password(String text)
	{
		//writeText(Password, text);
		writeText(Password, text, "PasswordTextBox");
	}
	
	public void clickOnLogin()
	{
		waitToElementLoad(5);
		click(LoginBtn, "Login Button");
		//javaScriptClick(LoginBtn, "Click on the Login Button", "LoginButton");
	}
	
	public void loginApplication(String username, String password)
	{
		writeText(Username, username, "UsernameTextBox");
		writeText(Password, password, "PasswordTextBox");
		javaScriptClick(LoginBtn, "Click on the Login Button", "LoginButton");
	}
	
	public String verifyTheAlertMessage(String expectedMsg) {
		
		String alertMsg = readText(alertMessage, "alert message");
		Assert.assertEquals(alertMsg, expectedMsg);	
		return alertMsg;
	}
	
    public String verifyFieldAlertMessage(String expectedMsg) {
		
		String alertMsg = readText(fieldAlert, "field alert message");
		Assert.assertEquals(alertMsg, expectedMsg);	
		return alertMsg;
	}
	
	public void verifyDashBoardText()
	{
		String actual = getText(pim, "DashBoard");
		Assert.assertEquals(actual, "Dashboard");		
	}
	
	public void verifyPIMText()
	{
		String actual = getText(pim, "PIM");
		Assert.assertEquals(actual, "PIM");		
	}
	public void clickOnPIM()
	{
		click(pimlink, "pimLink");
	}
	
	public void launchURL()
	{
		driver.get(configFileReader.getApplicationUrl());
	}

}
