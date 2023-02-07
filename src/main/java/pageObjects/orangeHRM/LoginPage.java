package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy(name = "username")
    public WebElement txt_username;

    @FindBy(name = "password")
    public WebElement txt_password;

    @FindBy(className = "oxd-button")
    public WebElement btn_Login;
}
