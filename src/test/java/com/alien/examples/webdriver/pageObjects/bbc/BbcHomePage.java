package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class BbcHomePage extends PageObject {
    
    private static final String UNUSED_EXAMPLE_XPATH_1 ="//*[@type='radio' and @checked='checked']";
    private static final String UNUSED_EXAMPLE_XPATH_2 = "//a[text()='Staging Area']";
    private static final String UNUSED_EXAMPLE_XPATH_3 = "//*[@id='finish' and contains(@class, 'disabledButton')]";
    private static final String UNUSED_EXAMPLE_XPATH_4 = "//*[@class='roomMargin']/*[contains(@class, 'containerPrimary')]";
    private static final String UNUSED_EXAMPLE_XPATH_5 = "//*[@class='roomMargin']/*[not(contains(@class, 'containerPrimary'))]";
    private static final String UNUSED_EXAMPLE_XPATH_6 = "//*[@type='button']/*[text() = 'Cancel']";
    private static final String UNUSED_EXAMPLE_XPATH_7 = ".//*[contains(text(),'SUCCESS')]";
    private static final String UNUSED_EXAMPLE_XPATH_8 = "//*[@id=\"job\"]/table/tbody/tr/td[4]/a";

    
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
