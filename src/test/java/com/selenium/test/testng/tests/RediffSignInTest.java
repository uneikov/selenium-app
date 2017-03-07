package com.selenium.test.testng.tests;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.Browser;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class RediffSignInTest {
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
        String signIn = "neikov@gmail.com";
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get("http://www.rediff.com");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
        String title = driver.getTitle();
        driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys(signIn);
        driver.findElement(By.cssSelector("#password")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
        //driver.findElement(By.cssSelector("body > div > div.content-area > div.rhs-area.floatR > div.login-area-free.floatR > div > form > div > div:nth-child(6) > div:nth-child(1) > input[type=\"submit\"]")).click();
        driver.findElement(By.cssSelector("#passwd")).sendKeys("passwd007");
        driver.findElement(By.cssSelector("#login > div.center-content > div.text-container > div.textfields > div.field_cont > div:nth-child(7) > div > input[type=\"submit\"]")).click();
        //driver.findElement(By.cssSelector("#passwd")).click();
        //driver.wait(1000L);
        //driver.findElement(By.xpath("//*[@id=\"login1\"]")).click();
        //driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.close();
        assertTrue("The page title is Rediffmail",title.equals("Rediffmail"));
    }
}
