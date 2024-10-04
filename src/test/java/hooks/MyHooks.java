package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import di.Context;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.ElementUtils;

public class MyHooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        Properties prop = ConfigReader.initializeProperties();
        driver = BrowserFactory.initializeBrowser(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        (new WebDriverWait(driver, Duration.ofSeconds(20))).until(
                ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(ElementUtils.IMPLICIT_WAIT_TIME));
    }

    @After
    public void tearDown() {
        Context.getDataMap().clear();

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @AfterTest
    public void clearStateData(){
        Context.getDataMap().clear();
    }

}
