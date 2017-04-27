package com.selenium.test;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.Browser;

public class InitSystemProperties {
    public static void Init(){
        Browser browser = TestsConfig.getConfig().getBrowser();
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/JavaProject/drivers/chromedriver.exe");
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/JavaProject/drivers/geckodriver.exe");
                break;
            case EDGE:
                //System.setProperty("webdriver.ie.driver", "C:/JavaProject/drivers/IEDriverServer.exe");
                System.setProperty("webdriver.edge.driver", "C:/JavaProject/drivers/MicrosoftWebDriver.exe");
                /*DesiredCapabilities cap = new DesiredCapabilities();*/
                /*cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
                break;
            default:
                System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
        }
    }
}
