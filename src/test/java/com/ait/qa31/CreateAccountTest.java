package com.ait.qa31;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void createAccountTest(){
        click(By.cssSelector("[href='/register']"));
        type(By.cssSelector("#FirstName"),"Mila");
        type(By.cssSelector("#LastName"),"Priss");
        type(By.cssSelector("#Email"),"mila11@gmail.com");
        type(By.cssSelector("#Password"),"MilaPriss11!");
        type(By.cssSelector("#ConfirmPassword"),"MilaPriss11!");
        click(By.cssSelector("#register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }



}

