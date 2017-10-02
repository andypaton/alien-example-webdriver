package com.alien.examples.webdriver.pageObjects.weather;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_VISIBLE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class CreateProfilePage extends PageObject {

	private static final String SIGN_HEADER_XPATH = "//*[contains(@class,'sign-header') and contains(text(),'Create your profile')]";
	
	@FindBy(xpath = SIGN_HEADER_XPATH)
	private WebElement header;

	
    public CreateProfilePage(final WebDriver webDriver) {
        super(webDriver);      
        waitForElement(By.xpath(SIGN_HEADER_XPATH), ELEMENT_IS_VISIBLE);
		assertTrue(this.isInitialized());		
    }
	
	public boolean isInitialized() {
		return header.isDisplayed();
	}
	
	
}