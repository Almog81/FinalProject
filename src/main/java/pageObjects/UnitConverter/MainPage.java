package pageObjects.UnitConverter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "button2")
    public AndroidElement btn_notNow;

    @AndroidFindBy(xpath = "//*[contains(@id, 'input')]")
    public AndroidElement txt_input;

    @AndroidFindBy(xpath = "//*[contains(@id, 'selector')]")
    public AndroidElement selector_Unit;

    @AndroidFindBy(id = "unit_kind")
    public List<AndroidElement> list_Unit;

    @AndroidFindBy(id = "unit_value")
    public List<AndroidElement> list_value;

    //Num Pade
    @AndroidFindBy(xpath = "//*[contains(@id, 'numok')]")
    public AndroidElement btn_OK;

}
