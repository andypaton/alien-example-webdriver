package com.alien.examples.webdriver.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.alien.examples.webdriver.helpers.Gender;
import com.alien.examples.webdriver.pageObjects.bbc.BbcHomePage;
import com.alien.examples.webdriver.pageObjects.bbc.RegisterAddressPage;
import com.alien.examples.webdriver.pageObjects.bbc.RegisterDobPage;
import com.alien.examples.webdriver.pageObjects.bbc.SignInPage;
import com.alien.utils.webdriver.CucumberWebDriver;
import com.alien.utils.webdriver.WebDriverUtility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.lang.RandomStringUtils;

public class BbcStep extends BaseStep {

	private Scenario scenario;
	
	private static String BBC_HOME_PAGE = "http://www.bbc.co.uk";

	private BbcHomePage bbcHomePage;
	private SignInPage signInPage;
	private RegisterDobPage registerDobPage;
	private RegisterAddressPage registerAddressPage;
	
    private final static String REGISTERED_USER = "blah@blah.com";
    private final static String REGISTERED_PASSWORD = "TestP@55w0rd";
    private final static String HOMETOWN = "Glasgow";
    private final static String HOMETOWN_SELECTION = "Glasgow, Glasgow City";
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
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
		
		bbcHomePage = new BbcHomePage(getWebDriver());
	}

	@Then("^BBC Cookies policy is displayed$")
	public void bbc_cookies_displayed() throws Throwable {

//		assertTrue("BBC Cookies not displayed", bbcHomePage.isElementPresent(webDriver, By.id("bbccookies")));
	}
	
	@When("^the \"([^\"]*)\" link is selected$")
	public void the_link_is_selected(String link) throws Throwable {

		switch(link) {
		case "Sign in":
			signInPage = bbcHomePage.signIn();
			break;
		case "Register Now":
			registerDobPage = signInPage.register();
			break;
		case "News":
			break;
		case "Sport":
			break;
		default:
			fail("Unknown link");
		}
	}

	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String page) throws Throwable {

		 // taking screenshots are very slow
         webDriverUtility.takeScreenShot();
	}

	@When("^existing registration details are entered$")
	public void existing_registration_details_are_entered() throws Throwable {
         
 		doRegistration(REGISTERED_USER);
	}
	
	@When("^new registration details are entered$")
	public void new_registration_details_are_entered() throws Throwable {
		 
		String username = RandomStringUtils.randomAlphabetic(5) + "blah.com";
		
		doRegistration(username);
	}
	
	@Then("^\"(.*)\" registration warning is displayed$")
	public void registration_warning_displayed(String warning) throws Throwable {
		 
		assertTrue(registerAddressPage.getErrorMessage(), registerAddressPage.getErrorMessage().contains(warning));
	}
	
	private void doRegistration(String username){
		
		 registerDobPage.enterDay("05");
		 registerDobPage.enterMonth("11");
		 registerDobPage.enterYear("1999");

		 registerAddressPage = registerDobPage.next();

		 registerAddressPage.enterEmail(username);
		 registerAddressPage.enterPassword(REGISTERED_PASSWORD);
		 registerAddressPage.enterHometown(HOMETOWN);
		 registerAddressPage.selectHometown(HOMETOWN_SELECTION);
		 //		 registerAddressPage.enterPostcode("G1 7BC");;
		 registerAddressPage.selectGender(Gender.MALE);
		 registerAddressPage.emailUpdates(false);;
        
         registerAddressPage.register();
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
