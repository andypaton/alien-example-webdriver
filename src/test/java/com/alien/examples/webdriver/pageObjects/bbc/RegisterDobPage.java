package com.alien.examples.webdriver.pageObjects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class RegisterDobPage extends PageObject {
	
    @FindBy(id = "day-input")
    private WebElement day;
    
    @FindBy(id = "month-input")
    private WebElement month;
    
    @FindBy(id = "year-input")
    private WebElement year;
    
    @FindBy(id = "submit-button")
    private WebElement next;
    
    @FindBy(xpath = "//div[contains(@class, 'for-message--error')]")
    private WebElement errorMessage;
    
    
    public RegisterDobPage(final WebDriver webDriver) {
        super(webDriver);      
        waitForPageToLoad(this.getClass());
    }
    
    public void enterDay(String day) {
        this.day.sendKeys(day);
    }
    
    public void enterMonth(String month) {
        this.month.sendKeys(month);
    }

    public void enterYear(String year) {
        this.year.sendKeys(year);
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    public void next() {
        next.click();
    }
	
	public RegisterNowPage registerNow(){
		registerNow.click();
		return new RegisterNowPage(webDriver);
	}

}
