package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ToDoListPage {
    private final ElementUtils utils;
    private final WebDriver driver;

    public ToDoListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

    @FindBy(css = "ul.todo-list label[data-testid='todo-item-label']")
    private List<WebElement> todoTaskList;

    @FindBy(css = "ul.todo-list #todo-input")
    private WebElement editTasknameInputField;

    @FindBy(css = "span.todo-count")
    private WebElement noOfTodoString;

    @FindBy(css = ".toggle-all")
    private WebElement completeAllButton;

    @FindBy(css = "button.clear-completed")
    private WebElement clearCompletedButton;

    public int getTodoTaskListSize() {
        return todoTaskList.size();
    }

    public boolean isTodoTaskPresent(String taskName) {
        return utils.isTextPresentInTheList(todoTaskList, taskName);
    }

    public boolean verifyNoTaskPresent() {
        return todoTaskList.isEmpty();
    }

    public void clickOnTodoTaskCheckbox(String taskName) {
        By checkboxLocator =
                By.xpath("//label[text()='" + taskName + "']/preceding-sibling::input");
        driver.findElement(checkboxLocator).click();
    }

    public boolean isTaskCompleted(String taskName) {
        String completedClass = "completed";
        By todoItemLocator = By.xpath(
                "//label[text()='" + taskName + "']//ancestor::li[@data-testid='todo-item']");
        String todoItemClass = driver.findElement(todoItemLocator).getAttribute("class");
        return todoItemClass.contains(completedClass);
    }

    public void doubleClickToEdit(String taskName) {
        utils.waitForAllElements(todoTaskList, 10);
        WebElement todoItem = driver.findElement(
                By.xpath("//label[text()='" + taskName + "']/parent::div[@class='view']"));
        new Actions(driver).doubleClick(todoItem).perform();
    }

    public void enterNewTodoTaskName(String updatedTaskName) {
        utils.clearText(editTasknameInputField);
        utils.enterTextIntoElement(clearCompletedButton, updatedTaskName);
    }

    public void clickDeleteButton(String taskName) {
        By taskView = By.xpath("//label[text()='" + taskName + "']/parent::div[@class='view']");
        utils.mouseHoverOverElement(driver.findElement(taskView));

        By deleteButtonLocator = By.xpath(
                "//label[text()='" + taskName + "']/following-sibling::button[@class='destroy']");

        utils.clickOnElement(driver.findElement(deleteButtonLocator));
    }

    public void clickCompleteAllButton() {
        completeAllButton.click();
    }

    public boolean allTodoTasksAreMarkedComplete() {
        boolean anyIncompleteTick = false;
        for (WebElement todoTask : todoTaskList) {
            if (!todoTask.getAttribute("class").contains("completed")) {
                anyIncompleteTick = true;
                break;
            }
        }

        return anyIncompleteTick;
    }

    public void doubleClickOnToDoTask(String taskName) {
        By todoItem = By.xpath("//label[text()='" + taskName + "']");
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(todoItem)).perform();
    }

    public void enterNewTaskName(String oldTaskName, String newTaskName) {
        WebElement newTodoInput =
                driver.findElement(By.cssSelector("#todo-input[value='" + oldTaskName + "']"));
        newTodoInput.sendKeys(newTaskName);
    }

    public void clickClearCompletedButton() {
        utils.clickOnElement(clearCompletedButton);
    }

    public boolean verifyNoChangeInTaskCount(String initialCount) {
        String laterTaskListCount = Integer.toString(todoTaskList.size());
        return laterTaskListCount.equals(laterTaskListCount);
    }

    public boolean itemsLeftCount(int expectedCount) {
        String text = noOfTodoString.getText();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String number = "0";
        if (matcher.find()) {
            number = matcher.group();
        } else {
            System.out.println("Number not found in the string.");
        }

        return Integer.parseInt(number) == expectedCount;
    }

    public int countOfTaskWithGivenName(String taskName) {
        int count = 0;
        for (WebElement todoTask : todoTaskList) {
            if (todoTask.getText().equals(taskName)) {
                count++;
            }
        }
        System.out.println("Count of task " + taskName + "is " + count);
        return count;
    }

}
