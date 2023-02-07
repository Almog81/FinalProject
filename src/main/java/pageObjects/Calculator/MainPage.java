package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    //Numbers
    @FindBy(xpath = "//*[@AutomationId='num0Button']")
    public WebElement btn_num0;

    @FindBy(xpath = "//*[@AutomationId='num1Button']")
    public WebElement btn_num1;

    @FindBy(xpath = "//*[@AutomationId='num2Button']")
    public WebElement btn_num2;

    @FindBy(xpath = "//*[@AutomationId='num3Button']")
    public WebElement btn_num3;

    @FindBy(xpath = "//*[@AutomationId='num4Button']")
    public WebElement btn_num4;

    @FindBy(xpath = "//*[@AutomationId='num5Button']")
    public WebElement btn_num5;

    @FindBy(xpath = "//*[@AutomationId='num6Button']")
    public WebElement btn_num6;

    @FindBy(xpath = "//*[@AutomationId='num7Button']")
    public WebElement btn_num7;

    @FindBy(xpath = "//*[@AutomationId='num8Button']")
    public WebElement btn_num8;

    @FindBy(xpath = "//*[@AutomationId='num9Button']")
    public WebElement btn_num9;

    //Actions
    @FindBy(xpath = "//*[@AutomationId='plusButton']")
    public WebElement btn_plus;

    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    public WebElement btn_multiply;

    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    public WebElement btn_divide;

    @FindBy(xpath = "//*[@AutomationId='minusButton']")
    public WebElement btn_minus;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    public WebElement btn_equal;

    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    public WebElement btn_clear;

    //Result
    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;


}