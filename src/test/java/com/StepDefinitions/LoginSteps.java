package com.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.pageObjects.Locators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	Locators loc;

	public LoginSteps() {
		// TODO Auto-generated constructor stub
	}

	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		loc = new Locators(BaseClass.getDriver());
		loc.setNavigationLink();

	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
		loc = new Locators(BaseClass.getDriver());
		loc.setEmail(string);
		loc.setPassword(string2);
		// Write code here that turns the phrase above into concrete actions

	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		loc.clickLogin();
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("user captures the error displayed")
	public void user_captures_the_error_displayed() {
		System.out.println(loc.getError());
		// Write code here that turns the phrase above into concrete actions

	}

}
