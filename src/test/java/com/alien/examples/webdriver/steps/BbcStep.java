package com.alien.examples.webdriver.steps;

import static com.alien.examples.webdriver.runtime.WebDriverManager.getWebDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.Gender;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.helpers.PropertyHelper;
import com.alien.examples.webdriver.pageObjects.bbc.BbcHomePage;
import com.alien.examples.webdriver.pageObjects.bbc.RegisterAddressPage;
import com.alien.examples.webdriver.pageObjects.bbc.RegisterDobPage;
import com.alien.examples.webdriver.pageObjects.bbc.SignInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=CucumberConfig.class)
public class BbcStep {
	
	@Autowired 
    private OutputHelper outputHelper;
	
	@Autowired 
    private PropertyHelper propertyHelper;

	
	private static String BBC_HOME_PAGE = "http://www.bbc.co.uk";

	private BbcHomePage bbcHomePage;
	private SignInPage signInPage;
	private RegisterDobPage registerDobPage;
	private RegisterAddressPage registerAddressPage;
	
    private final static String REGISTERED_USER = "blah@blah.com";
    private final static String REGISTERED_PASSWORD = "TestP@55w0rd";
    private final static String HOMETOWN = "Glasgow";
    private final static String HOMETOWN_SELECTION = "Glasgow, Glasgow City";
	

	@Given("^the BBC home page is opened$")
	public void bbc_home_page_opened() throws Throwable {
		
		getWebDriver().get(BBC_HOME_PAGE);
		
		bbcHomePage = new BbcHomePage(getWebDriver());
		
		outputHelper.showMessage("my headr", "my msg");;
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
		
		takeScreenshot();
	}

	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String page) throws Throwable {

		takeScreenshot();
	}

	@When("^existing registration details are entered$")
	public void existing_registration_details_are_entered() throws Throwable {
         
 		doRegistration(REGISTERED_USER);
	}
	
	@When("^new registration details are entered$")
	public void new_registration_details_are_entered() throws Throwable {
		 
		String username = RandomStringUtils.randomAlphabetic(5) + "@blah.com";
		
		doRegistration(username);
	}
	
	@Then("^\"(.*)\" registration warning is displayed$")
	public void registration_warning_displayed(String warning) throws Throwable {
		 
		assertTrue(registerAddressPage.getErrorMessage(), registerAddressPage.getErrorMessage().contains(warning));
	}
	
	private void doRegistration(String username) throws IOException{
		
		 registerDobPage.enterDay("05");
		 registerDobPage.enterMonth("11");
		 registerDobPage.enterYear("1999");

		 takeScreenshot();
		 
		 registerAddressPage = registerDobPage.next();

		 registerAddressPage.enterEmail(username);
		 registerAddressPage.enterPassword(REGISTERED_PASSWORD);
		 registerAddressPage.enterHometown(HOMETOWN);
		 registerAddressPage.selectHometown(HOMETOWN_SELECTION);
		 //		 registerAddressPage.enterPostcode("G1 7BC");;
		 registerAddressPage.selectGender(Gender.MALE);
		 registerAddressPage.emailUpdates(false);;
        
         registerAddressPage.register();

         takeScreenshot();
	}

	
	private void takeScreenshot() throws IOException{
		
		if (propertyHelper.showScreenshots()){
			outputHelper.takeScreenshot();
		}
	}
}
