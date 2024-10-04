package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features", glue = {"stepdefinitions", "hooks"},
        // plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html",
        // "json:target/cucumber-reports/cucumber-json-report.json",
        // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunnerTest extends AbstractTestNGCucumberTests {

}
