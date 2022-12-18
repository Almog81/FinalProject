package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.DatabaseFlows;
import workFlows.WebFlows;


@Listeners(utilities.Listeners.class)
public class OrangeHRMWebDB extends CommonOps {

    @Test(description = "Test01 - login to orangeHRM with DB")
    @Description("This Test login with DB and verifies the logo")
    public void Test01_loginDB(){
        DatabaseFlows.loginDB();
        Verifications.verifyTextElementIsDisplayed(orangeHRMLeftMenuPage.logoBanner);
    }


}
