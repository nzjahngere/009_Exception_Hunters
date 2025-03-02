Feature: Shopping Cart (SCF_003)
  Add/remove products, update quantities, check max items, etc.

  @Functional
  Scenario: SCF_003_001 (Add to Cart)
    Given I am logged in
    And I am on the products page
    When I click "Add to Cart" for "Sauce Labs Backpack"
    Then the product should appear in my cart

  @Functional
  Scenario: SCF_003_002 (Update Cart)
    Given I have "Sauce Labs Backpack" in my cart
    When I change the quantity from 1 to 2
    Then the cart quantity and total price should update accordingly

  @Exploratory
  Scenario: SCF_003_003 (Maximum Items in cart)
    Given I am logged in
    When I add multiple items until I reach the maximum quantity
    Then the site should handle the max limit without crashing

  @Negative
  Scenario: SCF_003_004 (Invalid Product ID)
    Given I am logged in
    When I try to add a product with an invalid ID "99999"
    Then I should see an error or the product is not added

  @Functional
  Scenario: SCF_003_005 (Remove from Cart)
    Given I have "Sauce Labs Backpack" in my cart
    When I click "Remove"
    Then the product should no longer be in my cart
