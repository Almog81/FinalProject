package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.DesktopFlows;
import workFlows.WebFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - plus Action")
    @Description("This Test preform a Plus Action and verifies the result")
    public void Test01_plusAction(){
        DesktopFlows.numberPlusNumber("12","98");
        Verifications.verifyTextInElement(calcMain.field_result.get(4),"110");
    }
    @Test(description = "Test02 - Minus Action")
    @Description("This Test preform a Minus Action and verifies the result")
    public void Test02_MinusAction(){
        DesktopFlows.numberMinusNumber("329","150");
        Verifications.verifyTextInElement(calcMain.field_result.get(4),"179");
    }
    @Test(description = "Test03 - Multiply Action")
    @Description("This Test preform a Multiply Action and verifies the result")
    public void Test03_MultiplyAction(){
        DesktopFlows.numberMultiplyNumber("4","2");
        Verifications.verifyTextInElement(calcMain.field_result.get(4),"8");
    }
    @Test(description = "Test04 - Divide Action")
    @Description("This Test preform a Divide Action and verifies the result")
    public void Test04_plusAction(){
        DesktopFlows.numberDivideNumber("20","2");
        Verifications.verifyTextInElement(calcMain.field_result.get(4),"10");
    }

}
