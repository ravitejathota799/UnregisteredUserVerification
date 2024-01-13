package com.stepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { ".//Features/LoginDDT.feature" }, glue = "com.StepDefinitions", plugin = { "pretty",
				"html:reports/myreport.html"
				 }, dryRun = false, monochrome = true)

public class TestRunner {

	public TestRunner() {
		// TODO Auto-generated constructor stub
	}

}
