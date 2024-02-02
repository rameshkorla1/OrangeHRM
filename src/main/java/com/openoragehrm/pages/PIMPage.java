package com.openoragehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.openorangehrm.actions.orangehrmActions;

public class PIMPage extends orangehrmActions {
	
	public WebDriver driver;
	
	public PIMPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;		
	}
	/**PIM Menu*/
	By PIMTab = By.xpath("//ul[@class='oxd-main-menu']//li[2]");
	By AddEmployeeButton = By.xpath("//*[@class='oxd-topbar-body-nav']//li[3]");
	
	/**Add Employee Fields
	 * **/
	By FirstName = By.xpath("//input[@name='firstName']");
	By MiddleName = By.xpath("//input[@name='middleName']");
	By LastName = By.xpath("//input[@name='lastName']");
	By createLoginDetails = By.cssSelector("div[class='oxd-switch-wrapper']");
	By Save = By.cssSelector("button[type='submit']");
	
	
	By employeeId = By.xpath("//div[@class='oxd-table-filter']/div[2]/form/div/div/div[2]/div/div[2]/input");  //div[@class='oxd-table-card']//div//div[2]
    By Search = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    
    By EditRecord = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");

    By EmployeeName = By.xpath("//div[@class='oxd-table-filter']//div[2]//div//div[1]/input");
    
    
    

    public void employeeSearch(String text)
    {
    	writeText(employeeId, text, "EmployeeIdTxtBox");
    	waitToElementLoad(3);
    	//click(Search);
    	doubleClick(Search);
    	waitToElementLoad(4);
//    	javaScriptClick(EditRecord, "select the record and edit");
    }
    
    public void searchOnEmpName(String text)
    {
    	writeText(EmployeeName, text, "Employee Name TxtBox");
    	waitToElementLoad(3);
    	doubleClick(Search);
    	waitToElementLoad(4);
    }
    
    public void editRecord()
    {
      	// Scroll 
    	scroll();
    	click(EditRecord, "EditLink");
    }
    
    public void clickOnPIMTab()
    {
    	click(PIMTab, "PIM Menu Link");
    }
    
    public void clickOnAddEmployeeButton()
    {
    	click(AddEmployeeButton, " Add Employee");
    }
    
    public void employeeDetails(String fname, String mname, String lname)
    {
    	writeText(FirstName, fname, "FirstName");
    	writeText(MiddleName, mname, "MiddleName");
    	writeText(LastName, lname, "LastName");
    }
    
    public void clickOnSave()
    {
    	click(Save, "Save Button");
    }
}
