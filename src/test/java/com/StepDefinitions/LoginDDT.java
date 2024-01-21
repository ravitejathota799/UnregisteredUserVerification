package com.StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.pageObjects.Locators;
import com.utils.DataReader;
import com.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginDDT {

	public LoginDDT() {
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	Locators loc;
	List<HashMap<String, String>> datamap; //Data driven
	String file = System.getProperty("user.dir") + "/src/test/resources/MiniProject.xlsx"; // Getting the file path from the current directory
	
	@Given("login page")
	public void the_user_navigates_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		loc = new Locators(BaseClass.getDriver());
		loc.setNavigationLink();

	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Locators l = new Locators(driver);
		int rows1 = ExcelUtility.getRowCount(file, "Sheet1"); // getting the row count from test case sheet
		for (int i = 1; i <= rows1; i++) {
//			l.setNavigationLink();	 //setting up the navigation link
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());	 // handling multiple windows
//			driver.switchTo().window(tabs.get(1));	 // switching the tab
			 l.setEmail(ExcelUtility.getCellData(file, "Sheet1", i, 0)); 	//getting the email field value from the excel file
			//logger.info("*** Entered Email ID ***");
			l.setPassword(ExcelUtility.getCellData(file, "Sheet1", i, 1)); 	//getting the password field value from the excel file
			//logger.info("*** Entered password ***");
			l.clickLogin();	 //clicking on the login button
			//logger.info("*** Clicked on login button ***");
			String s = l.getError();	 //actual result value
			String expectedResult = "Error: Email or password is incorrect!";	 //expected result value
			try {
				Assert.assertEquals(s, expectedResult); 	// Checking the actual and expected results
				ExcelUtility.setCellData(file, "Sheet1", i, 3, "Failed"); 	// making the cell as failed
				ExcelUtility.fillGreenColor(file, "Sheet1", i, 2);	 // making the cell background color as green
				ExcelUtility.fillGreenColor(file, "Sheet1", i, 3);	 // making the cell background color as green
				System.out.println("executed successfully and file Written Succefully"); 	// printing the output in the  console
			} catch (AssertionError e) {
				System.out.println("Assertion Error" + e);	 // catching the exception error message
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			

		}

	}

}
