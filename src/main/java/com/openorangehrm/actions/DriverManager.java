package com.openorangehrm.actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class DriverManager {
	public  WebDriver driver;
	public Properties prop;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver() throws IOException
	{
		prop = new Properties();
		String filePath = System.getProperty("user.dir")+"/Configuration/orangehrm.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			//1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs",prefs);
			//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		
			//WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Please pass the correct browset vlaue:"+browser);
		}		
		return driver;
	}
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	
	public WebDriver init_driver(String browserName)
	{
		
		//String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		System.out.println("browser value is:" +browserName);
		if(browserName.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserName.equals("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else if(browserName.equals("opera"))
		{
			//WebDriverManager.operadriver().setup();
			//tlDriver.set(new OperaDriver());
		}
		else
		{
			System.out.println("Please pass the correct browset vlaue: "+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	public void ApplicationURL()
	{
		driver.get(prop.getProperty("AppUrl"));
	}

}
