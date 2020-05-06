package com.foodforcharity.app.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SeleniumTest {

    private static WebDriver driver;

//    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/Caskroom/chromedriver/81.0.4044.69/chromedriver");
        driver = new ChromeDriver();
    }

//    @Test
    public void testChromeSelenium() {
        driver.get("http://localhost:8080/");
//        driver.get("http://google.com");
    }

//    @After
    public void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}