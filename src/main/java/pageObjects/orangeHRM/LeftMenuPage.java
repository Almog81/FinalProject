package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenuPage {
    @FindBy(className = "oxd-brand-banner")
    public WebElement logoBanner;

    @FindBy(css = "*>input[placeholder='Search']")
    public WebElement searchInput;

    @FindBy(css = ".oxd-main-menu>li>a>span")
    public List<WebElement> Menu;

    @FindBy(className = "oxd-main-menu")
    public List<WebElement> listMenu;

    @FindBy(xpath = "//*/span[text()='Admin']")
    public WebElement btn_Admin;

    @FindBy(xpath = "//*/span[text()='PIM']")
    public WebElement btn_PIM;

    @FindBy(xpath = "//*/span[text()='My Info']")
    public WebElement btn_MyInfo;

}