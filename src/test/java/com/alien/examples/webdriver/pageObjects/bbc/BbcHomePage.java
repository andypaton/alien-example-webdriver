package com.alien.examples.webdriver.pageObjects.bbc;

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
        waitForPageToLoad(this.getClass());
    }

	public boolean isInitialized() {
		return bbcCookies.isDisplayed();
	}

    public String getCookieMessage(){
    	return bbcCookies.getText();
    }
    
	public SignInPage submit(){
		signInLink.click();
		return new SignInPage(webDriver);
	}
}
