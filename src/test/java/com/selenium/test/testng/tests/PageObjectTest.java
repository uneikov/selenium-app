package com.selenium.test.testng.tests;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.YouTubePage;
import com.selenium.test.pages.YouTubeSearchResultsPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.Browser;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sidelnikov Mikhail on 19.09.14.
 * Uses TestNG test framework
 * Test demonstrates work with Page Object Pattern(https://code.google.com/p/selenium/wiki/PageObjects)
 */
@Listeners({ScreenShotOnFailListener.class})
public class PageObjectTest {

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
                break;
        }
        /*if (new TestsConfig().getBrowser().equals(Browser.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:/JavaProject/drivers/chromedriver.exe");
        }
        if(new TestsConfig().getBrowser().equals(Browser.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C:/JavaProject/drivers/geckodriver.exe");
        }*/
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void testSearch() {
        String toSearch = "Selenium";
        YouTubePage youTubePage = new YouTubePage();
        youTubePage.insertSearchString(toSearch);
        YouTubeSearchResultsPage resultsPage = youTubePage.doSearch();
        assertTrue("No results were found on results page", resultsPage.hasResults());
    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
