package apiTest;

import utils.Constants;
import utilities.Methods;
import utils.PayloadKeys;
import utils.RunTimeVariable;
import stepDefinitions.BaseClass;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class UpdateUserAPITest extends BaseClass {
    Methods methods = new Methods();
    String requestBody;
    JsonObject body;
    String requestPath;
    Response response;


    public void selectPayload(String payloadPath) throws Exception {
        try {
            this.requestBody = methods.readJsonAsString(PayloadKeys.PAYLOAD_UPDATE_USER + payloadPath + ".json")
                    .replace("morpheus", RunTimeVariable.NAME);

            System.out.println("The Payload seelcted is" + this.requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       public void getResponse() {
        try {
            body = methods.createJSONOBJ(this.requestBody);
            requestPath = BASE_URL + Constants.UPDATE_USER_URI;// https://reqres.in/api/users/ID
            requestPath = requestPath.replace("ID", RunTimeVariable.ID); // https://reqres.in/api/users/394
            System.out.println("Compelte Url for Hititng API:" + requestPath);
            response = methods.sendPutRequest(BASE_URL, requestPath, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validateResponseCode(int code) {
        try {
            methods.validateStatusCode(code, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validateResponseMessage() {
        JsonPath evalutor = response.jsonPath();
        System.out.println(evalutor.get("name").toString());
        System.out.println(RunTimeVariable.NAME);
        Assert.assertTrue(evalutor.get("name").toString().contains(RunTimeVariable.NAME));
    }
}
