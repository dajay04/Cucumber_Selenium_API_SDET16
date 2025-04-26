Feature: Updating a User using an Put API

  @sanity
  Scenario Outline: User verifies Update Portal API is working fine
    Given User selects "<Payload>" for Create Portal API
    When User hit create post api
    Given User selects "<Update_Payload>" for Update Portal API
    When User hit put post api
    Then User verifies response message in update api
    And User verifies "<Status_Code>" should matches on update
    Examples:
      | Payload    | Update_Payload    | Status_Code |
      | happy_path | happy_path_update | 400         |