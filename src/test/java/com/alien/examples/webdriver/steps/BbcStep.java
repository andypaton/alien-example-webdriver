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

public class BbcStep extends BaseStep {

	private Scenario scenario;
	
	private static String BBC_HOME_PAGE = "http://www.bbc.co.uk";

	private BbcHomePage bbcHomePage;
	private SignInPage signInPage;
	private RegisterDobPage registerDobPage;
	private RegisterAddressPage registerAddressPage;
	
	
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
		
		bbcHomePage = new BbcHomePage(getWebDriver());
		
		assertTrue(bbcHomePage.isInitialized());		

		webDriverUtility.takeScreenShot();
	}

//	@When("the BBC home page is loaded$")
//	public void home_page_loaded() throws Throwable {
//		
////		assertTrue("home page has not loaded", pageObjectHelper.isElementPresent(webDriver, By.id("hp-bbc-homepage-content")));
////
////		reportHelper.takeScreenShot(webDriver, scenario, "Home Page");
//		webDriverUtility.takeScreenShot();
//	}

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
		
		webDriverUtility.takeScreenShot();
	}

	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String page) throws Throwable {

		webDriverUtility.takeScreenShot();
	}

	@When("^valid registration details are entered$")
	public void valid_registration_details_are_entered() throws Throwable {
		 
		 registerDobPage.enterDay("05");
		 registerDobPage.enterMonth("11");
		 registerDobPage.enterYear("1999");

         webDriverUtility.takeScreenShot();

		 registerAddressPage = registerDobPage.next();

		 registerAddressPage.enterEmail("blah@blah.com");
		 registerAddressPage.enterPassword("TestP@55w0rd");
		 registerAddressPage.enterHometown("Glasgow");;
//		 registerAddressPage.enterPostcode("G1 7BC");;
		 registerAddressPage.selectGender(Gender.MALE);
		 
         webDriverUtility.takeScreenShot();
	}
	
	private CucumberWebDriver getWebDriver() {
		return webDriverUtility.getWebDriver();
	}
	
	@After
	public void teardown(Scenario scenario) {
		webDriverUtility.closeDriver();
	}
}
