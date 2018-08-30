package com.workspace.testproject.selenium.login;

import com.workspace.testproject.selenium.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginElements extends SeleniumDriver{

    public WebElement getEmail() {
        return driver.findElement(By.id("email"));
    }

    public void waitForEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public void waitForPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector("button[type='submit'"));
    }

    public void waitForClickableSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'")));
    }
}
