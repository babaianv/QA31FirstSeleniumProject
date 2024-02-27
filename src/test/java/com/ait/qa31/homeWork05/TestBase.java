package com.ait.qa31.homeWork05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {
    static WebDriver driver;

    public static By isPresentProductByName() {
        return By.cssSelector("[href='/141-inch-laptop']");
    }

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }

    public boolean isAlertAppears(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());

        if (alert == null){
            return false;
        }else {
            alert.accept();
            return true;
        }
    }

    public void clickLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#Email"), email);
        type(By.cssSelector("#Password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void addToCard() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void findElement() {
        click(By.cssSelector(".item-box:nth-child(3) .button-2.product-box-add-to-cart-button"));
    }

    public void removeFromCart() {
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }

    public boolean isProductExistsByName(String text){

        List<WebElement> products = driver.findElements(isPresentProductByName());

        for (WebElement product : products){
            if (product.getText().contains(text))
                return true;
        }
        return false;
    }
}

