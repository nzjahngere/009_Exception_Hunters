package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Step One locators
    private By firstNameField = By.id("first-name");
    private By lastNameField  = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueBtn    = By.id("continue");

    // Step Two locators
    private By finishBtn      = By.id("finish");
    private By orderComplete  = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueBtn).click();
    }

    public void completePurchase() {
        driver.findElement(finishBtn).click();
    }

    public boolean isOrderConfirmed() {
        // On success, "THANK YOU FOR YOUR ORDER" appears
        return driver.findElements(orderComplete).size() > 0;
    }
}
