package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeFindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelectorTest(){
            driver.findElement(By.cssSelector("li"));
            driver.findElement(By.cssSelector("head"));
            driver.findElement(By.cssSelector("#flyout-cart"));
            driver.findElement(By.cssSelector("#topcartlink"));
            driver.findElement(By.cssSelector(".header-links"));
            driver.findElement(By.cssSelector(".search-box"));
            driver.findElement(By.cssSelector("[href='/cart']"));
            driver.findElement(By.cssSelector("img[src='/Themes/DefaultClean/Content/images/logo.png']"));
            driver.findElement(By.cssSelector("link[href='/Themes/DefaultClean/Content/styles.css']"));
            driver.findElement(By.cssSelector("a[href='/register']"));
    }


    @Test
    public void findElementByXpathTest(){
            driver.findElement(By.xpath("//li"));
            driver.findElement(By.xpath("//head"));
            driver.findElement(By.xpath("//*[@id='flyout-cart']"));
            driver.findElement(By.xpath("//*[@id='topcartlink']"));
            driver.findElement(By.xpath("//*[@class='header-links']"));
            driver.findElement(By.xpath("//*[@class='search-box']"));
            driver.findElement(By.xpath("//*[@href='/cart']"));
            driver.findElement(By.xpath("//img[@src='/Themes/DefaultClean/Content/images/logo.png']"));
            driver.findElement(By.xpath("//link[@href='/Themes/DefaultClean/Content/styles.css']"));
            driver.findElement(By.xpath("//link[@href='/Themes/DefaultClean/Content/styles.css']"));
            driver.findElement(By.xpath("//a[@href='/register']"));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

