Feature: Product Search & Details (PSD_002)
  Includes scenarios for search (which is missing on the site) and verifying product details.

  @Negative
  Scenario: PSD_002_001 (Search by Product Name - Missing Feature)
    Given I am logged in
    When I attempt to search by name "Sauce Labs Backpack"
    Then I should find no search bar or search button
    And the site does not provide any search results

  @Negative
  Scenario: PSD_002_002 (Search for an Invalid Term - Missing Feature)
    Given I am logged in
    When I attempt to search for "xyz123"
    Then I should see no error or results
    And realize the search feature is not implemented

  @Negative
  Scenario: PSD_002_003 (Search by Category - Missing Feature)
    Given I am logged in
    When I look for a category dropdown or filter
    Then I should confirm there is no category-based search
    And the site lacks any advanced filtering

  @Functional
  Scenario: PSD_002_004 (Product Display Page)
    Given I am on the product listings page
    When I click on a product named "Sauce Labs Backpack"
    Then I should see basic product details like name, price, and description

  @Functional
  Scenario: PSD_002_005 (Product Image Zoom)
    Given I am on the product details page for "Sauce Labs Backpack"
    When I hover or click on the product image
    Then the image should zoom in if implemented
    And do nothing if not implemented


  @Functional
  Scenario: PSD_002_006 (Sorting & Filtering - If Any)
    Given I am on the product listings page
    When I try to sort or filter items (e.g., by price or name)
    Then I should see items reorder if sorting is present
    And no change if sorting is missing


  @Negative
  Scenario: PSD_002_007 (Search long product name - Missing Feature)
    Given I am logged in
    When I enter a very long product name "ExtraLongProductName123456"
    Then I should see no actual search results
    And confirm search is not implemented
