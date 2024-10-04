package stepdefinitions;

import org.testng.Assert;
import di.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ToDoListPage;

public class EditToDoTask {
    Context context;
    HomePage homePage;
    ToDoListPage toDoListPage;

    public EditToDoTask(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        toDoListPage = context.getToDoListPage();
    }

    @When("I double-click on the todo task")
    public void double_click_on_todo_task() {
        toDoListPage.doubleClickOnToDoTask(context.getData("todoTaskName"));
    }

    @And("I enter new todo task name {string} in edit field")
    public void enter_new_task_name(String updatedTaskName) {
        String oldTaskName = context.getData("todoTaskName");
        toDoListPage.enterNewTaskName(oldTaskName, updatedTaskName);

        //update only if new update task name is not blank
        if (!updatedTaskName.equals("")) {
            context.updateData("todoTaskName", oldTaskName, updatedTaskName);
        }
    }

    @Then("Verify that the task should name be updated")
    public void verify_task_name_updated() {
        toDoListPage.isTodoTaskPresent(context.getData("todoTaskName"));
    }

    @Then("Verify that task should not be updated")
    public void verify_task_name_not_updated() {
        Assert.assertTrue(toDoListPage.isTodoTaskPresent(context.getData("todoTaskName")), "Original task name still exists.");
    }
}
