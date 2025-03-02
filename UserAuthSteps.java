package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.UserAuth;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class UserAuthSteps {
    private WebDriver driver;
    private UserAuth loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new UserAuth(driver);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to the product inventory page")
    public void i_should_be_redirected_to_the_product_inventory_page() {
        assertTrue("Login failed!", loginPage.isLoginSuccessful());
        driver.quit();
    }

    @When("I enter incorrect username and password")
    public void i_enter_incorrect_username_and_password() {
        loginPage.login("invalid_user", "wrong_pass");
    }

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
        assertTrue("Error not displayed!", loginPage.isErrorDisplayed());
        driver.quit();
    }

    @When("I leave username and password blank")
    public void i_leave_username_and_password_blank() {
        loginPage.login("", "");
    }

    @Then("I should see an error prompting for required fields")
    public void i_should_see_an_error_prompting_for_required_fields() {
        assertTrue("Error not displayed for empty fields!", loginPage.isErrorDisplayed());
        driver.quit();
    }

    @When("I enter my username in uppercase and password in lowercase")
    public void i_enter_my_username_in_uppercase_and_password_in_lowercase() {
        loginPage.login("STANDARD_USER", "secret_sauce".toLowerCase());
    }

    @Then("I should see a login error if credentials are case-sensitive")
    public void i_should_see_a_login_error_if_credentials_are_case_sensitive() {
        assertTrue("Case sensitivity error not displayed!", loginPage.isErrorDisplayed());
        driver.quit();
    }

    @When("I look for a Forgot Password link")
    public void i_look_for_a_forgot_password_link() {
        // No Forgot Password link in Sauce Demo, so do nothing or check for absent element
    }

    @Then("I should not find any password recovery option")
    public void i_should_not_find_any_password_recovery_option() {
        // Negative check: link doesn't exist
        // E.g., driver.findElements(By.linkText("Forgot Password")).size() == 0
        // We'll just assert that the link is missing
        assertEquals("Forgot Password link found, but feature should be missing!", 
                     0, 
                     driver.findElements(org.openqa.selenium.By.linkText("Forgot Password")).size());
        driver.quit();
    }
}

