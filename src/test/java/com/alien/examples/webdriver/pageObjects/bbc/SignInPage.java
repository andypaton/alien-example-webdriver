package com.alien.examples.webdriver.pageObjects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class SignInPage extends PageObject {
	
    @FindBy(xpath = "//span[@data-reactid='53']")
    private WebElement registerNow;
    
    @FindBy(id = "username-input")
    private WebElement username;
    
    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id = "submit-button")
    private WebElement signIn;
    
    
    public SignInPage(final WebDriver webDriver) {
        super(webDriver);      
        waitForPageToLoad(this.getClass());
    }
    
    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }
    
//	public ConfirmationPage signIn(){
//		signIn.click();
//		return new ConfirmationPage(webDriver);
//	}
	
	public RegisterDobPage register(){
		registerNow.click();
		return new RegisterDobPage(webDriver);
	}

}
