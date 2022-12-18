package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMMenu {

    //Menu Buttons
    @FindBy(xpath = "//*/span[text()='Configuration ']")
    public WebElement btn_UserManagement;


    //Links List
    @FindBy(xpath = "//*/a[text()='Employee List']")
    public WebElement link_EmployeeList;

    @FindBy(xpath = "//*/a[text()='Add Employee']")
    public WebElement link_AddEmployee;

    @FindBy(xpath = "//*/a[text()='Reports']")
    public WebElement link_Reports;


}
