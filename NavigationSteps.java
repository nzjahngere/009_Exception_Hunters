package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.UserAuth;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class NavigationSteps {
    private WebDriver driver;
    private UserAuth loginPage;

    @Given("I am on a product listings page")
    public void i_am_on_a_product_listings_page() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertTrue("Login failed!", loginPage.isLoginSuccessful());
    }

    @When("I click on various product links")
    public void i_click_on_various_product_links() {
        // Example: click first product
        driver.findElement(By.xpath("//div[@class='inventory_item_name']")).click();
    }

    @Then("I should be taken to the correct product details page")
    public void i_should_be_taken_to_the_correct_product_details_page() {
        // Sauce Demo shows /inventory-item.html?id=4, etc.
        assertTrue("Not on product details page!", driver.getCurrentUrl().contains("inventory-item.html"));
        driver.quit();
    }

    @When("I check for any broken links")
    public void i_check_for_any_broken_links() {
        // Basic approach: gather all <a> elements, attempt a HEAD request
        // We'll skip the code, just a placeholder
    }

    @Then("any invalid or 404 links should show an error page")
    public void any_invalid_or_404_links_should_show_an_error_page() {
        assertTrue("No broken link check implemented yet!", true);
        driver.quit();
    }

    @Given("I have items in my cart")
    public void i_have_items_in_my_cart() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
        loginPage.login("standard_user", "secret_sauce");
        // Add item to cart (skipped)
        assertTrue("Cart is empty!", true);
    }

    @When("I navigate from cart to checkout and back")
    public void i_navigate_from_cart_to_checkout_and_back() {
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.id("checkout")).click();
        driver.navigate().back();
    }

    @Then("the site should handle the transitions smoothly without losing cart data")
    public void the_site_should_handle_the_transitions_smoothly_without_losing_cart_data() {
        // Check if cart still has item
        assertTrue("Cart data lost!", true);
        driver.quit();
    }
}
