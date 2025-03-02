Feature: Checkout Process (CPF_004)
  Proceed to checkout, fill shipping, select payment, get confirmation.

  @Functional
  Scenario: CPF_004_001 (Proceeding to Checkout)
    Given I have at least one item in my cart
    When I click "Checkout"
    And I fill shipping details
    Then I should move to the payment step (which is missing or simulated)

  @Functional
  Scenario: CPF_004_002 (Price Display Accuracy)
    Given I have multiple items in my cart
    When I reach the checkout page
    Then I should see a correct total price reflecting item quantities

  @Negative
  Scenario: CPF_004_003 (Invalid Payment Details)
    Given I am at the simulated payment step
    When I enter an invalid card number "1234-5678-0000"
    Then I should see a payment error or realize payment is not implemented

  @Negative
  Scenario: CPF_004_004 (Missing Mandatory Fields)
    Given I am on the checkout form
    When I leave shipping address blank
    Then I should see an error prompting for mandatory fields

  @Exploratory
  Scenario: CPF_004_005 (Checkout with maximum items)
    Given I have many items in my cart
    When I proceed to checkout
    Then the site should handle large item counts without performance issues

  @Functional
  Scenario: CPF_004_006 (Payment Gateway & Transactions)
    Given I am at the payment step
    When I try to choose "Credit Card" or "PayPal"
    Then I discover no real gateway exists
    And the site may skip to a mock confirmation

  @Functional
  Scenario: CPF_004_007 (Order Details & Price Calculations)
    Given I am on the final confirmation page
    Then the order summary should show correct item prices and total

  @Functional
  Scenario: CPF_004_008 (Order Confirmation)
    Given I have completed the checkout
    When I see the final page
    Then I should see an order confirmation message with an order ID
