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

    /*
    Method Name: insertNumbers
    Method Description: This method clicks on the respective number buttons in the calculator app.
    Method Parameters: value (String) - The string to be split into individual numbers.
    Method Return: None.
     */
    @Step("Business Flow: Insert Number")
    public static void insertNumbers(String value){
        String[] numbers = value.split("");
        for (String num:numbers) {
            UIActions.click(driver.findElement(By.xpath("//*[@AutomationId='num" + num +"Button']")));
        }
    }

    /*
    Method Name: numberPlusNumber
    Method Description: This method performs a calculation plus action of two numbers.
    Method Parameters: num1 (String) - The first number, num2 (String) - The second number.
    Method Return: None.
     */
    @Step("Business Flow: Number plus Number")
    public static void numberPlusNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_plus);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

    /*
    Method Name: numberMinusNumber
    Method Description: This method performs a calculation Minus action of two numbers.
    Method Parameters: num1 (String) - The first number, num2 (String) - The second number.
    Method Return: None.
     */
    @Step("Business Flow: Number Minus Number")
    public static void numberMinusNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_minus);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

    /*
    Method Name: numberDivideNumber
    Method Description: This method performs a calculation Divide action of two numbers.
    Method Parameters: num1 (String) - The first number, num2 (String) - The second number.
    Method Return: None.
     */
    @Step("Business Flow: Number Divide Number")
    public static void numberDivideNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_divide);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

    /*
    Method Name: numberMultiplyNumber
    Method Description: This method performs a calculation Multiply action of two numbers.
    Method Parameters: num1 (String) - The first number, num2 (String) - The second number.
    Method Return: None.
     */
    @Step("Business Flow: Number Multiply Number")
    public static void numberMultiplyNumber(String num1, String num2){
        UIActions.click(calcMain.btn_clear);
        insertNumbers(num1);
        UIActions.click(calcMain.btn_multiply);
        insertNumbers(num2);
        UIActions.click(calcMain.btn_equal);
    }

}
