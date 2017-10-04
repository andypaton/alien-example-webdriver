package com.alien.examples.webdriver.pageObjects.bbc;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_CLICKABLE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        waitForElement(By.id("submit-button"), ELEMENT_IS_CLICKABLE);
    }
    
    public void enterDay(String day) {
        this.day.sendKeys(day);
        this.day.sendKeys(Keys.TAB);
    }
    
    public void enterMonth(String month) {
        this.month.sendKeys(month);
        this.month.sendKeys(Keys.TAB);
    }

    public void enterYear(String year) {
        this.year.sendKeys(year);
        this.year.sendKeys(Keys.TAB);
    }
        
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    public RegisterAddressPage next() {
        next.click();
        return new RegisterAddressPage(webDriver);
    }

}
