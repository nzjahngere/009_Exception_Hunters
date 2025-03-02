package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public class SearchPage {
    @SuppressWarnings("unused")
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchFeaturePresent() {
        // There's no actual search bar or button on Sauce Demo
        // Return false or check the DOM for a hypothetical search element
        return false;
    }

    public void searchProduct(String productName) {
        // Attempting to search does nothing because feature is missing
        // You might log a message or throw an exception
    }
}
