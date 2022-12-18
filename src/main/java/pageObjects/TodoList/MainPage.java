package pageObjects.TodoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    //Input
    @FindBy(xpath = "//*[@placeholder='Create a task']")
    public WebElement txt_CreateTask;


    //Tasks
    @FindBy(className = "taskWrapper_2u8dN")
    public List<WebElement> list_taskList;

    @FindBy(how = How.XPATH, using = "//*/label[contains(@class, 'label_5i8SP')]")
    public List<WebElement> list_taskNames;

    @FindBy(how = How.XPATH, using = "//*/label[contains(@class, 'completed')]")
    public List<WebElement> list_finishTasks;

}
