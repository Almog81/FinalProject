package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.ElectronFlows;
@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - create New Task")
    @Description("This Test create New Task and verifies it in The list task")
    public void Test01_createNewTask(){
        int listSize = ElectronFlows.getTaskListSize();
        ElectronFlows.createNewTask("Test 01 - create");
        Verifications.verifyNumbers(ElectronFlows.getTaskListSize(),listSize + 1);
    }

    @Test(description = "Test02 - delete a Task")
    @Description("This Test delete Task and verifies it in The list task")
    public void Test02_deleteTask(){
        int listSize = ElectronFlows.getTaskListSize();
        ElectronFlows.createNewTask("Test 02 - delete");
        ElectronFlows.deleteTask(todoMain.list_taskList.get(0));
        Verifications.verifyNumbers(ElectronFlows.getTaskListSize(),listSize);
    }

    @Test(description = "Test03 - complete task")
    @Description("This Test create 5 Tasks and verifies it in The list task")
    public void Test03_completeTask() throws InterruptedException {
        ElectronFlows.createNumberOfTasks(5);
        ElectronFlows.toggleTask(ElectronFlows.findTaskByName("Task 02"));
        Verifications.verifyNumbers(ElectronFlows.getCompletedTaskListSize() ,1);
        ElectronFlows.emptyTaskList();
    }
}
