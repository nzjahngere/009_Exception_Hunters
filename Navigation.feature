Feature: Navigation (NVG_006)
  Verify that links between product pages, cart, and checkout work, and handle broken links.

  @Functional
  Scenario: NVG_006_001 (Navigation between Product Pages)
    Given I am on a product listings page
    When I click on various product links
    Then I should be taken to the correct product details page

  @Negative
  Scenario: NVG_006_002 (Broken links)
    Given I am on the homepage
    When I check for any broken links
    Then any invalid or 404 links should show an error page

  @Functional
  Scenario: NVG_006_003 (Navigation between cart & checkout)
    Given I have items in my cart
    When I navigate from cart to checkout and back
    Then the site should handle the transitions smoothly without losing cart data
