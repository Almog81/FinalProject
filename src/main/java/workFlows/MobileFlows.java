package workFlows;

import extensions.MobileAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.CommonOps;


import java.util.List;

public class MobileFlows extends CommonOps {

    /*
    Method Name: insertNumber
    Method Description: This method inputs a number as a string in the text field of the Unit Converter.
    Method Parameters: value - A string representing the number to be inputted.
    Method Return: None
     */
    @Step("Business Flow: insert Number")
    public static void insertNumber(String value){
        UnitConverterMain.txt_input.click();
        String[] numbers =  value.split("");
        for (String num:numbers) {
            mobileDriver.findElement(By.xpath("//*[@text='" + num + "']")).click();
            }
        UnitConverterMain.btn_OK.click();
    }

    /*
    Method Name: selectUnit
    Method Description: This method selects a unit from the unit list.
    Method Parameters: unit - A string representing the name of the unit to be selected.
    Method Return: None
     */
    @Step("Business Flow: Select Unit from list")
    public static void selectUnit(String unit){
        UnitConverterMain.selector_Unit.click();
        mobileDriver.findElement(By.xpath("//*[@text='" + unit +"']")).click();
    }

    /*
    Method Name: calculateValue
    Method Description: This method selects a unit and inputs a number for calculation.
    Method Parameters: unit - A string representing the name of the unit to be selected, value - A string representing the number to be inputted.
    Method Return: None
     */
    @Step("Business Flow: Select Unit and insert value")
    public static void calculateValue(String unit,String value){
        selectUnit(unit);
        insertNumber(value);
    }

    /*
    Method Name: getValue
    Method Description: This method returns the value of a selected unit.
    Method Parameters: kind - A string representing the name of the unit.
    Method Return: A string representing the value of the selected unit.
     */
    @Step("Business Flow: Get Value of Selected Unit")
    public static String getValue(String kind){
        int index = 0;
        for (int i = 0; i < UnitConverterMain.list_Unit.size(); i++){
            if (UnitConverterMain.list_Unit.get(i).getText().equals(kind))
                index = i;
        }
        return UnitConverterMain.list_value.get(index).getText();
    }
}
