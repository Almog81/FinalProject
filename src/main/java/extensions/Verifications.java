package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {
    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Text Is Displayed")
    public static void verifyTextElementIsDisplayed(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<WebElement> elements, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1)));
        assertEquals(elements.size(), expected);
    }

    @Step("Verify visibility Of Elements (Soft Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry" + elem.getText() + "not displayed");
        }
        softAssert.assertAll("some Elements were not displayed");
    }

    @Step("Verify visibility Of Picture")
    public static void verifyVisualElement(String imageName) {
        try {
            screen.find(getData("ImageRepo") + imageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error Comparing image file: " + e);
            fail("Error Comparing image file: " + e);
        }
    }

    @Step("Verify Text With Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Numbers")
    public static void verifyNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Empty List")
    public static void verifyEmptyList(List<WebElement> elements){
        assertEquals(elements.size(), 0);
    }

    @Step("Verify Equals List")
    public static void verifyEqualsList(List<String> expected, List<String> result){
        for (int i =0; i< expected.size(); i++) {
            assertEquals(result.get(i),expected.get(i)) ;
        }
    }



}
