package com.selenium.test.testng.tests;

import com.selenium.test.InitSystemProperties;
import com.selenium.test.pages.GamblingStationPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({ScreenShotOnFailListener.class})
public class GamblingStationTest {
    
    private GamblingStationPage page;
    
    @BeforeClass(groups = {"login", "horse"})
    public void beforeClass() {
        InitSystemProperties.Init();
        WebDriverFactory.startBrowser(true);
        page = new GamblingStationPage();
    }
    
    @Test(description="Insert user credential and navigate to stakes page",
            enabled = true, priority = 1, dataProvider = "credentials", groups = {"login"})
    public void testSignInToGamblingStation(String email, String password) {
        //page = new GamblingStationPage();
        if (page.isPageOpened()) {
            page.insertLogin(email);
            page.insertPassword(password);
            page.submitLoginInfo();// go to admin stakes page
            Assert.assertTrue("Виртуальный ипподром".equals(page.getWebDriver().getTitle()));
            page.navigateBack();
        }
    }
    
    @Parameters("button")
    @Test(enabled = true, priority = 2, dependsOnMethods = {"testSignInToGamblingStation"}, groups = {"horse"})
    public void testGoToStakesPageAndFindHorsesButton(String button) throws Exception {
        String email = "admin@gmail.com";
        String password = "admin";
        //page = new GamblingStationPage();
        if (page.isPageOpened()) {
            page.insertLogin(email);
            page.insertPassword(password);
            page.submitLoginInfo(); // go to admin stakes page
            page.getWebDriver().findElement(By.cssSelector("#command > a.btn.btn-danger")).click();
            String innerHtml = page.getWebDriver() // navigate to button "Horses"
                    .findElement(By.cssSelector("body > div.jumbotron > div > div > h3"))
                    .getAttribute("innerHTML");
            Assert.assertTrue(button.equals(innerHtml));
            page.navigateBack();
            page.navigateBack();
        }
    }
    
    @Test(description="Navigates to the Registration page", enabled = true, priority = 3, groups = {"login"})
    public void testRegister() {
        if (page.isPageOpened()) {
            page.clickRegister();
            String innerHTML = page.getWebDriver()
                    .findElement(By.cssSelector("body > div.jumbotron > div > div > h3"))
                    .getAttribute("innerHTML");
            Assert.assertTrue(innerHTML.contains("Регистрация"));
            page.navigateBack();
        }
    }
    
    @Test(description="Navigates to the About page", enabled = true, priority = 3, groups = {"login"})
    public void testAbout() {
        if (page.isPageOpened()) {
            page.clickAbout();
            String innerHTML = page.getWebDriver()
                    .findElement(By.cssSelector("head > title:nth-child(1)"))
                    .getAttribute("innerHTML");
            Assert.assertTrue(innerHTML.contains("About"));
            page.navigateBack();
        }
    }
    
    @AfterClass(groups = {"login", "horse"})
    public void afterClass() {
        WebDriverFactory.finishBrowser();
    }
    
    @DataProvider(name = "credentials")
    private Object[][] getData() {
        Object[][] credentials = new Object[3][2];
        credentials[0][0] = "admin@gmail.com";
        credentials[0][1] = "admin";
        credentials[1][0] = "user1@yandex.ru";
        credentials[1][1] = "password1";
        credentials[2][0] = "user2@yandex.ru";
        credentials[2][1] = "password2";
        return credentials;
    }
}
