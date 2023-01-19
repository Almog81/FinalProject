package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeeListPage {

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding>.oxd-text.oxd-text--span")
    public WebElement numberOfList;
    @FindBy(xpath = "//*/div[@class=\"oxd-table-card\"]")
    public List<WebElement> listOfEmployees;

    @FindBy(xpath = "//*/div[@class=\"oxd-table-card\"]/div/div[3]/div")
    public List<WebElement> employeesNames;

    @FindBy(xpath = "//*/div[@class=\"oxd-table-card\"]/div/div[3]/div")
    public List<WebElement> txt_searchName;

    @FindBy(xpath = "i[class=\"oxd-icon bi-trash\"]")
    public List<WebElement> deleteIcon;




    //After click on delete employee
    @FindBy(xpath = "//*/button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")
    public WebElement btn_yes;

    @FindBy(xpath = "//*/button[@class=\"oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin\"]")
    public WebElement btn_no;

}
