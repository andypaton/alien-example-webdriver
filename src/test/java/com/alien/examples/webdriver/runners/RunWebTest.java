package com.alien.examples.webdriver.runners;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true, 
        format={"progress","html:target/report/cucumber","json:target/report/cucumber/report.json"}, 
        glue="com.alien.examples.webdriver.steps",
        features="classpath:features", 
        tags={
        		"~@wip"
        		,"@andy"
//        		,"@bbc"
//        		,"@weather"
        		}, 
        monochrome = true
        )

public class RunWebTest {
	
    static {
    	
    	if (System.getProperty("web.driver") == null){
            System.setProperty("web.driver", "phantom");
    	}
    	
    	if (System.getProperty("screenshots") == null){
            System.setProperty("screenshots", "true");
    	}
    	
    	System.out.println("***** web.driver = " + System.getProperty("web.driver") + " *****");
    }
    
    @ClassRule
    public static WebSuiteClassRule webSuiteClassRule = new WebSuiteClassRule();
}
