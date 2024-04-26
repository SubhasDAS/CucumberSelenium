Feature: Login functionalitye1

  @smoke
  Scenario Outline: Sign up with a valid username and password
    Given I am on the sign-up page
    When I enter a valid username "< username >"
    And I enter a valid password "< password >"
    And I click the sign-up button
    Then I should see a success message

    Examples:
      | username | password |
      |        0 |        0 |
      |        1 |        1 |

  @regression
  Scenario Outline: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username "<username>" and password "<password>"
    And User clicks on the login button
    Then User is navigated to the homepage

    Examples:
      | username | password |
      |        0 |        0 |
      |        1 |        1 |
