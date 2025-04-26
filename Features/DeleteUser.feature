Feature: Creating a user using Post API

  @sanity
  Scenario Outline: User verifies create Portal API is working
    Given User selects "<Payload>" for Create Portal API
    When User hit create post api
    Then User verifies response message contains ID in it
    And User verifies "<Status_Code>" should matches
    Examples:
      | Payload    | Status_Code |
      | happy_path | 201         |
