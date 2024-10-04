package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class HomePage {
    private final ElementUtils utils;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//h1[text()='todos']")
    private WebElement logo;

    @FindBy(css = "#todo-input")
    private WebElement todoInputField;

    public boolean verifyHomePage() {
        return utils.isElementPresent(logo);
    }

    public void enterTodoTaskName(String taskName) {
        utils.enterTextIntoElement(todoInputField, taskName);
    }

    public void pressEnterKey() {
        utils.pressEnterKey(todoInputField);
    }

}
