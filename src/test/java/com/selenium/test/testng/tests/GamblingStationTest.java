package com.selenium.test.testng.tests;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.GamblingStationPage;
import com.selenium.test.webtestsbase.Browser;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GamblingStationTest {
    @BeforeTest
    public void beforeTest() {
        Browser browser = new TestsConfig().getBrowser();
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/JavaProject/drivers/chromedriver.exe");
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/JavaProject/drivers/geckodriver.exe");
                break;
            case IE10:
                System.setProperty("webdriver.ie.driver", "C:/JavaProject/drivers/IEDriverServer.exe");
                /*DesiredCapabilities cap = new DesiredCapabilities();*/
                /*cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
                break;
        }
        WebDriverFactory.startBrowser(true);
    }
    
    @Test
    public void testSignInToRediff() throws Exception{
        String email = "admin@gmail.com";
        String password = "admin";
        GamblingStationPage page = new GamblingStationPage();
        if (page.isPageOpened()){
            page.insertLoginString(email);
            page.insertPasswordString(password);
            page.submitLoginInfo();
        }
    }
    
    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
