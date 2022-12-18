package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.MobileFlows;
import workFlows.WebFlows;

@Listeners(utilities.Listeners.class)
public class UnitConverterMobile extends CommonOps {

    @Test(description = "Test01 - Unit convert: cm to inch")
    @Description("This Test convert a cm unit to inch")
    public void Test01_unitConvert(){
        String setValue = "10";
        String expected = "3.937008";

        MobileFlows.calculateValue("cm",setValue);
        String result =  MobileFlows.getValue("inch");

        Verifications.verifyText(result,expected);
    }

    @Test(description = "Test02 - Unit convert: inch to cm")
    @Description("This Test convert a inch unit to cm")
    public void Test02_unitConvert2(){
        String setValue = "10";
        String expected = "25.4";

        MobileFlows.calculateValue("inch",setValue);
        String result =  MobileFlows.getValue("cm");

        Verifications.verifyText(result,expected);
    }

}
