package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.UnitConverter.MainPage;
import pageObjects.orangeHRM.*;

public class ManagePages extends Base {

    //Web Page Object
    public static void initOrangeHRM(){
        orangeHRMLogin = PageFactory.initElements(driver, pageObjects.orangeHRM.LoginPage.class);
        orangeHRMLeftMenuPage = PageFactory.initElements(driver, LeftMenuPage.class);
        orangeHRMAdminMenu = PageFactory.initElements(driver, AdminMenu.class);
        orangeHRMAdminUserPage = PageFactory.initElements(driver, AdminUserPage.class);
        orangeHRMPIMMenu = PageFactory.initElements(driver, PIMMenu.class);
        orangeHRMAddNewEmployee = PageFactory.initElements(driver, AddNewEmployee.class);
        orangeHRMEmployeeListPage = PageFactory.initElements(driver, EmployeeListPage.class);
    }

    //Mobile Page Object
    public static void initUnitConvertor(){
        UnitConverterMain = new MainPage(mobileDriver);
    }

    //Electron Page Object
    public static void initTodoList(){
        todoMain = PageFactory.initElements(driver, pageObjects.TodoList.MainPage.class);
    }

    //Desktop Page Object
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }
}
