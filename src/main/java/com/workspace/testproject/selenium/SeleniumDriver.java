package com.workspace.testproject.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

    protected static WebDriver driver = new ChromeDriver();
    protected static WebDriverWait wait = new WebDriverWait(driver, 10);
}
