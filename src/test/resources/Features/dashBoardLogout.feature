Feature: Logout Test after Dashboard Loaded

  @regression
  Scenario: Successful Login verification with Valid Credentials
    Given User launches Chrome Browser
    When User open URL "https://practicetestautomation.com/practice-test-login/"
    And User enters Email as "student" and Password as "Password123"
    And User clicks on Submit Button
    Then User verifies PageTitle should be "Logged In Successfully | Practice Test Automation"
    And User clicks on Logout button
    Then User verifies PageTitle should be "Test Login | Practice Test Automation"
    And User closes browser