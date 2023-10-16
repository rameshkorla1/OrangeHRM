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
	
	By employeeId = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");  //div[@class='oxd-table-card']//div//div[2]
    By Search = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    
    By EditRecord = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");


    public void employeeSearch(String text)
    {
    	writeText(employeeId, text, "EmployeeIdTxtBox");
    	waitToElementLoad(3);
    	//click(Search);
    	doubleClick(Search);
    	waitToElementLoad(4);
    	// Scroll 
    	scroll();
 //   	scrollIntoView(EditRecord);
    	click(EditRecord, "EditLink");
//    	javaScriptClick(EditRecord, "select the record and edit");
    }
}
