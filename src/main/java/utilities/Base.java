package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.UnitConverter.MainPage;
import pageObjects.orangeHRM.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static JavascriptExecutor js;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String PlatformName;
    protected static String Environment;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    protected static TouchAction touchAction;

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    //Page Objects - Web
    protected static LoginPage orangeHRMLogin;
    protected static LeftMenuPage orangeHRMLeftMenuPage;
    protected static AdminMenu orangeHRMAdminMenu;
    protected static AdminUserPage orangeHRMAdminUserPage;
    protected static PIMMenu orangeHRMPIMMenu;
    protected static AddNewEmployee orangeHRMAddNewEmployee;
    protected static EmployeeListPage orangeHRMEmployeeListPage;


    //Page Objects - Mobile
    protected static MainPage UnitConverterMain;

    //Page Objects - Electron
    protected static pageObjects.TodoList.MainPage todoMain;

    //Page Objects - Desktop
    protected static pageObjects.Calculator.MainPage calcMain;


}
