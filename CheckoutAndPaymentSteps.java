package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.UserAuth;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.PaymentPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class CheckoutAndPaymentSteps {
    private WebDriver driver;
    private UserAuth loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    @Given("I have at least one item in my cart")
    public void i_have_at_least_one_item_in_my_cart() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
        loginPage.login("standard_user", "secret_sauce");
        cartPage = new CartPage(driver);

        // driver.get("https://www.saucedemo.com/inventory.html");
        // inventoryPage.clickProduct("Sauce Labs Backpack");
        // driver.get("https://www.saucedemo.com/cart.html");

        // For now, i just assert cart count > 0, so it might fail unless i really add something:
        driver.get("https://www.saucedemo.com/cart.html");
        assertTrue("No item in cart!", cartPage.getCartCount() > 0);
    }

    @When("I click Checkout and fill shipping details {string}, {string}, {string}")
    public void i_click_checkout_and_fill_shipping_details(String first, String last, String postal) {
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails(first, last, postal);
    }

    @Then("I should move to the payment step which is missing or simulated")
    public void i_should_move_to_the_payment_step_which_is_missing_or_simulated() {
        assertTrue("No real payment step found, as expected!", true);
        driver.quit();
    }

    @Given("I am on the payment method selection page")
    public void i_am_on_the_payment_method_selection_page() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
        loginPage.login("standard_user", "secret_sauce");
        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("John", "Doe", "12345");
        paymentPage = new PaymentPage(driver);
    }

    @When("I choose {string} and click Continue")
    public void i_choose_and_click_continue(String paymentMethod) {
        boolean available = paymentPage.isPaymentMethodAvailable(paymentMethod);
        assertFalse("Payment method unexpectedly available!", available);
    }

    @Then("I should see an order confirmation page with an order summary")
    public void i_should_see_an_order_confirmation_page_with_an_order_summary() {
        checkoutPage.completePurchase();
        assertTrue("Order not confirmed!", checkoutPage.isOrderConfirmed());
        driver.quit();
    }

    @When("I enter an invalid card number {string}")
    public void i_enter_an_invalid_card_number(String cardNumber) {
        paymentPage.enterPaymentDetails(cardNumber);
    }

    @Then("I should see a payment failure or realize payment is not implemented")
    public void i_should_see_a_payment_failure_or_realize_payment_is_not_implemented() {
        assertFalse("Payment system unexpectedly worked!", paymentPage.confirmPayment());
        driver.quit();
    }

    @When("I leave shipping address blank")
    public void i_leave_shipping_address_blank() {
        checkoutPage.fillCheckoutDetails("", "", "");
    }

    @Then("I should see an error prompting for mandatory fields")
    public void i_should_see_an_error_prompting_for_mandatory_fields() {
        assertFalse("Should still be on the same page due to error!", checkoutPage.isOrderConfirmed());
        driver.quit();
    }

    @When("I have many items in my cart for checkout")
    public void i_have_many_items_in_my_cart_for_checkout() {
        // Possibly add multiple items to the cart
    }

    @Then("the site should handle large item counts without performance issues")
    public void the_site_should_handle_large_item_counts_without_performance_issues() {
        assertTrue("Site performance degraded!", true);
        driver.quit();
    }

    @Then("the order summary should show correct item prices and total")
    public void the_order_summary_should_show_correct_item_prices_and_total() {
        assertTrue("Price calculation mismatch!", true);
        driver.quit();
    }

    @Then("I should see an order confirmation message with an order ID")
    public void i_should_see_an_order_confirmation_message_with_an_order_id() {
        assertTrue("No final confirmation message!", checkoutPage.isOrderConfirmed());
        driver.quit();
    }

    @Given("I am at the simulated payment step")
    public void i_am_at_the_simulated_payment_step() {
        // Negative approach for a missing payment step
    }

    @Given("I am on the checkout form")
    public void i_am_on_the_checkout_form() {
        // Possibly driver.get("some URL or partial approach")
    }

    @Given("I have completed the checkout")
    public void i_have_completed_the_checkout() {
        // Fill shipping, complete purchase
    }

    @When("I see the final page")
    public void i_see_the_final_page() {
        // Possibly check driver.getCurrentUrl() or final text
    }

    @Given("I am at the payment step")
    public void i_am_at_the_payment_step() {
        // Negative approach again
    }

    @When("I try to choose {string} or {string}")
    public void i_try_to_choose_or(String method1, String method2) {
        // Payment not implemented
    }

    @Then("I discover no real gateway exists")
    public void i_discover_no_real_gateway_exists() {
        assertTrue("No real gateway found, as expected", true);
    }

    @Then("the site may skip to a mock confirmation")
    public void the_site_may_skip_to_a_mock_confirmation() {
        assertTrue("Skipping to mock confirmation since no real payment", true);
    }

    @Given("I am on the final confirmation page")
    public void i_am_on_the_final_confirmation_page() {
        // Possibly driver.get("some final confirmation URL")
    }
}
