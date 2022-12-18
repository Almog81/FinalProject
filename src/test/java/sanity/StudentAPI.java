package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.ApiFlows;

import java.util.ArrayList;
import java.util.List;
@Listeners(utilities.Listeners.class)
public class StudentAPI extends CommonOps {

    @Test(description = "Test01 - Verify Student")
    @Description("This Test Verifies name is exist")
    public static void Test01_name(){
        Verifications.verifyText(ApiFlows.getStudentProperty("80","firstName"),"Troy");
        Verifications.verifyText(ApiFlows.getStudentProperty("80","lastName"),"Simon");
    }

    @Test(description = "Test02 - Create New Student")
    @Description("This Test Create a New Student and Verifies it")
    public static void Test02_CreateNewStudent(){
        ApiFlows.postStudent("Almog","Noach","almog81@gmail.com","Full Stack Automation");
        String id = ApiFlows.getStudentId("Almog");
        Verifications.verifyText(ApiFlows.getStudentProperty(id,"firstName"),"Almog");
        Verifications.verifyText(ApiFlows.getStudentProperty(id,"lastName"),"Noach");
    }
    @Test(description = "Test03 - Update Courses in Student")
    @Description("This Test Update Courses in Student and Verifies it")
    public static void Test03_UpdateCorsesInStudent(){
        String id = ApiFlows.getStudentId("Almog");

        List<String>  coursesList = new ArrayList<String>();
        coursesList.add("Java Course");
        coursesList.add("CSharp Course");
        coursesList.add("Python Course");
        coursesList.add("KUKU course");

        ApiFlows.putCourses(id,coursesList);
        List<String> result = ApiFlows.getStudentCourses(id);
        Verifications.verifyEqualsList(coursesList,result);
    }

    @Test(description = "Test04 - Delete a Student")
    @Description("This Test Delete Student and Verifies it")
    public static void Test04_DeleteStudent(){
        String id = ApiFlows.getStudentId("Almog");
        ApiFlows.deleteStudent(id);

        id = ApiFlows.getStudentId("Almog");
        Verifications.verifyText(id,"Not Fond!");
    }

}
