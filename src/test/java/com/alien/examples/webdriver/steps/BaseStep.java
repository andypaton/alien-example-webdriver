package com.alien.examples.webdriver.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.CucumberReportHelper;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.helpers.PageObjectHelper;

@ContextConfiguration(classes=CucumberConfig.class)
public class BaseStep {
	
	@Autowired protected WebDriver webDriver;
	@Autowired protected PageObjectHelper pageObjectHelper;
	@Autowired protected CucumberReportHelper reportHelper;
	@Autowired protected OutputHelper outputHelper;

	
}
