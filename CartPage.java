package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By cartBadge      = By.className("shopping_cart_badge");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        // Negative approach: check page source for productName
        return driver.getPageSource().contains(productName);
    }

    public int getCartCount() {
        if (driver.findElements(cartBadge).size() > 0) {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        }
        return 0;
    }

    public void removeFromCart(String productName) {
        String removeButtonXpath = "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button";
        driver.findElement(By.xpath(removeButtonXpath)).click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
