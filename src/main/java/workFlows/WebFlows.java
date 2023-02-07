package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;


public class WebFlows extends CommonOps {

    /*
    Method Name: loginAction
    Method Description: This method performs a login action to OrangeHRM, depending on the environment.
    Method Parameters: None
    Method Return: None
     */
    @Step("Business Flow: Login")
    public static void loginAction(){
        if (Environment.equalsIgnoreCase("online"))
            WebFlows.onlineLogin(getData("UserName"),getData("Password"));
        else if (Environment.equalsIgnoreCase("local")) {
            DatabaseFlows.loginDB();
        }
    }

    /*
    Method Name: onlineLogin
    Method Description: This method is used to perform online login by entering the username and password.
    Method Parameters: userName (String) - The username that is to be entered, password (String) - The password that is to be entered.
    Method Return: None
     */
    @Step("Business Flow: Online Login")
    public static void onlineLogin(String userName, String password){
        UIActions.updateText(orangeHRMLogin.txt_username, userName);
        UIActions.updateText(orangeHRMLogin.txt_password, password);
        UIActions.click(orangeHRMLogin.btn_Login);
    }

    /*
    Method Name: selectFromPageMenu
    Method Description: This method is used to select an option from a page menu.
    Method Parameters: elem1 (WebElement) - The first element that is to be hovered over, elem2 (WebElement) - The second element that is to be hovered over.
    Method Return: None
     */
    @Step("Business Flow: Select From Page Menu")
    public static void selectFromPageMenu(WebElement elem1, WebElement elem2){
        UIActions.museHover(elem1);
        UIActions.museHover(elem2);
    }

    /*
    Method Name: createNewEmployee
    Method Description: This method is used to create a new employee by entering details such as first name, last name, username and password.
    Method Parameters: firstName (String) - The first name of the new employee, lastName (String) - The last name of the new employee, userName (String) - The username of the new employee. pass (String) - The password of the new employee.
    Method Return: None
     */
    @Step("Business Flow: Create New Employee")
    public static void createNewEmployee(String firstName, String lastName,String userName,String pass){
        UIActions.click(orangeHRMPIMMenu.link_AddEmployee);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_firstName, firstName);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_lastName, lastName);
        UIActions.click(orangeHRMAddNewEmployee.switch_loginInfo);
        createLoginDetails(userName,pass);
        UIActions.click(orangeHRMAddNewEmployee.btn_save);
    }

    /*
    Method Name: createLoginDetails
    Method Description: This method is used to enter login details for new employee.
    Method Parameters: userName (String) - The username of the new employee, pass (String) - The password of the new employee.
    Method Return: None
     */
    @Step("Business Flow: Create Login Details")
    public static void createLoginDetails(String userName,String pass){
        try {
        UIActions.updateText(orangeHRMAddNewEmployee.txt_userName, userName);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_password.get(0), pass);
        UIActions.updateText(orangeHRMAddNewEmployee.txt_password.get(1), pass);
        }
        catch(Exception e) {
            UIActions.museHover(orangeHRMAddNewEmployee.switch_loginInfo);
            createLoginDetails(userName,pass);
        }
    }

    /*
    Method Name: searchEmployee
    Method Description: This method is used to search for an employee by their first name.
    Method Parameters: firstName (String) : The first name of the employee that is to be searched.
    Method Return: None
     */
    @Step("Business Flow: Search Employee By Name")
    public static void searchEmployee(String firstName) throws InterruptedException {
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        action.moveToElement(orangeHRMEmployeeListPage.txt_searchName).click().sendKeys(firstName).build().perform();
        Thread.sleep(2000);
        UIActions.museHover(orangeHRMEmployeeListPage.btn_search);
        Thread.sleep(4000);
    }

    /*
    Method Name: deleteEmployee
    Method Description: This method is used to delete an employee by searching for their first name.
    Method Parameters: firstName (String) - The first name of the employee that is to be deleted.
    Method Return: None
     */
    @Step("Business Flow: Delete Employee")
    public static void deleteEmployee(String firstName) throws InterruptedException {
        searchEmployee(firstName);
        Thread.sleep(6000);
        UIActions.museHover(orangeHRMEmployeeListPage.deleteIcon);
        UIActions.museHover(orangeHRMEmployeeListPage.btn_yes);
    }

    /*
    Method Name: searchAndVerify
    Method Description: This method is used to search for a text and verify if it is present or not.
    Method Parameters: textToSearch (String) - The text that is to be searched. expected (String) - The expected text.
    Method Return: None
     */
    @Step("Business Flow: Search And Verify Menu Option")
    public static void searchAndVerify(String textToSearch, String expected){
        UIActions.setSearch(textToSearch);
        if (expected.equalsIgnoreCase("null"))
            Verifications.verifyEmptyList(orangeHRMLeftMenuPage.Menu);
        else
            Verifications.verifyTextInElement(orangeHRMLeftMenuPage.Menu.get(0),expected);
    }

    /*
    Method Name: getNumberInParentheses
    Method Description: This method is used to get a number in parentheses.
    Method Parameters: elem (WebElement) - The element that contains the number in parentheses.
    Method Return: int - The number that is present in parentheses.
     */
    @Step("Get The number in parentheses")
    public static int getNumberInParentheses(WebElement elem){
        int start = elem.getText().indexOf('(') + 1;
        int end = elem.getText().indexOf(')');
        String result = elem.getText().substring(start,end);
        return (int) Long.parseLong(result);
    }
}
