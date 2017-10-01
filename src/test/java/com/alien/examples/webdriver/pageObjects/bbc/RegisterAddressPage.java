package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    
    @FindBy(id = "hometown-input")
    private WebElement hometown;
    
    @FindBy(id="location-list")
    private WebElement locationList;
    
    @FindBy(id = "gender-input")
    private WebElement genderDropdown;
    
    @FindBy(xpath = "//span[contains(text(), 'No, thanks')]")
    private WebElement noThanks;
    
    @FindBy(xpath = "//span[contains(text(), 'Yes please')]")  // exact text match
    private WebElement yesPlease;
    
    @FindBy(id = "submit-button")
    private WebElement register;
    
    private final static String LIST_ITEM_LOCATOR = "//li[contains(., '%s')]"; // partial text match
    private final static String ERROR_MESSAGE_CLASSNAME = "form-message__text"; 
    
    
    public RegisterAddressPage(final WebDriver webDriver) {
        super(webDriver);      
        waitForElement(By.id("submit-button"), ELEMENT_IS_VISIBLE);
    }
    
    public void enterEmail(String email) {
        this.email.sendKeys(email);
        this.email.sendKeys(Keys.TAB);
    }
    
    public void enterPassword(String password) {
        this.password.sendKeys(password);
        this.password.sendKeys(Keys.TAB);
    }

    public void enterPostcode(String postcode) {
        this.postcode.sendKeys(postcode);
        this.postcode.sendKeys(Keys.TAB);
    }
    
    public void enterHometown(String hometown) {
        this.hometown.sendKeys(hometown);
    }
    
    public void selectHometown(String selection) {
    	
        String xpath = String.format(LIST_ITEM_LOCATOR, selection);  
        
        waitForElement(By.xpath(xpath), ELEMENT_IS_VISIBLE);
        		
		webDriver.findElement(By.xpath(xpath)).click();
        this.hometown.sendKeys(Keys.TAB);
    }
    
    public void emailUpdates(boolean sendEmail) {
    	
      	if (sendEmail){
     		this.yesPlease.click();;    		
    	    }else{
    		    this.noThanks.click();;    		
    	    }
    }
    
    public void selectGender(Gender gender){
      	Select dropdown = new Select(genderDropdown);
    	    dropdown.selectByVisibleText(gender.value());
    }

    public String getErrorMessage() {
     	waitForElement(By.className(ERROR_MESSAGE_CLASSNAME), ELEMENT_IS_VISIBLE);
        return webDriver.findElement(By.className(ERROR_MESSAGE_CLASSNAME)).getText();
    }
    
    public void register() {
    	    register.click();
    }

}
