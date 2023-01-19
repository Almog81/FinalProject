package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewEmployee {
    @FindBy(css = "input[name='firstName']")
    public WebElement txt_firstName;

    @FindBy(css = "input[name='lastName']")
    public WebElement txt_lastName;

    @FindBy(css = ".oxd-switch-wrapper")
    public WebElement switch_loginInfo;

    @FindBy(xpath = "//*/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    public WebElement txt_userName;

    @FindBy(xpath = "//*/div[1]/div/div[2]/input[@type='password']")
    public WebElement txt_pass1;

    @FindBy(xpath = "//*/div[2]/div/div[2]/input[@type='password']")
    public WebElement txt_pass2;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement btn_save;
    //חסר כפתור


}
