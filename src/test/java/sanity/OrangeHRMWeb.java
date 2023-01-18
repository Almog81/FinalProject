package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.DatabaseFlows;
import workFlows.WebFlows;

import javax.swing.text.Utilities;


@Listeners(utilities.Listeners.class)
public class OrangeHRMWeb extends CommonOps {

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

    @Test(description = "Test02 - Verify Default Users")
    @Description("This Test verifies Default Users")
    public void Test02_verifyDefaultUsers(){
        UIActions.museHover(orangeHRMLeftMenuPage.btn_Admin);
        WebFlows.selectFromPageMenu(orangeHRMAdminMenu.btn_UserManagement, orangeHRMAdminMenu.link_Users);
        Verifications.verifyNumberOfElements(orangeHRMAdminUserPage.listOfUsers, 1);
    }

    @Test(description = "Test03 - Create New Employee")
    @Description("This Test Create New Employee and verifies the new number of Employees")
    public void Test03_CreateNewEmployee(){
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        WebFlows.createNewEmployee("Sam", "One", "SamOne80","So!1qaz@2wsx");
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        Verifications.verifyNumberOfElements(orangeHRMEmployeeListPage.listOfEmployees, 2);
    }

    @Test(description = "Test04 - Delete Employee")
    @Description("This Test verifies The deletion of a Employee")
    public void Test04_DeleteEmployee(){
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        WebFlows.deleteEmployee("Sam");
        UIActions.museHover(orangeHRMLeftMenuPage.btn_PIM);
        Verifications.verifyNumberOfElements(orangeHRMEmployeeListPage.listOfEmployees, 1);
    }

    @Test(description = "Test05 - Verify Menu Elements")
    @Description("This Test verifies The default menu element are displayed (Using soft assertion)")
    public void Test05_verifyMenuElements(){
        Verifications.visibilityOfElements(orangeHRMLeftMenuPage.listMenu);
    }

    @Test(description = "Test06 - Verify Avatar Image")
    @Description("This Test verifies The Avatar image of the Admin, Using Sikuli tool")
    public void Test06_verifyAvatarImage(){
        Verifications.verifyVisualElement("PaulAvatar");
    }

    @Test(description = "Test07 - Verify Search Menu Factuality", dataProvider = "DataProvider-Search", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test verifies The Search Factuality, Using Data Driving Test")
    public void Test07_verifySearchMenuFactuality(String text, String expected){
        driver.navigate().refresh();
        WebFlows.searchAndVerify(text, expected);
    }

}
