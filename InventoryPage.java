package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    // Example locator for the sort dropdown
    private By productSortDropdown = By.cssSelector(".product_sort_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sort items by a given option (e.g., "Price (low to high)", "Name (A to Z)")
     */
    public void sortProducts(String sortOption) {
        driver.findElement(productSortDropdown).click();
        // Then select the option from the dropdown, e.g.:
        // driver.findElement(By.xpath("//option[text()='" + sortOption + "']")).click();
    }

    /**
     * Click a single product by its displayed name.
     * e.g., "Sauce Labs Backpack"
     * 
     * Use an XPath that matches:
     * <div class="inventory_item_name">Sauce Labs Backpack</div>
     */
    public void clickProduct(String productName) {
        String productXpath = "//div[@class='inventory_item_name' and text()='" + productName + "']";
        driver.findElement(By.xpath(productXpath)).click();
    }

    /**
     * Add multiple products by name in a loop.
     * For each productName, it:
     *  1) Clicks the product
     *  2) (Optional) On the details page, click "Add to Cart"
     *  3) Navigates back to inventory to add the next item
     */
    public void addMultipleItems(String... productNames) {
        for (String name : productNames) {
            // 1) Click the product
            clickProduct(name);

            // 2) For a ProductDetailsPage, do something like:
            // new ProductDetailsPage(driver).addToCart();

            // 3) Navigate back to the inventory page to add the next product
            // if your flow stays on the same page, you may need to adjust:
            driver.navigate().back();
        }
    }
}
