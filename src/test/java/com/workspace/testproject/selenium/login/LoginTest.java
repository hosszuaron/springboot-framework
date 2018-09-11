package com.workspace.testproject.selenium.login;

import com.workspace.testproject.selenium.SeleniumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest extends SeleniumDriver {

    @Autowired
    private LoginActions loginActions;

    @Before
    public void setup() {
        driver.get("https://test.aw.ro:8282");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginTest() {

        loginActions.loginForAllPartners();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#/usersList'")));
        assertEquals(driver.getCurrentUrl(), "https://test.aw.ro:8282/#/home");
    }
}
