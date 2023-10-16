package com.openoragehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.openorangehrm.actions.orangehrmActions;

public class DashBoardPage extends orangehrmActions {
	
	public WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public By dashBoradTitle = By.xpath("//div[@class='oxd-topbar-header']//div[1]");
	
	
	public String verifyTheDashBoardTitle(String expected)
	{
		String actualtitle = readText(dashBoradTitle, "DashBoard Title");
		Assert.assertEquals(actualtitle, expected);
		return actualtitle;
	}

}
