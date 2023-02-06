package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps{
    /*
    Method Name: openConnection
    Method Description: Open a connection to a database using the specified URL, user and password
    Method Parameters: String dbURL - the URL of the database,
                       String user - the username to use for the connection,
                       String pass - the password to use for the connection.
    Method Return: None
     */
    public static void openConnection (String dbURL, String user, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        }catch (Exception e){
            System.out.println("Connection to the DB failed, See: " + e);
        }
    }

    /*
    Method Name: closeConnection
    Method Description: Close the connection to a database
    Method Parameters: None
    Method Return: None
     */
    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Closing to the DB failed, See: " + e);
        }
    }
}
