package com.alien.examples.webdriver.pageObjects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class BbcHomePage extends PageObject {

    @FindBy(id = "bbccookies")
    private WebElement bbcCookies;
    
    @FindBy(id = "signIn")
    private WebElement signInButton;
    
    
    public BbcHomePage(final WebDriver webDriver) {
        super(webDriver);      
        waitForPageToLoad(BbcHomePage.class);
    }

	public boolean isInitialized() {
		return bbcCookies.isDisplayed();
	}

    public String getCookieMessage(){
    	return bbcCookies.getText();
    }
    
	public SignInPage submit(){
		signInButton.click();
		return new SignInPage(webDriver);
	}
}
