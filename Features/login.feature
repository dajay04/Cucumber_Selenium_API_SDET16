Feature: Login Test

  @smoke @regression
  Scenario: Successful Login verification with Valid Credentials
    Given User launches Chrome Browser
    When User open URL "https://practicetestautomation.com/practice-test-login/"
    And User enters Email as "student" and Password as "Password123"
    And User clicks on Submit Button
    Then User verifies PageTitle should be "Logged In Successfully | Practice Test Automation"
    And User closes browser

    @regression
  Scenario Outline: Validating Login with Invalid Credentials
    Given User launches Chrome Browser
    When User open URL "https://practicetestautomation.com/practice-test-login/"
    And User enters Email as "<Username>" and Password as "<Password>"
    And User clicks on Submit Button
    Then User verifies error message "<Error_Message>"

    Examples:
      | Username   | Password         | Error_Message             |
      | student213 | Password123      | Your username is invalid! |
      | student    | Password12312312 | Your password is invalid! |
