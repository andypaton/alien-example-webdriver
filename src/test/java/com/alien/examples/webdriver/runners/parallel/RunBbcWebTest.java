package com.alien.examples.webdriver.runners.parallel;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true, 
        format={"progress","html:target/report/cucumber/bbc","json:target/report/cucumber/bbc/report.json"}, 
        glue="com.alien.examples.webdriver.steps",
        features="classpath:features/bbc", 
        tags={
        		"~@wip"
        		,"@bbc"
        		}, 
        monochrome = true
        )

public class RunBbcWebTest {
    
    static {
    	if (System.getProperty("web.driver") == null){
            System.setProperty("web.driver","firefox");
    	}
    }
    
    @ClassRule
    public static WebSuiteClassRule webSuiteClassRule = new WebSuiteClassRule();
}
