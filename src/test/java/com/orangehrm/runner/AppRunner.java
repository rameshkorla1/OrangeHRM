package com.orangehrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		stepNotifications = true,
		tags="@Userlogin",
		features = "src/test/resources/OrangeHRMFeatures",
		glue= {"com.orangehrm.steps","com.orangehrm.hooks"},
				plugin= {"pretty", 
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				         "timeline:test-output-thread/",
				         "rerun:target/failedRerun.txt"
				 }, monochrome = true
		)
public class AppRunner {

}
