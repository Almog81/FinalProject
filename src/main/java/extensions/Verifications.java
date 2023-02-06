package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    /*
    Method Name: verifyTextInElement
    Method Description: This method verifies the text in a given web element.
    Method Parameters: WebElement elem - the web element to be verified, String expected - the expected text of the web element.
    Method Return: None
     */
    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    /*
    Method Name: verifyTextElementIsDisplayed
    Method Description: This method verifies that a given web element is displayed.
    Method Parameters: WebElement elem - the web element to be verified
    Method Return: None
     */
    @Step("Verify Text Is Displayed")
    public static void verifyTextElementIsDisplayed(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    /*
    Method Name: verifyNumberOfElements
    Method Description: This method verifies the number of elements in a given list of web elements.
    Method Parameters: List<WebElement> elements - the list of web elements to be verified, int expected - the expected number of elements in the list.
    Method Return: None
     */
    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<WebElement> elements, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1)));
        assertEquals(elements.size(), expected);
    }

    /*
    Method Name: visibilityOfElements
    Method Description: This method verifies that all elements in a given list are displayed using soft assertion.
    Method Parameters: List<WebElement> elems - the list of web elements to be verified
    Method Return: None
     */
    @Step("Verify visibility Of Elements (Soft Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry" + elem.getText() + "not displayed");
        }
        softAssert.assertAll("some Elements were not displayed");
    }

    /*
    Method Name: verifyVisualElement
    Method Description: This method verifies that a visual element is present (Using Sikuli).
    Method Parameters: String imageName - the name of the image file to be verified
    Method Return: None
     */
    @Step("Verify visibility Of Picture")
    public static void verifyVisualElement(String imageName) {
        try {
            screen.find(getData("ImageRepo") + imageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error Comparing image file: " + e);
            fail("Error Comparing image file: " + e);
        }
    }

    /*
    Method Name: verifyText
    Method Description: This method verifies that two strings are equal.
    Method Parameters: String actual - the actual string, String expected - the expected string.
    Method Return: None
     */
    @Step("Verify Text With Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    /*
    Method Name: verifyNumbers
    Method Description: This method verifies that two integers are equal.
    Method Parameters: int actual - the actual integer, int expected - the expected integer
    Method Return: None
     */
    @Step("Verify Numbers")
    public static void verifyNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }

    /*
    Method Name: verifyEmptyList
    Method Description: This method verifies that a given list of web elements is empty.
    Method Parameters: List<WebElement> elements - the list of web elements to be verified
    Method Return: None
     */
    @Step("Verify Empty List")
    public static void verifyEmptyList(List<WebElement> elements){
        assertEquals(elements.size(), 0);
    }

    /*
    Method Name: verifyEqualsList
    Method Description: This method verifies that two given lists of strings are equal.
    Method Parameters: List<String> expected - the expected list of strings, List<String> result - the actual list of strings.
    Method Return: None
     */
    @Step("Verify Equals List")
    public static void verifyEqualsList(List<String> expected, List<String> result){
        for (int i =0; i< expected.size(); i++) {
            assertEquals(result.get(i),expected.get(i)) ;
        }
    }



}
