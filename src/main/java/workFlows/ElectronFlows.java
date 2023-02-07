package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    /*
    Method Name: createNewTask
    Method Description: This method creates a new task in the Todo_list application.
    Method Parameters: taskName (String) - name of the task to be created.
    Method Return: None.
     */
    @Step("Business Flow: create New Task")
    public static void createNewTask(String taskName){
        UIActions.updateText(todoMain.txt_CreateTask, taskName);
        UIActions.sendKeysAction(todoMain.txt_CreateTask, Keys.ENTER);
    }

    /*
    Method Name: createNumberOfTasks
    Method Description: This method creates multiple tasks in the Todo_list application.
    Method Parameters: taskNumber (int) - number of tasks to be created.
    Method Return: None.
     */
    @Step("Business Flow: create Number of Tasks")
    public static void createNumberOfTasks(int taskNumber){
        for (int i = 1; i<taskNumber ; i++)
            ElectronFlows.createNewTask("Task 0" + i);
    }

    /*
    Method Name: getTaskListSize
    Method Description: This method returns the size of the task list, which is the number of tasks present in the Todo_list.
    Method Parameters: None.
    Method Return: int - number of tasks in the task list.
    */
    @Step("Business Flow: get Task List Size")
    public static int getTaskListSize(){
        return todoMain.list_taskList.size();
    }

    /*
    Method Name: getCompletedTaskListSize
    Method Description: This method returns the size of the completed task list, which is the number of completed tasks present in the Todo_list.
    Method Parameters: None.
    Method Return: int - number of completed tasks in the completed task list.
     */
    @Step("Business Flow: get Completed Task List Size")
    public static int getCompletedTaskListSize(){
        return todoMain.list_finishTasks.size();
    }

    /*
    Method Name: emptyTaskList
    Method Description: This method deletes all the tasks in the Todo_list application.
    Method Parameters: None.
    Method Return: None.
     */
    @Step("Business Flow: Empty The Task List")
    public static void emptyTaskList(){
        int size = todoMain.list_taskList.size();
        for (int i = 0; i < size; i++)
            deleteTask(todoMain.list_taskList.get(0));
    }

    /*
    Method Name: deleteTask
    Method Description: This method deletes a task in the Todo_list application.
    Method Parameters: elem (WebElement) - WebElement representing the task to be deleted.
    Method Return: None.
     */
    @Step("Business Flow: delete a Task")
    public static void deleteTask(WebElement elem){
        UIActions.museHover(elem.findElement(By.className("destroy_19w1q")));
    }

    /*
    Method Name: toggleTask
    Method Description: This method marks a task as completed in the Todo_list application.
    Method Parameters: elem (WebElement) - WebElement representing the task to be marked as completed.
    Method Return: None.
     */
    @Step("Business Flow: toggle a Task")
    public static void toggleTask(WebElement elem){
        UIActions.museHover(elem.findElement(By.className("toggleIconsWrapper_2kpi8")));
    }

    /*
    Method Name: findTaskByName
    Method Description: This method finds a task in the Todo_list application.
    Method Parameters: name (String) - name of the task to be found.
    Method Return: WebElement - WebElement representing the found task.
     */
    @Step("Business Flow: Find Task By Name")
    public static WebElement findTaskByName(String name){
        int x = 0;
        for (int i = 0; i<todoMain.list_taskNames.size(); i++)
            if (todoMain.list_taskNames.get(i).getText().equalsIgnoreCase(name))
                x = i;
        return todoMain.list_taskList.get(x);
    }

}
