package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeeListPage {

    @FindBy(css = ".orangehrm-horizontal-padding>.oxd-text")
    public WebElement numberOfList;

    @FindBy(css = ".oxd-table-card")
    public List<WebElement> listOfEmployees;

    @FindBy(css = ".oxd-autocomplete-wrapper")
    public WebElement txt_searchName;

    @FindBy(css = ".orangehrm-left-space")
    public WebElement btn_search;

    @FindBy(css = ".oxd-icon.bi-trash")
    public WebElement deleteIcon;




    //After click on delete employee
    @FindBy(css = ".oxd-button--label-danger.orangehrm-button-margin")
    public WebElement btn_yes;

    @FindBy(xpath = ".oxd-button--text.orangehrm-button-margin")
    public WebElement btn_no;

}
