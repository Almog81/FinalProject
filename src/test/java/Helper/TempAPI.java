package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:9000";

    @Test
    public void Testing_API(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
                //.auth().preemptive().basic("admin","admin123"); for Autorotation

        //Get Request
        //response = httpRequest.get("/users?page=1");
        //response.prettyPrint();

        //Post Request
        JSONObject params = new JSONObject();
        params.put("firstName","Almog");
        params.put("lastName","Noach");
        params.put("email","Almog81@gmail.com");
        params.put("programme","Full Stack Automation");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(params.toJSONString());
        response =  httpRequest.put("/student/101");
        response =  httpRequest.delete("/student/101");

        response.prettyPrint();

        //14:10
    }
}
