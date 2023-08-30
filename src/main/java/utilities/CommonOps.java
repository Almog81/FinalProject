package utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
    Method Name: getData
    Method Description: This Method get the data from XML configuration file
    Method Parameters: String - The node Name
    Method Return: String - Value of the node
    */
    public static String getData(String nodeName){
        File fxmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " +  e);
        }
            assert doc != null;
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /*
    Method Name: initBrowser
    Method Description: Initializes the WebDriver for the specified browser.
    Method Parameters: browserType (String) - The type of browser (Chrome, Firefox, or Internet Explorer) to initialize.
    Method Return: None
    */
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        if (Environment.equalsIgnoreCase("local"))
            driver.get(getData("Local-URL"));
        else if (Environment.equalsIgnoreCase("Online"))
            driver.get(getData("Online-URL"));
        ManagePages.initOrangeHRM();
    }

    /*
    Method Name: initChromeDriver
    Method Description: Initializes the Chrome Driver.
    Method Parameters: None
    Method Return: driver (WebDriver) - The instance of the Chrome driver.
    */
    private static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    Method Name: initFirefoxDriver
    Method Description: Initializes the Firefox Driver.
    Method Parameters: None
    Method Return: driver (WebDriver) - The instance of the Firefox driver.
    */
    private static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /*
    Method Name: initIEDriver
    Method Description: Initializes the Internet Explorer Driver.
    Method Parameters: None
    Method Return: driver (WebDriver) - The instance of the Internet Explorer driver.
    */
    private static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /*
    Method Name: initMobile
    Method Description: Initializes the Mobile Driver for Android.
    Method Parameters: None
    Method Return: None
    */
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not connect to Appium Server.see details:" + e);
        }
        ManagePages.initUnitConvertor();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        touchAction = new TouchAction<>(mobileDriver);
        js = (JavascriptExecutor) driver;
    }

    /*
    Method Name: initAPI
    Method Description: Initializes the API for REST calls.
    Method Parameters: None
    Method Return: None
    */
    public static void  initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("Api_UserName"),getData("Api_Password"));
    }

    /*
    Method Name: initElectron
    Method Description: Initializes the Electron driver for the specified application.
    Method Parameters: None
    Method Return: None
    */
    public static void  initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        ManagePages.initTodoList();
    }

    /*
    Method Name: initDesktop
    Method Description: Initializes the Windows Desktop Driver for the specified application.
    Method Parameters: None
    Method Return: None
    */
    public static void  initDesktop(){
        dc.setCapability("app",getData("DesktopAppPath"));
        try {
            driver = new WindowsDriver(new URL(getData("DesktopServer")),dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to the Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        ManagePages.initCalculator();
    }

    /*
    Method Name: startSession
    Method Description: Start a session for the specified platform (web, mobile, API, Electron, or Desktop).
    Method Parameters: platform (String) - The type of platform to start a session for. environment (String) - The type of environment (local or online).
    Method Return: None
    */
    @BeforeClass
    @Parameters({"PlatformName","environment"})
    public static void startSession(String platform, String environment) {
        PlatformName = platform;
        Environment = environment;
        if(PlatformName.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (PlatformName.equalsIgnoreCase("mobile"))
            initMobile();
        else if (PlatformName.equalsIgnoreCase("api"))
            initAPI();
        else if (PlatformName.equalsIgnoreCase("electron"))
            initElectron();
        else if (PlatformName.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid Platform Name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("dbURL"),getData("dbUserName"),getData("dbPassword"));
    }

    /*
    Method Name: closeSession
    Method Description: Closes the active session, Depending on the platform.
    Method Parameters: None
    Method Return: None
     */
    @AfterClass
    public static void closeSession(){
        if (!PlatformName.equalsIgnoreCase("api")){
            if(!PlatformName.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    /*
    Method Name: saveScreenshot
    Method Description: This method takes a screenshot of the current page and saves it as a png image.
    Method Parameters: None
    Method Return: A byte array representing the screenshot image.
     */
    @Attachment(value = "Page Screen-Shot",type = "image/png")
    public byte[] saveScreenshot(){
        System.out.println("Start Screenshot");
        ManageDB.closeConnection();
        if(!PlatformName.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
