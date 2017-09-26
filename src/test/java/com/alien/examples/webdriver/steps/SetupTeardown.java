package com.alien.examples.webdriver.steps;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;

import cucumber.api.java.After;

@ContextConfiguration(classes=CucumberConfig.class)
public class SetupTeardown {
		
	@Autowired private static WebDriver webDriver;

	
	@BeforeClass
	public static void setUp() {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
