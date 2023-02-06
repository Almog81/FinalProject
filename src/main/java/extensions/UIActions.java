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
    /*
    Method Name: click
    Method Description: The method is used to click on an element.
    Method Parameters: WebElement elem
    Method Return: None
     */
    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.click();
    }

    /*
    Method Name: updateText
    Method Description: The method updates text on an element.
    Method Parameters: WebElement elem, String text
    Method Return: None
     */
    @Step("Update Text Element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.sendKeys(text);
    }

    /*
    Method Name: updateTextHuman
    Method Description: The method updates text on an element character by character.
    Method Parameters: WebElement elem, String text
    Method Return: None
     */
    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        for (char ch:text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch +"");
        }
    }

    /*
    Method Name: updateDropDown
    Method Description: The method updates a dropdown element by selecting a value by visible text.
    Method Parameters: WebElement elem, String text
    Method Return: None
     */
    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    /*
    Method Name: museHover
    Method Description: The method performs a mouse hover action on an element.
    Method Parameters: WebElement elem
    Method Return: None
     */
    @Step("Muse Hover on Element")
    public static void museHover(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).click().build().perform();
    }

    /*
    Method Name: setSearch
    Method Description: The method updates the search input field with a text value.
    Method Parameters: String text
    Method Return: None
     */
    @Step("Search for Menu Option")
    public static void setSearch(String text){
        UIActions.updateText(orangeHRMLeftMenuPage.searchInput, text);
    }

    /*
    Method Name: sendKeysAction
    Method Description: The method sends keys to an element.
    Method Parameters: WebElement elem, Keys value
    Method Return: None
     */
    @Step("Send Keys to Element")
    public static void sendKeysAction(WebElement elem, Keys value){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.sendKeys(value);
    }

    /*
    Method Name: refreshAction
    Method Description: The method refreshes the current page.
    Method Parameters: None
    Method Return: None
     */
    @Step("Refresh The Current Page")
    public static void refreshAction(){
        driver.navigate().refresh();
    }
}
