package com.alien.examples.webdriver.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.utils.webdriver.WebDriverUtility;

import cucumber.runtime.ScenarioImpl;

@ContextConfiguration(classes={CucumberConfig.class, cucumber.runtime.ScenarioImpl.class})
public class BaseStep {
	
	@Autowired protected OutputHelper outputHelper;
	
	protected WebDriverUtility webDriverUtility;
	@Autowired ScenarioImpl scenario;

}
