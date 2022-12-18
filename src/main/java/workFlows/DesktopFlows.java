package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.Arrays;
import java.util.List;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Insert Number")
    public static void insertNumbers(String value){
        String[] numbers = value.split("");
        for (String num:numbers) {
            UIActions.click(driver.findElement(By.xpath("//*[@AutomationId='num" + num +"Button']")));
        }
    }

    //Actions
    @Step("Business Flow: Number plus Number")
    public static void numberPlusNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_plus);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Business Flow: Number Minus Number")
    public static void numberMinusNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_minus);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }
    @Step("Business Flow: Number Divide Number")
    public static void numberDivideNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_divide);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }
    @Step("Business Flow: Number Multiply Number")
    public static void numberMultiplyNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_multiply);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

}
