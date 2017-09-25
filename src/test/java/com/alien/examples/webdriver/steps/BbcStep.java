package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BbcStep extends BaseStep {
	
	private Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@Given("^URL \"(.*)\" is opened in \"(Firefox|Chrome)\"$")
	public void go_to_url(String url,  String driver) throws Throwable {

		switch (driver) {
		
		case "Firefox": 
			webdriver = new FirefoxDriver();
		    break;

		case "Chrome": 
			webdriver = new ChromeDriver();
		    break;
		    
		}
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to(url);
	}

	@When("the BBC home page is loaded$")
	public void home_page_loaded() throws Throwable {
		
		assertTrue("home page has not loaded", pageObjectHelper.isElementPresent(webdriver, By.id("hp-bbc-homepage-content")));

		reportHelper.takeScreenShot(webdriver, scenario, "Home Page");
	}

	@Then("^BBC Cookies policy is displayed$")
	public void bbc_cookies_displayed() throws Throwable {

		assertTrue("BBC Cookies not displayed", pageObjectHelper.isElementPresent(webdriver, By.id("bbccookies")));
		
		outputHelper.showMessage(scenario, "BBC cookies message", "replace me with cookie message!");
	}

	@After
	private void teardown() {
		webdriver.close();
	}
}
