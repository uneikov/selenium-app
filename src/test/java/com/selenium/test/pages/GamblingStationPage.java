package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamblingStationPage extends BasePage {
    private static final String PAGE_URL = "http://gamblingstation.herokuapp.com";
    
    @FindBy(css = "#command > div:nth-child(1) > input")
    private WebElement loginFieldElement;
    
    @FindBy(css = "#command > div:nth-child(2) > input")
    private WebElement passwordFieldElement;
    
    @FindBy(css = "#command > button")
    private WebElement submitButtonElement;
    
    
    public GamblingStationPage() {
        super(true);
    }
    
    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }
    
    @Override
    public boolean isPageOpened() {
        return loginFieldElement.isDisplayed();
    }
    
    public void insertLoginString(String text) {
        loginFieldElement.sendKeys(text);
    }
    
    public void insertPasswordString(String text) {
        passwordFieldElement.sendKeys(text);
    }
    public void submitLoginInfo() {
        submitButtonElement.click();
    }
    
}
