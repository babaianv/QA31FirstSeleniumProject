package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToShoppingCartTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }

        clickOnLoginLink();
        fillLoginForm(new User().setEmail("babqa123@gmail.com").setPassword("Babval1807"));
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

