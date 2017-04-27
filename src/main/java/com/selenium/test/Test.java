package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/JavaProject/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/JavaProject/drivers/geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://gamblingstation.herokuapp.com");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("#command > div:nth-child(1) > input")).sendKeys("admin@gmail.com");
        //driver.findElement(By.xpath("//*[@id=\"command\"]/div[1]/input")).sendKeys("admin@gmail.com");
        driver.findElement(By.name("username")).sendKeys("admin@gmail.com");
        //driver.findElement(By.cssSelector("#command > div:nth-child(2) > input")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.cssSelector("#command > button")).click();
        //driver.findElement(By.xpath("//*[@id=\"command\"]/button")).click();
        //driver.findElement(By.xpath("//button[contains(.,'Войти')]")).click();
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(1).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS); do not working
        driver.close();
    }
}
