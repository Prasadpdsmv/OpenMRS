
Feature: Login

  Background:
    Given user visits login page

  @reg
  @login
  Scenario Outline: login with valid credentials
    When user entrer "<username>" and "<password>"
    And user clicks on login button
  Then user should see location select page
    Examples:
      | username | password |
      | admin    | 123qweASD |

  Scenario Outline: login with invalid credentials
    When user entrer "<username>" and "<password>"
    And user clicks on login button
    Then : user should see error message

    Examples:
    |username|password|
    |Aaskjokd|sdkkdk  |
    |Admin   |        |
    |        |        |
    |        |Admin123|

