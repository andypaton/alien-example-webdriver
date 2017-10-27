package com.alien.examples.webdriver.steps;

import static com.alien.examples.webdriver.runtime.WebDriverManager.getWebDriver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.runtime.RuntimeState;
import com.alien.utils.report.CucumberReport;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@ContextConfiguration(classes=CucumberConfig.class)
public class SetupTeardownStep {
	
    private static final Logger LOGGER = Logger.getLogger(SetupTeardownStep.class.getName());

	@Autowired 
    private RuntimeState runtimeState;
	
	@Autowired 
    private OutputHelper outputHelper;
	
	
	@Before
	public void setup(Scenario scenario) {
	    runtimeState.scenario = scenario;
	   
//	      Delete all cookies at the start of each scenario to avoid shared state between tests
	    
	    LOGGER.debug("Deleting all cookies [" + getWebDriver().hashCode() + "]");

	    getWebDriver().manage().deleteAllCookies();
	}
	
	@After
	public void teardown() throws Exception {
		
		if ( runtimeState.scenario.isFailed() ) {
    		    embedScreenshot();
		}
		
        CucumberReport.showDeveloperBusinessToggle(runtimeState.scenario);
	}
	
    public void embedScreenshot() throws IOException, InterruptedException {        	
        runtimeState.scenario.write("Scenario Failed in : " + getBrowserInfo());
        Thread.sleep(1000);
        outputHelper.takeScreenshot();
    }
    
    private String getBrowserInfo(){
        // we have to cast WebDriver object to RemoteWebDriver here, because the first one does not have a method that would tell you which browser it is driving.
        Capabilities cap = ((RemoteWebDriver) getWebDriver()).getCapabilities();
        String b = cap.getBrowserName();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion();
        return String.format("%s v:%s %s", b, v, os);
    }

}
