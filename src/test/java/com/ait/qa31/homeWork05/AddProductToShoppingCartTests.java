package com.ait.qa31.homeWork05;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToShoppingCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }

        clickOnLoginLink();
        fillLoginForm("babqa123@gmail.com", "Babval1807");
        clickLoginButton();
    }

    @Test
    public void addProductToCartTest(){
        findElement();
        addToCard();

        Assert.assertTrue(isProductExistsByName("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        removeFromCart();
    }

}

