package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddNewEmployee {
    @FindBy(css = "input[name='firstName']")
    public WebElement txt_firstName;

    @FindBy(css = "input[name='lastName']")
    public WebElement txt_lastName;

    @FindBy(css = ".oxd-switch-wrapper")
    public WebElement switch_loginInfo;

    @FindBy(xpath = "//input[@autocomplete='off']")
    public WebElement txt_userName;

    @FindBy(xpath = "//input[@type='password']")
    public List<WebElement> txt_password;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement btn_save;
}
