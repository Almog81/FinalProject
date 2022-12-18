package workFlows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class ApiFlows extends CommonOps {
    @Step("Business Flow: Get Student info by id")
    public static String getStudentProperty(String id, String jPath){
        response = ApiActions.get("/student/" + id);
        return ApiActions.extractFromJSON(response,jPath);
    }

    @Step("Business Flow: Get Student Courses by id")
    public static List<String> getStudentCourses(String id){
        response = ApiActions.get("/student/" + id);
        return ApiActions.extractListFromJSON(response,"courses");
    }

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

    @Step("Business Flow: Crate New Student")
    public static void postStudent(String firstName, String lastName, String email, String programme){
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("email",email);
        params.put("programme",programme);

        ApiActions.post(params,"/student");
    }
    @Step("Business Flow: Update Courses in Student")
    public static void putCourses(String id,List<String> coursesList ){
        params.put("firstName",getStudentProperty(id,"firstName"));
        params.put("lastName",getStudentProperty(id,"lastName"));
        params.put("email",getStudentProperty(id,"email"));
        params.put("programme",getStudentProperty(id,"programme"));

        params.put("courses",coursesList);
        ApiActions.put(params,"/student/" + id);
    }

    @Step("Business Flow: Delete Student")
    public static void deleteStudent(String id){
        ApiActions.delete("/student/" + id);
        System.out.println("Student Deleted!");
    }
}
