package workFlows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class ApiFlows extends CommonOps {
    /*
    Method Name: getStudentProperty
    Method Description: This method is used to retrieve a specific property of a student by providing their id and the property path in JSON format.
    Method Parameters: String id - The id of the student, String jPath - The JSON path of the property to be retrieved.
    Method Return: String: The value of the requested property of the student.
     */
    @Step("Business Flow: Get Student info by id")
    public static String getStudentProperty(String id, String jPath){
        response = ApiActions.get("/student/" + id);
        return ApiActions.extractFromJSON(response,jPath);
    }

    /*
    Method Name: getStudentCourses
    Method Description: This method is used to retrieve a list of courses that a student is enrolled in by providing their id.
    Method Parameters: String id - The id of the student.
    Method Return: List<String>: A list of courses that the student is enrolled in.
     */
    @Step("Business Flow: Get Student Courses by id")
    public static List<String> getStudentCourses(String id){
        response = ApiActions.get("/student/" + id);
        return ApiActions.extractListFromJSON(response,"courses");
    }

    /*
    Method Name: getStudentId
    Method Description: This method is used to retrieve the id of a student by providing their first name.
    Method Parameters: String fName: The first name of the student.
    Method Return: String: The id of the student.
     */
    @Step("Business Flow: Get Student id by First Name")
    public static String getStudentId(String fName){
        response = ApiActions.get("/student/list");
        List names = ApiActions.extractListFromJSON(response, "firstName");
        List ids = ApiActions.extractListFromJSON(response,"id");

        String id = "Not Fond!";
        for (int i = 0; i< names.size(); i++ ){
            if (names.get(i).toString().equalsIgnoreCase(fName))
                id = ids.get(i).toString();
        }
        System.out.println("The Student id of " + fName + " is: " + id);
        return id;
    }

    /*
    Method Name: postStudent
    Method Description: This method is used to create a new student by providing the student's first name, last name, email, and program.
    Method Parameters: String firstName: The first name of the student, String lastName: The last name of the student, String email: The email of the student, String programme: The program that the student is enrolled in.
    Method Return: None
     */
    @Step("Business Flow: Crate New Student")
    public static void postStudent(String firstName, String lastName, String email, String programme){
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("email",email);
        params.put("programme",programme);

        ApiActions.post(params,"/student");
    }

    /*
    Method Name: putCourses
    Method Description: This method is used to update the list of courses that a student is enrolled in by providing their id and a new list of courses.
    Method Parameters: String id - The id of the student, List<String> coursesList - A new list of courses that the student will be enrolled in.
    Method Return: None
     */
    @Step("Business Flow: Update Courses in Student")
    public static void putCourses(String id,List<String> coursesList ){
        params.put("firstName",getStudentProperty(id,"firstName"));
        params.put("lastName",getStudentProperty(id,"lastName"));
        params.put("email",getStudentProperty(id,"email"));
        params.put("programme",getStudentProperty(id,"programme"));

        params.put("courses",coursesList);
        ApiActions.put(params,"/student/" + id);
    }

    /*
    Method Name: deleteStudent
    Method Description: This method is used to delete a student by providing their id.
    Method Parameters: String id - The id of the student.
    Method Return: None
     */
    @Step("Business Flow: Delete Student")
    public static void deleteStudent(String id){
        ApiActions.delete("/student/" + id);
        System.out.println("Student Deleted!");
    }
}
