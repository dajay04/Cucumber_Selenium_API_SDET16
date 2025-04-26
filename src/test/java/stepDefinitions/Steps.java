package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import apiTest.CreateUserAPITest;
import apiTest.UpdateUserAPITest;

public class Steps
{
    CreateUserAPITest createUserAPITestobj = new CreateUserAPITest();
    UpdateUserAPITest updateUserAPITestobj = new UpdateUserAPITest();

    @Given("User selects {string} for Create Portal API")
    public void user_selects_for_create_portal_api(String payload) throws Exception
    {
        createUserAPITestobj.selectPayload(payload);
    }

    @When("User hit create post api")
    public void user_hit_create_post_api()
    {
        createUserAPITestobj.getResponse();
    }

    @Then("User verifies response message contains ID in it")
    public void user_verifies_response_message_contains_id_in_it()
    {
        createUserAPITestobj.validateResponseMessage();
    }

    @And("User verifies {string} should matches")
    public void user_verifies_should_matches(String code)
    {
        int code_expected = Integer.parseInt(code);
        createUserAPITestobj.validateResponseCode(code_expected);
    }

    @Given("User selects {string} for Update Portal API")
    public void user_selects_for_update_portal_api(String update_payload) throws Exception {
        updateUserAPITestobj.selectPayload(update_payload);
    }

    @When("User hit put post api")
    public void user_hit_put_post_api()
    {
        updateUserAPITestobj.getResponse();
    }

    @Then("User verifies response message in update api")
    public void user_verifies_response_message_in_update_api()
    {
        updateUserAPITestobj.validateResponseMessage();
    }

    @Then("User verifies {string} should matches on update")
    public void user_verifies_should_matches_on_update(String update_status_code)
    {
        int code = Integer.parseInt(update_status_code);
        updateUserAPITestobj.validateResponseCode(code);
    }
}
