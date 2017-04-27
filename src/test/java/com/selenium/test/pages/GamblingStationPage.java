package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebDriver;
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
    
    @FindBy(css = "body > div.jumbotron > div > p:nth-child(15) > a")
    private WebElement registerButtonElement;
    
    @FindBy(css = "body > div.jumbotron > div > p:nth-child(16) > a")
    private WebElement aboutButtonElement;
    
    /*@FindAll({@FindBy(css = "#command")})
    private List<WebElement> webElements;*/
    
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
    
    public void insertLogin(String text) {
        loginFieldElement.clear();
        loginFieldElement.sendKeys(text);
    }
    
    public void insertPassword(String text) {
        passwordFieldElement.clear();
        passwordFieldElement.sendKeys(text);
    }
    
    public void submitLoginInfo() {
        submitButtonElement.click();
    }
    
    public void clickRegister() {
        registerButtonElement.click();
    }
    
    public void clickAbout() {
        aboutButtonElement.click();
    }
    
    public void navigateBack() {
        getWebDriver().navigate().back();
    }
    
    public WebDriver getWebDriver() {
        return getDriver();
    }
}
