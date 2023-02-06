package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import java.util.List;

public class ApiActions extends CommonOps {
    /*
    Method Name: get
    Method Description: Makes a GET request to the server with a given parameter value.
    Method Parameters: paramValues (String) - the value of the parameter to be passed in the GET request.
    Method Return: Response object, representing the response from the server.
     */
    @Step("Get Data From Server")
    public static Response get(String paramValues){
        response = httpRequest.get(paramValues);
        return response;
    }

    /*
    Method Name: extractFromJSON
    Method Description: Extracts a value from the JSON-format response.
    Method Parameters: response (Response) - the response from the server in JSON format. path (String) - the path to the value to be extracted from the response.
    Method Return: String representation of the extracted value.
     */
    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    /*
    Method Name: extractListFromJSON
    Method Description: Extracts a list of values from the JSON-format response.
    Method Parameters: response (Response) - the response from the server in JSON format. value (String) - the value of the list to be extracted from the response.
    Method Return: List of the extracted values.
     */
    @Step("Extract List of Value From JSON Format")
    public static List extractListFromJSON(Response response, String value){
        jp = response.jsonPath();
        return jp.getList(value);
    }

    /*
    Method Name: post
    Method Description: Makes a POST request to the server with given parameters and resource.
    Method Parameters: params (JSONObject) - the parameters to be sent with the POST request. resource (String) - the resource endpoint for the POST request.
    Method Return: None
     */
    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
    }

    /*
    Method Name: put
    Method Description: Makes a PUT request to the server with given parameters and resource.
    Method Parameters: params (JSONObject) - the parameters to be sent with the PUT request. resource (String) - the resource endpoint for the PUT request.
    Method Return: None
     */
    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    /*
    Method Name: delete
    Method Description: Makes a DELETE request to the server with a given path.
    Method Parameters: path (String) - the path for the DELETE request.
    Method Return: None
     */
    @Step("Delete Data in Server")
    public static void delete(String path){
        response = httpRequest.delete(path);
    }
}
