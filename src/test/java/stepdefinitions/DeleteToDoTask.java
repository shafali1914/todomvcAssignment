package stepdefinitions;

import org.testng.Assert;
import di.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ToDoListPage;

public class DeleteToDoTask {

    Context context;
    HomePage homePage;
    ToDoListPage toDoListPage;

    public DeleteToDoTask(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        toDoListPage = context.getToDoListPage();
    }

    @When("I click the delete button next to the todo task")
    public void click_delete_button() {
        toDoListPage.clickDeleteButton(context.getData("todoTaskName"));
    }

    @Then("Verify that the todo task should be removed from the list")
    public void verify_deleted_todo_task() {
        Assert.assertTrue(toDoListPage.verifyNoTaskPresent());
    }

}
