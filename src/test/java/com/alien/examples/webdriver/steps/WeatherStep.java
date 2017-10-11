package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.pageObjects.weather.CreateProfilePage;
import com.alien.examples.webdriver.pageObjects.weather.WeatherHomePage;
import com.alien.examples.webdriver.runtime.RuntimeState;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=CucumberConfig.class)
public class WeatherStep {

	@Autowired 
    private RuntimeState runtimeState;
	
	@Autowired 
    private OutputHelper outputHelper;
	
	@Autowired 
    private WebDriver webDriver;

	
	private static String WEATHER_HOME_PAGE = "http://www.weather.com/";
		
	private WeatherHomePage weatherHomePage;
	private CreateProfilePage createProfilePage;

	
	@Given("^the weather home page is opened$")
	public void go_to_url() throws Throwable {
		
		webDriver.get(WEATHER_HOME_PAGE);
		
		weatherHomePage = new WeatherHomePage(webDriver);
		
		outputHelper.showMessage("scenario tags", runtimeState.scenario.getSourceTagNames().toString());
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

}

