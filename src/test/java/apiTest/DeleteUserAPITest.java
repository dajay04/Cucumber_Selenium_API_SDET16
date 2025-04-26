package apiTest;

import utils.Constants;
import utilities.Methods;
import utils.PayloadKeys;
import utils.RunTimeVariable;
import stepDefinitions.BaseClass;
import io.restassured.response.Response;

public class DeleteUserAPITest extends BaseClass
{
    Methods methods = new Methods();
    String requestPath;
    Response response;


    public void getResponse()
    {
        try
        {
            requestPath = BASE_URL + Constants.DELETE_USER_URI;
            requestPath = requestPath.replace("ID", RunTimeVariable.ID);
            System.out.println("Compelte Url for Hititng API:" + requestPath);
            response = methods.sendDeleteRequest(BASE_URL, requestPath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void validateResponseCode(int code)
    {
        try
        {
            methods.validateStatusCode(code, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
