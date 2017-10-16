package com.alien.examples.webdriver.steps;

import java.io.IOException;

import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.runtime.WebDriverManager;
import com.alien.utils.webdriver.WebDriverFactory;

import static com.alien.examples.webdriver.runtime.WebDriverManager.getWebDriver;

@ContextConfiguration(classes=CucumberConfig.class)
public class WebSuiteClassRule extends ExternalResource {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSuiteClassRule.class);

	
    @Override
    protected void before() throws Throwable {
    	    WebDriverManager.webDriver.set(WebDriverFactory.getWebDriver());
    	    
        LOGGER.debug("WebDriver instance created : " + getWebDriver().hashCode());
    }

    @Override
    protected void after() {
    	
        getWebDriver().close();
        WebDriverFactory.clear();

        LOGGER.debug("WebDriver instance destroyed : " + getWebDriver().hashCode());
    }

}
