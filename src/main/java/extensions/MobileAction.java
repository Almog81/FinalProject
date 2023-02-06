package extensions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;

public class MobileAction extends CommonOps {

    /*
    Method Name: updateText
    Method Description: This method updates the text of a MobileElement
    Method Parameters: MobileElement elem - The mobile element to be updated, String text - The text to be entered
    Method Return: None
     */
    @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    /*
    Method Name: tap
    Method Description: This method performs a tap action on a MobileElement
    Method Parameters: MobileElement elm - The mobile element to be tapped
    Method Return: None
     */
    @Step("Tap on Element")
    public static void tap(MobileElement elm){
        wait.until(ExpectedConditions.elementToBeClickable(elm));
        touchAction.tap(new TapOptions()
                .withElement(ElementOption.element(elm)))
                .perform();
    }

    /*
    Method Name: swipe
    Method Description: This method performs a swipe action in a specified direction
    Method Parameters: Direction dir - The direction of the swipe (DOWN, UP, LEFT, RIGHT)
    Method Return: void
     */
    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    /*
    Method Name: zoom
    Method Description: A method that performs the zoom action on a MobileElement.
    Method Parameters: MobileElement elem.
    Method Return: None.
     */
    @Step("Zoom Element")
    public static void zoom(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() /2;
        int y = elem.getLocation().getX() + elem.getSize().getWidth() /2;
        TouchAction finger1 = new TouchAction<>(mobileDriver);
        finger1.press(new ElementOption()
                .withElement(elem).withCoordinates(x,y-10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x,y-100));

        TouchAction finger2 = new TouchAction<>(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(elem).withCoordinates(x,y+10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x,y+100));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    /*
    Method Name: pinch
    Method Description: This method performs a pinch gesture on the given MobileElement.
    Method Parameters: MobileElement elem
    Method Return: None
     */
    @Step("Pinch")
    public static void pinch(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() /2;
        int y = elem.getLocation().getX() + elem.getSize().getWidth() /2;
        TouchAction finger1 = new TouchAction<>(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(elem).withCoordinates(x,y-100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x,y-10));

        TouchAction finger2 = new TouchAction<>(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(elem).withCoordinates(x,y+100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x,y+10));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    /*
    Method Name: dragAndDrop
    Method Description: This method performs a drag and drop gesture on two given MobileElement.
    Method Parameters: MobileElement start, MobileElement finish
    Method Return: None
     */
    @Step("Drag And Drop")
    public static void dragAndDrop(MobileElement start, MobileElement finish) {
        touchAction.press(new ElementOption()
                        .withElement(start))
                .moveTo(new ElementOption().withElement(finish))
                .release()
                .perform();
    }

    /*
    Method Name: longPress
    Method Description: This method performs a long press gesture on the given MobileElement.
    Method Parameters: MobileElement elem, int duration
    Method Return: None
     */
    @Step("Long Press")
    public static void longPress(MobileElement elem, int duration) {
        touchAction.longPress(new LongPressOptions()
                        .withElement(ElementOption.element(elem))
                        .withDuration(Duration.ofSeconds(duration)))
                .perform();
    }


    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
