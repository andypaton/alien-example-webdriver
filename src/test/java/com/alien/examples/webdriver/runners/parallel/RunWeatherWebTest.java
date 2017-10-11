package com.alien.examples.webdriver.runners.parallel;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true, 
        format={"progress","html:target/report/cucumber/weather","json:target/report/cucumber/weather/report.json"}, 
        glue="com.alien.examples.webdriver.steps",
        features="classpath:features/weather", 
        tags={
        		"~@wip"
        		,"@weather"
        		}, 
        monochrome = true
        )

public class RunWeatherWebTest {
    
    static {
    	if (System.getProperty("web.driver") == null){
            System.setProperty("web.driver","firefox");
    	}
    }
    
    @ClassRule
    public static WebSuiteClassRule webSuiteClassRule = new WebSuiteClassRule();
}
