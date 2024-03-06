package com.ait.qa31.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setup
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
//        driver.navigate().to("https://www.google.com"); //with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    // tests
    @Test
    public void openGoogleTest(){
        System.out.println("Google opened!");
    }


    //after - tearDown
    @AfterMethod(enabled = true)
    public void tearDown(){
//        driver.quit(); //all tabs and browser close
        driver.close(); //only one tab(if one tab -> close browser)
    }
}

