package com.ait.qa31;

import com.ait.qa31.TestBase;
import com.ait.qa31.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountWithCSVTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        isLoginLinkPresent();
    }

    @DataProvider
    public Iterator<Object[]> registerUsersWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userData.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @Test(dataProvider = "registerUsersWithCSV")
    public void createNewAccountPositiveTestFromDataProviderWithFile(User user) {

        clickRegisterLink();
        fillRegisterForm(user);
        clickRegisterButton();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='ico-logout']")));
        clickOnSignOutButton();
    }
}

