package com.saucedemo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        // Example: If you want to use WebDriverManager, do so. 
        // For now, let's assume geckodriver is on PATH:
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
