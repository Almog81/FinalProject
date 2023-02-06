package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    /*
    Method Name: getCredentials
    Method Description: A method to retrieve credentials from a database using a SQL query
    Method Parameters: String query: a SQL query to retrieve the data from the database
    Method Return: List<String>: a list of strings representing the credentials (username and password) retrieved from the database.
     */
    @Step("Get Data Credentials From Database")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<String>();
        try {
            rs =  stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }catch (Exception e){
            System.out.println("Printing Table Data failed, See: " + e);
        }
        return credentials;
    }

}
