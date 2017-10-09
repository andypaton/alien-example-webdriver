package com.alien.examples.webdriver.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.runtime.RuntimeState;
import com.alien.utils.report.CucumberReport;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@ContextConfiguration(classes=CucumberConfig.class)
public class SetupTeardownStep {
	
	@Autowired 
    private RuntimeState runtimeState;
	
	
	@Before
	public void setup(Scenario scenario) {
	    runtimeState.scenario = scenario;
	}
	
	@After
	public void teardown() throws Exception {
        CucumberReport.showDeveloperBusinessToggle(runtimeState.scenario);
	}

}
