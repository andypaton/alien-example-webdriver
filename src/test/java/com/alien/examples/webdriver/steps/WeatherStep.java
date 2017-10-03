package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.alien.examples.webdriver.pageObjects.weather.CreateProfilePage;
import com.alien.examples.webdriver.pageObjects.weather.WeatherHomePage;
import com.alien.utils.webdriver.CucumberWebDriver;
import com.alien.utils.webdriver.WebDriverUtility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherStep extends BaseStep {

	private Scenario scenario;
	
	private static String WEATHER_HOME_PAGE = "http://www.weather.com/";
		
	private WeatherHomePage weatherHomePage;
	private CreateProfilePage createProfilePage;

	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@Given("^the weather home page is opened in \"([^\"]*)\"$")
	public void go_to_url(String driver) throws Throwable {

		switch (driver) {
		
	    case "firefox": 
            System.setProperty("web.driver","firefox");
            break;
	    case "chrome": 
	    	System.setProperty("web.driver","chrome");
	    	break;
		    
		}
		
		webDriverUtility = new WebDriverUtility();
		webDriverUtility.registerScenario(scenario);
		webDriverUtility.registerTargetEndpoint(WEATHER_HOME_PAGE, false);
		
		weatherHomePage = new WeatherHomePage(getWebDriver());
	}
	
	@When("^the Profile button is clicked$")
	public void the_profile_button_clicked() throws Throwable {

	    weatherHomePage.clickProfileButton();

	    assertTrue("Sign up is not displayed", weatherHomePage.isSignUpDisplayed());
    }
	
	@When("^the Sign Up link is selected$")
	public void the_link_is_selected() throws Throwable {

		createProfilePage = weatherHomePage.signUp();
	}
	
	@Then("^the Create Profile page is displayed$")
	public void create_prfile_displayed() throws Throwable{
		
		assertTrue("Create Profile page is not displayed", createProfilePage.isInitialized());
	}

	private CucumberWebDriver getWebDriver() {
		return webDriverUtility.getWebDriver();
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		if (webDriverUtility != null) {
		    webDriverUtility.takeScreenShot();
		    webDriverUtility.closeDriver();
		}
	}
}

