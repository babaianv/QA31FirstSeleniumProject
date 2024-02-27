package com.ait.qa31.homeWork05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToShoppingCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            click(By.cssSelector("[href='/logout']"));
        }

        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#Email"),"babqa123@gmail.com");
        type(By.cssSelector("#Password"), "Babval1807");
        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void addProductToCartTest(){
        click(By.cssSelector(".item-box:nth-child(3) .button-2.product-box-add-to-cart-button"));
        click(By.cssSelector("[href='/cart']"));

        Assert.assertTrue(isProductExistsByName("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }
    public boolean isProductExistsByName(String text){

        List<WebElement> products = driver.findElements(By.cssSelector("[href='/141-inch-laptop']"));

        for (WebElement product : products){
            if (product.getText().contains(text))
                return true;
        }
        return false;
    }


}

