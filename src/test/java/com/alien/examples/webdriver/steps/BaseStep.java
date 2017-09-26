package com.alien.examples.webdriver.steps;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.CucumberReportHelper;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.helpers.PageObjectHelper;
import com.alien.examples.webdriver.pageObjects.bbc.BbcHomePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@ContextConfiguration(classes=CucumberConfig.class)
public class BaseStep {
	
	@Autowired protected static WebDriver webDriver;
	@Autowired protected PageObjectHelper pageObjectHelper;
	@Autowired protected CucumberReportHelper reportHelper;
	@Autowired protected OutputHelper outputHelper;
	
	protected Scenario scenario;
	protected BbcHomePage bbcHomePage;
	
	@BeforeClass
	public static void setUp() {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void cleanUp() {
		webDriver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDown() {
		webDriver.close();
	}
}
