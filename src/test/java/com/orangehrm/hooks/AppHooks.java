package com.orangehrm.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.openorangehrm.actions.DriverManager;
import com.openorangehrm.utilities.ConfigFileReader;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private DriverManager driverFactory;
	private WebDriver driver;
	private ConfigFileReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException
	{
		configReader = new ConfigFileReader();
		prop = configReader.init_prop();
	}	
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		driverFactory = new DriverManager();
		driver=driverFactory.init_driver(browserName);
	}	
	@After(order=0)
	public void quitBrowser()
	{	
		driver.quit();
//		sendToEmail sendEmail = new sendToEmail();
//		sendEmail.emailSending();
		
	}
	@AfterStep
	public void stepScreenshot(Scenario scenario) throws IOException
	{
		//String screenshotName =scenario.getName().replaceAll(" ", "_");
		//scenario.attach(Screenshot.getByteScreenshot(driver), "image/png", "");
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.attach(screenshot, "image/png", "");
		//scenario.attach(screenshot, "image/png", screenshotName);
	}
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screenshot
			String screenshotName =scenario.getName().replaceAll("", "_");
			byte[] sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(sourcepath, "image/png", screenshotName);
		}
		
		
	}
}
