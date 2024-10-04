package stepdefinitions;

import org.testng.Assert;
import di.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ToDoListPage;

public class ClearComplete {
    Context context;
    HomePage homePage;
    ToDoListPage toDoListPage;

    public ClearComplete(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        toDoListPage = context.getToDoListPage();
    }

    @When("I click the Clear completed button")
    public void click_clear_completed() {
        context.setData("initialTaskListCount",
                Integer.toString(toDoListPage.getTodoTaskListSize()));
        toDoListPage.clickClearCompletedButton();
    }

    @Then("Verify that no action should be taken")
    public void no_change_in_todo_task() {
        Assert.assertTrue(toDoListPage.verifyNoChangeInTaskCount(context.getData("initialTaskListCount")));
    }
}
