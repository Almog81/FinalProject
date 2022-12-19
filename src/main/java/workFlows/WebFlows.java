package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {
    @Step("Business Flow: Login")
    public static void loginAction(String userName, String password){
        UIActions.updateText(orangeHRMLogin.txt_username, userName);
        UIActions.updateText(orangeHRMLogin.txt_password, password);
        UIActions.click(orangeHRMLogin.btn_Login);
    }
    @Step("Business Flow: Select From Page Menu")
    public static void selectFromPageMenu(WebElement elem1, WebElement elem2){
        UIActions.museHover(elem1);
        UIActions.museHover(elem2);
    }
    @Step("Business Flow: Create New Employee")
    public static void createNewEmployee(String firstName, String lastName,String userName,String pass){
        UIActions.click(orangeHRMPIMMenu.link_AddEmployee);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_firstName, firstName);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_lastName, lastName);
        UIActions.museHover(orangeHRMAddNewEmployee.switch_loginInfo);
        UIActions.click(orangeHRMAddNewEmployee.switch_loginInfo);

        UIActions.updateText(orangeHRMAddNewEmployee.txt_userName, userName);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_pass1, pass);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_pass2, pass);
        UIActions.click(orangeHRMAddNewEmployee.btn_save);
    }
    @Step("Business Flow: Delete Employee")
    public static void deleteEmployee(String firstName){
        List<WebElement> employeeList = driver.findElements(By.xpath("//*/div[@class=\"oxd-table-card\"]/div/div[3]/div"));
        for (int i = 1 ; i <= employeeList.size(); i++){
            if (employeeList.get(i-1).getText().equals(firstName))
                UIActions.click(driver.findElement(By.xpath("//*/div[@class=\"oxd-table-card\"][" + i +"]/div/div[9]/div/button[1]")));
        }
        UIActions.click(orangeHRMEmployeeListPage.btn_yes);
    }
    @Step("Business Flow: Search And Verify Menu Option")
    public static void searchAndVerify(String textToSearch, String expected){
        UIActions.setSearch(textToSearch);
        if (expected.equalsIgnoreCase("null"))
            Verifications.verifyEmptyList(orangeHRMLeftMenuPage.Menu);
        else
            Verifications.verifyTextInElement(orangeHRMLeftMenuPage.Menu.get(0),expected);
    }

    //From Old Test
    @Step("Select Menu option")
    public static void selectMenuOption(String menu){
        UIActions.setSearch(menu);
        UIActions.click(orangeHRMLeftMenuPage.Menu.get(0));
    }


}