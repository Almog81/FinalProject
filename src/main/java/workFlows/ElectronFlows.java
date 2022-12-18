package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: create New Task")
    public static void createNewTask(String taskName){
        UIActions.updateText(todoMain.txt_CreateTask, taskName);
        UIActions.sendKeysAction(todoMain.txt_CreateTask, Keys.ENTER);
    }

    @Step("Business Flow: get Task List Size")
    public static int getTaskListSize(){
        return todoMain.list_taskList.size();
    }

    @Step("Business Flow: get Completed Task List Size")
    public static int getCompletedTaskListSize(){
        return todoMain.list_finishTasks.size();
    }


    @Step("Business Flow: Empty The Task List")
    public static void emptyTaskList(){
        int size = todoMain.list_taskList.size();
        for (int i = 0; i < size; i++)
            deleteTask(todoMain.list_taskList.get(0));
    }

    @Step("Business Flow: delete a Task")
    public static void deleteTask(WebElement elem){
        UIActions.museHover(elem.findElement(By.className("destroy_19w1q")));
    }

    @Step("Business Flow: toggle a Task")
    public static void toggleTask(WebElement elem){
        UIActions.museHover(elem.findElement(By.className("toggleIconsWrapper_2kpi8")));
    }

    @Step("Business Flow: Find Task By Name")
    public static WebElement findTaskByName(String name){
        int x = 0;
        for (int i = 0; i<todoMain.list_taskNames.size(); i++)
            if (todoMain.list_taskNames.get(i).getText().equalsIgnoreCase(name))
                x = i;
        return todoMain.list_taskList.get(x);
    }

}
