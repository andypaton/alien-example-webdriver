package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;

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
//        waitForPageToLoad(this.getClass());
//        waitForLoad();
        waitForElement(By.id("bbccookies"), ELEMENT_IS_VISIBLE);
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
