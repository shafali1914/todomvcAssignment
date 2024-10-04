package utils;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
    WebDriver driver;
    static Properties prop;
    public static final int IMPLICIT_WAIT_TIME = 30;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        return webElement.isDisplayed();
    }

    public void clickOnElement(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        webElement.click();
    }

    public void mouseHoverAndClick(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    public void mouseHoverOverElement(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void enterTextIntoElement(WebElement element, String text) {
        WebElement webElement = waitForWebElement(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void clearText(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        webElement.clear();
    }

    public void pressEnterKey(WebElement element) {
        WebElement webElement = waitForWebElement(element);
        webElement.sendKeys(Keys.ENTER);
    }

    public boolean isTextPresentInTheList(List<WebElement> elementList, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        for (WebElement webElement : elementList) {
            if (webElement.getText().equals(text))
                return true;
        }

        return false;
    }

    public void waitForAllElements(List<WebElement> elements, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForWebElement(WebElement element) {
        WebElement webElement = null;
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(ElementUtils.IMPLICIT_WAIT_TIME));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public void waitForElementLocatedBy(By type) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(ElementUtils.IMPLICIT_WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(type));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
