package stepdefinitions;

import org.testng.Assert;
import di.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ToDoListPage;

public class CompleteToDoTask {
    Context context;
    HomePage homePage;
    ToDoListPage toDoListPage;

    public CompleteToDoTask(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        toDoListPage = context.getToDoListPage();
    }


    @Given("I have a todo {string} in the list")
    public void verify_todo_task(String todoTaskName) {
        context.setData("todoTaskName", todoTaskName);
        homePage.enterTodoTaskName(todoTaskName);
        homePage.pressEnterKey();

        Assert.assertTrue(toDoListPage.isTodoTaskPresent(context.getData("todoTaskName")));
    }

    @When("I click the checkbox next to the todo task")
    public void click_checkbox_of_todo_task() {
        toDoListPage.clickOnTodoTaskCheckbox(context.getData("todoTaskName"));
    }

    @Then("Verify that the todo task should be marked as completed")
    public void verify_todo_task_marked_complete() {
        Assert.assertTrue(toDoListPage.itemsLeftCount(0));
        Assert.assertTrue(toDoListPage.isTaskCompleted(context.getData("todoTaskName")));
    }

    @When("I click on Complete All arrow")
    public void mark_all_todo_tasks_complete() {
        toDoListPage.clickCompleteAllButton();
    }

    @Then("Verify that all tasks should be marked Complete")
    public void verify_no_todo_task_left() {
        Assert.assertTrue(toDoListPage.allTodoTasksAreMarkedComplete());
        Assert.assertTrue(toDoListPage.itemsLeftCount(0));
    }
}
