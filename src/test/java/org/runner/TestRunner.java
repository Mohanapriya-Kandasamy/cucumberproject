package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources",glue = "org.stepdefinition",dryRun = false, tags = "@facebook1",
plugin = "json:C:\\Users\\siddh\\eclipse-workspace\\MavenCucumber\\ReportFolder\\json\\fb.json")
public class TestRunner  {
	
	@AfterClass
	
	public static  void report() {
		JvmReport.generateJvmReport(System.getProperty("user.dir")+ "\\ReportFolder\\json\\fb.json");

	}
	
	

}
