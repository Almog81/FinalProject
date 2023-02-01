package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {
    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.click();
    }
    @Step("Update Text Element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        for (char ch:text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch +"");
        }
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }
    @Step("Muse Hover on Element")
    public static void museHover(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).click().build().perform();
    }

    @Step("Search for Menu Option")
    public static void setSearch(String text){
        UIActions.updateText(orangeHRMLeftMenuPage.searchInput, text);
    }
    @Step("Send Keys to Element")
    public static void sendKeysAction(WebElement elem, Keys value){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.sendKeys(value);
    }

    @Step("Refresh The Current Page")
    public static void refreshAction(){
        driver.navigate().refresh();
    }
}
