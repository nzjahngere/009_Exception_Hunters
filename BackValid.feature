Feature: Backend Validation (BES_008)
  Tests API response times and database consistency for cart, checkout, etc.

  @Performance
  Scenario: BES_008_001 (API Response Time for Product Search)
    Given I make a GET request to the search API
    When I measure the response time
    Then it should return within acceptable limits (e.g., < 2 seconds)

  @Functional
  Scenario: BES_008_002 (Database Consistency on + to cart)
    Given I add an item to the cart
    When I check the database or cart API
    Then it should reflect the correct product and quantity

  @Functional
  Scenario: BES_008_003 (Checkout API Process)
    Given I have items ready for checkout
    When I submit a checkout request to the API
    Then the order should be created with a valid order ID
