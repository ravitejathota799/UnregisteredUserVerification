package com.stepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { ".//Features/login.feature" }, glue = "com.StepDefinitions", plugin = { "pretty",
				"html:reports/myreport.html", "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true)

public class TestRunner {

	public TestRunner() {
		// TODO Auto-generated constructor stub
	}

}
