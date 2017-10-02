package com.alien.examples.webdriver.pageObjects.weather;

import static com.alien.utils.webdriver.pageObjects.State.ELEMENT_IS_CLICKABLE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alien.utils.webdriver.pageObjects.PageObject;

public class WeatherHomePage extends PageObject {
		
	private static final String SIGN_UP_CSS = ".styles-PgWpwj1c__open__NIJok > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2)";
	private static final String PROFILE_BUTTON_CSS = "div.styles-oeXYFkbi__root__2g_Fj:nth-child(2) > button:nth-child(1)";

	
	@FindBy(css = PROFILE_BUTTON_CSS)
	private WebElement profileButton;
	
	@FindBy(css = SIGN_UP_CSS)
	private WebElement signUp;
    
	
    public WeatherHomePage(final WebDriver webDriver) {
        super(webDriver);      
//        waitForElement(By.cssSelector(PROFILE_BUTTON_CSS), ELEMENT_IS_CLICKABLE);
        waitForLoad();
		assertTrue(this.isInitialized());		
    }

	public boolean isInitialized() {
		return profileButton.isDisplayed();
	}
	
	public void clickProfileButton(){
        waitForElement(By.cssSelector(PROFILE_BUTTON_CSS), ELEMENT_IS_CLICKABLE);
        pause(FIVE_SECONDS);
		profileButton.click();
	}
    
	public CreateProfilePage signUp(){
        waitForElement(By.cssSelector(SIGN_UP_CSS), ELEMENT_IS_CLICKABLE);
		signUp.click();
		return new CreateProfilePage(webDriver);
	}

}
