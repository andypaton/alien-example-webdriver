package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class BbcHomePage extends PageObject {
	
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
