package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public class OrdHist {
    @SuppressWarnings("unused")
    private WebDriver driver;

    public OrdHist(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderHistoryLinkPresent() {
        // There's no "Order History" link on Sauce Demo
        return false;
    }

    public boolean hasPastOrders() {
        // If you try to navigate to a hypothetical /order-history, you'd get a 404
        return false;
    }

    public void openOrderHistory() {
        // Attempting to open order history does nothing or 404
    }
}
