package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.alien.examples.webdriver.pageObjects.bbc.BbcHomePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BbcStep extends BaseStep {
	
	private static String BBC_HOME_PAGE = "http://www.bbc.com";

//	private Scenario scenario;
//	private BbcHomePage bbcHomePage;
	
	
//	@Before
//	public void before(Scenario scenario) {
//	    this.scenario = scenario;
//	}
	
	@Given("^URL \"(.*)\" is opened in \"(Firefox|Chrome)\"$")
	public void go_to_url(String url,  String driver) throws Throwable {

		switch (driver) {
		
		case "Firefox": 
			webDriver = new FirefoxDriver();
	        System.setProperty("web.driver","firefox");
		    break;

		case "Chrome": 
			webDriver = new ChromeDriver();
	        System.setProperty("web.driver","chrome");
		    break;
		    
		}
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to(url);
	}
	
	@Given("^the BBC home page is opened in \"(Firefox|Chrome)\"$")
	public void bbc_home_page(String url,  String driver) throws Throwable {

		switch (driver) {
		
		case "Firefox": 
	        System.setProperty("web.driver","firefox");
		    break;

		case "Chrome": 
	        System.setProperty("web.driver","chrome");
		    break;
		    
		}
		
		webDriver.get(BBC_HOME_PAGE);
		
		bbcHomePage = new BbcHomePage(webDriver);
		
		assertTrue(bbcHomePage.isInitialized());		
	}

	@When("the BBC home page is loaded$")
	public void home_page_loaded() throws Throwable {
		
		assertTrue("home page has not loaded", pageObjectHelper.isElementPresent(webDriver, By.id("hp-bbc-homepage-content")));

		reportHelper.takeScreenShot(webDriver, scenario, "Home Page");
	}

	@Then("^BBC Cookies policy is displayed$")
	public void bbc_cookies_displayed() throws Throwable {

		assertTrue("BBC Cookies not displayed", pageObjectHelper.isElementPresent(webDriver, By.id("bbccookies")));
		
		outputHelper.showMessage(scenario, "BBC cookies message", "replace me with cookie message!");
	}

	@After
	private void teardown() {
		webDriver.close();
	}
}
