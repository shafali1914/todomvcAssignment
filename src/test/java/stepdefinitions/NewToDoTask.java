package stepdefinitions;

import org.testng.Assert;
import di.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ToDoListPage;

public class NewToDoTask {
    Context context;
    HomePage homePage;
    ToDoListPage toDoListPage;

    public NewToDoTask(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        toDoListPage = context.getToDoListPage();
    }

    @Given("I am on the TodoMVC homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(homePage.verifyHomePage());
    }

    @When("I enter {string} in the input field")
    public void enter_todo_task_name(String todoTaskName) {
        context.setData("todoTaskName", todoTaskName);
        homePage.enterTodoTaskName(todoTaskName);
    }

    @And("I press Enter button")
    public void press_enter() {
        homePage.pressEnterKey();
    }

    @Then("Verify the todo task should be displayed in the list")
    public void verify_new_created_todo_task() {
        Assert.assertTrue(toDoListPage.itemsLeftCount(1));
        Assert.assertTrue(toDoListPage.isTodoTaskPresent(context.getData("todoTaskName")));
    }

    @When("I enter an empty todo")
    public void create_empty_todo_task() {
        homePage.enterTodoTaskName("");
    }

    @Then("Verify that no task should be created")
    public void no_new_todo_task() {
        toDoListPage.verifyNoTaskPresent();
    }

    @Then("Verify that the application should not create duplicate tasks")
    public void verify_no_duplicate_task() {
        Assert.assertFalse(
                toDoListPage.countOfTaskWithGivenName(context.getData("todoTaskName")) > 1, "Found duplicate tasks in the list.");
    }
}
