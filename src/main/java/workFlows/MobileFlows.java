package workFlows;

import extensions.MobileAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.CommonOps;


import java.util.List;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: insert Number")
    public static void insertNumber(String value){
        UnitConverterMain.txt_input.click();
        String[] numbers =  value.split("");
        for (String num:numbers) {
            mobileDriver.findElement(By.xpath("//*[@text='" + num + "']")).click();
            }
        UnitConverterMain.btn_OK.click();
    }

    @Step("Business Flow: Select Unit from list")
    public static void selectUnit(String unit){
        UnitConverterMain.selector_Unit.click();
        mobileDriver.findElement(By.xpath("//*[@text='" + unit +"']")).click();
    }

    @Step("Business Flow: Select Unit and insert value")
    public static void calculateValue(String unit,String value){
        selectUnit(unit);
        insertNumber(value);
    }

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
