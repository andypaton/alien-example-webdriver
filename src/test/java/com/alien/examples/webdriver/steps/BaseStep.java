package com.alien.examples.webdriver.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.utils.webdriver.WebDriverUtility;

@ContextConfiguration(classes={CucumberConfig.class, cucumber.api.Scenario.class})
public class BaseStep {
	
//	@Autowired protected CucumberReportHelper reportHelper;
	@Autowired protected OutputHelper outputHelper;
	
	protected WebDriverUtility webDriverUtility;
//	@Autowired Scenario scenario;

}
