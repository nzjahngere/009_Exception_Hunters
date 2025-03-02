package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAuth {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage  = By.cssSelector("[data-test='error']");

    // Constructor
    public UserAuth(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Checks
    public boolean isLoginSuccessful() {
        // Sauce Demo redirects to /inventory.html on success
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}

