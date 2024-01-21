Feature: Login with InValid Credentials

  @regression
  Scenario Outline: Login Data Driven
    Given the user navigates to login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then user captures the error displayed
 

    Examples: 
      | email               | password |
      | jobspari2@gmail.com | abc258   |
