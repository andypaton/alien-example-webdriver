package com.alien.examples.webdriver.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.utils.webdriver.WebDriverUtility;

@ContextConfiguration(classes={CucumberConfig.class})
public class BaseStep {
	
	@Autowired protected OutputHelper outputHelper;
	
	@Autowired protected WebDriverUtility webDriverUtility;

}
