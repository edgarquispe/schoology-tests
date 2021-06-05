package org.example.schoology.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.example.core.Environment;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example",
        plugin = {"pretty"}
)
public class RunCucumber extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void setUp() {
        System.setProperty("dataproviderthreadcount",
                Environment.getInstance().getValue("threadCount"));
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest
    public void tearDown() {
        // clean data
        // reset flags
    }

}
