package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminUserPage {

    @FindBy(css = ".oxd-table-card")
    public List<WebElement> listOfUsers;
}
