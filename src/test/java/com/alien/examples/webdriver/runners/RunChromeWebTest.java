package com.alien.examples.webdriver.runners;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true, 
        format={"progress","html:target/report/cucumber","json:target/report/cucumber/acceptance-test-report.json"}, 
        glue="com.alien.examples.webdriver.steps",
        features="classpath:features", 
        tags={
        		"~@wip"
        		,"@bbc"
//        		,"@weather"
        		}, 
        monochrome = true
        )

public class RunChromeWebTest {
    
    static {
        System.setProperty("web.driver","chrome");
    }
    
    @ClassRule
    public static WebSuiteClassRule webSuiteClassRule = new WebSuiteClassRule();
}
