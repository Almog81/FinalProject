package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeeListPage {

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding>.oxd-text.oxd-text--span")
    public WebElement numberOfList;

    @FindBy(css = ".oxd-pagination-page-item.oxd-pagination-page-item--previous-next")
    public WebElement btn_nextPage;
    @FindBy(xpath = "//*/div[@class=\"oxd-table-card\"]")
    public List<WebElement> listOfEmployees;

    @FindBy(xpath = "//*/div[@class=\"oxd-table-card\"]/div/div[3]/div")
    public List<WebElement> employeesNames;

    @FindBy(css = ".oxd-autocomplete-wrapper")
    public WebElement txt_searchName;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    public WebElement btn_search;

    @FindBy(css = ".oxd-icon.bi-trash")
    public WebElement deleteIcon;




    //After click on delete employee
    @FindBy(xpath = "//*/button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")
    public WebElement btn_yes;

    @FindBy(xpath = "//*/button[@class=\"oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin\"]")
    public WebElement btn_no;

}
