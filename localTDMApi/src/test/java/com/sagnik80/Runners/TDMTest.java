package com.sagnik80.Runners;

import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import com.sagnik80.Global.GetPropVal;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,
		plugin = {"html:target/cucumber-html-report", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	   // tags = {"@RestAPI"},
	    features = "src/main/java/com/sagnik80/Feature"  , //refer to Feature file
	    glue={"com.sagnik80.StepDefinitions"}
	)
public class TDMTest {
	@AfterClass
	public static void writeExtentReport() {
		try {
			try {
				Reporter.loadXMLConfig(new File(GetPropVal.class.newInstance().getReportConfigPath()));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}