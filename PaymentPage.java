package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public class PaymentPage {
    @SuppressWarnings("unused")
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPaymentMethodAvailable(String methodName) {
        // No real payment gateway on Sauce Demo
        return false;
    }

    public void enterPaymentDetails(String cardNumber) {
        // No place to enter card, so do nothing or log a message
    }

    public boolean confirmPayment() {
        // Payment is not implemented, so always return false or throw
        return false;
    }
}
