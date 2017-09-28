package com.alien.examples.webdriver.pageObjects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alien.examples.webdriver.helpers.Gender;
import com.alien.utils.webdriver.pageObjects.PageObject;

public class RegisterAddressPage extends PageObject {
	
    @FindBy(id = "email-input")
    private WebElement email;
    
    @FindBy(id = "password-input")
    private WebElement password;
    
    @FindBy(id = "postcode-input")
    private WebElement postcode;
    
    @FindBy(id = "gender-input")
    private WebElement genderDropdown;
    
    @FindBy(xpath = "//div[contains(@class, 'for-message--error')]")
    private WebElement errorMessage;
    
    @FindBy(id = "submit-button")
    private WebElement emailThingYouLove;
    
    @FindBy(id = "register-button")
    private WebElement register;
       
    
    public RegisterAddressPage(final WebDriver webDriver) {
        super(webDriver);      
        waitForPageToLoad(this.getClass());
    }
    
    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void enterPostcode(String postcode) {
        this.postcode.sendKeys(postcode);
    }
    
    public void selectGender(Gender gender){
    	Select dropdown = new Select(genderDropdown);
    	dropdown.selectByVisibleText(gender.value());
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    public void register() {
    	register.click();
    }
	
//	public RegisterNowPage registerNow(){
//		registerNow.click();
//		return new RegisterNowPage(webDriver);
//	}

}
