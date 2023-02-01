package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;


public class WebFlows extends CommonOps {
    @Step("Business Flow: Login")
    public static void loginAction(){
        if (Location.equalsIgnoreCase("online"))
            WebFlows.onlineLogin(getData("UserName"),getData("Password"));
        else if (Location.equalsIgnoreCase("local")) {
            DatabaseFlows.loginDB();
        }
    }
    @Step("Business Flow: Online Login")
    public static void onlineLogin(String userName, String password){
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
        UIActions.click(orangeHRMAddNewEmployee.switch_loginInfo);
        createLoginDetails(userName,pass);
        UIActions.click(orangeHRMAddNewEmployee.btn_save);
        }
    @Step("Business Flow: Create Login Details")
    public static void createLoginDetails(String userName,String pass){
        try {
        UIActions.updateText(orangeHRMAddNewEmployee.txt_userName, userName);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_pass1, pass);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_pass2, pass);
        }
        catch(Exception e) {
            UIActions.museHover(orangeHRMAddNewEmployee.switch_loginInfo);
            createLoginDetails(userName,pass);
        }
    }
    @Step("Business Flow: Search Employee By Name")
    public static void searchEmployee(String firstName) throws InterruptedException {
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        action.moveToElement(orangeHRMEmployeeListPage.txt_searchName).click().sendKeys(firstName).build().perform();
        Thread.sleep(2000);
        UIActions.museHover(orangeHRMEmployeeListPage.btn_search);
        Thread.sleep(4000);
    }
    @Step("Business Flow: Delete Employee")
    public static void deleteEmployee(String firstName) throws InterruptedException {
        searchEmployee(firstName);
        Thread.sleep(6000);
        UIActions.museHover(orangeHRMEmployeeListPage.deleteIcon);
        UIActions.museHover(orangeHRMEmployeeListPage.btn_yes);
    }
    @Step("Business Flow: Search And Verify Menu Option")
    public static void searchAndVerify(String textToSearch, String expected){
        UIActions.setSearch(textToSearch);
        if (expected.equalsIgnoreCase("null"))
            Verifications.verifyEmptyList(orangeHRMLeftMenuPage.Menu);
        else
            Verifications.verifyTextInElement(orangeHRMLeftMenuPage.Menu.get(0),expected);
    }
    @Step("Get The number in parentheses")
    public static int getNumberInParentheses(WebElement elem){
        int start = elem.getText().indexOf('(') + 1;
        int end = elem.getText().indexOf(')');
        String result = elem.getText().substring(start,end);
        return (int) Long.parseLong(result);
    }

}
