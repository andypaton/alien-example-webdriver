package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.alien.examples.webdriver.pageObjects.bbc.BbcHomePage;
import com.alien.utils.webdriver.WebDriverUtility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BbcStep extends BaseStep {

	private Scenario scenario;

	
	private static String BBC_HOME_PAGE = "http://www.bbc.co.uk";

	private BbcHomePage bbcHomePage;
	
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
//	@Given("^URL \"(.*)\" is opened in \"(Firefox|Chrome)\"$")
//	public void go_to_url(String url,  String driver) throws Throwable {
//
//		switch (driver) {
//		
//		case "Firefox": 
//			webDriver = new FirefoxDriver();
//	        System.setProperty("web.driver","firefox");
//		    break;
//
//		case "Chrome": 
//			webDriver = new ChromeDriver();
//	        System.setProperty("web.driver","chrome");
//		    break;
//		    
//		}
//		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        webDriver.navigate().to(url);
//	}
	
	@Given("^the BBC home page is opened in \"(firefox|chrome)\"$")
	public void bbc_home_page(String driver) throws Throwable {

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
		webDriverUtility.registerTargetEndpoint(BBC_HOME_PAGE, false);
		
		bbcHomePage = new BbcHomePage(webDriverUtility.getWebDriver());
		
		assertTrue(bbcHomePage.isInitialized());		

		webDriverUtility.takeScreenShot();
	}

	@When("the BBC home page is loaded$")
	public void home_page_loaded() throws Throwable {
		
//		assertTrue("home page has not loaded", pageObjectHelper.isElementPresent(webDriver, By.id("hp-bbc-homepage-content")));
//
//		reportHelper.takeScreenShot(webDriver, scenario, "Home Page");
		webDriverUtility.takeScreenShot();
	}

	@Then("^BBC Cookies policy is displayed$")
	public void bbc_cookies_displayed() throws Throwable {

//		assertTrue("BBC Cookies not displayed", pageObjectHelper.isElementPresent(webDriver, By.id("bbccookies")));
//		
//		outputHelper.showMessage(scenario, "BBC cookies message", "replace me with cookie message!");
	}
	
	@When("^the \"([^\"]*)\" link is selected$")
	public void the_link_is_selected(String link) throws Throwable {

		bbcHomePage.signIn();
		
		webDriverUtility.takeScreenShot();

	}

	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String page) throws Throwable {


	}

	@When("^valid registration details are entered$")
	public void valid_registration_details_are_entered() throws Throwable {

	}
	
	@After
	public void teardown(Scenario scenario) {
		webDriverUtility.closeDriver();
	}
}
