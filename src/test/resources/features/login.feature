Feature: Login functionality

  @smoke
  Scenario: Sign up with a valid username and password
    Given I am on the sign-up page
    When I enter a valid username
    And I enter a valid password 
    And I click the sign-up button
    Then I should see a success message

  @regression
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks on the login button
    Then User is navigated to the homepage
