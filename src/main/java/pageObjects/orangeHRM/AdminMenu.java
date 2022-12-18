package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminMenu {

    //Menu Buttons
    @FindBy(xpath = "//*/span[text()='User Management ']")
    public WebElement btn_UserManagement;

    @FindBy(xpath = "//*/span[text()='Job ']")
    public WebElement btn_Job;

    //Links List
    @FindBy(xpath = "//*/a[text()='Users']")
    public WebElement link_Users;

    @FindBy(xpath = "//*/a[text()='Work Shifts']")
    public WebElement link_WorkShifts;

}
