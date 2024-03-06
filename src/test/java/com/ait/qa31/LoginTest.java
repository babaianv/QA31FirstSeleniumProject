package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        User user = new User()
                .setEmail("mila11@gmail.com")
                .setPassword("MilaPriss11!");
        fillLoginForm(user);
        clickLoginButton();

        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }

}

