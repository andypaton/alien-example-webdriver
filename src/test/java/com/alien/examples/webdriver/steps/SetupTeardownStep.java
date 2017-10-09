package com.alien.examples.webdriver.steps;

import com.alien.utils.report.CucumberReport;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetupTeardownStep {
	
	private Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void teardown() throws Exception {
        CucumberReport.showDeveloperBusinessToggle(scenario);
	}

}
