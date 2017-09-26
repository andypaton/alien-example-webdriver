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

public class WeatherStep extends BaseStep {

	private Scenario scenario;
	
	private static String WEATHER_URL = "http://www.weather.com/";
	
	private static String PROFILE_BUTTON_XPATH = "//*[contans(@classname, '__profileButton')]";
	
	
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@Given("^the weather page is opened in \"(Firefox|Chrome)\"$")
	public void go_to_url(String driver) throws Throwable {

		switch (driver) {
		
		case "Firefox": 
			webDriver = new FirefoxDriver();
		    break;

		case "Chrome": 
			webDriver = new ChromeDriver();
		    break;
		    
		}
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to(WEATHER_URL);
	}
	
	@When("the weather home page has loaded$")
	public void home_page_loaded() throws Throwable {
		
		System.out.println(webDriver.getPageSource());
		
		assertTrue("weather page has not loaded", pageObjectHelper.isElementPresent(webDriver, By.xpath(PROFILE_BUTTON_XPATH)));

		reportHelper.takeScreenShot(webDriver, scenario, "Home Page");
	}

	@Then("^the Profile link is displayed$")
	public void profile_displayed() throws Throwable {

		assertTrue("Profile link not displayed", pageObjectHelper.isElementPresent(webDriver, By.xpath(PROFILE_BUTTON_XPATH)));
		
		scenario.write("Hooray - cookies policy is displayed!!!");
	}

	@After
	private void teardown() {
		webDriver.close();
	}
}

