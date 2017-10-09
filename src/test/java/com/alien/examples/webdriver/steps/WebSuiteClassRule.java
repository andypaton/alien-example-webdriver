package com.alien.examples.webdriver.steps;

import org.junit.rules.ExternalResource;

import com.alien.utils.webdriver.WebDriverFactory;


public class WebSuiteClassRule extends ExternalResource {

    @Override
    protected void before() throws Throwable {
    		WebDriverFactory.getWebDriver();
    }

    @Override
    protected void after() {
        WebDriverFactory.getWebDriver().close();
        WebDriverFactory.clear();
    };

}
