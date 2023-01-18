package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.DatabaseFlows;
import workFlows.WebFlows;


@Listeners(utilities.Listeners.class)
public class OrangeHRMWebOnline extends CommonOps {

    @Test(description = "Test01 - verify Logo")
    @Description("This Test login and verifies the logo")
    public void Test01_verifyLogo(){
        if (Location.equalsIgnoreCase("online"))
            WebFlows.loginAction(getData("UserName"),getData("Password"));
        else if (Location.equalsIgnoreCase("local")) {
            DatabaseFlows.loginDB();
        }
        Verifications.verifyTextElementIsDisplayed(orangeHRMLeftMenuPage.logoBanner);
    }


}
