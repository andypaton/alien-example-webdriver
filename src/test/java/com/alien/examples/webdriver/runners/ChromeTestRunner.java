package com.alien.examples.webdriver.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.utils.webdriver.WebDriverUtility;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
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

@ContextConfiguration(classes={CucumberConfig.class})
public class ChromeTestRunner {
	
	@Autowired static private WebDriverUtility webDriverUtility;

    static {
//        System.setProperty("web.driver","chrome");
    }
    
    @BeforeClass
    static public void setup() {
    	
        System.setProperty("web.driver","chrome");

		webDriverUtility = new WebDriverUtility();
    }
    
	@AfterClass
	static public void teardown() {
		
		if (webDriverUtility != null) {
		    webDriverUtility.closeDriver();
		}
	}
    
}