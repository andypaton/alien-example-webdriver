package com.alien.examples.webdriver.helpers;

import java.io.IOException;

import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.utils.report.CucumberReport.ReportBuilder;

import cucumber.api.Scenario;
import cucumber.api.java.Before;


//@ContextConfiguration(classes={cucumber.runtime.ScenarioImpl.class})
@ContextConfiguration(classes={CucumberConfig.class})
public class OutputHelper {
	
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
    public void showMessage(String header, String message) throws IOException {
        new ReportBuilder().createSection(header, message).build(scenario).write();
    }
    
}
