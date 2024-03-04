package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CreateAccountTest extends TestBase {


        @DataProvider
    public Iterator<Object[]> registerByCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userData.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "registerByCSV")
    public void createAccountPositiveTest(User user) {
        clickRegisterLink();
        fillRegisterForm(user);
        clickRegisterButton();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='ico-logout']")));

    }

}

