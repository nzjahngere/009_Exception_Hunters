package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetails {
    private WebDriver driver;

    // Example locators
    private By productName    = By.className("inventory_details_name");
    private By productDesc    = By.className("inventory_details_desc");
    private By productPrice   = By.className("inventory_details_price");
    private By addToCartBtn   = By.cssSelector(".btn_inventory");
    // No real zoom element in Sauce Demo, but we can simulate or check if an image is clickable
    private By productImage   = By.cssSelector(".inventory_details_img");

    public ItemDetails(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductDescription() {
        return driver.findElement(productDesc).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public boolean zoomImage() {
        // Sauce Demo doesn't have real zoom
        // You can simulate by clicking the image or checking if a zoom overlay appears
        driver.findElement(productImage).click();
        // Return false or check if a zoom effect is triggered
        return false; // negative approach: no real zoom
    }
}

