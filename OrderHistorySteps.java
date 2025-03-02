package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.UserAuth;
import com.saucedemo.pages.OrdHist;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class OrderHistorySteps {
    private WebDriver driver;
    private UserAuth loginPage;
    private OrdHist historyPage;

    @Given("I am logged in and the site is missing order history")
    public void i_am_logged_in_and_the_site_is_missing_order_history() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertTrue("Login failed!", loginPage.isLoginSuccessful());
        historyPage = new OrdHist(driver);
    }

    @When("I navigate to My Account or Order History")
    public void i_navigate_to_my_account_or_order_history() {
        // No real link, so do nothing or attempt a direct URL
        historyPage.openOrderHistory();
    }

    @Then("I should not find any real order history page")
    public void i_should_not_find_any_real_order_history_page() {
        assertFalse("Order history link found, but should not exist!", historyPage.isOrderHistoryLinkPresent());
        driver.quit();
    }

    @When("I have many past orders if the feature existed")
    public void i_have_many_past_orders_if_the_feature_existed() {
        // Hypothetical
    }

    @Then("the site cannot display them since order history is missing")
    public void the_site_cannot_display_them_since_order_history_is_missing() {
        assertFalse("Somehow found order history data!", historyPage.hasPastOrders());
        driver.quit();
    }

    @When("I open a hypothetical order detail page")
    public void i_open_a_hypothetical_order_detail_page() {
        historyPage.openOrderHistory();
    }

    @Then("I realize no actual order detail is shown or the site shows a 404 page")
    public void i_realize_no_actual_order_detail_is_shown_or_the_site_shows_a_404_page() {
        assertFalse("Order detail unexpectedly present!", historyPage.hasPastOrders());
        driver.quit();
    }
}
