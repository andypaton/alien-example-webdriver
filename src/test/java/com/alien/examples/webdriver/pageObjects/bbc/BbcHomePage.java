package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class BbcHomePage extends PageObject {
    
    private static final String UNUSED_EXAMPLE_XPATH_01 ="//*[@type='radio' and @checked='checked']";
    private static final String UNUSED_EXAMPLE_XPATH_02 = "//a[text()='Staging Area']";
    private static final String UNUSED_EXAMPLE_XPATH_03 = "//*[@id='finish' and contains(@class, 'disabledButton')]";
    private static final String UNUSED_EXAMPLE_XPATH_04 = "//*[@class='roomMargin']/*[contains(@class, 'containerPrimary')]";
    private static final String UNUSED_EXAMPLE_XPATH_05 = "//*[@class='roomMargin']/*[not(contains(@class, 'containerPrimary'))]";
    private static final String UNUSED_EXAMPLE_XPATH_06 = "//*[@type='button']/*[text() = 'Cancel']";
    private static final String UNUSED_EXAMPLE_XPATH_07 = ".//*[contains(text(),'SUCCESS')]";
    private static final String UNUSED_EXAMPLE_XPATH_08 = "//*[@id=\"job\"]/table/tbody/tr/td[4]/a";
    private static final String UNUSED_EXAMPLE_XPATH_09 = "//div[starts-with(@id, 'test')]";  // starts-with
    private static final String UNUSED_EXAMPLE_XPATH_10 = "//div[contains(@id, 'test')]"; // contains
    
    private static final String UNUSED_EXAMPLE_CSS_1 = "div[id^=test]";  // starts-with
    private static final String UNUSED_EXAMPLE_CSS_2 = "div[id$=test]";  // ends-with
    private static final String UNUSED_EXAMPLE_CSS_3 = "div[id*=test]";  // contains

    
    @FindBy(id = "bbccookies")
    private WebElement bbcCookies;
    
    @FindBy(id = "idcta-username")
    private WebElement signInLink;
    
    
    
    public BbcHomePage(final WebDriver webDriver) {
        super(webDriver);      
//        waitForPageToLoad(this.getClass());  // cant use this if all elements are not going to be visible
//        waitForLoad();
        waitForElement(By.id("bbccookies"), ELEMENT_IS_VISIBLE);
        assertTrue(this.isInitialized());        
    }

    public boolean isInitialized() {
        return bbcCookies.isDisplayed();
    }

    public String getCookieMessage(){
        return bbcCookies.getText();
    }
    
    public SignInPage signIn(){
        signInLink.click();
        return new SignInPage(webDriver);
    }
}
