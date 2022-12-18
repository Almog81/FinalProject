package workFlows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class DatabaseFlows extends CommonOps {
    @Step("Business Flow: Login to orangeHRM with Database Credentials")
    public static void loginDB(){
        List<String> cred = DBActions.getCredentials("SELECT name,password FROM employees WHERE id='3'");
        UIActions.updateText(orangeHRMLogin.txt_username, cred.get(0));
        UIActions.updateText(orangeHRMLogin.txt_password, cred.get(1));
        UIActions.click(orangeHRMLogin.btn_Login);
    }
    //TODO More flows

}
